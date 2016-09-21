package com.bayviewglen.dayseven;

import java.util.Scanner;

public class BayviewGlenPools {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		final double LINER_ONE = 58.9;
		final double LINER_TWO = 82.1;
		final double LINER_THREE = 45.8; 
		
		System.out.print("Please input the length of the pool:");
		double length = keyboard.nextDouble();
		
		System.out.print("Please input the width of the pool:");
		double width = keyboard.nextDouble();
		
		System.out.print("Please input the depth of the shallow end:");
		double depthShallow = keyboard.nextDouble();
		
		System.out.print("Please input the depth of the deep end:");
		double depthDeep = keyboard.nextDouble();
		
		System.out.print("Please input the length of the transition between the shallow & deep end:");
		double transition = keyboard.nextDouble();
		
		System.out.print("Please input the length of the shallow end:");
		double lengthShallow = keyboard.nextDouble();
		
		System.out.print("Please input the price of liner 1:");
		double linerOne = keyboard.nextDouble();
		
		System.out.print("Please input the price of liner 2:");
		double linerTwo = keyboard.nextDouble();
		
		System.out.print("Please input the price of liner 3:");
		double linerThree = keyboard.nextDouble();
		
		
		
	}

}
