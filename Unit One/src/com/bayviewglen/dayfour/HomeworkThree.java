package com.bayviewglen.dayfour;

public class HomeworkThree {

	public static void main(String[] args) {
		
		int num = 827159;
		int digit2 = num / 10000 % 10;
		int digit5 = num / 10 % 10;
		
		System.out.println(num);
		System.out.println("The 2nd digit is " + digit2 + ".");
		System.out.println("The 5th digit is " + digit5 + ".");
	}

}
