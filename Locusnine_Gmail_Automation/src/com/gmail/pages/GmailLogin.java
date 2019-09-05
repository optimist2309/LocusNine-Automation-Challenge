package com.gmail.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GmailLogin {
	
	private WebDriver driver;
	
	// Properties of LoginPage
	// EmailID
	@FindBy(id = "identifierId")
	private WebElement emailID;
	
	// NextButton
	@FindBy(id = "identifierNext")
	private WebElement nextButton;
	
	// Password Field
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordField;
	
	// Next Button on Second Page
	@FindBy(xpath = "//span[contains(text(),'Next')]")
	private WebElement nextButton2;
	
	public GmailLogin(WebDriver webDriver) {
	this.driver = webDriver;
	PageFactory.initElements(driver, this);
	}
	
	public void perFormlogin(String Email, String Password) {
	emailID.sendKeys(Email);
	nextButton.click();
	passwordField.sendKeys(Password);
	nextButton2.click();	
	}
	
	public void verifyLogin() {
		
		WebDriverWait wait=new WebDriverWait(driver, 20);
		WebElement inbox;
		inbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Inbox')]")));
		inbox.click();
		
		if(driver.getCurrentUrl().equals("https://mail.google.com/mail/u/0/#inbox"))	
		
		{
	    	System.out.println("Login Successfully");
	    }

	    else
	    {
	        System.out.println("You are not Logged into Gmail");
	        
	    }
		
		}
}

