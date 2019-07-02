package compoundedInterest;

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
		
		System.out.print("The compounded interest rate per year = % ");
		interestRate = (userInput.nextDouble())/100;
		
		System.out.print("The number of years = ");
		periods = userInput.nextInt();
		
		totalCost = principal*(Math.pow((1+interestRate), periods));
		interest = totalCost - principal;
		System.out.println("The compounded interest paid over " + periods + " years equals €" + interest);
		System.out.println("The total cost of the loan equals €" + totalCost);
	}
}
