package com.qa.CRM.TestUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.qa.CRM.TestBase.TestBase;


public class ExcelOperations extends TestBase{
	

	public String getCellData(String filePath,String fileName, int sheetno, int rowno, int cellno) throws IOException {

	Workbook wb = null;

	File filepath = new File(filePath+"/"+fileName);
	FileInputStream	fis = new FileInputStream(filepath);
	String fileExtensionName = fileName.substring(fileName.indexOf("."));
	if(fileExtensionName.equals(".xlsx")){
	wb = new XSSFWorkbook(fis);
	}else if(fileExtensionName.equals(".xls")){
	wb = new HSSFWorkbook(fis);
	}
	Sheet ws = wb.getSheetAt(sheetno);
	Row r = ws.getRow(rowno);
	String cellData = r.getCell(cellno).getStringCellValue();
	return cellData;	

	}

	public int getRowCount(String filePath,String fileName, int sheetno) throws IOException {

	Workbook wb = null;
	File filepath = new File(filePath+"/"+fileName);	
	FileInputStream	fis = new FileInputStream(filepath);	
	String fileExtensionName = fileName.substring(fileName.indexOf("."));	
	if(fileExtensionName.equals(".xlsx")){	
	wb = new XSSFWorkbook(fis);	
	}else if(fileExtensionName.equals(".xls")){	
	wb = new HSSFWorkbook(fis);	
	}	
	Sheet ws = wb.getSheetAt(sheetno);	
	int rowCount1 = ws.getLastRowNum();	
	return rowCount1;	
	}
	
	
	public Row getRow(String filePath,String fileName, int sheetno,int rowNum,int colNum) throws IOException {

		Workbook wb = null;
		File filepath = new File(filePath+"/"+fileName);	
		FileInputStream	fis = new FileInputStream(filepath);	
		String fileExtensionName = fileName.substring(fileName.indexOf("."));	
		if(fileExtensionName.equals(".xlsx")){	
		wb = new XSSFWorkbook(fis);	
		}else if(fileExtensionName.equals(".xls")){	
		wb = new HSSFWorkbook(fis);	
		}	
		Sheet ws = wb.getSheetAt(sheetno);	
		Row r = ws.getRow(rowNum);
		return r;
		}
	
}