package com.goibibo.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.goibibo.base.TestBase;
import com.goibibo.pages.FlightReview;


public class FlightReviewTest extends TestBase {

	@Test
	public void init() throws Exception{
	
	
		FlightReview fb = PageFactory.initElements(driver, FlightReview.class);
		fb.reviewTicket();
	
}
}
