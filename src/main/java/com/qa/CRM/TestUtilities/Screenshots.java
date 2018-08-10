package com.qa.CRM.TestUtilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.CRM.TestBase.TestBase;

public class Screenshots extends TestBase {
	
	public String captureScreenshot(WebDriver driver,String location,String name) throws IOException{
		
		File scrfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrfile, new File(location+name));
		return location+name;
	}

}
