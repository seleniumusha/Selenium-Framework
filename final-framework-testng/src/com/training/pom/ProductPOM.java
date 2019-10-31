package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPOM {

	private WebDriver driver; 
	
	public ProductPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Products')]")
	private WebElement product; 
	
	@FindBy(xpath="//input[@id='input-name']")
	private WebElement prodname;
	
	@FindBy(xpath="//button[@id='button-filter']")
	private WebElement filter;
	
	@FindBy(xpath="//input[@id='input-price']")
	private WebElement price;
	
	@FindBy(xpath="//tr[1]//td[8]//a[1]//i[1]")
	private WebElement Edit;
	
	@FindBy(xpath="//a[contains(text(),'Data')]")
	private WebElement Data;
	
	@FindBy(xpath="//input[@id='input-quantity']")
	private WebElement Quantity;
	
	@FindBy(xpath="//i[@class='fa fa-save']")
	private WebElement Save;
	
	@FindBy(xpath="//tr[2]//td[1]//input[1]")
	private WebElement checkbox2; 
		
	public void clickProduct() {
		this.product.click();
	}
	
	public void sendProdName(String prodname) {
		this.prodname.clear();
		this.prodname.sendKeys(prodname);
	}
	
	public void clickFilterbttn() {
		this.filter.click();
	}
	
	public void sendPrice(String price) {
		this.prodname.clear();
		this.price.clear();
		this.price.sendKeys(price);
	}
	public void clickeditbttn() {
		this.Edit.click();
	}
	public void clickdatabttn() {
		this.Data.click();
	}
	public void sendquantity(String Quantity) {
		this.Quantity.clear();
		this.Quantity.sendKeys(Quantity);
	}
	public void clicksavebttn() {
		this.Save.click();
	}
	public void checkbttn2() {
		this.checkbox2.click(); 
	}
}
