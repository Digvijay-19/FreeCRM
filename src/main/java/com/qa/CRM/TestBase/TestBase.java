package com.qa.CRM.TestBase;

import org.openqa.selenium.WebDriver;

import com.qa.CRM.TestUtilities.ExcelOperations;

public class TestBase  {

	public static WebDriver driver;
	public static ExcelOperations Eo = new ExcelOperations();
	public static String currentDir = System.getProperty("user.dir");
	public static String filePath = currentDir.replace("\\", "\\\\");
	public static String TestDatapath = currentDir + "\\src\\main\\java\\com\\qa\\CRM\\ExcelData";
	public static String login = filePath + "\\src\\main\\java\\"
			+ "com\\qa\\CRM\\ExcelData\\LoginTest.xls" ;
	
	
}
