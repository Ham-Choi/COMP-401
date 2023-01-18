package a3;

public class IngredientPortionImpl implements IngredientPortion {
	private Ingredient ing;
	private double amount;
	
	public IngredientPortionImpl(Ingredient ing, double amount) {
		
		if (ing.equals(null)) {
			throw new RuntimeException("Ingredient is null");
		}
		if (amount < 0) {
			throw new RuntimeException("Amount must be positive");
		}
		this.ing = ing;
		this.amount = amount;
	}
	@Override
	public Ingredient getIngredient() {
		// TODO Auto-generated method stub
		return ing;
	}
	@Override
	public double getAmount() {
		// TODO Auto-generated method stub
		return amount;
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return ing.getName();
	}
	@Override
	public boolean getIsVegetarian() {
		// TODO Auto-generated method stub
		return ing.getIsVegetarian();
	}
	@Override
	public double getCalories() {
		// TODO Auto-generated method stub
		return ing.getCaloriesPerOunce() * amount;
	}
	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return ing.getPricePerOunce() * amount;
	}
	@Override
	public IngredientPortion combine(IngredientPortion other) {
		// TODO Auto-generated method stub
		if (!this.getName().equals(other.getName())) {
			throw new RuntimeException("Ingredients are not the same and can not be combined");
		}
		if (other.equals(null)) {
			return this;
		}
		return new IngredientPortionImpl(this.ing, this.amount + other.getAmount());
	}
}