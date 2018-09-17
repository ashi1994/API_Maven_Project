package com.json_java;

import java.util.ArrayList;

public class CriteriaGroup {
		  private String logicalOperator;
		  Criteria criteria= new Criteria();

		 // Getter Methods 

		  public Criteria getCriteria() {
			return criteria;
		}

		public void setCriteria(Criteria criteria) {
			this.criteria = criteria;
		}

		public String getLogicalOperator() {
		    return logicalOperator;
		  }

		 // Setter Methods 

		  public void setLogicalOperator( String logicalOperator ) {
		    this.logicalOperator = logicalOperator;
		  }

		@Override
		public String toString() {
			return "CriteriaGroup [logicalOperator=" + logicalOperator + ", criteria=" + criteria.toString() + "]";
		}

		  
}
