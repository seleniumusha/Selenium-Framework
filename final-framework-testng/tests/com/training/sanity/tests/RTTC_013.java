package com.training.sanity.tests;

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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.Assert;
import com.training.generics.ScreenShot;
import com.training.pom.AdminPOM;
import com.training.pom.CategoryPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_013 {
	
	private WebDriver driver;
	private String baseUrl;
	private AdminPOM adminPOM;
	private CategoryPOM categoryPOM;
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
		screenShot.captureScreenShot("RTTC13_1");
	}
	@Test(priority=2, dependsOnMethods = "LoginTest" )
	public void categoryTest() throws InterruptedException {
	
		WebElement categories=driver.findElement(By.xpath("//i[@class='fa fa-tags fw']"));
		Actions cat=new Actions(driver);
		cat.moveToElement(categories).build().perform();
		categoryPOM.clickcategory();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		assertEquals("Categories",driver.getTitle());
		System.out.println("Successful");
	}
	@Test(priority=3)
	public void AddcatTest() throws InterruptedException {
	
		categoryPOM.clickplus();
		categoryPOM.sendcategoryName("INDIAN");
		categoryPOM.sendTitle("India-Hyderabad");
		categoryPOM.clickSave();
		screenShot.captureScreenShot("RTTC13_2");
		
		categoryPOM.checkbttn(); 
		screenShot.captureScreenShot("RTTC13_3");
		
	}
	@Test(priority=4, dependsOnMethods = "AddcatTest")
	public void deleteCatTest() throws InterruptedException {
	
		categoryPOM.clickdelete();
		Alert alert1 = driver.switchTo().alert();
		String alertmsg1=driver.switchTo().alert().getText();
		
		System.out.println("alert msg is" +alertmsg1);
		
		alert1.accept();
		screenShot.captureScreenShot("RTTC13_4");
		
		
}
}