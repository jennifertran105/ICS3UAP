package com.bayviewglen.assignment;

import java.util.Scanner;

public class Hangman {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		final String VALID_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 ";
		final String VALID_CHARACTERS_NOSPACE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		final int SPACES = 30;
		int rounds = 1;
		int p1Score = 0;
		int p2Score = 0;
		int numGuessed = 0;
		int turns = 1;
		String phraseMaker = "";
		String guesser = "";
		String guessPhrase = "";
		String choice = "";
		String codedPhrase = "";
		String possibleCharacters = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z 0 1 2 3 4 5 6 7 8 9";
		String solutionPhrase = "";

		// Name Input
		System.out.print("Player 1, please enter your name: ");
		String p1n = keyboard.nextLine().trim();

		System.out.print("Player 2, please enter your name: ");
		String p2n = keyboard.nextLine().trim();

		System.out.println(p1n + " and " + p2n + " let's begin the game of Hangman...");

		boolean gameOver = false;
		while (!gameOver) {
			// Switches guessing player every round
			if (rounds % 2 == 0) {
				phraseMaker = p1n;
				guesser = p2n;

			} else if (rounds % 2 == 1) {
				phraseMaker = p2n;
				guesser = p1n;
			}
			System.out.println("-------------------------------------------------");
			System.out.println("Round " + rounds + " Start...");
			numGuessed = 0;
			codedPhrase = "";

			System.out.println(phraseMaker + " please enter an alphanumeric phrase to guess:");
			boolean validPhrase = false;
			// Get phrase and checks various things
			while (!validPhrase) {

				guessPhrase = keyboard.nextLine().toUpperCase().trim();
				System.out.println();

				validPhrase = true;
				if (guessPhrase.length() == 0) {
					System.out.print(phraseMaker + ", ERROR- Please enter an ALPHANUMERIC phrase:");
					validPhrase = false;
				}
				// Checks of phrase is alphanumeric
				for (int k = 0; k < guessPhrase.length() && validPhrase; k++) {
					if (VALID_CHARACTERS.indexOf(guessPhrase.charAt(k)) == -1) {
						System.out.print(phraseMaker + ", ERROR- Please enter an ALPHANUMERIC phrase:");
						guessPhrase = keyboard.nextLine().toUpperCase().trim();
						validPhrase = false;

					}

				} // end for loop checks if phrase alphanumerical

			} // end while Valid phrase
			for (int i = 0; i < SPACES; i++)
				System.out.println();
			for (int j = 0; j < guessPhrase.length(); j++) {
				if (guessPhrase.charAt(j) == ' ') {
					codedPhrase += ("/ ");
				} else {
					codedPhrase += ("_ ");
				}
			} // end for loop coding phrase

			System.out.println();
			boolean round = true;
			while (numGuessed < 7 && round) {
				System.out.println("Your possible choices to guess are: " + possibleCharacters);
				System.out.println("This is the hidden phrase: " + codedPhrase);
				System.out.println(guesser + " you have used " + numGuessed
						+ " guesses, would you like to (1) guess a character or (2) solve: ");

				boolean validChoice = false;
				while (!validChoice) {
					choice = keyboard.nextLine().toUpperCase().trim();

					// Choice 1 (Character)
					if (choice.equals("1")) {
						System.out.println("Your available letters & numbers are: " + possibleCharacters);
						System.out.println("");
						System.out.print("Please enter your choice: ");
						boolean validCharacter = false;
						while (!validCharacter) {
							choice = keyboard.nextLine().toUpperCase().trim();
							if (VALID_CHARACTERS.indexOf(choice.charAt(0)) == -1) {
								System.out.print("ERROR - you must enter an alphanumeric character: ");
							} else if (choice.length() < 1 || choice.length() > 1) {
								System.out.print("ERROR - you must only enter one alphanumeric character: ");
							} else if (possibleCharacters.indexOf(choice) == -1) {
								System.out.print("ERROR - you have already guessed that character: ");
							} else {
								validCharacter = true;

							}
							// Replaces in possible characters
							if (VALID_CHARACTERS_NOSPACE.indexOf(choice) != -1
									&& possibleCharacters.indexOf(choice) != -1) {
								possibleCharacters = possibleCharacters.substring(0, possibleCharacters.indexOf(choice))
										+ "_" + possibleCharacters.substring(possibleCharacters.indexOf(choice) + 1);
							}
							// Replaces in phrase
							for (int g = 0; g < guessPhrase.length(); g++) {
								if (guessPhrase.charAt(g) == choice.charAt(0)) {
									codedPhrase = codedPhrase.substring(0, g * 2) + choice
											+ codedPhrase.substring(g * 2 + 1);

								}
							}
							if (codedPhrase.indexOf("_") == -1) {
								System.out.println(guesser + ", you have won the round!");
								numGuessed--;
								round = false;
							}
							validChoice = true;
							numGuessed++;
						} // while (!validCharacter) ends

						System.out.println(possibleCharacters);
						System.out.println(codedPhrase);
						// Choice 2 (Solution)
					} else if (choice.equals("2")) {
						System.out.print("Please enter your solution: ");
						validPhrase = true;
						while (validPhrase) {
							solutionPhrase = keyboard.nextLine().toUpperCase().trim();
							numGuessed++;
							validPhrase = false;
							for (int i = 0; i < solutionPhrase.length() && validPhrase; i++) {
								if (VALID_CHARACTERS.indexOf(solutionPhrase.charAt(i)) == -1) {
									System.out.print(guesser + ", please enter an ALPHANUMERIC answer: ");
									validPhrase = true;
								}
							}
						} // while (!validPhrase) ends
						if (solutionPhrase.equals(guessPhrase)) {
							System.out.println(guesser + ", you have won the round!");
							numGuessed--;
							round = false;
						} else {
							System.out.println(guesser + " you are incorrect.");
							round = true;
						}
						validChoice = true;
						numGuessed++;
					}

				} // end while (!validchoice)
			} // end while (num guessed
			if (numGuessed == 7) {
				System.out.print(guesser + ", you have used all your guesses... Please enter your solution: ");
				validPhrase = true;
				while (validPhrase) {
					solutionPhrase = keyboard.nextLine().toUpperCase();

					validPhrase = false;
					for (int i = 0; i < solutionPhrase.length(); i++) {
						if (VALID_CHARACTERS.indexOf(guessPhrase.charAt(i)) == -1) {
							System.out.print(guesser + ", please enter your solution using ALPHANUMERIC CHARACTERS: ");
							solutionPhrase = keyboard.nextLine().toUpperCase();
							validPhrase = true;
						}
					}
				}
				if (solutionPhrase.equals(guessPhrase)) {
					System.out.println("You are correct!");
					round = false;
					numGuessed--;
				} else {
					System.out.println("You are incorrect!");
					numGuessed++;

				}
			}
			// Takes number of guesses and adds to score
			if (turns % 2 == 1) {
				p1Score += 8 - numGuessed;
			} else if (turns % 2 == 0) {
				p2Score += 8 - numGuessed;
				rounds++;

			}
			System.out.println("Total players points:");
			System.out.println(p1n + ": " + p1Score);
			System.out.println(p2n + ": " + p2Score);
			// Displays Winner & if tie plays another round
			if (turns % 2 == 0 && rounds > 5) {
				if (p1Score > p2Score) {
					System.out.println(p1n + ", WINS :)" + p2n + ", loses :(");
					gameOver = true;
				} else if (p1Score < p2Score) {
					System.out.println(p2n + ", WINS :)" + p1n + ", loses :(");
					gameOver = true;
				} else {
					System.out.println("This game is a tie! Please play a tie-breaker to determine the winner...");
					gameOver = false;
				}
			}
			turns++;
		} // end while (!game over)
		long time = System.currentTimeMillis();
		System.out.println("The program will close in 5 seconds...");
		while ((double) (System.currentTimeMillis() - time) < 10000.0) {
		}
		System.out.println("Goodbye.");
		keyboard.close();
	}
}
