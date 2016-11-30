package com.bayviewglen.assignment;

import java.util.Scanner;

public class PracticeWork {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		final String VALID_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 ";
		final String VALID_CHARACTERS_NOSPACE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		boolean validPhrase = false;
		boolean halfRoundOver = false;
		boolean validChoice = false;
		boolean validCharacter = false;
		String codedPhrase = " ";
		int rounds = 1;
		String phraseMaker = " ";
		String guesser = " ";
		String possibleChars = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z 0 1 2 3 4 5 6 7 8 9";
		final int MAX_GUESSES = 7;
		int p1Score = 0;
		int p2Score = 0;
		 boolean p1IsGuesser = true;
		boolean correct = false;
		int numGuesses = 0; 

		// Name Input
		System.out.print("Player 1, please enter your name: ");
		String p1n = keyboard.nextLine();

		System.out.print("Player 2, please enter your name: ");
		String p2n = keyboard.nextLine();

		System.out.println(p1n + " and " + p2n + " let's begin the game of Hangman...");

		// Round
		System.out.println("-------------------------------------------------");
		System.out.println("Round Start...");

	
		// Round
		// bigwhileloop
		// big for loop for each 1/2 round
		// don't forget to add name into input

		if (rounds % 2 == 0) {
			phraseMaker = p1n;
			guesser = p2n;

		} else if (rounds % 2 == 1) {
			phraseMaker = p2n;
			guesser = p1n;
		}

		System.out.println(phraseMaker + " please enter an alphanumeric phase to guess:");
		String guessPhrase = keyboard.nextLine().toUpperCase().trim();
		System.out.println();

		// Checks if Phrase is alpha numerical
		for (int i = 0; i < guessPhrase.length(); i++) {
			if (VALID_CHARACTERS.indexOf(guessPhrase.charAt(i)) == -1) {
				System.out.print("ERROR- Please enter an alphanumeric phase:");
				guessPhrase = keyboard.nextLine().toUpperCase().trim();
			} else {
				validPhrase = true;
			}
		}
		// Codes the phrase
		for (int j = 0; j < guessPhrase.length(); j++) {
			if (guessPhrase.charAt(j) == ' ') {
				codedPhrase += ("/ ");
			} else {
				codedPhrase += ("_ ");
			}
		}
		System.out.println(codedPhrase);
		while (!halfRoundOver){
		// choices

			while (!validChoice) {
				 if (numGuesses != MAX_GUESSES) {
	                 System.out.print(guesser + ", you have used " + numGuesses + " out of 7 guesses, would you like to (1) guess a character or (2) solve: ");
				String choice = keyboard.nextLine().toUpperCase();
				if (choice.equals("1")) {
					System.out.println("Your available letters & numbers are: " + possibleChars);
					System.out.println("");
					System.out.print("Please enter your choice: ");
					validCharacter = false;
					while (!validCharacter) {
						choice = keyboard.nextLine().toUpperCase();
						if (VALID_CHARACTERS.indexOf(choice.charAt(0)) == -1) {
							System.out.print("ERROR - you must enter an alphanumeric character: ");
						} else if (choice.length() < 1 || choice.length() > 1) {
							System.out.print("ERROR - you must only enter one alphanumeric character: ");
						} else if (possibleChars.indexOf(choice) == -1) {
							System.out.print("ERROR - you have already guessed that character: ");
						} else {
							validCharacter = true;
						}

					}
					//Replaces in possible charcters
					if (VALID_CHARACTERS_NOSPACE.indexOf(choice) != -1 && possibleChars.indexOf(choice) != -1) {
						possibleChars = possibleChars.substring(0, possibleChars.indexOf(choice)) + "_"
								+ possibleChars.substring(possibleChars.indexOf(choice) + 1);

					}
					// Replaces in phrase 
					for (int i = 0; i < guessPhrase.length(); i++) {
						if (guessPhrase.substring(i, i + 1).equals(choice)) {
							codedPhrase = codedPhrase.substring(0, i) + choice + codedPhrase.substring(i + 2);

						}
					}
					System.out.println(possibleChars);
					System.out.println(codedPhrase);
// SOlution
				} else if (choice.equals("2")) {
					System.out.print("Please enter your solution: ");
					String solutionPhrase = keyboard.nextLine().toUpperCase();
					if (solutionPhrase.equals(guessPhrase)) {
						System.out.println(guesser + " you are correct!");
					} else {
						System.out.println(guesser + " you are incorrect.");
					}
				}
			}
			}
//		 if (correct && p1IsGuesser) {
      //       p1Score += 1 + (7 - guesses);
    //     } else if (correct) {
  //           p2Score += 1 + (7 - guesses);
		}//while half round over 

		// display winner

	}
}
