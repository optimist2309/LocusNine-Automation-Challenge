package com.gmail.tests;
import com.gmail.basetest.TestBase;
import com.gmail.pages.GmailComposeMail;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class GmailComposeMailTest extends TestBase {
	@Test
	public void init() throws Exception{
		String recpId = null;
		String subJect = null;
		String msg = null;
		
		try {
	        FileInputStream fStream = new FileInputStream(new File(
	                "/home/optimist2309/test_data/testdata.xlsx")); //Enter the path to your excel here

	        // Create workbook instance referencing the file created above
	        XSSFWorkbook workbook = new XSSFWorkbook(fStream);

	        // Get your first or desired sheet from the workbook
	        XSSFSheet sheet = workbook.getSheetAt(0); // getting first sheet

	        XSSFRow  row   = sheet.getRow(1);
	        XSSFCell cell3 = row.getCell(2);
	        XSSFCell cell4 = row.getCell(3);
	        XSSFCell cell5 = row.getCell(4);
	        
	        recpId   = cell3.toString();
	        subJect  = cell4.toString(); 
	        msg      = cell5.toString();
	        
	        
	        fStream.close();
	        workbook.close();
	    } catch (Exception e) {
	    	
	        e.printStackTrace();
	    }
		GmailComposeMail compmail = PageFactory.initElements(driver, GmailComposeMail.class);
		compmail.sntMail(recpId, subJect, msg);
		compmail.veriFymail();
	}
	}


