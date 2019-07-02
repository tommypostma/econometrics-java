package deusExMachina;

import deusExMachina.FoodStuff;

public class Household {
	FoodStuff produce;
	int product;
	int[] stock = new int[] { 0, 0, 0, 0 };;

	// constructor method
	public Household(FoodStuff what) {
		this.produce = what;
		product = produce.getProductVal();

	}
	//Turning FoodStuff enum entries into an array
	public static String[] products() {
		String[] products = new String[FoodStuff.values().length];
		int i = 0;
		
		for (FoodStuff food : FoodStuff.values()) {
			products[i++] = food.name();
		}
		return products;
	}
	final String[] products = products();

	public void produceSurplus() {
		stock[product] += Parameters.surplusRate;
	}

	public void barterSurplus() {
		stock[product] -= Parameters.exchangeVolume;
		for (int i = 0; i <= 3; i++) {
			if (i != product) {
				stock[i] += Parameters.exchangeVolume;
			}
		}
	}

	public void eat() {
		for (int i = 0; i <= 3; i++) {
			if (i != product) {
				stock[i] -= Parameters.depletionRate * Parameters.familySize;
			}
		}
	}
	
	public void reportStock() {
		System.out.println("My house makes and has a surpuls of " + produce + " = " + stock[product] + ".");
		System.out.println("Of the other products I still have ");
		for (int i = 0; i <= 3; i++) {
			if (i != product) {
				System.out.println("\t" + stock[i] + " of the product " + products[i] + ", ");
			}
		}
	}
}
