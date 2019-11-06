//Please change Base URL to admin url before running this script
package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AdminPOM;
import com.training.pom.CategoryPOM;
import com.training.pom.ProductPOM;
import com.training.pom.RegistrationPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;

public class RTTC_015 {
	private WebDriver driver;
	private String baseUrl;
	private AdminPOM adminPOM;
	private CategoryPOM categoryPOM;
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
		categoryPOM = new CategoryPOM(driver);
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
	@Test(priority=0)
	public void LoginTest() throws InterruptedException {
		
		adminPOM.sendUserName("admin");
		adminPOM.sendPassword("admin@123");
		adminPOM.clickLoginBtn(); 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		screenShot.captureScreenShot("RTTC15_1");
	}
	@Test(priority=1, dependsOnMethods ="LoginTest")
	public void ProdTest() throws InterruptedException {
		
		WebElement category=driver.findElement(By.xpath("//i[@class='fa fa-tags fw']"));
		Actions cat=new Actions(driver);
		cat.moveToElement(category).build().perform();
		screenShot.captureScreenShot("RTTC15_2");
		productPOM.clickProduct();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		assertEquals("Products",driver.getTitle());
	}
	@Test(priority= 2,  dependsOnMethods ="ProdTest")
	public void CreateProdTest() throws InterruptedException {
		categoryPOM.clickplus();
		categoryPOM.sendcategoryName("Chandana");
		categoryPOM.sendTitle("Chandana");
		categoryPOM.clickData();
		
		categoryPOM.sendModel("Chandana");
		categoryPOM.clickSave();
		screenShot.captureScreenShot("RTTC15_2");
	}
	@Test(priority=3)
	public void SearchProdTest() throws InterruptedException {
	
		productPOM.sendProdName("Chandana");
		productPOM.clickFilterbttn(); 
	}
	@Test(priority=4)
	public void DeleteTest() throws InterruptedException {
	
		categoryPOM.checkbttn1(); 
		screenShot.captureScreenShot("RTTC15_3");
		
		categoryPOM.clickdelete();
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();
		screenShot.captureScreenShot("RTTC15_4");	
}
}
	
