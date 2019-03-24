package com.Walkthrough.Concepts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.hssf.eventusermodel.dummyrecord.LastCellOfRowDummyRecord;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class GetExcelData {
	
	

	public static void getTestdata(String Sheet,String Value) throws Exception
	{
		try
		{
			String path = System.getProperty("user.dir")+File.separator+"Resources"+File.separator+"Rockers.xlsx";
			File file = new File(path);
			FileInputStream fis = new FileInputStream(file);
			Thread.sleep(1000);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sht =  wb.getSheet(Sheet);
			int rowcnt = sht.getLastRowNum() - sht.getFirstRowNum();
			
			for(int i = 1; i<=rowcnt; i++)
			{
				if(sht.getRow(i).getCell(1).getStringCellValue().equalsIgnoreCase(Value))
				{
					String data = sht.getRow(i).getCell(2).getStringCellValue();
					System.out.println("The expected data for "+Value+" from Excel sheet is "+ data);
					break;
				}
				
			}
		}
		catch(NullPointerException e)
		{
			System.out.println("The Selected value is not a valid one "+e);
		}
	}
	
	@Test(priority = 0)
	public void testcase() throws Exception
	{
		getTestdata("TestData", "Nineth");
	}

}
