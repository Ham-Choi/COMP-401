package a2;

import java.util.Scanner;

public class A2Adept {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numbOfIngreds = scan.nextInt();
		String Ingredient_Name[] = new String[numbOfIngreds];
		double Price_Per_Ounce[] = new double[numbOfIngreds];
		boolean Is_Vegetarian[] = new boolean[numbOfIngreds];
		double Calories_Per_Ounce[] = new double[numbOfIngreds];
		for (int i = 0; i < numbOfIngreds; i++) {
			Ingredient_Name[i] = scan.next();
			Price_Per_Ounce[i] = scan.nextDouble();
			Is_Vegetarian[i] = scan.nextBoolean();
			Calories_Per_Ounce[i] = scan.nextDouble();
		}
		int numbOfRecipes = scan.nextInt();
		String Menu_Item_Name[] = new String[numbOfRecipes];
		int Numb_Of_Ingreds[] = new int[numbOfRecipes];
		String Recipe_Ingreds[][] = new String[numbOfRecipes][];
		double Recipe_Amount[][] = new double[numbOfRecipes][];
		for (int i = 0; i < numbOfRecipes; i++) {
			Menu_Item_Name[i] = scan.next();
			Numb_Of_Ingreds[i] = scan.nextInt();
			Recipe_Ingreds[i] = new String[Numb_Of_Ingreds[i]];
			Recipe_Amount[i] = new double[Numb_Of_Ingreds[i]];
			for (int y = 0; y < Numb_Of_Ingreds[i]; y++) {
				Recipe_Ingreds[i][y] = scan.next();
				Recipe_Amount[i][y] = scan.nextDouble();	
			}
		}
		scan.close();
		for (int i = 0; i < numbOfRecipes; i++) {
			System.out.println(Menu_Item_Name[i] + ":");
			System.out.println(calorieCount(Recipe_Ingreds[i], Recipe_Amount[i], Ingredient_Name, Calories_Per_Ounce) + " calories");
			System.out.println("$" + String.format("%.2f", calculateCost(Recipe_Ingreds[i], Recipe_Amount[i], Ingredient_Name, Price_Per_Ounce)));			
			System.out.println(isRecipeVeg(Recipe_Ingreds[i], Ingredient_Name, Is_Vegetarian));
		}
		// Your code here.
	}
	
	// You can define helper methods here if needed.
	public static int calorieCount(String[] recipeIngreds, double[] recipeAmount, String[] ingredName, double[] caloriePerOunce) {
		double calorieCount = 0;
		for (int a = 0; a < recipeIngreds.length; a++) {
			for(int u = 0; u < ingredName.length; u++) {
				if (ingredName[u].equals(recipeIngreds[a])) {
					calorieCount += caloriePerOunce[u]*recipeAmount[a];
				}
			}
		}
		return ((int) (calorieCount + 0.5));
	}
	public static String isRecipeVeg(String[] recipeIngreds, String[] ingredName, boolean[] isVeg) {
		for (int i = 0; i < recipeIngreds.length; i++) {
			for (int u = 0; u < ingredName.length; u++) {
				if (ingredName[u].equals(recipeIngreds[i])) {
					if(isVeg[u]) {
						continue;
					} else {	
						return "Non-Vegetarian";
					}
				}
			}
		}
		return "Vegetarian";
	}
	public static double calculateCost(String[] recipeIngreds, double[] recipeAmount, String[] ingredName, double[] pricePerOunce) {
		double totalCost = 0;
		for (int i = 0; i < recipeIngreds.length; i++) {
			for (int u = 0; u < ingredName.length; u++) {
				if(ingredName[u].equals(recipeIngreds[i])) {
					totalCost += recipeAmount[i]*pricePerOunce[u];
				}
			}
		}
		return totalCost;
	}
}
