package cosineTaylorApproximation;

import java.util.Scanner;

public class Cosine {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		System.out.print("Use Taylor polynomials to approximate cos ");
		double x = userInput.nextDouble();
		System.out.print("Use epsilon = ");
		double epsilon = userInput.nextDouble();
		userInput.close();

		double cosExact = Math.cos(x);
		double cosApproximate = 1;
		int count = 1;

		while (Math.abs(cosApproximate - cosExact) > epsilon) {
			cosApproximate = cosApproximate + (Math.pow(-1, count) * Math.pow(x, 2 * count)) / nFactorial(2 * count);
			count++;
		}

		System.out.println("The exact value of cos " + x + " equals " + "cos " + x + " = " + cosExact);
		System.out.println("The approximation with epsilon = " + epsilon + " equals " + cosApproximate);
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
