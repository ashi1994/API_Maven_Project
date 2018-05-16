package BaseOperation;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.testng.annotations.AfterClass;

public class BaseClass {
  @Test
  public void f() {
  }
  @BeforeClass
  public void accessUrl() {
	  FileInputStream reader;
	try {
		reader = new FileInputStream(System.getProperty("user.dir")+"/"+"src/test/resources/app.properties");
		 Properties pr=new Properties(); 
			pr.load(reader);
			String Url=pr.getProperty("BaseUrl").trim();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
	  
  }

  @AfterClass
  public void afterClass() {
  }

}
