package com.qa.CRM.PageTest;


import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.CRM.DevPages.CRMLoginPage;
import com.qa.CRM.TestBase.TestBase;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class LoginPageTest extends TestBase {
	
	CRMLoginPage lp = new CRMLoginPage();;
	 
	@BeforeMethod
	 public void setUp(){
		 extent = ExtentReports.get(LoginPageTest.class);
		 extent.init("./AutomationReport.html", true);
		 extent.config().documentTitle("FreeCRMAutomationReport");
		 extent.config().reportHeadline("FreeCRMReport");
		 extent.config().reportTitle("AutomationTestCasesReport");
		 extent.config().displayCallerClass(false);
		 extent.config().useExtentFooter(false);	 
	 }
	
	@Test(priority=1)
	public void login() throws IOException{
		    extent.startTest("Open Browser");
		    extent.log(LogStatus.PASS, "Open Browser Page Started");
			int rowCount = Eo.getRowCount(TestDataPath, loginFile, 0);
			System.out.println("Number of rows in sheet : " +rowCount);
			for(int i=1;i<=rowCount;i++){
			Row r = Eo.getRow(TestDataPath, loginFile, 0, 1, 0);
			lp.Login(r);
			//driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		}
	}
	
	@Test(priority=2)
	public void validateCRMFeature() throws IOException, InterruptedException{
		extent.startTest("CRM Feature");
	    //extent.log(LogStatus.PASS, "Open Browser Page Started");
		/*
		int rowCount = Eo.getRowCount(TestDataPath, loginFile, 0);
		//System.out.println("Number of rows " +rowCount);
		for(int i=1;i<=rowCount;i++){
		Row r = Eo.getRow(TestDataPath, loginFile, 0, 1, 0);
		lp.Login(r);
		} */
		lp = PageFactory.initElements(driver, CRMLoginPage.class);
		Thread.sleep(2000);
		lp.verifyCRMFeature();
}

	@AfterMethod
	public void breakDown(ITestResult result) throws IOException{
		
		 if(ITestResult.FAILURE == result.getStatus()){
			 
			String path = scrnshts.captureScreenshot(driver, screenshotPath, "login.Page.png");
			extent.attachScreenshot(path);
			extent.log(LogStatus.FAIL, "Test Case Failed"+" "+ result.getMethod() +" "+ " "+result.getThrowable());
		}
		else if(ITestResult.SKIP == result.getStatus()){
			
			extent.log(LogStatus.SKIP, "Skip");
			String path = scrnshts.captureScreenshot(driver, screenshotPath, "login.Page.png");
			extent.attachScreenshot(path);
			extent.log(LogStatus.FAIL, "Test Case Skipped"+" "+ result.getMethod() +" "+ " "+result.getThrowable());
		}
		 
		else if(ITestResult.SUCCESS == result.getStatus()){
			
			extent.log(LogStatus.PASS, "Test Case Pass"+" "+ result.getMethod());
		}
		
		extent.endTest();
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
}
	
	

