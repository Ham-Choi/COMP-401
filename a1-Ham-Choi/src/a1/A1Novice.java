package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numbOfCust = scan.nextInt();
		for (int i = 0; i < numbOfCust; i++) {
			String first = scan.next();
			String last = scan.next();
			int num = scan.nextInt();
			double total = 0;
			for(int a = 0; a < num; a++) {
				int quan = scan.nextInt();
				String name = scan.next();
				double price = scan.nextDouble();
				total += quan * price;
			}		
			System.out.println(first.charAt(0) + ". " + last + ": " + String.format("%.2f", total));
		}
		scan.close();
		// Your code goes here.
		//3 Carrie Brownstein 3 2 asds 0.75 1 Orange 1.25 2 Milk 3.15 Corin Tucker 2 3 Basda 0.75 2 Spinge 1.15 Janet Weiss 1 5 sad 2.50
	}
	// You can define / use static helper methods here.
}
