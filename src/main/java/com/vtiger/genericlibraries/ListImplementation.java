package com.vtiger.genericlibraries;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.utils.FileUtil;
import com.google.common.io.Files;

public class ListImplementation  implements ITestListener{

	

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String failedtestCaseName=result.getMethod().getMethodName();
		String currentdate=new Date().toString().replace(":", "_").replace(" ", "_");
		EventFiringWebDriver ed=new EventFiringWebDriver(BaseClass.sdriver);
		File srcimg=ed.getScreenshotAs(OutputType.FILE);
		File dest=new File("./Screenshot/"+failedtestCaseName+currentdate+".PNG");
		try {
			FileUtils.copyFile(srcimg, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	

}
