package com.bayviewglen.assignment;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CrossCountryAssignment {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		final int SIXTY = 60;
		DecimalFormat formatter = new DecimalFormat("00.000");
		
		// Runner 1 
		System.out.print("Runner One, please enter your first & last name: ");
		String nameone = keyboard.nextLine();
		String firstnameone = nameone.split(" ")[0];
		String lastnameone = nameone.split(" ")[1];

		System.out.print(firstnameone + ", please enter your mile one time (MM:SS.SS):");
		String runneronemiletimeone = keyboard.nextLine();
		
		System.out.print("Please enter your time to mile two (MM:SS.SS):");
		String runneronemiletimetwo = keyboard.nextLine();
		 
		System.out.print("Please enter your time to complete 5km (MM:SS.SS):"); 
		String runneronefivekmtime = keyboard.nextLine();

		// Runner 1 Split One
		int runnerOneSplitOneMinutes = Integer.parseInt(runneronemiletimeone.split(":")[0]);
		double runnerOneSplitOneSeconds = Double.parseDouble(runneronemiletimeone.split(":")[1]);
		double runnerOneSplitOneTotal = (runnerOneSplitOneMinutes * SIXTY) + runnerOneSplitOneSeconds;
		
		runnerOneSplitOneMinutes = (int)(runnerOneSplitOneTotal/SIXTY) ;
		runnerOneSplitOneSeconds = runnerOneSplitOneTotal % SIXTY;
		String rOneSecondsOneFormatted = (formatter.format(runnerOneSplitOneSeconds));
		String rOneSplitOneFormatted = runnerOneSplitOneMinutes + ":" + rOneSecondsOneFormatted; 
       
		// Runner 1 Split Two
		int runnerOneSplitTwoMinutes = Integer.parseInt(runneronemiletimetwo.split(":")[0]);
		double runnerOneSplitTwoSeconds = Double.parseDouble(runneronemiletimetwo.split(":")[1]);
		double runnerOneSplitTwoTotal = (runnerOneSplitTwoMinutes * SIXTY) + runnerOneSplitTwoSeconds;
		runnerOneSplitTwoTotal -= runnerOneSplitOneTotal;
		
		runnerOneSplitTwoMinutes = (int)(runnerOneSplitTwoTotal/SIXTY) ;
		runnerOneSplitTwoSeconds = runnerOneSplitTwoTotal % SIXTY;
		String rOneSecondsTwoFormatted = (formatter.format(runnerOneSplitTwoSeconds));
		String rOneSplitTwoFormatted = runnerOneSplitTwoMinutes + ":" + rOneSecondsTwoFormatted; 
		
		// Runner 1 Split Three
		int runnerOneSplitThreeMinutes = Integer.parseInt(runneronefivekmtime.split(":")[0]);
		double runnerOneSplitThreeSeconds = Double.parseDouble(runneronefivekmtime.split(":")[1]);
		double runnerOneSplitThreeTotal = (runnerOneSplitThreeMinutes * SIXTY) + runnerOneSplitThreeSeconds;
		runnerOneSplitThreeTotal = runnerOneSplitThreeTotal - (runnerOneSplitOneTotal + runnerOneSplitTwoTotal);
		
		runnerOneSplitThreeMinutes = (int)(runnerOneSplitThreeTotal/SIXTY) ;
		runnerOneSplitThreeSeconds = runnerOneSplitThreeTotal % SIXTY;
		String rOneSecondsThreeFormatted = (formatter.format(runnerOneSplitThreeSeconds));
		String rOneSplitThreeFormatted = runnerOneSplitThreeMinutes + ":" + rOneSecondsThreeFormatted;
			
		// Runner 1 Total Time
		//double runnerOneTotalTime = rOneSplitOneFormatted + rOneSplitTwoFormatted + rOneSplitThreeFormatted;
		
		// Runner 1 Summary
		System.out.println(" ");
		System.out.println("Runner One Summary- " + lastnameone + ", " + firstnameone );
		System.out.println("Time for first split: " + rOneSplitOneFormatted );
		System.out.println("Time for second split: " + rOneSplitTwoFormatted);
		System.out.println("Time for third split: " + rOneSplitThreeFormatted);
		System.out.println("Total Time: ");

		// Runner 2
		System.out.println(" ");
		System.out.print("Runner Two, please enter your first & last name: ");
		String nametwo = keyboard.nextLine();
		String firstnametwo = nameone.split(" ")[0];
		String lastnametwo = nameone.split(" ")[1];

		System.out.print(firstnametwo + ", please enter your mile one time (MM:SS.SS):");
		String runnertwomiletimeone = keyboard.nextLine();

		System.out.print("Please enter your time to mile two (MM:SS.SS):");
		String runnertwomiletimetwo = keyboard.nextLine();

		System.out.print("Please enter your time to complete 5km (MM:SS.SS):");
		String runnertwofivekmtime = keyboard.nextLine();
		
		
	}
}
