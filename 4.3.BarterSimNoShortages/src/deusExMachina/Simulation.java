package deusExMachina;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Simulation {

	private static Household1[] households;

	public static void main(String[] args) throws IOException {
		// initialize objects and status
		households = new Household1[FoodStuff.values().length];

		for (FoodStuff product : FoodStuff.values()) {
			households[product.ordinal()] = new Household1(product);
		}

		BarterPlace1 underTree = new BarterPlace1();

		// Open the file and a writer to it
		Path path = Paths.get(Parameters.outputFile);
		Writer writer = Files.newBufferedWriter(path);

		// Write heading
		writer.write("Date,");
		for (Household1 house : households) {
			for (FoodStuff food : FoodStuff.values()) {
				writer.write(food.toString() + " by the " + house.getWhatIsMade().toString() + " producers,");
			}
		}
		writer.write("\n");

		int barteringCycle = 1;
		do {
			System.out.println("Cycle " + barteringCycle + " starts");
			// produce food first
			for (Household1 house : households) {
				house.produceOwnFood();
			}
			System.out.println("\n After producing and BEFORE bartering, the houses have:");
			for (FoodStuff food : FoodStuff.values()) {
				households[food.ordinal()].reportStocks();
			}
			// barter
			underTree.doBarter(households);
			System.out.println("\n Bartering has ended, the houses have:");
			for (FoodStuff food : FoodStuff.values()) {
				households[food.ordinal()].reportStocks();
			}
			// consume
			for (Household1 house : households) {
				house.eatsADay();
			}
			System.out.println("\n Barter and Consume Cycle " + barteringCycle + " ended\n");
			underTree.reportStocks();

			// Write the "day" in the first column
			writer.write(barteringCycle + ",");
			for (Household1 house : households) {
				for (FoodStuff food : FoodStuff.values()) {
					// Per house write the amount of stock in the csv and a
					// comma before the next one
					writer.write(house.reportStockOf(food) + ",");
				}
			}
			// End the line
			writer.write("\n");

			barteringCycle++;
		} while (barteringCycle <= Parameters.maxNoOfDays);
	
		writer.close();
	}
	
	// compute total members in barterplace
	public static int getBarterPlaceMebers() {
		int barterPlaceMembers = 0;
		for (Household1 house : households) {
			barterPlaceMembers += house.getFamilyMembers();
		}
		return barterPlaceMembers;
	}
}
