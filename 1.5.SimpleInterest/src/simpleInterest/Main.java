package simpleInterest;

import java.util.Scanner;

public class Main {
	
	//declaration of used variables
	private static Scanner userInput;
	static double principal;
	static double interestRate;
	static int periods;
	static double interest;
	static double totalCost;
	
	public static void main(String[] args) {
		userInput = new Scanner(System.in);
		System.out.print("The principal value = €");
		principal = userInput.nextDouble(); //assigns next entered double to variable
		
		System.out.print("The simple interest rate per year = % ");
		interestRate = (userInput.nextDouble())/100;
		
		System.out.print("The number of years = ");
		periods = userInput.nextInt();
		
		interest = principal*interestRate*periods;
		System.out.println("The simple interest paid over " + periods + " years equals €" + interest);
		totalCost = principal + interest;
		System.out.println("The total cost of the loan equals €" + totalCost);
	}
}
