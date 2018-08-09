package com.qa.CRM.PageTest;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.CRM.DevPages.CRMLoginPage;
import com.qa.CRM.TestBase.TestBase;

public class LoginPageTest extends TestBase {

	@BeforeMethod
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "/home/flatmind/Documents/Drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(4000, TimeUnit.SECONDS);
	}
	
	@Test
	public void login() throws IOException{
		    int rowCount = Eo.getRowCount(login, 0);
			CRMLoginPage lp = PageFactory.initElements(driver, CRMLoginPage.class);
		    System.out.println(rowCount);
		    for(int i=1;i<=rowCount;i++){
			Row r = Eo.getRow(login, 0, 1);
			System.out.println(r);
			//System.out.println(r.getCell(0).getStringCellValue());
			lp.Login(r);
			driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		    }
	
	}
	
	
	
}
