package com.bayviewglen.daysix;

public class HomeworkFour {

	public static void main(String[] args) {
		double light = 3e8;
		int seconds = 60;
		int minutes = 60;
		int hours = 24;
		int days = 365;
		double lightyear = ((((light*seconds)* minutes)*hours)*days);
		
		System.out.println("The distance that light would travel in a year is " + lightyear + ".");
		
		
	}

}
