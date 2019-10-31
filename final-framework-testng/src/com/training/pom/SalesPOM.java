package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalesPOM {
	
		private WebDriver driver; 
		
		public SalesPOM(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//i[@class='fa fa-plus']")
		private WebElement addorder;
		
		public void clickplus() {
			this.addorder.click();
		}
		@FindBy(xpath="//input[@id='input-firstname']")
		private WebElement firstname;
		
		public void sendFirstName(String firstname) {
			this.firstname.clear();
			this.firstname.sendKeys(firstname);
		}
		@FindBy(xpath="//input[@id='input-lastname']")
		private WebElement lastname;
		
		public void sendLastName(String lastname) {
			this.lastname.clear();
			this.lastname.sendKeys(lastname);
		}
		@FindBy(xpath="//input[@id='input-email']")
		private WebElement email;
		
		public void sendEmail(String email) {
			this.email.clear();
			this.email.sendKeys(email);
		}
		@FindBy(xpath="//input[@id='input-telephone']")
		private WebElement phone;
		
		public void sendPhone(String phone) {
			this.phone.clear();
			this.phone.sendKeys(phone);
		}
		@FindBy(xpath="//button[@id='button-customer']")
		private WebElement bttncontinue;
		
		public void clickconbutton() {
			this.bttncontinue.click();
		}
		
		@FindBy(xpath="//input[@id='input-product']")
		private WebElement clickbox;
		
		public void clickprod() {
			this.clickbox.click();
		}
		
		@FindBy(xpath="//input[@id='input-quantity']")
		private WebElement quantity;
		
		public void sendQuantity(String quantity) {
			this.quantity.clear();
			this.quantity.sendKeys(quantity);
		}
		
		@FindBy(xpath="//button[@id='button-product-add']")
		private WebElement addprod;
		
		public void clickAddprod() {
			this.addprod.click();
		}
		
		@FindBy(xpath="//button[@id='button-cart']")
		private WebElement bttncart;
		
		public void clickCartbttn() {
			this.bttncart.click();
		}
		@FindBy(xpath="//input[@id='input-payment-firstname']")
		private WebElement payfirstname;
		
		public void sendPayFirstName(String payfirstname) {
			this.payfirstname.clear();
			this.payfirstname.sendKeys(payfirstname);
		}
		@FindBy(xpath="//input[@id='input-payment-lastname']")
		private WebElement paylastname;
		
		public void sendPayLastName(String paylastname) {
			this.paylastname.clear();
			this.paylastname.sendKeys(paylastname);
		}

		@FindBy(xpath="//input[@id='input-payment-address-1']")
		private WebElement address;
		
		public void sendAddress(String address) {
			this.address.clear();
			this.address.sendKeys(address);
		}
		@FindBy(xpath="//input[@id='input-payment-city']")
		private WebElement city;
		
		public void sendCity(String city) {
			this.city.clear();
			this.city.sendKeys(city);
		}
		@FindBy(xpath="//button[@id='button-payment-address']")
		private WebElement bttnpay;
		
		public void clickbttnPayment() {
			this.bttnpay.click();
		}

		@FindBy(xpath="//input[@id='input-shipping-firstname']")
		private WebElement sfirstname;
		
		public void sendShipfName(String sfirstname) {
			this.sfirstname.clear();
			this.sfirstname.sendKeys(sfirstname);
		}
		@FindBy(xpath="//input[@id='input-shipping-lastname']")
		private WebElement slastname;
		
		public void sendShiplName(String slastname) {
			this.slastname.clear();
			this.slastname.sendKeys(slastname);
		}
		@FindBy(xpath="//input[@id='input-shipping-address-1']")
		private WebElement saddress;
		
		public void sendShipaddress(String saddress) {
			this.saddress.clear();
			this.saddress.sendKeys(saddress);
		}
		@FindBy(xpath="//input[@id='input-shipping-city']")
		private WebElement scity;
		
		public void sendShipcity(String scity) {
			this.scity.clear();
			this.scity.sendKeys(scity);
		}

		@FindBy(xpath="//button[@id='button-shipping-address']")
		private WebElement shipbttn;
		
		public void clickShipcont() {
			this.shipbttn.click();
		}
		
		@FindBy(xpath="//button[@id='button-save']")
		private WebElement savebttn;
		
		public void clickSave() {
			this.savebttn.click();
		}
}
