package com.bayviewglen.dayseven;

import java.util.Scanner;

public class BayviewGlenPools {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		final double LINER_ONE = 58.9;
		final double LINER_TWO = 82.4;
		final double LINER_THREE = 45.5; 
		
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
		
		System.out.println("The price of liner 1 per square meter: $" + LINER_ONE);
		
		System.out.println("The price of liner 2 per square meter: $" + LINER_TWO);
		
		System.out.println("The price of liner 3 per square meter: $" + LINER_THREE);

		System.out.println("");
		
		
		//Volume
		double heightDifference = depthDeep - depthShallow;
		double middleLength = Math.sqrt(Math.pow(transition, 2) - Math.pow(heightDifference, 2));
		double smallRectangle = heightDifference * lengthShallow * width;
		double smallTriangle = middleLength * heightDifference * width/2;
		double totalVolume = (width * length * depthDeep) - ((smallRectangle) + (smallTriangle));
		System.out.println("The volume of the pool is " + totalVolume + " litres.");
		double for90Percent = 0.9;
		double findPercent = totalVolume * for90Percent;
		System.out.println("The volume of 90% of the pool is " + findPercent + " litres.");
		System.out.println("");
		
		//Surface Area
		//double deepLength = length - (lengthShallow + middleLength);
		double areaA = 2*(length * depthDeep) - ((heightDifference * lengthShallow) + ((middleLength *heightDifference)/2));
		double areaB = 2 * (width * depthDeep);
		double areaC = length * width;
		double totalSurfaceArea = areaA + areaB + areaC;
		System.out.println("The total surface area of the pool is " + totalSurfaceArea + "m^2.");
		
		// Prices
		double linerOnePrice = LINER_ONE * totalSurfaceArea;
		System.out.println("The price of the first liner is $" + linerOnePrice + ".");
		double linerTwoPrice = LINER_TWO * totalSurfaceArea;
		System.out.println("The price of the second liner is $" + linerTwoPrice + ".");
		double linerThreePrice = LINER_THREE * totalSurfaceArea;
		System.out.println("The price of the three liner is $" + linerThreePrice + ".");
			
	}

}
