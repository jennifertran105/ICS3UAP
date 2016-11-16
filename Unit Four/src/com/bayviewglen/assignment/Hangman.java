package com.bayviewglen.assignment;

import java.util.Scanner;

public class Hangman {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		final String VALID_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 ";
		final String VALID_CHARACTERS_NOSPACE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

		// Name Input
		System.out.print("Player 1, please enter your name: ");
		String namep1 = keyboard.nextLine();

		System.out.print("Player 2, please enter your name: ");
		String namep2 = keyboard.nextLine();

		System.out.println(namep1 + " and " + namep2 + " let's begin the game of Hangman...");

		// Round
		System.out.println("Round Start...");
		System.out.println("Please enter a alphanumeric phase to guess:");
		String phrase1 = keyboard.nextLine().toUpperCase();

		boolean valid = false;
		
		while (!valid){
			
		}
		
	}
}
