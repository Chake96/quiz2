package main;
import java.io.*;
import java.util.Scanner;

import org.apache.poi.ss.formula.functions.FinanceLib;


public class main {

	private static double tuCost;
	private static double tuIncrease;
	private static double months;
	private static double apr;

	public static double getTuCost() {
		return tuCost;
	}
	public static double getTuIncrease() {
		return tuIncrease;
	}
	public double getMonths() {
		return months;
	}
	public static double getApr() {
		return apr;
	}

	public void setTuCost(double tuCost) {
		this.tuCost = tuCost;
	}
	public void setTuIncrease(double tuIncrease) {
		this.tuIncrease = tuIncrease;
	}
	public void setMonths(double months) {
		this.months = months;
	}
	public void setApr(double apr) {
		this.apr = apr;
	}


	//the main method which takes in user input and displays
	//the monthly payments and total tuition loan price
	public static void main(String[] args){
		double total = 0;
		double currentTuition = 0;
		double pmt;

		double finalValue = 0;
		boolean paynow = false;		

		main program = new main();

		Scanner uInput = new Scanner (System.in);

		System.out.println("What is your starting tuition cost?");
		double tuCost = uInput.nextDouble();	
		program.setTuCost(tuCost);
		System.out.println("Cost: $"+ getTuCost());

		System.out.println("How much does tution increase per year?");
		double tuIncrease = uInput.nextDouble();	
		program.setTuIncrease(tuIncrease);
		System.out.println("Increase: %"+ getTuIncrease());

		System.out.println("How Many Years Untill the Loan can be paid off?");
		months = uInput.nextDouble();	
		program.setMonths(months);



		System.out.println("What is your Annual Percentage Rate?");
		double apr = uInput.nextDouble();	
		program.setApr(apr);
		System.out.println("Percent: "+ getApr());

		currentTuition = tuCost;
		for(int i = 1; i < 5; i++){
			total = total + currentTuition;
			currentTuition = currentTuition + (currentTuition*tuIncrease);

		}


		apr = apr/12;
		months = months * 12;
		pmt = -FinanceLib.pmt(-apr, months, finalValue, total, paynow);
		System.out.printf("The total cost of the tuition will be $%6.2f \n", total);
		System.out.printf("Each monthly payment must be $%5.2f", pmt);
	}



}
