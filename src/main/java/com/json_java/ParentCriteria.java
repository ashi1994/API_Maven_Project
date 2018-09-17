package com.json_java;

public class ParentCriteria {

	@Override
	public String toString() {
		return "ParentCriteria [logicalOperator=" + logicalOperator + ", criteriaGroup=" + criteriaGroup.toString() + "]";
	}
	private String logicalOperator;
	private CriteriaGroup criteriaGroup;
	
	
	public ParentCriteria(String logicalOperator, CriteriaGroup criteriaGroup) {
		this.logicalOperator = logicalOperator;
		this.criteriaGroup = criteriaGroup;
	}
	public String getLogicalOperator() {
		return logicalOperator;
	}
	public void setLogicalOperator(String logicalOperator) {
		this.logicalOperator = logicalOperator;
	}
	public CriteriaGroup getCriteriaGroup() {
		return criteriaGroup;
	}
	public void setCriteriaGroup(CriteriaGroup criteriaGroup) {
		this.criteriaGroup = criteriaGroup;
	}
	
	
	
	
	
	
}
