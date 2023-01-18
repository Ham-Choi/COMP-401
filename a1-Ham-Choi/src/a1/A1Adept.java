package a1;

import java.util.*;
public class A1Adept {

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
		double[] total = new double[numbOfCust];
		for (int i = 0; i < numbOfCust; i++) {
			first[i] = scan.next();
			last[i] = scan.next();
			int numOfItems = scan.nextInt();
			for(int a = 0; a < numOfItems; a++) {
				int quan = scan.nextInt();
				String product = scan.next();
				for (int y = 0; y < id.length; y++) {
					if (id[y].equals(product)) {
						total[i] = total[i] + quan*id_cost[y];
					}
				}
			}
		}
		double biggestUseValue = 0;
		double smallestUseValue = 100;
		double sum = 0;
		double avg;
		for (int i = 0; i < total.length; i++) {
			if (total[i] > biggestUseValue) {
				biggestUseValue = total[i];
			}
			if (total[i] < smallestUseValue) {
				smallestUseValue = total[i];
			}
			sum = sum + total[i];
		}
		avg = sum/total.length;
		int biggestId= 0;
		int smallestId= 0;
		for (int i = 0; i < numbOfCust; i++) {
			if (biggestUseValue == total[i]) {
				biggestId = i;
			}
			if (smallestUseValue == total[i]) {
				smallestId = i;
			}
		}
		scan.close();
		System.out.println("Biggest: " + first[biggestId] + " " + last[biggestId] + " (" + String.format("%.2f", total[biggestId]) + ")");
		System.out.println("Smallest: " + first[smallestId] + " " + last[smallestId] + " (" + String.format("%.2f", total[smallestId]) + ")");
		System.out.println("Average: " + String.format("%.2f", avg));
		// Your code goes here.
	}
	// 6 Apple 0.25 Banana 0.75 Milk 3.15 Orange 1.25 Salami 2.50 Sponge 1.15 3 Carrie Brownstein 3 2 Banana 1 Orange 2 Milk Corin Tucker 2 3 Banana 2 Sponge Janet Weiss 1 5 Salami
	// You can define / use static helper methods here.

}
