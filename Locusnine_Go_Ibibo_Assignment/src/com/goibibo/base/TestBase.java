package com.goibibo.base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
public static WebDriver driver = null;

@BeforeSuite

public void initialize() throws IOException{
driver = new ChromeDriver();

//To maximize browser
driver.manage().window().maximize();

//Implicit wait
driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

//To open open GoIbibo.
driver.get("https://www.goibibo.com/");
}

@AfterSuite

//Test cleanup
public void TeardownTest()
{
TestBase.driver.quit();
}
}
