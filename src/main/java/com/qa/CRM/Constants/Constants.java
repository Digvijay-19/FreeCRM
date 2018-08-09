package com.qa.CRM.Constants;

import com.qa.CRM.TestUtilities.ExcelOperations;

public class Constants {

	ExcelOperations Eo = new ExcelOperations();
	public static String currentDir = System.getProperty("user.dir");
	public static String TestDatapath = currentDir + "//src//main//java//com//qa//CRM//ExcelData";
	public static String login = TestDatapath + "//LoginTest.xls";
	
	
	
}
