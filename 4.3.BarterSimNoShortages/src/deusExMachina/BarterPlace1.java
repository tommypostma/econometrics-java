package deusExMachina;

public class BarterPlace1 {
	private int[] commonStocks = new int[FoodStuff.values().length];
	public double[] fairFraction = new double[FoodStuff.values().length];
	public boolean[] enoughLeft = new boolean[FoodStuff.values().length];

	public BarterPlace1() {
		// initialize common stocks on zero for all foods
		for (FoodStuff food : FoodStuff.values()) {
			commonStocks[food.ordinal()] = 0;
			enoughLeft[food.ordinal()] = false;
		}
	}

	public void doBarter(Household1[] households) {
		// fill the commonStocks
		for (Household1 house : households) {
			house.giveProductionTo(this);
		}
		this.checkStocks();
		// take what you need
		// or get
		for (Household1 house : households) {
			house.takeWhatItNeedsFrom(this);
		}
	}

	public void add(FoodStuff product, int howMuch) {
		commonStocks[product.ordinal()] += howMuch;
	}

	public void takeAway(FoodStuff product, int howMuch) {
		commonStocks[product.ordinal()] -= howMuch;
	}

	public void reportStocks() {
		for (FoodStuff food : FoodStuff.values()) {
			System.out.println(food + " remaining under the tree = " + commonStocks[food.ordinal()]);
		}
		System.out.println();
	}

	public void checkStocks() {
		// Check if there is enough left for each household to take
		// theMaxExchange rate
		for (FoodStuff food : FoodStuff.values()) {
			int maxBarterPlaceExchange = Parameters.exchangePerDayPerPerson * Simulation.getBarterPlaceMebers();
			if (commonStocks[food.ordinal()] < maxBarterPlaceExchange) {
				enoughLeft[food.ordinal()] = false;
				//!!!!
				double members = Simulation.getBarterPlaceMebers();
				fairFraction[food.ordinal()] = commonStocks[food.ordinal()]/members;
				
			} else {
				enoughLeft[food.ordinal()] = true;
			}
		}
	}
}
