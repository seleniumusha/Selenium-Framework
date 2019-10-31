package com.training.sanity.tests;

import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AdminPOM;
import com.training.pom.ProductPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_014 {

	private WebDriver driver;
	private String baseUrl;
	private AdminPOM adminPOM;
	private ProductPOM productPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	
	@BeforeSuite
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeClass
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		adminPOM = new AdminPOM(driver); 
		productPOM = new ProductPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterTest
	public void tearDown() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.quit();
	}
	@Test(priority=1)
	public void LoginTest() throws InterruptedException {
		
		adminPOM.sendUserName("admin");
		adminPOM.sendPassword("admin@123");
		adminPOM.clickLoginBtn(); 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		screenShot.captureScreenShot("RTTC14_1");
	}
	@Test(priority=2, dependsOnMethods = "LoginTest")
	public void CateTest() throws InterruptedException {
			
		WebElement category=driver.findElement(By.xpath("//i[@class='fa fa-tags fw']"));
		Actions cat=new Actions(driver);
		cat.moveToElement(category).build().perform();
		productPOM.clickProduct(); 
		screenShot.captureScreenShot("RTTC14_2");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		assertEquals("Products",driver.getTitle());
	
	}
	@Test(priority=3)
	public void ProdTest() throws InterruptedException {
	
		productPOM.sendProdName("Integer vitae iaculis massa");
		
		productPOM.clickFilterbttn(); 
		screenShot.captureScreenShot("RTTC14_3");
	}
	@Test(priority=4, dependsOnMethods = "ProdTest")
	public void PriceTest() throws InterruptedException {
	
		productPOM.sendPrice("515");
		
		productPOM.clickFilterbttn(); 
		screenShot.captureScreenShot("RTTC14_4");		
	}
}
