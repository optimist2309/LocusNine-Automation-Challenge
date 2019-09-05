package com.goibibo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class FlightReview {
	
	private WebDriver driver;
	public FlightReview (WebDriver webDriver) {
	this.driver = webDriver;
	PageFactory.initElements(driver, this);
	}
	
	// Ticket Details
	@FindBy(xpath = "//body/div[@id='content']/div/div/div[@class='bkPage']/div[@class='fl width100']/div[@class='bkWrap']/div[@class='flightDetails fl']/div[1]")	
	private WebElement ticketDetails;
	
	// Traveler Details
	@FindBy(xpath = "//div[@class='flightDetails fl']//div//div[@class='borderAll whiteBg posRel crdShdw brRadius5 fl width100 marginT10']//div[@class='fl width100 padLR15 padTB10']")	
	private WebElement travellerDetails;
	
	// Final Price Details.
	@FindBy(xpath = "//div[contains(@class,'borderAll posRel whiteBg crdShdw brRadius5 fl width100 padB10 bkFxdRt marginTB10')]//div[contains(@class,'disPopup farSumTopEn')]")	
	private WebElement finalPrice;
		
	
	public void reviewTicket() throws InterruptedException {
		
		Thread.sleep(7000);
		
		String TicketDet = ticketDetails.getAttribute("innerText");
		System.out.println(TicketDet);
		
		String TravelerDet = travellerDetails.getText();
		System.out.println(TravelerDet);
		
	}
	

}
