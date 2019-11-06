//Please change Base URL to admin url before running this script
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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AdminPOM;
import com.training.pom.CategoryPOM;
import com.training.pom.ProductPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_073 {
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
		screenShot.captureScreenShot("RTTC073_1");
	}

	@Test(priority= 1, dependsOnMethods = "LoginTest" )
	public void CateTest() throws InterruptedException {
			
		WebElement category=driver.findElement(By.xpath("//i[@class='fa fa-tags fw']"));
		Actions cat=new Actions(driver);
		cat.moveToElement(category).build().perform();
		productPOM.clickProduct(); 
		screenShot.captureScreenShot("RTTC073_2");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		assertEquals("Products",driver.getTitle());
	}

	@Test(priority= 2,  dependsOnMethods ="CateTest")
	public void AddProdTest() throws InterruptedException {
		categoryPOM.clickplus();
		screenShot.captureScreenShot("RTTC73_3");
		categoryPOM.sendcategoryName("Finger Ring");
		categoryPOM.sendTitle("Finger Ring for ladies");
	}
		@Test(priority= 3)
		public void DataTest() throws InterruptedException {
		categoryPOM.clickData();
		
		categoryPOM.sendModel("SKU-012");
		categoryPOM.sendPrice("500");
		productPOM.sendquantity("50");
		categoryPOM.clickData();
		categoryPOM.clickLink();
		driver.findElement(By.xpath("//input[@id='input-category']")).sendKeys("ORNAMENTS");
		driver.findElement(By.xpath("//div[@id='tab-links']//li[1]//a[1]")).click();
		productPOM.clicksavebttn();
		screenShot.captureScreenShot("RTTC73_4");
	}
	
}
