package com.bayviewglen.assignment;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CrossCountryAssignment {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		final int SEC_TO_MINS = 60;
		DecimalFormat formatter = new DecimalFormat("00.000");
		
				
		// Runner 1
		System.out.print("Please enter your first & last name: ");
		String nameone = keyboard.nextLine(); 
		String firstnameone = nameone.split(" ")[0];
		String lastnameone = nameone.split(" ")[1];
		
		System.out.print(firstnameone + ", please enter your mile one time (MM:SS.SS):");
		String onetimeone = keyboard.nextLine();
		/*	
		System.out.print("Please enter your time to mile two (MM:SS.SS):");
		String twotimeone = keyboard.nextLine();
		
		System.out.print("Please enter your time to 5km (MM:SS.SS):");
		String fulltimeone = keyboard.nextLine();
		*/
		
		
		System.out.println("Runner One Summary");
		
		//Split One
		int x = Integer.parseInt(onetimeone.split(":")[0]);
		double y = Double.parseDouble(onetimeone.split(":")[1]);
		double z = (x*60) + y;
		System.out.println(x + " " + y + " " + z);
		
		x = (int)(z/60);
		y = z - (60*x);
		String y2 = (formatter.format(y));
		System.out.println(x + ":" + y2);
		
		
	}

}
