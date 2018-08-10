package com.qa.CRM.TestBase;

import org.openqa.selenium.WebDriver;

import com.qa.CRM.TestUtilities.ExcelOperations;
import com.qa.CRM.TestUtilities.Screenshots;
import com.relevantcodes.extentreports.ExtentReports;

public class TestBase  {

	public static WebDriver driver;

	public static ExcelOperations Eo = new ExcelOperations();
	public static Screenshots scrnshts = new Screenshots();
	public static ExtentReports extent = new ExtentReports();
	//public static ExtentTest extentTest = new ExtentTest("extentPath","extentPath");
	public static String currentDir = System.getProperty("user.dir");
	// /home/flatmind/Documents/Secured/FreeCRMProject
	public static String TestDataPath = currentDir + "/src/main/java/com/qa/CRM/ExcelData";
	public static String extentPath = currentDir + "/test-output/";
	public static String screenshotPath = currentDir + "/src/main/java/com/qa/CRM/Screenshots/";
	/* 
	 * /home/flatmind/Documents/Secured/FreeCRMProject/src/main/java/com/qa/CRM/ExcelData
	 */
	public static String loginFile = "/LoginTest.xlsx";
	
	
	
}
