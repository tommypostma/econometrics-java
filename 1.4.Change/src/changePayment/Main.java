package changePayment;
import java.util.Scanner; //java class that handles input from user

public class Main {
	//declaration of used variables
	private static Scanner userInput;
	private static Scanner userInput2;
	static double change;
	static double amountPayable;
	static double amountPaid;
	static int changeEuros;
	static int changeCents;

	public static void main(String[] args) {
		change  = -100.0; //init value of change has to be a random stricktly negative number
		userInput = new Scanner(System.in);
		System.out.print("The amount to be paid = € ");
		amountPayable = userInput.nextDouble(); //assigns next entered double to variable
		
		System.out.print("The amount paid  = € ");
		amountPaid = userInput.nextDouble();

		change = amountPaid - amountPayable;
		changeEuros = (int) change;
		changeCents = (int) Math.round((change - changeEuros)*100);
		
		//avoiding negative amount of change
		while (change < 0 ) {
			System.out.println("Amount of money paid is not sufficient. Please try again.");
			userInput2 = new Scanner(System.in);
			System.out.print("The amount to be paid = € ");
			amountPayable = userInput2.nextDouble();
			
			System.out.print("The amount paid  = € ");
			amountPaid = userInput2.nextDouble();

			change  = amountPaid - amountPayable;
			changeEuros = (int) change;
			changeCents = (int) Math.round((change - changeEuros)*100);
		}
		
		//Determining if and what change costumer should receive
		if (change > 0 ) {
			System.out.println("The amount of change  = €" + change);
			System.out.print("The costumer should receive: ");
			
			//Determine what type(s) of money the costumer should receive
			int rest500 = changeEuros % 500;
				if (rest500 < changeEuros ) {
					int eur500 = ((changeEuros - rest500) / 500); //using (int) to avoid error converting double to int
					changeEuros = changeEuros - eur500*500;
					System.out.print(eur500 + " €500 note(s), ");
				}
			int rest200 = changeEuros % 200;
				if (rest200 < changeEuros ) {
					int eur200 = ((changeEuros - rest200) / 200); 
					changeEuros = changeEuros - eur200*200;
					System.out.print(eur200 + " €200 note(s), ");
				}
			int rest100 = changeEuros % 100;
				if (rest100 < changeEuros ) {
					int eur100 = ((changeEuros - rest100) / 100); 
					changeEuros = changeEuros - eur100*100;
					System.out.print(eur100 + " €100 note(s), ");
				}
			int rest50 = changeEuros % 50;
				if (rest50 < changeEuros ) {
					int eur50 = ((changeEuros - rest50) / 50); 
					changeEuros = changeEuros - eur50*50;
					System.out.print(eur50 + " €50 note(s), ");
				}
			int rest20 = changeEuros % 20;
				if (rest20 < changeEuros ) {
					int eur20 = ((changeEuros - rest20) / 20); 
					changeEuros = changeEuros - eur20*20;
					System.out.print(eur20 + " €20 note(s), ");
				}
			int rest10 = changeEuros % 10;
				if (rest10 < changeEuros ) {
					int eur10 = ((changeEuros - rest10) / 10); 
					changeEuros = changeEuros - eur10*10;
					System.out.print(eur10 + " €10 note(s), ");
				}
			int rest5 = changeEuros % 5;
				if (rest5 < changeEuros ) {
					int eur5 = ((changeEuros - rest5) / 5); 
					changeEuros = changeEuros - eur5*5;
					System.out.print(eur5 + " €5 note(s), ");
				}
			int rest2 = changeEuros % 2;
				if (rest2 < changeEuros ) {
					int eur2 = ((changeEuros - rest2) / 2); 
					changeEuros = changeEuros - eur2*2;
					System.out.print(eur2 + " €2 coin(s), ");
				}
			int rest1 = changeEuros % 1;
				if (rest1 < changeEuros ) {
					int eur1 = ((changeEuros - rest1) / 1); 
					changeEuros = changeEuros - eur1*1;
					System.out.print(eur1 + " €1 coin(s), ");
				}
			int rest050 = changeCents % 50;
				if (rest050 < changeCents ) {
					int eur050 = ((changeCents - rest050) / 50); 
					changeCents = changeCents - eur050*50;
					System.out.print(eur050 + " €0.50 coin(s), ");
				}
			int rest020 = changeCents % 20;
				if (rest020 < changeCents ) {
					int eur020 = ((changeCents - rest020) / 20); 
					changeCents = changeCents - eur020*20;
					System.out.print(eur020 + " €0.20 coin(s), ");
				}
			int rest010 = changeCents % 10;
				if (rest010 < changeCents ) {
					int eur010 = ((changeCents - rest010) / 10); 
					changeCents = changeCents - eur010*10;
					System.out.print(eur010 + " €0.10 coin(s), ");
				}	
			int rest005 = changeCents % 5;
				if (rest005 < changeCents ) {
					int eur005 = ((changeCents - rest005) / 5); 
					changeCents = changeCents - eur005*5;
					System.out.print(eur005 + " €0.05 coin(s), ");
				}
			int rest002 = changeCents % 2;
				if (rest002 < changeCents ) {
					int eur002 = ((changeCents - rest002) / 2); 
					changeCents = changeCents - eur002*2;
					System.out.print(eur002 + " €0.02 coin(s), ");
				}
			int rest001 = changeCents % 1;
				if (rest001 < changeCents ) {
					int eur001 = ((changeCents - rest001) / 1); 
					changeCents = changeCents - eur001*1;
					System.out.print(eur001 + " €0.01 coin(s), ");
				}		
			
		} else {
			System.out.println("The costumer receives no change.");
		}
		 
		
		
		
		
	}

}
