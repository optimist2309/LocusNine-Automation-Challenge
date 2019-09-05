package com.gmail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailLogout {

	private WebDriver driver;
	
	public GmailLogout(WebDriver webDriver) {
		this.driver = webDriver;
		PageFactory.initElements(driver, this);
		}
	
	// Profile Click
	@FindBy(xpath = "//a[@class='gb_z gb_Ia gb_g']")
	private WebElement profileBtn;
	
	// Sign Out Button
	@FindBy(xpath = "//a[@id='gb_71']")
	private WebElement signOutbtn;
	
	public void logOutverify() {
	String sent_page_mail_url = driver.getCurrentUrl();
	profileBtn.click();
	signOutbtn.click();
	
	if(driver.getCurrentUrl().equals(sent_page_mail_url)) {
	System.out.println("You are not Loged out");	
	}
	
	else {
		System.out.println("Logout SucessFully");
	}
	}
}

