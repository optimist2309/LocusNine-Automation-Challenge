package com.gmail.tests;

import com.gmail.basetest.TestBase;
import com.gmail.pages.GmailLogout;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class GmailLogoutTest extends TestBase {
	
	@Test
	public void init() throws Exception{
	
		GmailLogout Logout = PageFactory.initElements(driver, GmailLogout.class);
		Logout.logOutverify();
	}
	}

