package deusExMachina;

import java.util.Random;

public class Household1 {
	
	private final FoodStuff whatIsMade;
	
	private int familyMembers; //make public s.t. main containing class can compute total members in barterplace
	public int[] stocks = null;
	Random rand = null;
	
	public Household1(FoodStuff produced) {
		whatIsMade = produced;
		rand  = new Random();
		familyMembers = rand.nextInt(Parameters.maxFamilySize - Parameters.minFamilySize) + Parameters.minFamilySize;
		System.out.println("The household that produces " + whatIsMade + " has " + familyMembers + " persons.");
		//initialize stocks
		stocks = new int[FoodStuff.values().length];
		for (FoodStuff food : FoodStuff.values()) {
			stocks[food.ordinal()] = 0;
		}
	}
	
	public void produceOwnFood() {
		stocks[whatIsMade.ordinal()] += Parameters.minProductionPerDay + rand.nextInt(Parameters.maxProductionPerDay - Parameters.minProductionPerDay);
	}
	
	public void giveProductionTo(BarterPlace1 underTree) {
		//They give all their production, they will get back what they need
		underTree.add(whatIsMade, stocks[whatIsMade.ordinal()]);
		stocks[whatIsMade.ordinal()] = 0;
	}
	
	public void takeWhatItNeedsFrom(BarterPlace1 underTree) {
		//Check if there is enough left for each household to take the maxExchange rate
		for (FoodStuff food : FoodStuff.values()) {
			if(underTree.enoughLeft[food.ordinal()] == false) {
				int whatItGets = (int) Math.floor(underTree.fairFraction[food.ordinal()]*familyMembers);
				stocks[food.ordinal()] += whatItGets;
				underTree.takeAway(food, whatItGets);
			} else {
				int maxConsumption = Parameters.exchangePerDayPerPerson * familyMembers;
				stocks[food.ordinal()] += maxConsumption;
				underTree.takeAway(food, maxConsumption);
			}
		}
	}
	
	public void eatsADay() {
		for (FoodStuff food : FoodStuff.values()) {
			//Check if there is enough left to take the maxConsumption rate for each familymember
			if (stocks[food.ordinal()] < (Parameters.maxConsumptionPerPersonPerDay * familyMembers)) {
				//consume all stock
				stocks[food.ordinal()] = 0;
			} else {
				//consume some random amount of stock
				stocks[food.ordinal()] -= rand.nextInt(Parameters.maxConsumptionPerPersonPerDay) * familyMembers;
			}
		}
	}
	
	public void reportStocks() {
		System.out.println("The house producing " + whatIsMade + " has now");
		for (FoodStuff food : FoodStuff.values()) {
			System.out.print(food + " = " + stocks[food.ordinal()] + "\t\t");
		}
		System.out.println("\n");
	}
	
	public int getFamilyMembers() {
		return familyMembers;
	}
	
	public FoodStuff getWhatIsMade() {
		return whatIsMade;
	}
	
	public int reportStockOf(FoodStuff food) {
		return stocks[food.ordinal()];
	}
}
