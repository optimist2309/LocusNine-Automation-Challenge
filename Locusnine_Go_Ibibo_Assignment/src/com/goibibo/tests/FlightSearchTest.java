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
import com.goibibo.pages.FlightSearch;

public class FlightSearchTest extends TestBase {
	
	@Test
	public void init() throws Exception{
	String Source = null ;
	String Dest = null;
	String Day = null;
	String Year = null;
	String Month = null;
	String MonthToBeSelected = null;
	
	try {
        FileInputStream fStream = new FileInputStream(new File(
                "/home/optimist2309/test_data/testdata.xlsx")); //Enter the path to your excel here

        // Create workbook instance referencing the file created above
        XSSFWorkbook workbook = new XSSFWorkbook(fStream);

        // Get your first or desired sheet from the workbook
        XSSFSheet sheet = workbook.getSheetAt(0); // getting first sheet

        XSSFRow  row   = sheet.getRow(1);
        XSSFCell cell1 = row.getCell(5);
        XSSFCell cell2 = row.getCell(6);
        XSSFCell cell3 = row.getCell(7);
        XSSFCell cell4 = row.getCell(8);
        XSSFCell cell5 = row.getCell(9);
        
        Source   = cell1.toString();
        Dest     = cell2.toString();
        Day      = cell3.toString();
        Month    = cell4.toString();
            
        String DayValueInString = new BigDecimal(cell3.getNumericCellValue()).toPlainString();
        Year = new BigDecimal(cell5.getNumericCellValue()).toPlainString();
       
        Day = DayValueInString;
        MonthToBeSelected = Month + " " + Year;
        
        fStream.close();
        workbook.close();
    
	} catch (Exception e) {
    
        e.printStackTrace();
    }
	
	FlightSearch fs1 = PageFactory.initElements(driver, FlightSearch.class);
	fs1.searchFlight(Source, Dest, MonthToBeSelected,Day);
	
}
}