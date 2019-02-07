package com.core;

import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.*;

public class ExcelHandleUsingFillo {
	Fillo fc=new Fillo();
	
	
	
	@Test
	public void readFile() throws FilloException {
		Connection conn=fc.getConnection(System.getProperty("user.dir")+"/payload/daily_meal_ingestion_product.xlsx");
		String strQuery="Select * from Sheet1";
		Recordset recordset=conn.executeQuery(strQuery);
		while(recordset.next()){
		    System.out.println(recordset.getField("Store ID*"));
		}

		recordset.close();
		conn.close();
					
	}
	@Test
	public void insertValue() throws FilloException {


        //System.setProperty("ROW", "1");//Table start row
        //System.setProperty("COLUMN", "3");//Table start column
		Connection conn=fc.getConnection(System.getProperty("user.dir")+"/payload/UpdateExcel.xlsx");
		//String strQuery="INSERT INTO Sheet1 (Store ID,External SKU*,dietary preference) VALUES ('100','UK','Something')";
		//String strQuery="INSERT INTO 'Sheet1'(Store ID,External SKU,dietary preference) VALUES ('100','UK','Something')";
		String strQuery="INSERT INTO Sheet1 (Name,Country) VALUES('Peter','UK')";

		conn.executeUpdate(strQuery);

		conn.close();


	}
	@Test
	public void upadateValue() throws FilloException {
	Fillo fillo=new Fillo();
	Connection connection=fillo.getConnection(System.getProperty("user.dir")+"/payload/daily_meal_ingestion_product.xlsx");
	String strQuery="Update Sheet1 Set Store ID*='200' where External SKU*=2";

	connection.executeUpdate(strQuery);

	connection.close();


	}
}
