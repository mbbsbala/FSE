package com.fse.models;

import java.io.Serializable;

public class IncomeDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2572913261072485499L;
	private Double salary;
	private int incrementPercentage;
	private int noOfIncrements;
	private int deductionPercentage;
	private int noOfDeductions;
	private int predictionYears;
	
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public int getIncrementPercentage() {
		return incrementPercentage;
	}
	public void setIncrementPercentage(int incrementPercentage) {
		this.incrementPercentage = incrementPercentage;
	}
	
	public int getDeductionPercentage() {
		return deductionPercentage;
	}
	public void setDeductionPercentage(int deductionPercentage) {
		this.deductionPercentage = deductionPercentage;
	}
	
	public int getPredictionYears() {
		return predictionYears;
	}
	public void setPredictionYears(int predictionYears) {
		this.predictionYears = predictionYears;
	}
	public int getNoOfIncrements() {
		return noOfIncrements;
	}
	public void setNoOfIncrements(int noOfIncrements) {
		this.noOfIncrements = noOfIncrements;
	}
	public int getNoOfDeductions() {
		return noOfDeductions;
	}
	public void setNoOfDeductions(int noOfDeductions) {
		this.noOfDeductions = noOfDeductions;
	}
	
}
