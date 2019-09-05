package com.gmail.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
public class GmailComposeMail {
	
	private WebDriver driver;
	
	public GmailComposeMail(WebDriver webDriver) {
		this.driver = webDriver;
		PageFactory.initElements(driver, this);
		}
	
	// Compose Mail Button.
	@FindBy(xpath = "//div[@class='T-I J-J5-Ji T-I-KE L3']")
	private WebElement comPoseField;
	
	// Recipients Field. 
	@FindBy(xpath = "//textarea[@name='to']")
	private WebElement recepField;
	
	// Subject Field. 
	@FindBy(xpath = "//input[@name='subjectbox']")
	private WebElement subjctField;
	
	// Message Body Field. 
	@FindBy(xpath = "//div[@id=':rp']")
	private WebElement msgField;
		
	// Sent Button Field. 
	@FindBy(xpath = "//div[@id=':qa']")
	private WebElement sndbutton;
	
	
	public void veriFymail() {
	WebDriverWait wait=new WebDriverWait(driver, 20);
	WebElement sentMail;
	sentMail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Sent')]")));
	sentMail.click();
	
	//Verify that mail is sent
    if (driver.findElement(By.xpath("//span[contains(text(),'You Know Who I AM . I am Iron man')]")) != null)

    {
    	System.out.println("Email Sent Successfully");
    }

    else
    {
        System.out.println("Error::Email is not sent!!");
    }
	
	}
	
	public void sntMail(String Emailid, String Subject, String Msg) {
		comPoseField.click();
		recepField.sendKeys(Emailid);
		subjctField.sendKeys(Subject);
		msgField.sendKeys(Msg);
		sndbutton.click();
		}
}
