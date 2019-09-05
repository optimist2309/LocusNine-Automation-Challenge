package com.goibibo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightSearch {
	
	private WebDriver driver;
	
	public FlightSearch (WebDriver webDriver) {
		this.driver = webDriver;
		PageFactory.initElements(driver, this);
		}
	
	// Properties of page.
		
	// one-way button Locater.
	@FindBy(xpath = "//span[@class='curPointFlt switchAct']")	
	private WebElement oneWaytrip;
	
	// Source Input Field Locater.
	@FindBy(xpath = "//input[@id='gosuggest_inputSrc']")
	private WebElement sourceInput;
	
	// Destination Input Field Locater.
	@FindBy(xpath = "//input[@id='gosuggest_inputDest']")
	private WebElement sourceDest;
	
	//  Calendar Locater.
	@FindBy(xpath = "//input[@placeholder='Departure']")
	private WebElement calDate;
	
	// Search Button Field Locater.
	@FindBy(xpath = "//button[@id='gi_search_btn']")
	private WebElement searchBtn;
	
	public void searchFlight(String Source, String Dest, String MonthToBeSelected, String DAY) throws InterruptedException {
			
		oneWaytrip.click();
		
		sourceInput.sendKeys(Source);
		Thread.sleep(2000);
		sourceInput.sendKeys(Keys.DOWN, Keys.RETURN);
		
		sourceDest.sendKeys(Dest);
		Thread.sleep(2000);
		sourceDest.sendKeys(Keys.DOWN, Keys.RETURN);
		
		// Clicking on Departure Date Picker Box
		driver.findElement(By.xpath("//input[@type='text' and @placeholder='Departure']")).click();
				
		// Logic for Expected Date Picker
		while (true) 
		{
		String monthOnPage = driver.findElement(By.xpath("//div[@class='DayPicker-Caption' and @role='heading']")).getText();
							
		if (monthOnPage.equals(MonthToBeSelected)) 
		{
						break;
					} else
					{
						driver.findElement(
								By.xpath("//span[@role='button' and @class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
					}

				}
				
				// Clicking over the DAY variable date
				driver.findElement(By.xpath("//div[@class='DayPicker-Week']/div[@class='DayPicker-Day']/div[text()=" + DAY + "]")).click();
			Thread.sleep(10000);
			
		searchBtn.click();
		Thread.sleep(30000);
		
		}
	
	
	
	
	
	
	
	




}
