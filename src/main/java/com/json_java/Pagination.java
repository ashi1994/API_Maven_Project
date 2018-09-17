package com.json_java;

public class Pagination {
		  private float totalRecords;
		  private float maxRows;
		  private float pageNumber;


		 // Getter Methods 

		  public float getTotalRecords() {
		    return totalRecords;
		  }

		  public float getMaxRows() {
		    return maxRows;
		  }

		  public float getPageNumber() {
		    return pageNumber;
		  }

		 // Setter Methods 

		  public void setTotalRecords( float totalRecords ) {
		    this.totalRecords = totalRecords;
		  }

		  public void setMaxRows( float maxRows ) {
		    this.maxRows = maxRows;
		  }

		  public void setPageNumber( float pageNumber ) {
		    this.pageNumber = pageNumber;
		  }

		  public Pagination(float totalRecords,float maxRows,float pageNumber) {
			  this.totalRecords = totalRecords;
			  this.maxRows = maxRows;
			  this.pageNumber = pageNumber;
		  }

		@Override
		public String toString() {
			return "Pagination [totalRecords=" + totalRecords + ", maxRows=" + maxRows + ", pageNumber=" + pageNumber
					+ "]";
		}
		  
		  
}
