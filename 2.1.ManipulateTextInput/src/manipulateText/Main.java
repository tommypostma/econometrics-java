package manipulateText;

import java.util.Scanner;

public class Main {

	private static Scanner userInput;
	
	public static void main(String[] args) {
		userInput  = new Scanner(System.in);
		System.out.print("First input: ");
		String firstInput = userInput.next();
		System.out.print("Second input: ");
		String secondInput = userInput.next();
		
		System.out.println(secondInput);
		System.out.println(firstInput);
	}
}
