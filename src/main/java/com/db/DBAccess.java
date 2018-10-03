package com.db;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DBAccess {
	public Connection mConnection = null;

	/**
	 * Method to get DB connection
	 * 
	 * @return
	 */

	public Connection getConnection() {

		String databaseDriverName = "jdbc:oracle:thin:@192.168.1.225:1521:ORCL225";

		try {
			mConnection = DriverManager.getConnection(databaseDriverName, "EINVOICE_QA", "EINVOICE_QA");
			if (mConnection != null) {
				System.out.println(
						"************************ Connection has been established successfully *******************");
			}
		} catch (SQLException e) {
			System.out.println("Exception occured while connecting to DB:" + e.toString());
		}
		return mConnection;
	}

	/**
	 * Method to close DB Connection
	 * 
	 */
	public void closeConnection() {
		try {
			mConnection.close();
		} catch (SQLException e) {
			System.out
					.println("**************** Exception occured while closing the DB ***************" + e.toString());
		}
		finally {
			System.out.println("Connection close sucessfully");
		}
	}

	/**
	 * Method to get coloumn Value
	 * 
	 * @param query
	 * @param columnLabel
	 * @return
	 */

	public String getColumnValue(String query, String columnLabel) {
		System.out.println(" Query : " + query);

		ResultSet resultSet = null;
		try {
			m_preparedStatement = mConnection.prepareStatement(query);
			resultSet = m_preparedStatement.executeQuery();

			if (resultSet != null) {
				resultSet.next();
			}
			return resultSet.getString(columnLabel);
		} catch (Exception e) {

		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (m_preparedStatement != null) {
					m_preparedStatement.close();
					m_preparedStatement = null;
				}
				if (m_statement != null) {
					m_statement.close();
					m_statement = null;
				}
			} catch (SQLException e) {
				System.out.println("Exception occured while closing the statements");
			}
		}
		return null;
	}

//	public String getMAPVersionDetails(String coloumnName) {
//		String query = String.format("select %s from MAP_META_VERSION", coloumnName);
//		return getColumnValue(query, coloumnName);
//	}
//	
//	public void getClientDetails() throws SQLException {
//		String que="select * from CLIENT_MASTER";
//		m_statement=mConnection.createStatement();
//		ResultSet rs=m_statement.executeQuery(que);  
//		while(rs.next())  
//			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
//		
//	
//	}
	
	/**
	 * Below function will Give a random invoice id 
	 * @param coloumnName
	 * @return
	 */
	
	public String getInvoiceDetails(String coloumnName) {
		String query = String.format("select %s from (select invoice_id FROM eproc_invoice ORDER BY dbms_random.value) WHERE rownum =1", coloumnName);
		return getColumnValue(query, coloumnName);
	}
	
	public String getFilterId(String coloumnName) {
		String query = String.format("select %s from einvoice_user_filter_data where ROWNUM=1;", coloumnName);
		return getColumnValue(query, coloumnName);
		
	}
	
		public String getFilterDetails(String coloumnName, String tenantID,String userdID) {
		String query =  "select "+coloumnName+" from einvoice_user_filter_data where tenant_id='"+tenantID+"' and user_id='"+userdID+"'";
		return getColumnValue(query, coloumnName);
	}

	private PreparedStatement m_preparedStatement = null;

	private Statement m_statement = null;


}

//http://toolsqa.com/selenium-webdriver/data-base-operations-in-selenium-java/
//put jar ojdbc7-12.0.1 jar for connecting the driver
