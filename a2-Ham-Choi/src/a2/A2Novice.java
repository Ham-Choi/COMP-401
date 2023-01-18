package a2;

import java.util.Scanner;

public class A2Novice {

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
		scan.close();
		double[] caloriePerPrice = calPerPrice(Calories_Per_Ounce, Price_Per_Ounce, Ingredient_Name);
		// Your code here.
		
		System.out.println("Number of vegetarian ingredients: " + numberOfVeg(Is_Vegetarian));
		System.out.println("Highest cals/$: " + highestCalPerPrice(caloriePerPrice, Ingredient_Name));
		System.out.println("Lowest cals/$: " + lowestCalPerPrice(caloriePerPrice, Ingredient_Name));
		
	}
	
	// You can define helper methods here if needed.
	public static int numberOfVeg(boolean[] ingreds) {
		int vegetables = 0;
		for (int i = 0; i < ingreds.length; i++) {
			if (ingreds[i] == true) {
				vegetables++;
			}
		}
		return vegetables;
	}
	
	public static double[] calPerPrice(double[] cals, double[] price, String[] ingred) {
		double[] calPerPrice = new double[ingred.length];
		for (int i = 0; i < ingred.length; i++) {
			calPerPrice[i] = cals[i]/price[i];
		// cals divided by price
		}
		return calPerPrice;
	}
	public static String highestCalPerPrice(double[] units, String[] ingred) {
		int highest = 0;
		for (int i = 0; i < ingred.length; i++) {
			if (units[i] > units[highest]) {
				highest = i;
			}
		}
		return ingred[highest];	
	}
	public static String lowestCalPerPrice(double[] units, String[] ingred) {
		int lowest = ingred.length - 1;
		for (int i = 0; i < ingred.length; i++) {
			if (units[i] < units[lowest]) {
				lowest = i;
			}
		}
		return ingred[lowest];	
	}
}
