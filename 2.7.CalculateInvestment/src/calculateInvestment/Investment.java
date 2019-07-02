package calculateInvestment;

import java.util.Scanner;

public class Investment {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		System.out.print("Gross Domestic Product (GDP - million $) = ");
		double gdp = userInput.nextDouble();
		System.out.print("Gross Domestic Consumption (DC - million $) = ");
		double dc = userInput.nextDouble();
		System.out.print("Gross Government Spending (GS - million $) = ");
		double gs = userInput.nextDouble();
		System.out.print("Gross Net Exports (NX - million $) = ");
		double nx = userInput.nextDouble();
		userInput.close();

		double inv = gdp - dc - gs - nx;
		int invDollars = (int) inv;
		int invCents = (int) Math.round((inv - invDollars) * 100);

		System.out.println("The potential investment INV = GDP - DC - GS - NX = " + invDollars + "." + invCents);
	}
}
