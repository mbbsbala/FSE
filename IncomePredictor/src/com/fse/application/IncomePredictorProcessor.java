package com.fse.application;

import java.text.DecimalFormat;

import com.fse.models.IncomeDTO;

/**
 * 
 * @author o1172
 *
 */
public class IncomePredictorProcessor {
	
	private DecimalFormat df1 = new DecimalFormat("##,##,##,##,##,##,##0.00");
	
	public void incrementReportGenerator(IncomeDTO incomeDto) {
		System.out.println("Increment Report");
		System.out.println("| Year | Starting Salary | Number of Increments | Increment % | Increment Amount  |");
		int years = incomeDto.getPredictionYears();
		for (int i = 1; i <= years; i++) {
			double incrementAmount = incomeDto.getSalary() * (Float.parseFloat(String.valueOf(incomeDto.getIncrementPercentage())) / 100) * incomeDto.getNoOfIncrements();
			System.out.println("| " + i + "    | " + df1.format(incomeDto.getSalary()) + "       | " + incomeDto.getNoOfIncrements() + "                    | " + incomeDto.getIncrementPercentage() + "%          | " + df1.format(incrementAmount) + "           |");
			incomeDto.setSalary(incomeDto.getSalary() + incrementAmount);
		}
	}
	
	public void deductionReportGenerator(IncomeDTO incomeDto) {
		System.out.println("Deduction Report");
		System.out.println("| Year | Starting Salary | Number of deductions | Deduction  % | Deduction Amount |");
		int years = incomeDto.getPredictionYears();
		for (int i = 1; i <= years; i++) {
			double deductedAmount = incomeDto.getSalary() * (Float.parseFloat(String.valueOf(incomeDto.getDeductionPercentage())) / 100) * incomeDto.getNoOfDeductions();
			System.out.println("| " + i + "    | " + df1.format(incomeDto.getSalary()) + "       | " + incomeDto.getNoOfIncrements() + "                    | " + incomeDto.getDeductionPercentage() + "%          | " + df1.format(deductedAmount) + "            |");
			incomeDto.setSalary(incomeDto.getSalary() - deductedAmount);
		}
	}
	
	public void predictionGenerator(IncomeDTO incomeDto) {
		System.out.println("Prediction");
		System.out.println("| Year | Starting Salary | Increment Amount | Deduction Amount | Salary Growth  |");
		int years = incomeDto.getPredictionYears();
		for (int i = 1; i <= years; i++) {
			double incrementAmount = incomeDto.getSalary() * (Float.parseFloat(String.valueOf(incomeDto.getIncrementPercentage())) / 100) * incomeDto.getNoOfIncrements();
			double deductedAmount = incomeDto.getSalary() * (Float.parseFloat(String.valueOf(incomeDto.getDeductionPercentage())) / 100) * incomeDto.getNoOfDeductions();;
			double salaryGrouth = incrementAmount - deductedAmount;
			System.out.println("| " + i + "    | " + df1.format(incomeDto.getSalary()) + "       | " + df1.format(incrementAmount) + "           | " + df1.format(deductedAmount) + "           | " + df1.format(salaryGrouth) + "          |");
			incomeDto.setSalary(incomeDto.getSalary() + salaryGrouth);
		}
	}
}
