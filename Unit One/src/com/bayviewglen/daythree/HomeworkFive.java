package com.bayviewglen.daythree;

public class HomeworkFive {

	public static void main(String[] args) {
		int pennies, nickels, dimes, quarters, loonies, toonies;
		double totalmoney = 0;
		
		pennies = 10;
		nickels = 9;
		dimes = 8;
		quarters = 7;
		loonies = 6;
		toonies = 5;
		
		totalmoney = 0.01 * pennies + 0.05 * nickels + 0.10 * dimes + 0.25 * quarters + 1.0 * loonies + 2.0 * toonies;
		System.out.println("If I have " + pennies + " pennies, " + nickels + " nickels, " + dimes + " dimes, " + quarters + " quarters, " + loonies + " loonies and " + toonies + " toonies.");
		System.out.println("There is $" + totalmoney + " in total.");
			 	
		
	}

}
