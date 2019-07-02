package deusExMachina;

public enum FoodStuff {
	TOMATO (0) , CHEESE (1) , BREAD (2) , OLIVE_OIL (3);

	public int product;
	
	FoodStuff(int p) {
		this.product = p;
	}
	
	public int getProductVal() {
		return product;
	}
}

