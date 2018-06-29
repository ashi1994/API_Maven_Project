package com.base;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.common.Helper;


public class CustomListner implements ISuiteListener,ITestListener {
	public void onFinish(ISuite arg0) {
		   File htmlFile = new File(System.getProperty("user.dir")+"/"+"/test-output/html/index.html");
			  try {
				Desktop.getDesktop().browse(htmlFile.toURI());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		System.out.println("Ending Test Suite "+arg0.getName());		
	}
	}
	public void onStart(ISuite arg0) {
		// TODO Auto-generated method stub
//Helper.deleteFile(System.getProperty("user.dir")+"/"+"/test-output/html",2,".html");
		
	}
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
	public void onTestFailure(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

}
