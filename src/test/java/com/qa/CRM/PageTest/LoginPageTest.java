package com.qa.CRM.PageTest;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.CRM.DevPages.CRMLoginPage;
import com.qa.CRM.TestBase.TestBase;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;


public class LoginPageTest extends TestBase {
	
	CRMLoginPage lp = new CRMLoginPage();;
	 
	@BeforeClass
	 public void setUp(){
		 extent.config().documentTitle("FREECRMREPORT");
	 }
	
	@Test(priority=1)
	public void login() throws IOException{
			int rowCount = Eo.getRowCount(TestDataPath, loginFile, 0);
			System.out.println("Number of rows " +rowCount);
			for(int i=1;i<=rowCount;i++){
			Row r = Eo.getRow(TestDataPath, loginFile, 0, 1, 0);
			lp.Login(r);
			driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
			}
	}

	@AfterMethod
	public void breakDown(ITestResult result){
		
		 if(ITestResult.FAILURE == result.getStatus()){
		 
			extent.log(LogStatus.FAIL, "Fail");
		}
		else if(ITestResult.SKIP == result.getStatus()){
			extent.log(LogStatus.SKIP, "Skip");
		}
		else if(ITestResult.SUCCESS == result.getStatus()){
			extent.log(LogStatus.PASS, "Pass");
		}
		
		extent.flush();
		extent.close();
		
		driver.close();
	}
	
	
	
	
	
	
	
	
	
}
	
	

