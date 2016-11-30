package com.bayviewglen.assignment;

import java.util.Scanner;

public class PraticeWork {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		final String ALPHANUMERALS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 ";
		final String NO_SPACE_ALPHANUMERALS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		final int PLAYER_ONE_TURN = 1;
		final int PLAYER_TWO_TURN = 0;
		final int CHAR_BEGIN = 0;
		final int INDEX_NEED = -1;
		final int SPACE_NUM = 30;
		final int TURNS = 2;
		final int CHAR_OVER_ONE = 1;
		final int PLAYER_TURN = 2;
		final int POINTS = 8;
		final int ROUNDS = 5;
		final int GUESS = 7;
		final int ROUNDS_DONE = 0;

		String guesses = " ";
		String playerNow = " ";
		String guess = " ";
		String message = " ";
		String cover = " ";
		String playerOpponent = " ";
		int playerOnePoints = 0;
		int playerTwoPoints = 0;
		int rounds = 1;
		int guessed;
		int turns = 1;

		System.out.print("Please enter your name Player 1: ");
		String player1 = keyboard.nextLine().trim();

		System.out.print("Please enter your name Player 2: ");
		String player2 = keyboard.nextLine().trim();

		boolean gameOver = false;
		while (!gameOver) {

			if (turns % PLAYER_TURN == PLAYER_ONE_TURN) {
				playerNow = player1;
				playerOpponent = player2;
			} else if (turns % PLAYER_TURN == PLAYER_TWO_TURN) {
				playerNow = player2;
				playerOpponent = player1;
			}
			System.out.println("--------------------- Round " + rounds + "-------------------- ");
			guesses = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
			cover = "";
			guessed = 0;

			System.out.print(playerOpponent + ", please enter the phrase/word you want your opponent to guess: ");
			boolean crossed = true;
			while (crossed) {
				message = keyboard.nextLine().toUpperCase().trim();
				crossed = false;
				if (message.length() == 0) {
					System.out.print(playerOpponent + ", please enter a message you want your opponent to guess: ");
					crossed = true;
				}
				for (int i = 0; i < message.length(); i++) {
					if (ALPHANUMERALS.indexOf(message.charAt(i)) == INDEX_NEED) {
						System.out.print(playerOpponent + ", please enter an ALPHANUMERIC message to be guessed: ");
						crossed = true;
						break;
					}
				}
			}

			for (int i = 0; i < SPACE_NUM; i++)
				System.out.println();

			for (int i = 0; i < message.length(); i++) {
				if (message.charAt(i) == ' ')
					cover += "/";
				else
					cover += "_";
			}

			for (int i = 0; i < cover.length(); i++) {
				System.out.print(cover.charAt(i) + " ");
			}
			System.out.println();

			boolean round = true;
			while (guessed < GUESS && round) {

				System.out.print(playerNow + ", you have used " + guessed
						+ " guesses, would you like to (1) solve the word/phrase or (2) guess a character: ");
				String UserInput = keyboard.nextLine();
				while (!(UserInput.equals("1") || UserInput.equals("2"))) {
					System.out.print(playerNow + ", you have to (1) solve the word/phrase or (2) guess a character!! ");
					UserInput = keyboard.nextLine();
				}

				if (UserInput.equals("1")) {
					System.out.print(playerNow + ", please enter your answer: ");
					crossed = true;
					while (crossed) {
						guess = keyboard.nextLine().toUpperCase().trim();
						crossed = false;
						for (int i = 0; i < guess.length(); i++) {
							if (ALPHANUMERALS.indexOf(guess.charAt(i)) == INDEX_NEED) {
								System.out.print(playerNow + ", please enter an ALPHANUMERIC answer: ");
								crossed = true;
								break;
							}
						}
					}

					if (guess.equals(message)) {
						System.out.println(playerNow + ", you are correct!!");
						round = false;
						guessed--;
					} else {
						System.out.println(playerNow + ", you are wrong!!");
					}

				} else if (UserInput.equals("2")) {
					System.out.print("Unused Characters: ");
					for (int i = 0; i < guesses.length(); i++) {
						System.out.print(guesses.charAt(i) + " ");

					}
					System.out.print(playerNow + ", please guess a single character: ");
					crossed = true;
					while (crossed) {
						guess = keyboard.nextLine().toUpperCase().trim();
						if (NO_SPACE_ALPHANUMERALS.indexOf(guess) == INDEX_NEED) {
							System.out.print(playerNow
									+ ", please guess a single character (NO SPACES, only using ALPHANUMERIC CHARACTERS!!: ");
						} else if (guess.length() > 1 || guess.length() < 1) {
							System.out.print(playerNow + ", please guess a letter!! ");
						} else if (guesses.indexOf(guess) == INDEX_NEED) {
							System.out.print(playerNow + ", please guess a letter you have not BEFORE!! ");
						} else {
							crossed = false;
							guesses = guesses.substring(CHAR_BEGIN, guess.indexOf(guess)) + "_"
									+ guesses.substring(guess.indexOf(guess) + CHAR_OVER_ONE);

						}

					}

					if (message.indexOf(guess) != INDEX_NEED) {
						System.out.println(playerNow + ", the letter '" + guess + "' is in word/phrase, NICE!");
						for (int i = 0; i < cover.length(); i++) {
							if (message.substring(i, i + CHAR_OVER_ONE).equals(guess))
								cover = cover.substring(CHAR_BEGIN, i) + guess + cover.substring(i + CHAR_OVER_ONE);
						}
					} else {
						System.out.println(playerNow + ", the letter '" + guess + "' is not in the word/phrase, BOO!!");
					}

					for (int i = 0; i < cover.length(); i++) {
						System.out.print(cover.charAt(i) + " ");
					}

					System.out.println();
					if (cover.indexOf("_") == INDEX_NEED) {
						System.out.println("CONGRATS YOU HAVE WON!!");
						guessed--;
						round = false;
					}

				}
				guessed++;
			}

			if (guessed == GUESS) {
				System.out.print(playerNow + ", you have used all your guesses. Please enter your solution!! ");
				crossed = true;
				while (crossed) {
					guess = keyboard.nextLine().toUpperCase();

					crossed = false;
					for (int i = 0; i < guess.length(); i++) {
						if (ALPHANUMERALS.indexOf(message.charAt(i)) == INDEX_NEED) {
							System.out
									.print(playerNow + ", please enter your solution using ALPHANUMERIC CHARACTERS: ");
							guess = keyboard.nextLine().toUpperCase();
							crossed = true;
						}
					}
				}
				if (guess.equals(message)) {
					System.out.println("CORRECT!!");
				} else {
					System.out.println("WRONG!!");
					guessed++;

				}
			}

			if (turns % PLAYER_TURN == PLAYER_ONE_TURN) {
				playerOnePoints += POINTS - guessed;
			} else if (turns % PLAYER_TURN == PLAYER_TWO_TURN) {
				playerTwoPoints += POINTS - guessed;
				rounds++;

			}

			System.out.println("Total player points");
			System.out.println(player1 + ": " + playerOnePoints);
			System.out.println(player2 + ": " + playerTwoPoints);

			if (turns % TURNS == ROUNDS_DONE && rounds > ROUNDS) {
				if (playerOnePoints > playerTwoPoints) {
					System.out.println("CONGRATULATIONS " + player1 + ", YOU WON!!");
					gameOver = true;
				} else if (playerOnePoints < playerTwoPoints) {
					System.out.println("CONGRATULATIONS " + player2 + ", YOU WON!!");
					gameOver = true;
				} else {
					System.out.println("THE GAME IS A TIE!! The next round will be the tie breaker!!");
				}
			}

			turns++;

		}
		keyboard.close();

	}

}