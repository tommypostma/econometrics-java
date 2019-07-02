package checkPrimeNumber;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		System.out.print("Enter the number that has to be checked on primality: ");
		int numberInput = userInput.nextInt();
		userInput.close();
		
		boolean isItPrime = true;
		int counter = 2;
		
		while(counter <= Math.sqrt(numberInput) && isItPrime == true) {
			if (numberInput % counter == 0) {
				isItPrime = false;
				System.out.println("The number " + numberInput + " is not a prime number");
			}
			counter++;
		}
		
		if (isItPrime == true) {
			System.out.println("The number " + numberInput + " is a prime number");
		}
	}	

}
