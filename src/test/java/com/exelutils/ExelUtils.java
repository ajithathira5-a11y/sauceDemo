package com.exelutils;


import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExelUtils {
	
	public static Object[][] getTestData(String filepath, String sheetname) throws IOException
	{
		FileInputStream fis = new FileInputStream(filepath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetname);
		
		int row = sheet.getLastRowNum();
		int col = sheet.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[row][col];
		
		DataFormatter formatter  = new DataFormatter();
		for(int i = 1;i<=row;i++)
		{
			for(int j=0; j<col;j++)
			{
				data[i-1][j] = formatter.formatCellValue(sheet.getRow(i).getCell(j));
				
			}
		}
		workbook.close();
		
		fis.close();
		return data;
		
	}

}
