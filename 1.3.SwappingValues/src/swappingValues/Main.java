package swappingValues;

public class Main {
	public static void main(String[] arg) {
		int a = 5;
		int b = 7;
		System.out.println("Before swapping a = " + a + ", b = " + b);
		a = a-b; //a = -2
		b = b + a; //b = b + (a-b) = a = 5
		a = b - a; //a = b + (a-b) - (a-b) = b = 7
		System.out.println("After swapping a = " + a + ", b = " + b);
	}
	
}	