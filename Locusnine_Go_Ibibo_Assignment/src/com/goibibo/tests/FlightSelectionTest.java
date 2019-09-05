package com.goibibo.tests;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.goibibo.base.TestBase;
import com.goibibo.pages.FlightSelection;

public class FlightSelectionTest extends TestBase {
	
	@Test
	public void init() throws Exception{
		
		int Title = 0;
		String Fname = null;
		String Mname = null;
		String Lname = null;
		String Email = null;
		String Mobno = null;
		
		try {
	        FileInputStream fStream = new FileInputStream(new File(
	                "/home/optimist2309/test_data/testdata.xlsx")); //Enter the path to your excel here

	        // Create workbook instance referencing the file created above
	        XSSFWorkbook workbook = new XSSFWorkbook(fStream);

	        // Get your first or desired sheet from the workbook
	        XSSFSheet sheet = workbook.getSheetAt(0); // getting first sheet

	        XSSFRow  row   = sheet.getRow(1);
	        XSSFCell cell1 = row.getCell(10);
	        XSSFCell cell2 = row.getCell(11);
	        XSSFCell cell3 = row.getCell(12);
	        XSSFCell cell4 = row.getCell(13);
	        XSSFCell cell5 = row.getCell(14);
	        XSSFCell cell6 = row.getCell(15);
	        
	        String DayValueInString = new BigDecimal(cell6.getNumericCellValue()).toPlainString();
	        Title     = (int) cell1.getNumericCellValue();
	        Fname     = cell2.toString();
	        Mname     = cell3.toString();
	        Lname     = cell4.toString();
	        Email     = cell5.toString(); 
	        Mobno     = DayValueInString;
	        
	        fStream.close();
	        workbook.close();
	    
		} catch (Exception e) {
	    
	        e.printStackTrace();
	    
	    }
		
		FlightSelection fb = PageFactory.initElements(driver, FlightSelection.class);
		String ServiceProviderName = fb.flightBook();
		fb.bookingfinal(Fname, Mname, Lname, Email, Mobno, Title ,ServiceProviderName);
		
}
}
