package com.bayviewglen.assignment;

import java.util.Scanner;

public class Hangman {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		final String VALID_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 ";
		final String VALID_CHARACTERS_NOSPACE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

		//Name Input
		System.out.println("Player 1, please enter your name: ");
		String namep1 = keyboard.nextLine();

		System.out.println("Player 2, please enter your name: ");
		String namep2 = keyboard.nextLine();
		
		//Round 

	}

}
