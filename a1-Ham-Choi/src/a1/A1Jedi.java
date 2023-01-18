package a1;

import java.util.ArrayList;
import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int itemsInS = scan.nextInt();
		String[] id = new String[itemsInS];
		double[] id_cost = new double[itemsInS];
		for (int i = 0; i < itemsInS; i++) {
			id[i] = scan.next();
			id_cost[i] = scan.nextDouble();
		}
		int numbOfCust = scan.nextInt();
		String[] first = new String[numbOfCust];
		String[] last = new String[numbOfCust];
		int numbCustBought[] = new int[id.length];
		int numbItemsBought[] = new int[id.length];
		for (int i = 0; i < numbOfCust; i++) {
			first[i] = scan.next();
			last[i] = scan.next();
			int numOfItems = scan.nextInt();
			String[] listOfBought = new String[numOfItems]; 
			ArrayList <String >counter = new ArrayList<String>();
			//int value = 0;
			for(int a = 0; a < numOfItems; a++) {
				int quan = scan.nextInt();
				listOfBought[a] = scan.next();
				for (int y = 0; y < id.length; y++) {
					if (id[y].equals(listOfBought[a])) {
						numbItemsBought[y] = numbItemsBought[y] + quan;
						for (int k = 0; k < numOfItems; k++) {
							if (!counter.contains(listOfBought[a])) {
								counter.add(listOfBought[a]);
								//value++;
								numbCustBought[y]++;
								break;
							}
						}
					}	
				}

			}
		}
		scan.close();
		for (int i = 0; i < itemsInS; i++) {
			if (numbCustBought[i] == 0 || numbItemsBought[i] == 0) {
				System.out.println("No customers bought " + id[i]);
			} else {
				System.out.println(numbCustBought[i] + " customers bought " + numbItemsBought[i] + " " + id[i]);
			}
		}
		// Your code goes here.
	}
	// 6 Apple 0.25 Banana 0.75 Milk 3.15 Orange 1.25 Salami 2.50 Sponge 1.15 3 Carrie Brownstein 3 2 Banana 1 Orange 2 Milk Corin Tucker 2 3 Banana 2 Sponge Janet Weiss 1 5 Salami
	// You can define / use static helper methods here.
}
/*			
			for(int a = 0; a < numOfItems; a++) {
				int quan = scan.nextInt();
				listOfBought[a] = scan.next();
				for (int y = 0; y < listOfBought.length; y++) {
					if (listOfBought[a].equals(id[y])) {
						numbItemsBought[y] = numbItemsBought[y] + quan;
						numbCustBought[y]++;
					}
				}
			}
			for (int k = 0; k < listOfBought.length; k++) {
				String tempArr = listOfBought[k];
				for (int x = 0; x < listOfBought.length; x++) {
					if (tempArr.equals(listOfBought[x])) {
						for (int r = 0; r < id.length; r++) {
							if (tempArr.equals(id[r])) {
								numbCustBought[r] = numbCustBought[r] - 1;

 */
