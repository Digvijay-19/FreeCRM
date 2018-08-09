package com.qa.CRM.TestUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.qa.CRM.TestBase.TestBase;


public class ExcelOperations extends TestBase{
	

	public String getxlsorxlsxCellData(String folderpath,String filename, int sheetno, int rowno, int cellno) throws IOException {

	Workbook wb = null;

	File filepath = new File(folderpath+"\\"+filename);
	FileInputStream	fis = new FileInputStream(filepath);
	String fileExtensionName = filename.substring(filename.indexOf("."));
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

	public int getRowCountxlsorxlsx(String folderpath,String filename, int sheetno) throws IOException {

	Workbook wb = null;

	File filepath = new File(folderpath+"\\"+filename);	
	FileInputStream	fis = new FileInputStream(filepath);	
	String fileExtensionName = filename.substring(filename.indexOf("."));	
	if(fileExtensionName.equals(".xlsx")){	
	wb = new XSSFWorkbook(fis);	
	}else if(fileExtensionName.equals(".xls")){	
	wb = new HSSFWorkbook(fis);	
	}	
	Sheet ws = wb.getSheetAt(sheetno);	
	int rowCount1 = ws.getLastRowNum();	
	return rowCount1;	
	}
	
	
	public String getRowxlsorxlsx(String folderpath,String filename, int sheetno,int rowNum,int colNum) throws IOException {

		Workbook wb = null;

		File filepath = new File(folderpath+"\\"+filename);	
		FileInputStream	fis = new FileInputStream(filepath);	
		String fileExtensionName = filename.substring(filename.indexOf("."));	
		if(fileExtensionName.equals(".xlsx")){	
		wb = new XSSFWorkbook(fis);	
		}else if(fileExtensionName.equals(".xls")){	
		wb = new HSSFWorkbook(fis);	
		}	
		Sheet ws = wb.getSheetAt(sheetno);	
		Row r = ws.getRow(rowNum);
		String s = r.getCell(colNum).getStringCellValue();
		return s;
		}
	
	public int getRowCount(String path,int sheetNum) throws IOException{
		
		XSSFWorkbook wb = null;
		try {
		FileInputStream file=new FileInputStream(path);
		wb = new XSSFWorkbook(file);
		XSSFSheet ws=wb.getSheetAt(sheetNum);
		int rowCount = ws.getLastRowNum();
		return rowCount;
		}
		
		finally 
		{
		  wb.close();
		}
	}
	
	public Row getRow(String path,int sheetNum,int rowNum) throws IOException{
		
	
		XSSFWorkbook wb = null;
		try {
		FileInputStream file=new FileInputStream(path);
		wb = new XSSFWorkbook(file);
		XSSFSheet ws=wb.getSheetAt(sheetNum);
		Row r = ws.getRow(rowNum);	
		return r;
	} 
		finally
		{
		wb.close();
	   }
	}
	
	
	public String getCellData(String path,int sheetNum,int rowNum,int cellNum) throws IOException{
		

		XSSFWorkbook wb = null;
		try {
		FileInputStream file=new FileInputStream(path);
		wb = new XSSFWorkbook(file);
		XSSFSheet ws=wb.getSheetAt(sheetNum);
		String data = ws.getRow(rowNum).getCell(cellNum).getStringCellValue();
		return data;
	}
		finally
		{
			wb.close();
		}
	}
}