//Please change Base URL to admin url before running this script
package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AdminPOM;
import com.training.pom.CategoryPOM;
import com.training.pom.ProductPOM;
import com.training.pom.SalesPOM;
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

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class RTTC_045 {
	private WebDriver driver;
	private String baseUrl;
	private AdminPOM adminPOM;
	private SalesPOM salesPOM;
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
		salesPOM = new SalesPOM(driver); 
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
		screenShot.captureScreenShot("RTTC045_1");
	}

	@Test(priority=1, dependsOnMethods = "LoginTest")
	public void CartTest() throws InterruptedException {
				
		WebElement ordericon = driver.findElement(By.xpath("//body/div[@id='container']/nav[@id='column-left']/ul[@id='menu']/li[@id='menu-sale']/a[1]"));
		Actions act = new Actions (driver);
		act.moveToElement(ordericon).build().perform();
		driver.findElement(By.xpath("//li[@id='menu-sale']//ul//li//a[contains(text(),'Orders')]")).click();
		
		screenShot.captureScreenShot("RTTC045_2");
		
		assertEquals("Orders",driver.getTitle());
		salesPOM.clickplus();
	}
	@Test(priority= 2)
	public void CreateOrderTest() throws InterruptedException {
		salesPOM.sendFirstName("Lakshmi");
		salesPOM.sendLastName("Chandana");
		salesPOM.sendEmail("chandana8@gmail.com");
		salesPOM.sendPhone("8888888888");
		salesPOM.clickconbutton();
		salesPOM.clickprod();
		driver.findElement(By.xpath("//input[@id='input-product']")).sendKeys("A Finger Ring");
		driver.findElement(By.xpath("//body//div[@class='tab-content']//div[@class='tab-content']//li[1]//a[1]")).click();
		
		salesPOM.sendQuantity("10");
		salesPOM.clickAddprod();
		screenShot.captureScreenShot("RTTC045_3");	
		salesPOM.clickCartbttn();
	}
		@Test(priority= 3, dependsOnMethods = "CreateOrderTest")
		public void CreatepaymentTest() throws InterruptedException {
		salesPOM.sendPayFirstName("Chandana");
		salesPOM.sendPayLastName("Namana");
		salesPOM.sendAddress("Kukatpally");
		salesPOM.sendCity("Hyderabad");
		
		WebElement country= driver.findElement(By.xpath("//select[@id='input-payment-country']"));
		Select cutry= new Select(country);
		cutry.selectByVisibleText("India");
		
		WebElement Zone= driver.findElement(By.xpath("//select[@id='input-payment-zone']"));
		Select state= new Select(Zone);
		state.selectByVisibleText("Telangana");
		
		screenShot.captureScreenShot("RTTC045_4");	
		salesPOM.clickbttnPayment();
		
		}
		@Test(priority= 4)
		public void CreateShipTest() throws InterruptedException {
	
		salesPOM.sendShipfName("Lakshmi");
		salesPOM.sendShiplName("chandu");
		salesPOM.sendShipaddress("Kukatpally");
		salesPOM.sendShipcity("Hyderabad");
		
		WebElement country1= driver.findElement(By.xpath("//select[@id='input-shipping-country']"));
		Select cutry1= new Select(country1);
		cutry1.selectByVisibleText("India");
		
		WebElement Zone1= driver.findElement(By.xpath("//select[@id='input-shipping-zone']"));
		Select state1= new Select(Zone1);
		state1.selectByVisibleText("Telangana");
		screenShot.captureScreenShot("RTTC045_5");	
		salesPOM.clickShipcont();
		
		}
		@Test(priority= 5)
		public void CreateOrder1Test() throws InterruptedException {
			
			driver.findElement(By.xpath("//select[@id='input-shipping-method']")).sendKeys("Free Shipping - Rs.0");
		
		WebElement payment= driver.findElement(By.xpath("//select[@id='input-payment-method']"));
		Select paym= new Select(payment);
		paym.selectByVisibleText("Cash On Delivery");
		
		salesPOM.clickSave();
		screenShot.captureScreenShot("RTTC045_6");
	}
			@Test(priority= 6, dependsOnMethods = "CreateOrder1Test")
		public void CreateSearchTest() throws InterruptedException {
				
			WebElement ordericon1 = driver.findElement(By.xpath("//body/div[@id='container']/nav[@id='column-left']/ul[@id='menu']/li[@id='menu-sale']/a[1]"));
			Actions act1 = new Actions (driver);
			act1.moveToElement(ordericon1).build().perform();
			driver.findElement(By.xpath("//li[@id='menu-sale']//ul//li//a[contains(text(),'Orders')]")).click();
				
			driver.findElement(By.xpath("//input[@id='input-customer']")).sendKeys("Lakshmi Chandana");
			productPOM.clickFilterbttn();
			driver.findElement(By.xpath("//tr[1]//td[8]//a[1]//i[1]")).click();
			screenShot.captureScreenShot("RTTC045_7");
			driver.findElement(By.xpath("//button[@id='button-invoice']//i[@class='fa fa-cog']")).click();
			screenShot.captureScreenShot("RTTC045_8");	
}
}