//Please change Base URL to Retail url before running this script
package com.training.sanity.tests;

import static org.junit.Assert.assertEquals;
import static org.testng.AssertJUnit.assertEquals;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AdminPOM;
import com.training.pom.CategoryPOM;
import com.training.pom.LoginPOM;
import com.training.pom.ProductPOM;
import com.training.pom.SearchPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_074 {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private AdminPOM adminPOM;
	private SearchPOM searchPOM;
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
		loginPOM = new LoginPOM(driver); 
		searchPOM = new SearchPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test (priority = 0)
	public void LoginTest() throws InterruptedException {
		
		WebElement register=driver.findElement(By.xpath("//i[@class='fa fa-user-o']"));
		Actions Reg=new Actions(driver);
		Reg.moveToElement(register).build().perform();
		driver.findElement(By.xpath("//span[contains(text(),'LOGIN / REGISTER')]")).click();
		
		Thread.sleep(3000);
		loginPOM.sendUserName("chandana4@gmail.com");
		loginPOM.sendPassword("reva123");
		loginPOM.clickLoginBtn();
		assertEquals("My Account",driver.getTitle());
		
		Thread.sleep(3000);
		screenShot.captureScreenShot("RTTC_074_1");
	}
		@Test (priority = 1)
		public void SearchTest() throws InterruptedException {
		WebElement search=driver.findElement(By.xpath("//a[@id='search_button']"));
		Actions sear=new Actions(driver);
		sear.moveToElement(search).build().perform();
		driver.findElement(By.xpath("//input[@id='filter_keyword']")).sendKeys("lacinia congue");
		driver.findElement(By.xpath("//a[@id='search_button']")).click();
		assertEquals("lacinia congue",driver.getTitle());
		searchPOM.SelItem();
		searchPOM.sendquantity("10");
		driver.findElement(By.xpath("//button[@id='button-cart']")).click();
		Thread.sleep(3000);		

		WebElement cart=driver.findElement(By.xpath("//i[@class='tb_icon ico-linea-ecommerce-bag']"));
		Actions cart1=new Actions(driver);
		cart1.moveToElement(cart).build().perform();
		driver.findElement(By.xpath("//a[contains(text(),'View Cart')]")).click();
		assertEquals("Shopping Cart",driver.getTitle());
		screenShot.captureScreenShot("RTTC_074_2");
		}
		@Test (priority = 2)
		public void SearchTest1() throws InterruptedException {
		searchPOM.clickbttn1();
		assertEquals("Checkout",driver.getTitle());
		Thread.sleep(3000);		
		searchPOM.clickbttn2();
		Thread.sleep(3000);		
		searchPOM.clickbttn3();
		Thread.sleep(3000);		
		searchPOM.clickbttn4();
		Thread.sleep(3000);		
		searchPOM.Selcheck();
		Thread.sleep(3000);		
		searchPOM.clickbttn5();
		Thread.sleep(3000);		
		searchPOM.clickbttn6();
		Thread.sleep(3000);		
		searchPOM.clickbttn7();
		screenShot.captureScreenShot("RTTC_074_3");
		WebElement logout=driver.findElement(By.xpath("//i[@class='fa fa-user-o']"));
		Actions log=new Actions(driver);
		log.moveToElement(logout).build().perform();
		driver.findElement(By.xpath("//span[contains(text(),'LOGOUT')]")).click();
		}
	public void setbrowser() {
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Software\\chromedriver_win32\\chromedriver.exe");

		driver=new ChromeDriver(); 
	
		driver.get("baseURL=http://retail.upskills.in/admin");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test(priority=3)
	public void AdminTest() throws InterruptedException {
		
		adminPOM.sendUserName("admin");
		adminPOM.sendPassword("admin@123");
		adminPOM.clickLoginBtn(); 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		screenShot.captureScreenShot("RTTC74_4");
		
		WebElement orders=driver.findElement(By.xpath("//i[@class='fa fa-shopping-cart fw']"));
		Actions act1=new Actions(driver);
		act1.moveToElement(orders).build().perform();
		driver.findElement(By.xpath("//li[@class='active open']//a[contains(text(),'Orders')]")).click();
		assertEquals("Orders",driver.getTitle());
		driver.findElement(By.xpath("//input[@id='input-order-id']")).sendKeys("314");
		driver.findElement(By.xpath("//button[@id='button-filter']")).click();
		driver.findElement(By.xpath("//i[@class='fa fa-eye']")).click();
		
		WebElement Rbox=driver.findElement(By.xpath("//select[@id='input-order-status']"));
		Select sel1=new Select(Rbox);
		sel1.selectByVisibleText("Complete");
	
		driver.findElement(By.xpath("//button[@id='button-history']")).click();
		screenShot.captureScreenShot("RTTC74_5");
		
		WebElement orders1=driver.findElement(By.xpath("//i[@class='fa fa-shopping-cart fw']"));
		Actions act11=new Actions(driver);
		act11.moveToElement(orders1).build().perform();
		driver.findElement(By.xpath("//li[@class='active open']//a[contains(text(),'Orders')]")).click();
		driver.findElement(By.xpath("//input[@id='input-order-id']")).sendKeys("314");
		driver.findElement(By.xpath("//button[@id='button-filter']")).click();
		screenShot.captureScreenShot("RTTC74_6");
	}
}

	