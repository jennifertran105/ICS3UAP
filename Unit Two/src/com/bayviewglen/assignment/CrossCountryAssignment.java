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

		System.out.print(firstnameone + ", please enter your mile one time (MM:SS.SS): ");
		String ronemiletimeone = keyboard.nextLine();

		System.out.print("Please enter your time to mile two (MM:SS.SS): ");
		String ronemiletimetwo = keyboard.nextLine();

		System.out.print("Please enter your time to complete 5km (MM:SS.SS): ");
		String ronefivekmtime = keyboard.nextLine();

		// Runner 1 Split One
		int rOneSplitOneMinutes = Integer.parseInt(ronemiletimeone.split(":")[0]);
		double rOneSplitOneSeconds = Double.parseDouble(ronemiletimeone.split(":")[1]);
		double rOneSplitOneTotal = (rOneSplitOneMinutes * SIXTY) + rOneSplitOneSeconds;

		rOneSplitOneMinutes = (int) (rOneSplitOneTotal / SIXTY);
		rOneSplitOneSeconds = rOneSplitOneTotal % SIXTY;
		String rOneSecondsOneFormatted = (formatter.format(rOneSplitOneSeconds));
		String rOneSplitOneFormatted = rOneSplitOneMinutes + ":" + rOneSecondsOneFormatted;

		// Runner 1 Split Two
		int rOneSplitTwoMinutes = Integer.parseInt(ronemiletimetwo.split(":")[0]);
		double rOneSplitTwoSeconds = Double.parseDouble(ronemiletimetwo.split(":")[1]);
		double rOneSplitTwoTotal = (rOneSplitTwoMinutes * SIXTY) + rOneSplitTwoSeconds;
		rOneSplitTwoTotal -= rOneSplitOneTotal;

		rOneSplitTwoMinutes = (int) (rOneSplitTwoTotal / SIXTY);
		rOneSplitTwoSeconds = rOneSplitTwoTotal % SIXTY;
		String rOneSecondsTwoFormatted = (formatter.format(rOneSplitTwoSeconds));
		String rOneSplitTwoFormatted = rOneSplitTwoMinutes + ":" + rOneSecondsTwoFormatted;

		// Runner 1 Split Three
		int rOneSplitThreeMinutes = Integer.parseInt(ronefivekmtime.split(":")[0]);
		double rOneSplitThreeSeconds = Double.parseDouble(ronefivekmtime.split(":")[1]);
		double rOneSplitThreeTotal = (rOneSplitThreeMinutes * SIXTY) + rOneSplitThreeSeconds;
		rOneSplitThreeTotal = rOneSplitThreeTotal - (rOneSplitOneTotal + rOneSplitTwoTotal);

		rOneSplitThreeMinutes = (int) (rOneSplitThreeTotal / SIXTY);
		rOneSplitThreeSeconds = rOneSplitThreeTotal % SIXTY;
		String rOneSecondsThreeFormatted = (formatter.format(rOneSplitThreeSeconds));
		String rOneSplitThreeFormatted = rOneSplitThreeMinutes + ":" + rOneSecondsThreeFormatted;

		// Runner 1 Total Time Formatted
		int rOneTimeMinutes = Integer.parseInt(ronefivekmtime.split(":")[0]);
		double rOneTimeSeconds = Double.parseDouble(ronefivekmtime.split(":")[1]);
		double rOneTotalTime = (rOneTimeMinutes * SIXTY) + rOneTimeSeconds;

		rOneTimeMinutes = (int) (rOneTotalTime / SIXTY);
		rOneTimeSeconds = rOneTotalTime % SIXTY;
		String rOneTimeSecondsFormatted = (formatter.format(rOneTimeSeconds));
		String rOneTotalTimeFormatted = rOneTimeMinutes + ":" + rOneTimeSecondsFormatted;

		// Runner 1 Summary
		System.out.println(" ");
		System.out.println("Runner One Summary- " + lastnameone + ", " + firstnameone);
		System.out.println("Time for first split: " + rOneSplitOneFormatted);
		System.out.println("Time for second split: " + rOneSplitTwoFormatted);
		System.out.println("Time for third split: " + rOneSplitThreeFormatted);
		System.out.println("Total Time: " + rOneTotalTimeFormatted);

		// Runner 2
		System.out.println(" ");
		System.out.print("Runner Two, please enter your first & last name: ");
		String nametwo = keyboard.nextLine();
		String firstnametwo = nameone.split(" ")[0];
		String lastnametwo = nameone.split(" ")[1];

		System.out.print(firstnametwo + ", please enter your mile one time (MM:SS.SS): ");
		String rtwomiletimeone = keyboard.nextLine();

		System.out.print("Please enter your time to mile two (MM:SS.SS): ");
		String rtwomiletimetwo = keyboard.nextLine();

		System.out.print("Please enter your time to complete 5km (MM:SS.SS): ");
		String rtwofivekmtime = keyboard.nextLine();

		// Runner 2 Split One
		int rTwoSplitOneMinutes = Integer.parseInt(rtwomiletimeone.split(":")[0]);
		double rTwoSplitOneSeconds = Double.parseDouble(rtwomiletimeone.split(":")[1]);
		double rTwoSplitOneTotal = (rTwoSplitOneMinutes * SIXTY) + rTwoSplitOneSeconds;

		rTwoSplitOneMinutes = (int) (rTwoSplitOneTotal / SIXTY);
		rTwoSplitOneSeconds = rTwoSplitOneTotal % SIXTY;
		String rTwoSecondsOneFormatted = (formatter.format(rTwoSplitOneSeconds));
		String rTwoSplitOneFormatted = rTwoSplitOneMinutes + ":" + rTwoSecondsOneFormatted;

		// Runner 2 Split Two
		int rTwoSplitTwoMinutes = Integer.parseInt(rtwomiletimetwo.split(":")[0]);
		double rTwoSplitTwoSeconds = Double.parseDouble(rtwomiletimetwo.split(":")[1]);
		double rTwoSplitTwoTotal = (rTwoSplitTwoMinutes * SIXTY) + rTwoSplitTwoSeconds;
		rTwoSplitTwoTotal -= rTwoSplitOneTotal;

		rTwoSplitTwoMinutes = (int) (rTwoSplitTwoTotal / SIXTY);
		rTwoSplitTwoSeconds = rTwoSplitTwoTotal % SIXTY;
		String rTwoSecondsTwoFormatted = (formatter.format(rTwoSplitTwoSeconds));
		String rTwoSplitTwoFormatted = rTwoSplitTwoMinutes + ":" + rTwoSecondsTwoFormatted;

		// Runner 2 Split Three
		int rTwoSplitThreeMinutes = Integer.parseInt(rtwofivekmtime.split(":")[0]);
		double rTwoSplitThreeSeconds = Double.parseDouble(rtwofivekmtime.split(":")[1]);
		double rTwoSplitThreeTotal = (rTwoSplitThreeMinutes * SIXTY) + rTwoSplitThreeSeconds;
		rTwoSplitThreeTotal = rTwoSplitThreeTotal - (rTwoSplitOneTotal + rTwoSplitTwoTotal);

		rTwoSplitThreeMinutes = (int) (rTwoSplitThreeTotal / SIXTY);
		rTwoSplitThreeSeconds = rTwoSplitThreeTotal % SIXTY;
		String rTwoSecondsThreeFormatted = (formatter.format(rTwoSplitThreeSeconds));
		String rTwoSplitThreeFormatted = rTwoSplitThreeMinutes + ":" + rTwoSecondsThreeFormatted;

		// Runner 2 Total Time Formatted
		int rTwoTimeMinutes = Integer.parseInt(rtwofivekmtime.split(":")[0]);
		double rTwoTimeSeconds = Double.parseDouble(rtwofivekmtime.split(":")[1]);
		double rTwoTotalTime = (rTwoTimeMinutes * SIXTY) + rTwoTimeSeconds;

		rTwoTimeMinutes = (int) (rTwoTotalTime / SIXTY);
		rTwoTimeSeconds = rTwoTotalTime % SIXTY;
		String rTwoTimeSecondsFormatted = (formatter.format(rTwoTimeSeconds));
		String rTwoTotalTimeFormatted = rTwoTimeMinutes + ":" + rTwoTimeSecondsFormatted;

		// Runner 2 Summary
		System.out.println(" ");
		System.out.println("Runner Two Summary- " + lastnametwo + ", " + firstnametwo);
		System.out.println("Time for first split: " + rTwoSplitOneFormatted);
		System.out.println("Time for second split: " + rTwoSplitTwoFormatted);
		System.out.println("Time for third split: " + rTwoSplitThreeFormatted);
		System.out.println("Total Time: " + rTwoTotalTimeFormatted);

		// Runner 3
		System.out.print("Runner Three, please enter your first & last name: ");
		String namethree = keyboard.nextLine();
		String firstnamethree = nameone.split(" ")[0];
		String lastnamethree = nameone.split(" ")[1];

		System.out.print(firstnamethree + ", please enter your mile one time (MM:SS.SS): ");
		String rthreemiletimeone = keyboard.nextLine();

		System.out.print("Please enter your time to mile two (MM:SS.SS): ");
		String rthreemiletimetwo = keyboard.nextLine();

		System.out.print("Please enter your time to complete 5km (MM:SS.SS): ");
		String rthreefivekmtime = keyboard.nextLine();

		// Runner 3 Split One
		int rThreeSplitOneMinutes = Integer.parseInt(rthreemiletimeone.split(":")[0]);
		double rThreeSplitOneSeconds = Double.parseDouble(rthreemiletimeone.split(":")[1]);
		double rThreeSplitOneTotal = (rThreeSplitOneMinutes * SIXTY) + rThreeSplitOneSeconds;

		rThreeSplitOneMinutes = (int) (rThreeSplitOneTotal / SIXTY);
		rThreeSplitOneSeconds = rThreeSplitOneTotal % SIXTY;
		String rThreeSecondsOneFormatted = (formatter.format(rThreeSplitOneSeconds));
		String rThreeSplitOneFormatted = rThreeSplitOneMinutes + ":" + rThreeSecondsOneFormatted;

		// Runner 3 Split Two
		int rThreeSplitTwoMinutes = Integer.parseInt(rthreemiletimetwo.split(":")[0]);
		double rThreeSplitTwoSeconds = Double.parseDouble(rthreemiletimetwo.split(":")[1]);
		double rThreeSplitTwoTotal = (rThreeSplitTwoMinutes * SIXTY) + rThreeSplitTwoSeconds;
		rThreeSplitTwoTotal -= rThreeSplitOneTotal;

		rThreeSplitTwoMinutes = (int) (rThreeSplitTwoTotal / SIXTY);
		rThreeSplitTwoSeconds = rThreeSplitTwoTotal % SIXTY;
		String rThreeSecondsTwoFormatted = (formatter.format(rThreeSplitTwoSeconds));
		String rThreeSplitTwoFormatted = rThreeSplitTwoMinutes + ":" + rThreeSecondsTwoFormatted;

		// Runner 3 Split Three
		int rThreeSplitThreeMinutes = Integer.parseInt(rthreefivekmtime.split(":")[0]);
		double rThreeSplitThreeSeconds = Double.parseDouble(rthreefivekmtime.split(":")[1]);
		double rThreeSplitThreeTotal = (rThreeSplitThreeMinutes * SIXTY) + rThreeSplitThreeSeconds;
		rThreeSplitThreeTotal = rThreeSplitThreeTotal - (rThreeSplitOneTotal + rThreeSplitTwoTotal);

		rThreeSplitThreeMinutes = (int) (rThreeSplitThreeTotal / SIXTY);
		rThreeSplitThreeSeconds = rThreeSplitThreeTotal % SIXTY;
		String rThreeSecondsThreeFormatted = (formatter.format(rOneSplitThreeSeconds));
		String rThreeSplitThreeFormatted = rThreeSplitThreeMinutes + ":" + rThreeSecondsThreeFormatted;

		// Runner 3 Total Time Formatted
		int rThreeTimeMinutes = Integer.parseInt(rthreefivekmtime.split(":")[0]);
		double rThreeTimeSeconds = Double.parseDouble(rthreefivekmtime.split(":")[1]);
		double rThreeTotalTime = (rThreeTimeMinutes * SIXTY) + rThreeTimeSeconds;

		rThreeTimeMinutes = (int) (rThreeTotalTime / SIXTY);
		rThreeTimeSeconds = rThreeTotalTime % SIXTY;
		String rThreeTimeSecondsFormatted = (formatter.format(rThreeTimeSeconds));
		String rThreeTotalTimeFormatted = rThreeTimeMinutes + ":" + rThreeTimeSecondsFormatted;

		// Runner 3 Summary
		System.out.println(" ");
		System.out.println("Runner Three Summary- " + lastnamethree + ", " + firstnamethree);
		System.out.println("Time for first split: " + rThreeSplitOneFormatted);
		System.out.println("Time for second split: " + rThreeSplitTwoFormatted);
		System.out.println("Time for third split: " + rThreeSplitThreeFormatted);
		System.out.println("Total Time: " + rThreeTotalTimeFormatted);

		// Runner 4
		System.out.print("Runner Four, please enter your first & last name: ");
		String namefour = keyboard.nextLine();
		String firstnamefour = nameone.split(" ")[0];
		String lastnamefour = nameone.split(" ")[1];

		System.out.print(firstnamefour + ", please enter your mile one time (MM:SS.SS): ");
		String rfourmiletimeone = keyboard.nextLine();

		System.out.print("Please enter your time to mile two (MM:SS.SS): ");
		String rfourmiletimetwo = keyboard.nextLine();

		System.out.print("Please enter your time to complete 5km (MM:SS.SS): ");
		String rfourfivekmtime = keyboard.nextLine();

		// Runner 4 Split One
		int rFourSplitOneMinutes = Integer.parseInt(rfourmiletimeone.split(":")[0]);
		double rFourSplitOneSeconds = Double.parseDouble(rfourmiletimeone.split(":")[1]);
		double rFourSplitOneTotal = (rFourSplitOneMinutes * SIXTY) + rFourSplitOneSeconds;

		rFourSplitOneMinutes = (int) (rFourSplitOneTotal / SIXTY);
		rFourSplitOneSeconds = rFourSplitOneTotal % SIXTY;
		String rFourSecondsOneFormatted = (formatter.format(rFourSplitOneSeconds));
		String rFourSplitOneFormatted = rFourSplitOneMinutes + ":" + rFourSecondsOneFormatted;

		// Runner 4 Split Two
		int rFourSplitTwoMinutes = Integer.parseInt(rfourmiletimetwo.split(":")[0]);
		double rFourSplitTwoSeconds = Double.parseDouble(rfourmiletimetwo.split(":")[1]);
		double rFourSplitTwoTotal = (rFourSplitTwoMinutes * SIXTY) + rFourSplitTwoSeconds;
		rFourSplitTwoTotal -= rFourSplitOneTotal;

		rFourSplitTwoMinutes = (int) (rFourSplitTwoTotal / SIXTY);
		rFourSplitTwoSeconds = rFourSplitTwoTotal % SIXTY;
		String rFourSecondsTwoFormatted = (formatter.format(rFourSplitTwoSeconds));
		String rFourSplitTwoFormatted = rFourSplitTwoMinutes + ":" + rFourSecondsTwoFormatted;

		// Runner 4 Split Three
		int rFourSplitThreeMinutes = Integer.parseInt(rfourfivekmtime.split(":")[0]);
		double rFourSplitThreeSeconds = Double.parseDouble(rfourfivekmtime.split(":")[1]);
		double rFourSplitThreeTotal = (rFourSplitThreeMinutes * SIXTY) + rFourSplitThreeSeconds;
		rFourSplitThreeTotal = rFourSplitThreeTotal - (rFourSplitOneTotal + rFourSplitTwoTotal);

		rFourSplitThreeMinutes = (int) (rFourSplitThreeTotal / SIXTY);
		rFourSplitThreeSeconds = rFourSplitThreeTotal % SIXTY;
		String rFourSecondsThreeFormatted = (formatter.format(rFourSplitThreeSeconds));
		String rFourSplitThreeFormatted = rFourSplitThreeMinutes + ":" + rFourSecondsThreeFormatted;

		// Runner 4 Total Time Formatted
		int rFourTimeMinutes = Integer.parseInt(rfourfivekmtime.split(":")[0]);
		double rFourTimeSeconds = Double.parseDouble(rfourfivekmtime.split(":")[1]);
		double rFourTotalTime = (rFourTimeMinutes * SIXTY) + rFourTimeSeconds;

		rFourTimeMinutes = (int) (rFourTotalTime / SIXTY);
		rFourTimeSeconds = rFourTotalTime % SIXTY;
		String rFourTimeSecondsFormatted = (formatter.format(rFourTimeSeconds));
		String rFourTotalTimeFormatted = rFourTimeMinutes + ":" + rFourTimeSecondsFormatted;

		// Runner 4 Summary
		System.out.println(" ");
		System.out.println("Runner Four Summary- " + lastnamefour + ", " + firstnamefour);
		System.out.println("Time for first split: " + rFourSplitOneFormatted);
		System.out.println("Time for second split: " + rFourSplitTwoFormatted);
		System.out.println("Time for third split: " + rFourSplitThreeFormatted);
		System.out.println("Total Time: " + rFourTotalTimeFormatted);

		// Runner 5
		System.out.print("Runner Five, please enter your first & last name: ");
		String namefive = keyboard.nextLine();
		String firstnamefive = nameone.split(" ")[0];
		String lastnamefive = nameone.split(" ")[1];

		System.out.print(firstnameone + ", please enter your mile one time (MM:SS.SS): ");
		String rfivemiletimeone = keyboard.nextLine();

		System.out.print("Please enter your time to mile two (MM:SS.SS): ");
		String rfivemiletimetwo = keyboard.nextLine();

		System.out.print("Please enter your time to complete 5km (MM:SS.SS): ");
		String rfivefivekmtime = keyboard.nextLine();

		// Runner 5 Split One
		int rFiveSplitOneMinutes = Integer.parseInt(rfivemiletimeone.split(":")[0]);
		double rFiveSplitOneSeconds = Double.parseDouble(rfivemiletimeone.split(":")[1]);
		double rFiveSplitOneTotal = (rFiveSplitOneMinutes * SIXTY) + rFiveSplitOneSeconds;

		rFiveSplitOneMinutes = (int) (rFiveSplitOneTotal / SIXTY);
		rFiveSplitOneSeconds = rFiveSplitOneTotal % SIXTY;
		String rFiveSecondsOneFormatted = (formatter.format(rFiveSplitOneSeconds));
		String rFiveSplitOneFormatted = rFiveSplitOneMinutes + ":" + rFiveSecondsOneFormatted;

		// Runner 5 Split Two
		int rFiveSplitTwoMinutes = Integer.parseInt(rfivemiletimetwo.split(":")[0]);
		double rFiveSplitTwoSeconds = Double.parseDouble(rfivemiletimetwo.split(":")[1]);
		double rFiveSplitTwoTotal = (rFiveSplitTwoMinutes * SIXTY) + rFiveSplitTwoSeconds;
		rFiveSplitTwoTotal -= rFiveSplitOneTotal;

		rFiveSplitTwoMinutes = (int) (rFiveSplitTwoTotal / SIXTY);
		rFiveSplitTwoSeconds = rFiveSplitTwoTotal % SIXTY;
		String rFiveSecondsTwoFormatted = (formatter.format(rFiveSplitTwoSeconds));
		String rFiveSplitTwoFormatted = rFiveSplitTwoMinutes + ":" + rFiveSecondsTwoFormatted;

		// Runner 5 Split Three
		int rFiveSplitThreeMinutes = Integer.parseInt(rfivefivekmtime.split(":")[0]);
		double rFiveSplitThreeSeconds = Double.parseDouble(rfivefivekmtime.split(":")[1]);
		double rFiveSplitThreeTotal = (rFiveSplitThreeMinutes * SIXTY) + rFiveSplitThreeSeconds;
		rFiveSplitThreeTotal = rFiveSplitThreeTotal - (rFiveSplitOneTotal + rFiveSplitTwoTotal);

		rFiveSplitThreeMinutes = (int) (rFiveSplitThreeTotal / SIXTY);
		rFiveSplitThreeSeconds = rFiveSplitThreeTotal % SIXTY;
		String rFiveSecondsThreeFormatted = (formatter.format(rFiveSplitThreeSeconds));
		String rFiveSplitThreeFormatted = rFiveSplitThreeMinutes + ":" + rFiveSecondsThreeFormatted;

		// Runner 5 Total Time Formatted
		int rFiveTimeMinutes = Integer.parseInt(rfivefivekmtime.split(":")[0]);
		double rFiveTimeSeconds = Double.parseDouble(rfivefivekmtime.split(":")[1]);
		double rFiveTotalTime = (rFiveTimeMinutes * SIXTY) + rFiveTimeSeconds;

		rFiveTimeMinutes = (int) (rFiveTotalTime / SIXTY);
		rFiveTimeSeconds = rFiveTotalTime % SIXTY;
		String rFiveTimeSecondsFormatted = (formatter.format(rFiveTimeSeconds));
		String rFiveTotalTimeFormatted = rFiveTimeMinutes + ":" + rFiveTimeSecondsFormatted;

		// Runner 5 Summary
		System.out.println(" ");
		System.out.println("Runner Five Summary- " + lastnamefive + ", " + firstnamefive);
		System.out.println("Time for first split: " + rFiveSplitOneFormatted);
		System.out.println("Time for second split: " + rFiveSplitTwoFormatted);
		System.out.println("Time for third split: " + rFiveSplitThreeFormatted);
		System.out.println("Total Time: " + rFiveTotalTimeFormatted);

		// Runner 1-5 Table
		
		
		keyboard.close();
	}
}
