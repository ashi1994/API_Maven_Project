package com.db;

import org.testng.annotations.Test;

import java.sql.SQLException;

public class ProcessDbCall {
    @Test
    public void f() throws SQLException {
        DBAccess db = new DBAccess();
        db.getConnection();
        System.out.println(db.getInvoiceDetails("INVOICE_ID"));
    }
}
