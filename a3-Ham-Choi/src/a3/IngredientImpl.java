package a3;

public class IngredientImpl implements Ingredient {
	
	private String name;
	private double pricePerOunce;
	private int caloriesPerOunce;
	private boolean Is_Vegetarian;
	private double caloriesPerDollar;
	
	public IngredientImpl(String name, double price, int calories, boolean is_vegetarian) {
		this.name = name;
		this.pricePerOunce = price;
		this.caloriesPerOunce = calories;
		this.Is_Vegetarian = is_vegetarian;
		
		if (name.equals(null)) {
			throw new RuntimeException("No name");
		}
		if(price < 0) {
			throw new RuntimeException("Price can not be negative");
		}
		if (calories < 0) {
			throw new RuntimeException("Calories can not be negative");
		}
	}
	public String getName() {
		return name;
	}
	public double getPricePerOunce() {
		return pricePerOunce;
	}
	public int getCaloriesPerOunce() {
		return caloriesPerOunce;
	}
	public boolean getIsVegetarian() {
		return Is_Vegetarian;
	}
	public double getCaloriesPerDollar() {
		caloriesPerDollar = caloriesPerOunce/pricePerOunce;
		return caloriesPerDollar;
	}
	
}

