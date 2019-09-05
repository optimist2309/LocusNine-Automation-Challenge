package com.gmail.tests;

import com.gmail.basetest.TestBase;
import com.gmail.pages.GmailLogin;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class GmailLoginTest extends TestBase {
	@Test
	public void init() throws Exception{
		String emaiId = null ;
		String password = null;
		
		try {
	        FileInputStream fStream = new FileInputStream(new File(
	                "/home/optimist2309/test_data/testdata.xlsx")); //Enter the path to your excel here

	        // Create workbook instance referencing the file created above
	        XSSFWorkbook workbook = new XSSFWorkbook(fStream);

	        // Get your first or desired sheet from the workbook
	        XSSFSheet sheet = workbook.getSheetAt(0); // getting first sheet

	        XSSFRow  row   = sheet.getRow(1);
	        XSSFCell cell1 = row.getCell(0);
	        XSSFCell cell2 = row.getCell(1);
	        
	        emaiId   = cell1.toString();
	        password = cell2.toString();
	        
	        fStream.close();
	        workbook.close();
	    } catch (Exception e) {
	    
	        e.printStackTrace();
	    }
		
	GmailLogin loginpage = PageFactory.initElements(driver, GmailLogin.class);
	loginpage.perFormlogin(emaiId, password);
	loginpage.verifyLogin();
	}
	}
