package changePayment;

import java.util.Scanner;

public class Main {
	// declaration of used variables
	private static Scanner userInput;
	static double change;
	static double amountPayable;
	static double amountPaid;
	static int changeEuros;
	static int changeCents;
	static String moneyType;

	public static void main(String[] args) {
		userInput = new Scanner(System.in);
		System.out.print("The amount to be paid = € ");
		amountPayable = userInput.nextDouble(); // assigns next entered double
												// to variable

		System.out.print("The amount paid  = € ");
		amountPaid = userInput.nextDouble();

		change = amountPaid - amountPayable;
		changeEuros = (int) change;
		changeCents = (int) Math.round((change - changeEuros) * 100);

		// avoiding negative amount of change
		while (change < 0) {
			System.out.println("Amount of money paid is not sufficient. Please try again.");
			System.out.print("The amount to be paid = € ");
			amountPayable = userInput.nextDouble();

			System.out.print("The amount paid  = € ");
			amountPaid = userInput.nextDouble();
			userInput.close();

			change = amountPaid - amountPayable;
			changeEuros = (int) change;
			changeCents = (int) Math.round((change - changeEuros) * 100);
		}

		if (change > 0) {
			System.out.println("The amount of change  = €" + changeEuros + "." + changeCents);
			System.out.print("The costumer should receive: ");

			// computing change
			int[] eurosTypes = { 500, 200, 100, 50, 20, 10, 5, 2, 1 };
			double[] centsTypes = { 0.50, 0.20, 0.10, 0.05, 0.02, 0.01 };
			int eurosTypesCount = 0;
			int centsTypesCount = 0;
			while (changeEuros > 0) {
				int eur = ((changeEuros - (changeEuros % eurosTypes[eurosTypesCount])) / eurosTypes[eurosTypesCount]);
				if (eurosTypes[eurosTypesCount] > 2) {
					moneyType = " note(s),";
				} else {
					moneyType = " coin(s),";
				}
				if (eur > 0) {
					System.out.print(eur + " €" + eurosTypes[eurosTypesCount] + moneyType);
				}
				changeEuros = changeEuros - eurosTypes[eurosTypesCount] * eur;
				eurosTypesCount = eurosTypesCount + 1;
			}
			while (changeCents > 0) {
				
				int cent = (int) ((changeCents - (changeCents % (centsTypes[centsTypesCount]*100))) / (centsTypes[centsTypesCount]*100));
				if (cent > 0) {
					System.out.print(cent + " €" + centsTypes[centsTypesCount] + " coin(s), ");
				}
				changeCents = (int) (changeCents - (centsTypes[centsTypesCount]*100) * cent);
				centsTypesCount = centsTypesCount + 1;
			}
		} else {
			System.out.println("The costumer receives no change.");
		}
	}

}
