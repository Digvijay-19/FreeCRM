package com.qa.CRM.DevPages;


import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.CRM.TestBase.TestBase;

public class CRMLoginPage extends TestBase{

	 CRMLoginPage lp = null;
	 
	 
	 @FindBy(xpath = "//a[contains(text(),'Features')]")
	 WebElement crmFeature;
	 
	
	 
	 public void Login(Row r){
		 
		lp = PageFactory.initElements(driver, CRMLoginPage.class);
		if(r.getCell(0).getStringCellValue()=="Chrome")
		{
	      System.setProperty("webdriver.chrome.driver", "/home/flatmind/Documents/Drivers/chromedriver");
		  driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().pageLoadTimeout(4000, TimeUnit.SECONDS);
	    }
		driver.get(r.getCell(1).getStringCellValue());
		
	 }
	 
	 public void verifyModelsName(){
		 
	 }

}
