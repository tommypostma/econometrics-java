package fibonacciSequence;

import java.util.Arrays;
import java.util.Scanner;

public class Fibonacci {
	
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		System.out.print("Enter the number of Fibonacci numbers you would like to know: ");
		int upperbound = userInput.nextInt();
		userInput.close();
		
		int[] fibonacci = new int[upperbound];
		fibonacci[0] = 1;
		fibonacci[1] = 1;
		
		for (int counter = 2; counter <= (upperbound - 1); counter++) {
			fibonacci[counter] = (fibonacci[counter - 1] + fibonacci[counter - 2]);
		}
		
		System.out.print("The first " + upperbound + " Fibonacci numbers are:");
		System.out.println(Arrays.toString(fibonacci));
	}

}
