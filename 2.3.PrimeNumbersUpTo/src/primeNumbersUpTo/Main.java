package primeNumbersUpTo;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int[] primes;
	static int numberCheck;

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		System.out.print("Enter the upper bound for checking on primality: ");
		int upperbound = userInput.nextInt();
		userInput.close();

		int[] primes = new int[0];

		for (numberCheck = 1; numberCheck <= upperbound; numberCheck++) {
			boolean isItPrime = true;
			int counter = 2;
			while (counter <= Math.sqrt(numberCheck) && isItPrime == true) { //using trial division
				if (numberCheck % counter == 0) {
					isItPrime = false;
				}
				counter++;
			}
			if (isItPrime == true) {
				primes = addElement(primes, numberCheck);
			}
		}
		System.out.println("These are the " + primes.length + " prime numbers up to and including " + upperbound + ":");
		System.out.println(Arrays.toString(primes));
	}
	
	//Arrays are fixed in size, coppying the original into a new one with length + 1 solves the problem
	static int[] addElement(int[] add, int element) {
		add = Arrays.copyOf(add, add.length + 1);
		add[add.length - 1] = element;
		return add;
	}
	

}
