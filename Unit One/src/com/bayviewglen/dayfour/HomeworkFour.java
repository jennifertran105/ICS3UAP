package com.bayviewglen.dayfour;

import java.util.Scanner;

public class HomeworkFour {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		double vi, a, t;
		
		vi = keyboard.nextInt();
		a = keyboard.nextInt();
		t = keyboard.nextInt(); 
		
		double vf = vi + (a*t);
		System.out.println("If the initial velocity of the car is " + vi + " km per hour," + " and the acceleration is " + a + " m/s^2, and it takes, " + t + " minutes.");
		System.out.println("The final velocity of the car is " + vf + ".");
		
		

	}

}
