package sineTaylorApproximation;

import java.util.Scanner;

public class Sine {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		System.out.print("Use Taylor polynomials to approximate sin ");
		double x = userInput.nextDouble();
		System.out.print("Use epsilon = ");
		double epsilon = userInput.nextDouble();
		userInput.close();

		double sinExact = Math.sin(x);
		double sinApproximate = x;
		int count = 1;

		while (Math.abs(sinApproximate - sinExact) > epsilon) {
			sinApproximate = sinApproximate
					+ (Math.pow(-1, count) * Math.pow(x, 2 * count + 1)) / nFactorial(2 * count + 1);
			count++;
		}

		System.out.println("The exact value of sin " + x + " equals " + "sin " + x + " = " + sinExact);
		System.out.println("The approximation with epsilon = " + epsilon + " equals " + sinApproximate);
		System.out.println("It has been derived using Taylor polynomials of order " + count);

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
