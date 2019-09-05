package com.goibibo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FlightSelection {
	
private WebDriver driver;
	
	public FlightSelection (WebDriver webDriver) {
		this.driver = webDriver;
		PageFactory.initElements(driver, this);
	}
	
	// Properties of page.
	
	// Departure Filter 4 am to 11 am.
	@FindBy(xpath = "//span[contains(text(),'4am - 11am')]")	
	private WebElement Fouramto11amfilter;
	
	// Departure Filter 11 am to 4pm.
	@FindBy(xpath = "//span[contains(text(),'11am - 4pm')]")	
	private WebElement elevenamto4pm;
		
	// Departure Filter 4pm to 9pm.
	@FindBy(xpath = "//span[contains(text(),'4pm - 9pm')]")	
	private WebElement fourpmto9pm;
		
	// Departure Filter 9pm  to 4 am..
	@FindBy(xpath = "//span[contains(text(),'9pm - 4am')]")	
	private WebElement ninePmto4amfilter;
	
	// ZeroStopFilter
	@FindBy(xpath = "//span[@class='ico16 fb'][contains(text(),'0')]")	
	private WebElement ZeroStopFilter;
		
	//This will always interact with first flight after applying filters.
	@FindBy(xpath = "//body//div[@class='fltHpyWrp padT10 marginT20']//div//div[1]//div[1]//div[1]//div[1]//div[2]//span[1]//span[1]//input[1]")
	private WebElement bookBtn;
	
	// Airline Service Provider Name;
	@FindBy(xpath = "//body/div[@id='content']/div/div/div[@class='paleGreyBg2 width100 fl']/div[@class='fltHpyWrp padT10 marginT20']/div/div[@class='fltHpyResults intRnd']/div/div[@class='marginB10']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]")
	private WebElement serviceProviderName;
	
	// Charity Check-box
	@FindBy(xpath = "//input[@name='charityCheckbox']")	
	private WebElement checkboxCharity;
			
	// Insurance Check-box
	@FindBy(xpath = "//input[@name='insuranceRadio']")	
	private WebElement Insurance;
			
	// Passenger Title Drop Down
	@FindBy(xpath = "//select[@id='Adulttitle1']")	
	private WebElement TitledropDown;
			
	// Passenger First name
	@FindBy(id = "AdultfirstName1")	
	private WebElement FirstName;
			
	// Passenger Middle name
	@FindBy(id = "AdultmiddleName1")	
	private WebElement MiddleName;
			
	// Passenger Last name
	@FindBy(id = "AdultlastName1")	
	private WebElement LastName;
					
	// Passenger Email Id
	@FindBy(id = "email")	
	private WebElement EmailId;
				
	// Passenger Mobile Number
	@FindBy(id = "mobile")	
	private WebElement Mobileno;
	
	// Service provider Name
	@FindBy(xpath = "//span[@class='db greyLt ico12']")	
	private WebElement providerName;
	
	// Travel date Info.
	@FindBy(xpath = "//div[@class='col-md-3 col-sm-3 col-xs-4 padL20']//span[@class='co12 db grey'][contains(text(),'Mon Sep 23 2019')]")	
	private WebElement TraveldateInfo;
	
	// Proceed to payment button
	@FindBy(xpath = "//button[@class='button orange col-md-3 fr large']")
	private WebElement proceedToPaymentText;
			
	public String flightBook() throws InterruptedException {
	ninePmto4amfilter.click();
	Fouramto11amfilter.click();
	elevenamto4pm.click();
	fourpmto9pm.click();
	ZeroStopFilter.click();
	Thread.sleep(5000);
	String SSP = serviceProviderName.getText();
	System.out.println("Airlines Service Provider Name from book page" + " : - " + " " +  serviceProviderName);
	bookBtn.click();
	return SSP;
	}
	
	public void bookingfinal(String firstname, String midname, String lastName, String Mail, String Contactno, int title, String SpNAME) throws InterruptedException {
			
            String traveldateInfo = TraveldateInfo.getAttribute("innerHTML");
			
			if (traveldateInfo.equals("Mon Sep 23 2019")) 
			{
				System.out.println("Travel Date Information is right");
			}
			
			else {
				System.out.println("Travel Date Information is not right");
			}
			
			String serviceNamefromguest = providerName.getAttribute("innerHTML");
			System.out.println("Airlines Service Provider Name from review page" + " : - " + " " +  serviceNamefromguest);
			
			if (serviceNamefromguest.equals(SpNAME)) 
			{
				System.out.println("Airline Service Provider is same as From Book and review page");
			}
			
			else {
				System.out.println("Airline Service Provider is not same as From Book and review page");
			}
			
			
			
			checkboxCharity.click();
			Insurance.click();
			Thread.sleep(5000);
			
			Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='Adulttitle1']")));
			dropdown.selectByIndex(title);
			FirstName.sendKeys(firstname);
			MiddleName.sendKeys(midname);
			LastName.sendKeys(lastName);
			EmailId.sendKeys(Mail);
			Mobileno.sendKeys(Contactno);
			proceedToPaymentText.click();
						
		}
}








