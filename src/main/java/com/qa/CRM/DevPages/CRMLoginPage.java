package com.qa.CRM.DevPages;

import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.CRM.TestBase.TestBase;

public class CRMLoginPage extends TestBase{

	 @FindBy(xpath = "//a[contains(text(),'Features')]")
	 WebElement crmFeature;
	 
	 public void Login(Row r){
		 
		driver.get(r.getCell(0).getStringCellValue());
		if(crmFeature.isDisplayed()){
			System.out.println(crmFeature.getText());
		}
	 }

}
