package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryPOM {

	private WebDriver driver; 
	
	public CategoryPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Categories')]")
	private WebElement category; 
		
	@FindBy(xpath="//i[@class='fa fa-plus']")
	private WebElement addcategory;
	
	@FindBy(xpath="//input[@id='input-name1']")
	private WebElement catname;
	
	@FindBy(xpath="//input[@id='input-meta-title1']")
	private WebElement title;
	
	@FindBy(xpath="//a[contains(text(),'Data')]")
	private WebElement data;
	
	@FindBy(xpath="//input[@id='input-model']")
	private WebElement model;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	private WebElement button;
	
	// //*[@name='selected[]' and @value='705']
	@FindBy(xpath="//tr[3]//td[1]//input[1]")
	private WebElement checkbox; 
	
	@FindBy(xpath="//tbody//tr[1]//td[1]//input[1]")
	private WebElement checkbox1; 
	
	@FindBy(xpath="//i[@class='fa fa-trash-o']")
	private WebElement delete;
	
	public void clickcategory() {
		this.category.click();
	}
	
	public void clickplus() {
		this.addcategory.click();
	}
	
	public void sendcategoryName(String catname) {
		this.catname.clear();
		this.catname.sendKeys(catname);
	}
	
	public void sendTitle(String title) {
		this.title.clear();
		this.title.sendKeys(title);
	}
	
	public void clickData() {
		this.data.click();
	}
	
	public void sendModel(String model) {
		this.model.clear();
		this.model.sendKeys(model);
	}
	
	public void clickSave() {
		this.button.click();
	}
	
	public void checkbttn() {
		this.checkbox.click(); 
	}
	
	public void checkbttn1() {
		this.checkbox1.click(); 
	}
	
	public void clickdelete() {
		this.delete.click(); 
	}
	@FindBy(xpath="//input[@id='input-price']")
	private WebElement price;
	
	public void sendPrice(String price) {
		this.price.clear();
		this.price.sendKeys(price);
	}
	@FindBy(xpath="//a[contains(text(),'Links')]")
	private WebElement link;
	
	public void clickLink() {
		this.link.click();
	}
	
}
