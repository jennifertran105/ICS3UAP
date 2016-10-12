package com.bayviewglen.assignment;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CrossCountryAssignment {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		final int SIXTY = 60;
		DecimalFormat formatter = new DecimalFormat("00.000");

		// Runner 1 
		System.out.print("Please enter your first & last name: ");
		String nameone = keyboard.nextLine();
		String firstnameone = nameone.split(" ")[0];
		String lastnameone = nameone.split(" ")[1];

		System.out.print(firstnameone + ", please enter your mile one time (MM:SS.SS):");
		String runneronemiletimeone = keyboard.nextLine();
		
		System.out.print("Please enter your time to mile two (MM:SS.SS):");
		String runneronemiletimetwo = keyboard.nextLine();
		 
		System.out.print("Please enter your time to complete 5km (MM:SS.SS):"); 
		String runneronefivekmtime = keyboard.nextLine();
		 


		// Runner One Split One
		int runnerOneSplitOne = Integer.parseInt(runneronemiletimeone.split(":")[0]);
		double runnerOneSplitOneSeconds = Double.parseDouble(runneronemiletimeone.split(":")[1]);
		double runnerOneSplitOneMinutes = (runnerOneSplitOneMinutes * SIXTY) + runnerOneSplitOneSeconds;
		
		runnerOneSplitOneMinutes = (int)-(runnerOneSplitOneTotal/SIXTY) ;
		runnerOneSplitOneSeconds = runnerOneSplitOneTotal % SIXTY;
		String SecondsFormatted = (formatter.format(runnerOneSplitOneSeconds));
		String SplitFormatted = runnerOneSplitOneMinutes + ":" + SecondsFormatted; 
		System.out.println("Time for first split: " );
        
		// Runner One Split Two
		int runnerOneSplitTwo = Integer.parseInt(runneronemiletimetwo.split(":")[0]);
		double runnerOneSplitTwoSeconds = Double.parseDouble(runneronemiletimetwo.split(":")[1]);
		double runnerOneSplitTwoMinutes = (runnerOneSplitTwoMinutes * SIXTY) + runnerOneSplitTwoSeconds;
	
				
		// Runner One Split Three
				
		// Runner One Summary
		System.out.println(" ");
		System.out.println("Runner One Summary");

	}
}
