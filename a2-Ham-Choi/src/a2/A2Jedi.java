package a2;

import java.util.Scanner;

public class A2Jedi {

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
		double ouncesNeeded[] = new double[Ingredient_Name.length];
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
		String[] order = new String[0];
		while (scan.hasNext()) {
			String tempNext = scan.next();
			if(tempNext.equals("EndOrder")) {
				scan.close();
				break;
			} else {
				order = add(order, tempNext);
			}
		}
		
		ouncesNeeded = amountNeeded(Menu_Item_Name, order, Ingredient_Name, Recipe_Ingreds, Recipe_Amount);
		System.out.println("The order will require:");
		for (int i = 0; i < Ingredient_Name.length; i++) {
			System.out.println(String.format("%.2f", ouncesNeeded[i]) + " ounces of " + Ingredient_Name[i]);
		}
		// Your code here.
	}
	// You can define helper methods here if needed.
	public static String[] add(String[] startingArray, String newValue) {
		int currentLength = startingArray.length;
		int newLength = currentLength + 1;
		String[] tempArray = new String[newLength];
		for (int i = 0; i < currentLength; i++){
			tempArray[i] = startingArray[i];
		}
		tempArray[newLength - 1] = newValue;
		return tempArray;
	}
	public static double[] amountNeeded(String[] recipeNames, String[] order, String[] ingredNames, String[][] recipeIngred, double[][] ouncesPerOrder) {
		double[] requiredAmount = new double[ingredNames.length]; 
		for (int i = 0; i < order.length; i++) {
			for (int y = 0; y < ingredNames.length; y++) {
				for (int k = 0; k < recipeNames.length; k++) {
					if (order[i].equals(recipeNames[k])) {
						for (int u = 0; u < recipeIngred[k].length; u++) {
							if (recipeIngred[k][u].equals(ingredNames[y])) {
								requiredAmount[y] = requiredAmount[y] + ouncesPerOrder[k][u];
							}	
						}
					}
				}	
			}
			
		}
		return requiredAmount;
	}

}