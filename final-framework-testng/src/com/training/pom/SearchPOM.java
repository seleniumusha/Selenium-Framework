package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPOM {


	private WebDriver driver; 
	
	public SearchPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'lacinia congue')]")
	private WebElement item;
	
	public void SelItem() {
		this.item.click();
	}

	@FindBy(xpath="//input[@id='input-quantity']")
	private WebElement quantity;
	
	public void sendquantity(String quantity) {
		this.quantity.clear();
		this.quantity.sendKeys(quantity);
	}
	
	@FindBy(xpath="//a[@class='btn btn-primary']")
	private WebElement cntbttn1;
	
	public void clickbttn1() {
		this.cntbttn1.click();
	}
	
	@FindBy(xpath="//input[@id='button-payment-address']")
	private WebElement cntbttn2;
	
	public void clickbttn2() {
		this.cntbttn2.click();
	}
	@FindBy(xpath="//input[@id='button-shipping-address']")
	private WebElement cntbttn3;
	
	public void clickbttn3() {
		this.cntbttn3.click();
	}
	@FindBy(xpath="//input[@id='button-shipping-method']")
	private WebElement cntbttn4;
	
	public void clickbttn4() {
		this.cntbttn4.click();
	}
	@FindBy(xpath="//input[@name='agree']")
	private WebElement check;
	
	public void Selcheck() {
		this.check.clear();
		this.check.click();
	}
	@FindBy(xpath="//input[@id='button-payment-method']")
	private WebElement cntbttn5;
	
	public void clickbttn5() {
		this.cntbttn5.click();
	}
	@FindBy(xpath="//input[@id='button-confirm']")
	private WebElement cntbttn6;
	
	public void clickbttn6() {
		this.cntbttn6.click();
	}
	@FindBy(xpath="//a[@class='btn btn-primary']")
	private WebElement cntbttn7;
	
	public void clickbttn7() {
		this.cntbttn7.click();
	}
	


	
}

