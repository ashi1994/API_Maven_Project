package com.json_java;

import java.util.ArrayList;

public class FilterAPI {
	
		  private String trackingNumber;
		  private String info1;
		  private String info2;
		  Pagination paginationObject;
		  ParentCriteria criteriaGroup;
		  
		  
		public ParentCriteria getParentCriteria() {
			return criteriaGroup;
		}

		public void setParentCriteria(ParentCriteria parentCriteria) {
			this.criteriaGroup = parentCriteria;
		}

		private String locale;


		 // Getter Methods 

		  public String getTrackingNumber() {
		    return trackingNumber;
		  }

		  public String getInfo1() {
		    return info1;
		  }

		  public String getInfo2() {
		    return info2;
		  }

		  public Pagination getPagination() {
		    return paginationObject;
		  }

		  public String getLocale() {
		    return locale;
		  }

		 // Setter Methods 

		  public void setTrackingNumber( String trackingNumber ) {
		    this.trackingNumber = trackingNumber;
		  }

		  public void setInfo1( String info1 ) {
		    this.info1 = info1;
		  }

		  public void setInfo2( String info2 ) {
		    this.info2 = info2;
		  }

		  public void setPagination( Pagination paginationObject ) {
		    this.paginationObject = paginationObject;
		  }

		  public void setLocale( String locale ) {
		    this.locale = locale;
		  }
		  
		  public FilterAPI(String trackingNumber,String info1,String info2,Pagination paginationObject, ParentCriteria parentCriteria) {
			  this.trackingNumber=trackingNumber;
			  this.info1=info1;
			  this.info2=info1;
			  this.paginationObject=paginationObject;
			  this.criteriaGroup=parentCriteria;
			  
		  }

		@Override
		public String toString() {
			return "FilterAPI [trackingNumber=" + trackingNumber + ", info1=" + info1 + ", info2=" + info2
					+ ", paginationObject=" + paginationObject.toString() + ", criteriaGroup=" + criteriaGroup.toString() + ", locale="
					+ locale + "]";
		}

		  
		
		}


