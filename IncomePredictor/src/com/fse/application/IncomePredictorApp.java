package com.fse.application;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.fse.models.IncomeDTO;

/**
 * 
 * @author o1172
 *
 */
public class IncomePredictorApp {

	private static final List<String> PREDICTION_YEARS = Arrays.asList(new String[]{"5","10","20","30","50"});
	private static final List<String> FREQUENCY = Arrays.asList(new String[]{"1","2","3","4"});
			
	public static void main(String[] args) {
		//String choice = "N";
		String salary = null;
		String incrementPercent = null;
		String incrementFrequency = null;
		String deductionPercent = null;
		String deductionFrequency = null;
		String predictionInput = null;
		
		//do { 
			try {
				System.out.print("Enter starting salary for the employee : ");
				while(StringUtils.isBlank(salary) || (StringUtils.isNotBlank(salary) && Double.parseDouble(salary) < 1)) {
					salary = (new BufferedReader(new InputStreamReader(System.in))).readLine();
					if((StringUtils.isNotBlank(salary) && Double.parseDouble(salary) < 1)) {
						System.out.print("Please enter valid Salary: ");
					} else if(StringUtils.isBlank(salary)) {
						System.out.print("Please enter valid Salary: ");
					}
				}
				System.out.print("Enter Increment to be received in percent : ");
				while(StringUtils.isBlank(incrementPercent) || (StringUtils.isNotBlank(incrementPercent) && Integer.parseInt(incrementPercent) < 1)) {
					incrementPercent = (new BufferedReader(new InputStreamReader(System.in))).readLine();
					if((StringUtils.isNotBlank(incrementPercent) && Integer.parseInt(incrementPercent) < 1)) {
						System.out.print("Please enter valid Increment Percentage: ");
					} else if(StringUtils.isBlank(incrementPercent)) {
						System.out.print("Please enter valid Increment Percentage");
					}
				}
				System.out.print("Please choose any one of the frequency \n**************************************************\n" 
						+ "1. Monthly\n" 
						+ "2. Quarterly\n" 
						+ "3. Half-Yearly\n"
						+ "4. Annually\n**********************************\n" + "How frequently is increment received (1-4) : ");
				while(StringUtils.isBlank(incrementFrequency) || StringUtils.isNotBlank(incrementFrequency) && !FREQUENCY.contains(incrementFrequency)) {
					incrementFrequency = (new BufferedReader(new InputStreamReader(System.in))).readLine();
					if(StringUtils.isNotBlank(incrementFrequency) && !FREQUENCY.contains(incrementFrequency)) {
						System.out.print("Please enter valid Frequency [1-4]: ");
					} else if(StringUtils.isBlank(incrementFrequency)) {
						System.out.print("Please enter valid Frequency [1-4]: ");
					}
				}
				System.out.print("Enter Deductions on income in percent : ");
				while(StringUtils.isBlank(deductionPercent) || (StringUtils.isNotBlank(deductionPercent) && Integer.parseInt(deductionPercent) < 1)) {
					deductionPercent = (new BufferedReader(new InputStreamReader(System.in))).readLine();
					if((StringUtils.isNotBlank(deductionPercent) && Integer.parseInt(deductionPercent) < 1)) {
						System.out.print("Please enter valid Deductions Percentage: ");
					} else if(StringUtils.isBlank(deductionPercent)) {
						System.out.print("Please enter valid Deductions Percentage");
					}
				}
				
				System.out.print("Please choose any one of the frequency \n**************************************************\n" 
						+ "1. Monthly\n" 
						+ "2. Quarterly\n" 
						+ "3. Half-Yearly\n"
						+ "4. Annually\n**********************************\n" + "How frequently are deductions done (1-4) : ");
				while(StringUtils.isBlank(deductionFrequency) || StringUtils.isNotBlank(deductionFrequency) && !FREQUENCY.contains(deductionFrequency)) {
					deductionFrequency = (new BufferedReader(new InputStreamReader(System.in))).readLine();
					if(StringUtils.isNotBlank(deductionFrequency) && !FREQUENCY.contains(deductionFrequency)) {
						System.out.print("Please enter valid Frequency [1-4]: ");
					} else if(StringUtils.isBlank(incrementFrequency)) {
						System.out.print("Please enter valid Frequency [1-4]: ");
					}
				}
				
				System.out.print("Prediction for (years) : ");
				while(StringUtils.isBlank(predictionInput) || (StringUtils.isNotBlank(predictionInput) && !PREDICTION_YEARS.contains(predictionInput))) {
					predictionInput = (new BufferedReader(new InputStreamReader(System.in))).readLine();
					if((StringUtils.isNotBlank(predictionInput) && !PREDICTION_YEARS.contains(predictionInput))) {
						System.out.print("Please enter valid Prediction for (years) " + PREDICTION_YEARS + " : ");
					} else if(StringUtils.isBlank(predictionInput)) {
						System.out.print("Please enter valid Prediction for (years) " + PREDICTION_YEARS + " : ");
					}
				}
				System.out.println("------------------------------------------------------------------------------------------------------------------");
				
				IncomePredictorProcessor processor = new IncomePredictorProcessor();
				
				IncomeDTO incomeDto = new IncomeDTO();
				incomeDto.setSalary(Double.parseDouble(salary));
				incomeDto.setIncrementPercentage(Integer.parseInt(incrementPercent));
				incomeDto.setNoOfIncrements(getNoOfIncOrDec(incrementFrequency));
				incomeDto.setDeductionPercentage(Integer.parseInt(deductionPercent));
				incomeDto.setNoOfDeductions(getNoOfIncOrDec(deductionFrequency));
				incomeDto.setPredictionYears(Integer.parseInt(predictionInput));
				
				processor.incrementReportGenerator(incomeDto);
				System.out.println("------------------------------------------------------------------------------------------------------------------");
				
				incomeDto.setSalary(Double.parseDouble(salary));
				processor.deductionReportGenerator(incomeDto);				
				System.out.println("------------------------------------------------------------------------------------------------------------------");
				
				incomeDto.setSalary(Double.parseDouble(salary));
				processor.predictionGenerator(incomeDto);
				System.out.println("------------------------------------------------------------------------------------------------------------------");
				
				/*System.out.print("Do you want to continue (Y/N) : ");
				choice = (new BufferedReader(new InputStreamReader(System.in))).readLine();*/
			} catch(Exception e) {
				System.err.println("Error while predicting income. with error : " + e.getMessage());
			}
		//} while("Y".equals(choice));
	}

	private static int getNoOfIncOrDec(String frequency) {
		int incfreq = Integer.parseInt(frequency);
		if(incfreq == 1) {
			return 12;
		} else if(incfreq == 2) {
			return 4;
		} else if(incfreq == 3) {
			return 2;
		} else {
			return 1;
		}
	}
}
