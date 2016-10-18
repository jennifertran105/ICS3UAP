package com.bayviewglen.assignment;

import java.util.Scanner;

public class PraticeWork {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Please ender a 5 digit number: ");
		int number = keyboard.nextInt();
		int secondDigit = number/1000%10;
		int fourthDigit = number/10%10;
		System.out.println("The product of the 2nd & 4th digit is " + (secondDigit * fourthDigit) + ".");
		

	}

}
