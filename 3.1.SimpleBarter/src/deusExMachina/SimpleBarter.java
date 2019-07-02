package deusExMachina;

public class SimpleBarter {

	public static void main(String[] args) {
		Household bakers = new Household(FoodStuff.BREAD);
		Household dairies = new Household(FoodStuff.CHEESE);
		Household reds = new Household(FoodStuff.TOMATO);
		Household greens = new Household(FoodStuff.OLIVE_OIL);

		int cycles = 0;
		do {
			// produce a surplus
			dairies.produceSurplus();
			bakers.produceSurplus();
			reds.produceSurplus();
			greens.produceSurplus();
			System.out.println("    AFTER PRODUCTION");
			dairies.reportStock();
			bakers.reportStock();
			reds.reportStock();
			greens.reportStock();
			// barter the surpluses
			dairies.barterSurplus();
			bakers.barterSurplus();
			reds.barterSurplus();
			greens.barterSurplus();
			System.out.println("    AFTER BARTER");
			dairies.reportStock();
			bakers.reportStock();
			reds.reportStock();
			greens.reportStock();
			// consume
			dairies.eat();
			bakers.eat();
			reds.eat();
			greens.eat();
			System.out.println("    AFTER CONSUMPTION");
			dairies.reportStock();
			bakers.reportStock();
			reds.reportStock();
			greens.reportStock();

			cycles++;
			System.out.println("\n\n CYCLE no. " + cycles + " has finished");
		} while (cycles < Parameters.maxNoOfDays); 
	} 
}
