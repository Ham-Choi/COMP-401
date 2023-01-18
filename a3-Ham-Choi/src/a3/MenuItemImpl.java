package a3;

public class MenuItemImpl implements MenuItem{
	private String name;
	private IngredientPortion[] ingredientPortions;
	
	public MenuItemImpl(String name, IngredientPortion[] ingredients) {
		
		
		if (name.equals(null)) {
			throw new RuntimeException ("Name can not be null");
		}
		
		if (ingredients.length <= 0) {
			throw new RuntimeException ("Ingredients must have a list greater than zero");
		}
		
		if (ingredients.equals(null)) {
			throw new RuntimeException ("Ingredients list is null");
		}
		
		for (int i = 0; i < ingredients.length; i++) {
			if (ingredients[i].equals(null)) {
				throw new RuntimeException ("An Ingredient index is null");
			}
		}
		this.name = name;
		this.ingredientPortions = ingredients.clone();
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}


	@Override
	public IngredientPortion[] getIngredients() {
		// TODO Auto-generated method stub
		IngredientPortion[] ingClone = ingredientPortions.clone();
		return ingClone;
	}


	@Override
	public int getCalories() {
		// TODO Auto-generated method stub
		int cals = 0;
		for(int i = 0; i < this.ingredientPortions.length; i++) {
			cals += this.ingredientPortions[i].getCalories();
		}
		return cals;
	}


	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		double cost = 0;
		for (int i = 0; i < this.ingredientPortions.length; i++) {
			cost += this.ingredientPortions[i].getCost();
		}
		return cost;
	}


	@Override
	public boolean getIsVegetarian() {
		// TODO Auto-generated method stub
		boolean isVeg = true;
		for (int i = 0; i < this.ingredientPortions.length; i++) {
			if (!this.ingredientPortions[i].getIsVegetarian()) {
				isVeg = false;
			}
		}
		return isVeg;
	}
}
