package factorialList;

import java.util.Arrays;
import java.util.Scanner;

public class factorial {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		System.out.print("Print the factorials of the integers from 1 up to and including: ");
		int upperbound = userInput.nextInt();
		userInput.close();

		int[] factorials = new int[upperbound];
		factorials[0] = nFactorial(1);

		for (int count = 2 ; count <= upperbound ; count++) {
		factorials[count - 1] = nFactorial(count);
		}

		System.out.print("The factorials of the integers from 1 up to and including " + upperbound + " are: ");
		System.out.println(Arrays.toString(factorials));
	}

	static int nFactorial(int n) {
		if (n < 1) {
			n = 1;
		} else {
			int bound = n;
			for (int i = 1; i < bound; i++) {
				n = n * i;
			}
		}
		return n;
	}

}
