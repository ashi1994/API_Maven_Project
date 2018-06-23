package com.base;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.ISuite;
import org.testng.ISuiteListener;

import com.common.Helper;


public class CustomListner implements ISuiteListener {
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
Helper.deleteFile(System.getProperty("user.dir")+"/"+"/test-output/html",2,".html");
		
	}

}
