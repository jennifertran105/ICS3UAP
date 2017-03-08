package com.bayviewglen.horseRacing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class HorseRacing {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		introMessage();
		String play = "";

		String[] horses = getHorses();
		String[] playerInfo = getPlayerInfo();
		String[] playerNames = getPlayersNames(playerInfo);
		double[] playerWallets = getPlayersWallets(playerInfo);

		// start the horse race
		while (!play.equalsIgnoreCase("no")) {

			String[] horsePlay = initializeHorse(horses);
			displayHorse(horsePlay);

			boolean race = true;
			double[] bet = new double[playerNames.length];
			int[] horseBet = new int[playerNames.length];
			for (int i = 0; i < horseBet.length; i++) {
				horseBet[i] = 10;
			}

			while (race) {
				int decision = getDecisions(keyboard);

				// first choice (gets player amount of bet)
				if (decision == 1) {
					playerNameGraph(playerInfo, playerNames, playerWallets);
					getBets(keyboard, playerNames, playerWallets, horsePlay, bet, horseBet);

					// second choice (add player to betting list)
				} else if (decision == 2) {
					playerInfo = addPlayer(keyboard, playerNames, playerWallets, playerInfo);
					playerNames = getPlayersNames(playerInfo);
					playerWallets = getPlayersWallets(playerInfo);
					playerNameGraph(playerInfo, playerNames, playerWallets);
					bet = DoubleArray(playerInfo, bet);
					horseBet = IntArray(playerInfo, horseBet);

					// third choice (save and quit game)
				} else if (decision == 3) {
					quitGame(playerInfo, playerNames, playerWallets);
					race = false;
					play = "no";

					// shows race
				} else {
					displayRace(horsePlay, keyboard);
					race = false;
				}
			}

			if (!play.equalsIgnoreCase("no"))

			{
				adjustWallets(horsePlay, playerNames, playerWallets, bet, horseBet);
				play = playAgain(keyboard);
			}

		}
		playerQuit(playerInfo, playerNames, playerWallets);
		// end of game (saves and quit)
	}

	public static void introMessage() {
		// plays introduction message
		
	System.out.println("WELCOME TO HORSE BETTING SIMULATOR 2K17. HAVE FUN AND GOOD LUCK!!!!!");
		
	}

	public static String[] getPlayerInfo() {
		String[] info = { "" };
		String fileName = "input/players.dat";
		Scanner files = null;
		try {
			files = new Scanner(new File(fileName));
			String num = files.nextLine();
			int number = Integer.valueOf(num);
			info = new String[number];
			int i = 0;
			while (files.hasNext()) {
				info[i] = files.nextLine();
				i++;
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + e.getMessage());
		} finally {
			if (files != null) {
				files.close();
			}
		}
		return info;

	}

	private static void playerQuit(String[] playerInfo, String[] playerNames, double[] playerWallets) {
		System.out.println("Thanks for playing Horse Betting Simulator 2k17!!!");
		quitGame(playerInfo, playerNames, playerWallets);

	}

	private static void adjustWallets(String[] horses, String[] playerNames, double[] playerWallets, double[] bet,
			int[] horseBet) {
		// adjusts wallets based on player's bet and winnings

		int[] position = new int[horses.length];
		int winner = horseWinner(position);

		for (int i = 0; i < playerNames.length; i++) {
			if (horseBet[i] == 10) {
				System.out.println(playerNames[i] + "you did not bet on a horse yet!");
			} else if (winner == horseBet[i]) {
				playerWallets[i] += bet[i];
				System.out.println(playerNames[i] + "your horse won the race!!! NICE");
			} else {
				playerWallets[i] -= bet[i];
				System.out.println(playerNames[i] + "your horse lost the race!!! TOO BAD");
			}
		}

	}

	private static int horseWinner(int[] position) {
		// see which horse wins the race
		int winner = 0;
		for (int i = 0; i < position.length; i++) {
			if (position[i] == 35)
				;
			winner = i;
		}
		return winner;
	}

	private static String playAgain(Scanner keyboard) {
		// ask player if they want to play again, or leave and save/quit the
		// game
		String play;
		System.out.println("Would you like the play again? (Yes or No)");
		play = keyboard.nextLine();

		while (!play.equalsIgnoreCase("yes") && !play.equalsIgnoreCase("no")) {
			System.out.println("Please answer if you would like to play again please! (Yes or No)");
			play = keyboard.nextLine();
		}
		return play;

	}

	private static void displayRace(String[] horses, Scanner keyboard) {
		// shows the race graphic where the horse move across the field
		boolean winner = false;
		int[] position = new int[horses.length];
		track(horses, position, keyboard);
		while (!winner) {
			horsesMove(horses, position, keyboard);
			winner = checkWinner(position);
		}
		int win = horseWinner(position);
		System.out.println(horses[win] + " wins the race!! NICE");
	}

	private static boolean checkWinner(int[] position) {
		// checks for the winning horse
		boolean win = false;
		for (int i = 0; i < position.length; i++) {
			if (position[i] == 25)
				win = true;
		}
		return win;
		
	

	}

	private static void horsesMove(String[] horses, int[] position, Scanner keyboard) {
		// gets horses position
		for (int i = 0; i < position.length; i++) {
			int j = (int) (Math.random() * 3);
			position[i] += j;
		}
	}

	private static void track(String[] horses, int[] position, Scanner keyboard) {
		// displays the track where the horses race on
		for (int i = 0; i < horses.length; i++) {
			System.out.println("--------------------------------------------------------------------");
			System.out.printf("%-1s |" + horses[i], " ");
		}

		System.out.println("--------------------------------------------------------------------");
		System.out.println();
	

	}

	private static int[] IntArray(String[] playerInfo, int[] horseBet) {
		// fix betting array for adding new player
		int[] newBetting = new int[playerInfo.length];
		for (int i = 0; i < playerInfo.length - 1; i++) {
			newBetting[i] = 10;
		}
		newBetting[playerInfo.length - 1] = 10;
		horseBet = newBetting;
		return horseBet;

	}

	private static void quitGame(String[] playerInfo, String[] playerNames, double[] playerWallets) {
		// saves/quits the game
		for (int i = 0; i < playerInfo.length; i++) {
			playerInfo[i] = playerNames[i] + "," + playerWallets[i];
		}
		String name = "input/players.dat";
		PrintWriter printWriter;

		try {
			printWriter = new PrintWriter(new FileOutputStream(name));
			int length = playerInfo.length;
			printWriter.println(length);
			for (int i = 0; i < length; i++) {
				printWriter.println(playerInfo[i]);
			}
			printWriter.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	private static double[] DoubleArray(String[] playerInfo, double[] bet) {
		// fix betting array for adding new player
		double[] newBet = new double[playerInfo.length];
		for (int i = 0; i < playerInfo.length - 1; i++) {
			newBet[i] = bet[i];
		}
		newBet[playerInfo.length - 1] = 0;
		bet = newBet;
		return bet;
	}

	private static String[] addPlayer(Scanner keyboard, String[] playerNames, double[] playerWallets,String[] playerInfo) {
		// adds a new player into the game
		System.out.println("Welcome player! The current people in the game are: ");
		playerNameGraph(playerInfo, playerNames, playerWallets);
		System.out.println("Please enter your username: ");
		String playerName = keyboard.nextLine();
		System.out.println("Please enter the amount of money you want in your wallet!");
		String wallet = keyboard.nextLine();
		String playersInfo = playerName + "," + wallet;
		String[] newPlayerInfo = new String[playerInfo.length + 1];
		for (int i = 0; i < playerInfo.length; i++) {
			newPlayerInfo[i] = playerInfo[i];

		}
		newPlayerInfo[newPlayerInfo.length - 1] = playersInfo;
		playerInfo = newPlayerInfo;
		return playerInfo;

	}

	private static void getBets(Scanner keyboard, String[] playerNames, double[] playerWallets, String[] horsePlay, double[] bet, int[] horseBet) {
		// gets bets from players playing
		int racePlayers = horsePlay.length;
		boolean betting = true;
		int playerIndex = 0;
		while (betting) {

			playerIndex = choosePlayer(keyboard, playerNames, playerIndex);
			if (playerWallets[playerIndex] != 0) {
				getPlayerBet(keyboard, playerNames, playerWallets, bet, playerIndex, horseBet, racePlayers);

			} else {
				System.out.println("You dont have any more money to bet with!!!");

			}
			System.out.println("Would another player want to place a bet?? (Yes or No)");
			String betting$ = keyboard.nextLine();

			while (!betting$.equalsIgnoreCase("yes") && !betting$.equalsIgnoreCase("no")) {
				System.out.println("Please answer Yes or No, would another player want to place a bet");
				betting$ = keyboard.nextLine();
			}
			if (betting$.equalsIgnoreCase("no")) {
				betting = false;
			}

		}

	}

	private static void getPlayerBet(Scanner keyboard, String[] playerNames, double[] playerWallets, double[] bet, int playerIndex, int[] horseBet, int racePlayers) {
		// get player's horse and bet
		getPlayerMoneybet(keyboard, playerNames, playerWallets, bet, playerIndex);
		getPlayerHorseBet(keyboard, playerNames, playerIndex, horseBet, racePlayers);
	}

	private static void getPlayerHorseBet(Scanner keyboard, String[] playerNames, int playerIndex, int[] horseBet,
			int racePlayers) {
		// gets horse that the player wants to bet on
		while (horseBet[playerIndex] < 1 || horseBet[playerIndex] > racePlayers) {
			System.out.print(playerNames[playerIndex] + ", please enter the number of the horse you want to bet on: ");
			String readHorse = keyboard.nextLine();

			try {
				horseBet[playerIndex] = Integer.valueOf(readHorse) - 1;
			} catch (NumberFormatException e) {
				System.out.println("Please enter a number!!");
				horseBet[playerIndex] = -1;
			}
		}
	}

	private static void getPlayerMoneybet(Scanner keyboard, String[] playerNames, double[] playerWallets, double[] bet,
			int playerIndex) {
		while (bet[playerIndex] < 1 || bet[playerIndex] > playerWallets[playerIndex]) {
			System.out.print(playerNames[playerIndex] + ", you have " + (playerWallets[playerIndex])
					+ " in your wallet left, please enter your betting amount: ");
			String readBet = keyboard.nextLine();

			try {
				bet[playerIndex] = Double.valueOf(readBet);
			} catch (NumberFormatException e) {
				System.out.println("Please enter a number!!");
				bet[playerIndex] = -1;

			}
		}

	}

	private static int choosePlayer(Scanner keyboard, String[] playerNames, int playerIndex) {
		// chooses which player is betting
		int num = 0;
		while (num > playerNames.length || num < 1) {
			System.out.println("please enter the number coresponding to your name: ");
			String name = keyboard.nextLine();

			try {
				num = Integer.valueOf(name);
			} catch (NumberFormatException e) {
				System.out.println(" Please enter a number!!");
				num = -1;
			}

		}
		playerIndex = num - 1;
		return playerIndex;
	}

	private static void playerNameGraph(String[] info, String[] names, double[] wallets) {
		// displays players and amount of money on a chart
		System.out.printf("%-1s %15s %-15s \n", "#", "Player Name", "Wallet");
		for (int i = 0; i < info.length; i++) {
			System.out.printf("%1d %15s %-15f \n", i + 1, names[i], wallets[i]);

		}
	}

	private static int getDecisions(Scanner keyboard) {
		// gets choice from what player wants to do
		System.out.println(
				"What would you like to do? 1. Bet on horses, 2. Add a player, 3. Save and quit, 4. Start Race!");
		int choice = 0;
		while (choice != 1 && choice != 2 && choice != 3 && choice != 4) {
			System.out.println("Please enter the number that coresponds with the action you want to do");
			String playing = keyboard.nextLine();

			try {
				choice = Integer.valueOf(playing);
			} catch (NumberFormatException e) {
				System.out.println("Please enter a number!!");
				choice = -1;
			}
		}
		return choice;
	}

	private static String[] initializeHorse(String[] horses) {
		// select horses to be in the race by random
		int x = (int) (Math.random() * (4) + 5);
		int numHorses = horses.length;
		String[] horsesPlaying = new String[x];
		int[] horseIndex = new int[x];
		boolean previousInt = false;

		for (int i = 0; i < x; i++) {
			int y = (int) (Math.random() * numHorses);
			previousInt = checkForDuplicate(y, horseIndex);
			while (previousInt) {
				y = (int) (Math.random() * numHorses - 1);
				previousInt = checkForDuplicate(y, horseIndex);
			}
			horseIndex[i] = y;
		}

		for (int i = 0; i < x; i++) {
			horsesPlaying[i] = horses[horseIndex[i]];
		}

		return horsesPlaying;
	}

	private static boolean checkForDuplicate(int x, int[] y) {
		// checks to make sure no duplicate horses in race
		for (int num : y) {
			if (num == x) {
				return true;
			}
		}
		return false;
	}

	public static double[] makeStringDouble(String[] value) {
		// string array to a double array
		double[] doubl = { 0.0 };
		for (int i = 0; i <= doubl.length; i++) {
			doubl[i] = Double.valueOf(value[i]);
		}

		return doubl;
	}

	private static void displayHorse(String[] arr) {
		// displays horses in the race
		System.out.println(" \nThe Horse in the race today are: ");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(i + 1 + "." + arr[i]);
		}

	}

	private static String[] getHorses() {
		String[] horses = { "" };
		String fileName = "input/horse.dat";
		Scanner files = null;
		try {
			files = new Scanner(new File(fileName));
			String num = files.nextLine();
			int number = Integer.valueOf(num);
			horses = new String[number];
			int i = 0;
			while (files.hasNext()) {
				horses[i] = files.nextLine();
				i++;
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + e.getMessage());
		} finally {
			if (files != null) {
				files.close();
			}
		}
		return horses;

	}

	private static double[] getPlayersWallets(String[] info) {
		String[] wallet = new String[info.length];
		for (int i = 0; i < info.length; i++) {
			int position = info[i].indexOf(',');
			wallet[i] = info[i].substring(position + 1);
		}
		double[] money = new double[info.length];
		for (int i = 0; i < money.length; i++) {
			money[i] = Double.valueOf(wallet[i]);
		}

		return money;
	}

	private static String[] getPlayersNames(String[] info) {
		String[] name = new String[info.length];
		for (int i = 0; i < info.length; i++) {
			int position = info[i].indexOf(',');
			name[i] = info[i].substring(0, position);
		}
		return name;
	}
}