package com.qa.CRM.TestBase;

import org.openqa.selenium.WebDriver;

import com.qa.CRM.TestUtilities.ExcelOperations;
import com.relevantcodes.extentreports.ExtentReports;

public class TestBase  {

	public static WebDriver driver;

	public static ExcelOperations Eo = new ExcelOperations();
	public static  ExtentReports extent = new ExtentReports("extentPath", true);
	public static String currentDir = System.getProperty("user.dir");
	// /home/flatmind/Documents/Secured/FreeCRMProject
	public static String TestDataPath = currentDir + "/src/main/java/com/qa/CRM/ExcelData";
	public static String extentPath = currentDir + "/test-output/";
	/* 
	 * /home/flatmind/Documents/Secured/FreeCRMProject/src/main/java/com/qa/CRM/ExcelData
	 */
	public static String loginFile = "/LoginTest.xlsx";
	
	
}
