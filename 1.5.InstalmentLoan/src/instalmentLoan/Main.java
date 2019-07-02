package instalmentLoan;

import java.util.Scanner;

public class Main {
	//declaration of used variables
	private static Scanner userInput;
	static double onTheSpot;
	static double interestRate;
	static double periods;
	static double interest;
	static double totalCost;
	static double monthlyCost;
		
	public static void main(String[] args) {
		userInput = new Scanner(System.in);
		System.out.print("Money needed right away = €");
		onTheSpot = userInput.nextDouble(); //assigns next entered double to variable
		
		System.out.print("Duration of loan = ");
		periods = userInput.nextDouble();
		
		System.out.print("The interest rate = % ");
		interestRate = (userInput.nextDouble())/100;
		
		totalCost = onTheSpot/(1 - interestRate*periods);
		interest = totalCost - onTheSpot;	
		monthlyCost = totalCost / (periods*12); 
		
		System.out.println("The total cost of the loan equals €" + totalCost);
		System.out.println("The paid interest over " + periods + " years equals €" + interest);
		System.out.println("The total monthly loan payment equals €" + monthlyCost);
	}

}
