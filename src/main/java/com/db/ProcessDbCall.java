package com.db;

import java.sql.SQLException;

import org.testng.annotations.Test;

public class ProcessDbCall {
  @Test
  public void f() throws SQLException {
	  DBAccess db=new DBAccess();
	  db.getConnection();
	  System.out.println(db.getInvoiceDetails("INVOICE_ID"));
  }
}
