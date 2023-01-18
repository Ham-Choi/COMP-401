package a3;

import java.util.*;

public class A3Jedi {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numbOfIngreds = s.nextInt();
		String[] ingredNames = new String[numbOfIngreds];
		Ingredient hi = new IngredientImpl("ve", 0.5, 14, true);
		
		double pricePerOunce[] = new double[numbOfIngreds];
		boolean isVeg[] = new boolean[numbOfIngreds];
		double caloriesPerOunce[] = new double[numbOfIngreds];
		for (int i = 0; i < numbOfIngreds; i++) {
			ingredNames[i] = s.next();
			pricePerOunce[i] = s.nextDouble();
			isVeg[i] = s.nextBoolean();
			caloriesPerOunce[i] = s.nextDouble();
		}
		
	}
}
