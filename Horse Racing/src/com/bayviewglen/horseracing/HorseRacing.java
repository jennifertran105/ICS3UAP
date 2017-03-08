package com.bayviewglen.horseracing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

//TODO cant start game with no players
public class HorseRacing {
	static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) throws InterruptedException {
		introMessage();
		String[] horses = getHorses();
		String[] playerData = new String[100];
		String[] playerNames = new String[100];
		int[] playerWallets = new int[100];

		//TODO make sure it adds and doesnt rewrite array
		horses = getHorses();
		playerData = getPlayerData();
		playerNames = getPlayersNames(playerData);
		playerWallets = getPlayerWallets(playerData);

		// Starts Game
		boolean gameOver = false;
		while (!gameOver) {

			String[] horsePlay = getHorsesInRace(horses);
			//displayHorse(horsePlay);
			// Starts Race
			boolean race = true;
			double[] bet = new double[playerNames.length];
			int[] horseBet = new int[playerNames.length];
			for (int i = 0; i < horseBet.length; i++) {
				horseBet[i] = 10;
			}

			
			while (race) {
				int decision = getChoice(keyboard);

				// 1st choice (gets player amount of bet)
				if (decision == 1) {
					//fix this so it doesnt show without names
					displayPlayerNamesWallets(playerData, playerNames, playerWallets);
					
					getPlayerBets(keyboard, playerNames, playerWallets, horsePlay, bet, horseBet);

					// 2nd choice (add player to betting list)
				} else if (decision == 2) {
					playerData = addPlayer(keyboard, playerNames, playerWallets, playerData);
					playerNames = getPlayersNames(playerData);
					playerWallets = getPlayerWallets(playerData);
					displayPlayerNamesWallets(playerData, playerNames, playerWallets);
					bet = DoubleArray(playerData, bet);
					horseBet = IntArray(playerData, horseBet);

					// 3rd choice (save and quit game)
				} else if (decision == 3) {
					playerQuit(playerData, playerNames, playerWallets);
					race = false;
					gameOver = true;

					// Displays Race
				} else {
					displayRace(horsePlay, keyboard);
					race = false;
				}
			}

			if (!gameOver)

			{
				payOutBets(horsePlay, playerNames, playerWallets, bet, horseBet);
			}

		}
		gameEnd(playerData, playerNames, playerWallets);
		// End of Game
	}
	// Pays out winnings to player's wallets based on bets

	private static void payOutBets(String[] horsePlay, String[] playerNames, double[] playerWallets, double[] bet,
			int[] horseBet) {
		int[] position = new int[horsePlay.length];
		int winner = winningHorse(position);

		for (int i = 0; i < playerNames.length; i++) {
			if (horseBet[i] == 10) {
				System.out.println(playerNames[i] + "you did not bet.");
			} else if (winner == horseBet[i]) {
				playerWallets[i] += bet[i];
				System.out.println(playerNames[i] + "you have won your bet.");
			} else {
				playerWallets[i] -= bet[i];
				System.out.println(playerNames[i] + "you have lost your bet.");
			}
		}
	}

	// Prints beginning message
	public static void introMessage() throws InterruptedException {
		System.out.println("Welcome to Horse Racing!");

	}

	// Get Players Data from player.dat file
	private static String[] getPlayerData() {
		String[] playerData = null;
		try {
			Scanner scanner = new Scanner(new File("input/player.dat"));
			int numPlayers = Integer.parseInt(scanner.nextLine());
			playerData = new String[numPlayers];

			for (int i = 0; i < numPlayers; i++) {
				playerData[i] = scanner.nextLine().split(" ")[0];
			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		return playerData;
	}

	private static void updatePlayerData(String[] playerNames, double[] playerWallets) {
		// TODO Auto-generated method stub

	}

	// Sees which horse wins the race
	private static int winningHorse(int[] position) {
		int winner = 0;
		for (int i = 0; i < position.length; i++) {
			if (position[i] == 35)
				;
			winner = i;
		}
		return winner;
	}

	// Displays the race
	private static void displayRace(String[] horses, Scanner keyboard) {
		boolean winner = false;
		int[] position = new int[horses.length];
		track(horses, position, keyboard);
		while (!winner) {
			moveHorses(horses, position, keyboard);
			winner = checkWinner(position);
		}
		int win = winningHorse(position);
		System.out.println(horses[win] + " WINS");
	}

	// Checks which horse wins
	private static boolean checkWinner(int[] position) {
		boolean win = false;
		for (int i = 0; i < position.length; i++) {
			if (position[i] == 25)
				win = true;
		}
		return win;

	}

	// Moves the horses in the race
	private static void moveHorses(String[] horses, int[] position, Scanner keyboard) {
		for (int i = 0; i < position.length; i++) {
			int j = (int) (Math.random() * 3);
			position[i] += j;
		}
	}

	// Display the horse track
	private static void track(String[] horses, int[] position, Scanner keyboard) {
		for (int i = 0; i < horses.length; i++) {
			System.out.println("--------------------------------------------------------------------");
			System.out.printf("%-1s |" + horses[i], " ");
		}
		System.out.println("-------------------------------------------------------------------- \n");
	}

	// Fixes betting array for adding new player
	private static int[] IntArray(String[] playerData, int[] horseBet) {
		int[] newBet = new int[playerData.length];
		for (int i = 0; i < playerData.length - 1; i++) {
			newBet[i] = 10;
		}
		newBet[playerData.length - 1] = 10;
		horseBet = newBet;
		return horseBet;
	}

	// Fixes betting array for adding new player
	private static double[] DoubleArray(String[] playerInfo, double[] bet) {
		double[] newBet = new double[playerInfo.length];
		for (int i = 0; i < playerInfo.length - 1; i++) {
			newBet[i] = bet[i];
		}
		newBet[playerInfo.length - 1] = 0;
		bet = newBet;
		return bet;
	}

	// Enables you to add in a new player
	private static String[] addPlayer(Scanner keyboard, String[] playerNames, double[] playerWallets,
			String[] playerData) {
		System.out.println("The current people in the game are: ");
		//TODO fix this
		displayPlayerNamesWallets(playerData, playerNames, playerWallets);
		System.out.println("Please enter your only your first name: ");
		String playerName = keyboard.next().trim();
		System.out.println("Please enter the amount of money you have: ");
		String wallet = keyboard.next().trim();
		String playersData = playerName + "," + wallet;
		//TODO why tho
		String[] newPlayerData = new String[playerData.length + 1];
		for (int i = 0; i < playerData.length; i++) {
			newPlayerData[i] = playerData[i];
		}
		newPlayerData[newPlayerData.length - 1] = playersData;
		playerData = newPlayerData;
		return playerData;
	}

	private static int startRace(int[] horsesInRace) {
		// TODO Auto-generated method stub
		return 0;
	}

	// Gets current players bets
	private static int[][] getPlayerBets(Scanner keyboard, String[] playerNames, double[] playerWallets,
			String[] horsePlay, double[] bet, int[] horseBet) {
		int racePlayers = horsePlay.length;
		boolean betting = true;
		int playerIndex = 0;
		while (betting) {

			playerIndex = getPlayersNames(keyboard, playerNames, playerIndex);
			if (playerWallets[playerIndex] != 0) {
				getBet(keyboard, playerNames, playerWallets, bet, playerIndex, horseBet, racePlayers);

			} else {
				System.out.println("You have no more money.");

			}
			System.out.println("Would another player want to place a bet:");
			String moneyAmount = keyboard.nextLine();

			while (!moneyAmount.equalsIgnoreCase("yes") && !moneyAmount.equalsIgnoreCase("no")) {
				System.out.println("Would another player want to place a bet? Please answer Yes or No:");
				moneyAmount = keyboard.nextLine();
			}
			if (moneyAmount.equalsIgnoreCase("no")) {
				betting = false;
			}

		}

	}

	// Get the horse and bet of the players
	private static void getBet(Scanner keyboard, String[] playerNames, double[] playerWallets, double[] bet,
			int playerIndex, int[] horseBet, int racePlayers) {

		getPlayerMoneybet(keyboard, playerNames, playerWallets, bet, playerIndex);
		getPlayerHorseBet(keyboard, playerNames, playerIndex, horseBet, racePlayers);
	}

	// Gets the horse that the player wants to bet on
	private static void getPlayerHorseBet(Scanner keyboard, String[] playerNames, int playerIndex, int[] horseBet,
			int racePlayers) {
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

	// Get the amount of money the player wants to bet
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

	private static void displayPlayerNamesWallets(String[] info, String[] names, double[] wallets) {
		// displays players and amount of money on a chart
		System.out.printf("%-1s %15s %-15s \n", "#", "Player Name", "Wallet");
		for (int i = 0; i < info.length; i++) {
			System.out.printf("%1d %15s %-15f \n", i + 1, names[i], wallets[i]);

		}
	}

	// Lets the player choose what to do
	private static int getChoice(Scanner keyboard) {
		System.out.println("Would you like to [1] Bet on horses [2] Add player [3] Save and Quit [4] Start Race");
		int choice = 0;
		while (choice != 1 && choice != 2 && choice != 3 && choice != 4) {
			System.out.println("Please enter a number:");
			String playing = keyboard.nextLine();

			try {
				choice = Integer.valueOf(playing);
			} catch (NumberFormatException e) {
				System.out.println("Please enter a number:");
				choice = -1;
			}
		}
		return choice;
	}

	// Gets the horses that are going to be racing at random
	private static String[] getHorsesInRace(String[] horses) {
		int x = (int) (Math.random() * (4) + 5);
		int numHorses = horses.length;
		String[] horsesPlaying = new String[x];
		int[] horseIndex = new int[x];
		boolean previousInt = false;

		for (int i = 0; i < x; i++) {
			int y = (int) (Math.random() * numHorses);
			previousInt = checkDuplicateHorses(y, horseIndex);
			while (previousInt) {
				y = (int) (Math.random() * numHorses - 1);
				previousInt = checkDuplicateHorses(y, horseIndex);
			}
			horseIndex[i] = y;
		}

		for (int i = 0; i < x; i++) {
			horsesPlaying[i] = horses[horseIndex[i]];
		}

		return horsesPlaying;
	}

	// Checks to see if there are any duplicate horses in the race
	private static boolean checkDuplicateHorses(int x, int[] y) {
		for (int num : y) {
			if (num == x) {
				return true;
			}
		}
		return false;
	}

	// Converts string array to a double array
	public static double[] makeStringDouble(String[] value) {
		double[] doubl = { 0.0 };
		for (int i = 0; i <= doubl.length; i++) {
			doubl[i] = Double.valueOf(value[i]);
		}

		return doubl;
	}

	// Displays the horses that are going to be racing
	private static void displayHorse(String[] arr) {
		System.out.println(" \nHorses in the race are... ");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(i + 1 + "." + arr[i]);
		}

	}

	private static int[] getPlayerWallets(String[] data) {
		String[] wallet = new String[data.length];
		for (int i = 0; i < data.length; i++) {
			int position = data[i].indexOf(',');
			wallet[i] = data[i].substring(position + 1);
		}
		int[] money = new int[data.length];
		for (int i = 0; i < money.length; i++) {
			money[i] = Integer.valueOf(wallet[i]);
		}

		return money;
	}

	// Chooses the player that is going to bet
	private static String[] choosePlayer() {
		int num = 0;
		while (num > playerNames.length || num < 1) {
			System.out.println("Enter the number of the player that would like to bet: ");
			String name = keyboard.nextLine();

			try {
				num = Integer.valueOf(name);
			} catch (NumberFormatException e) {
				System.out.println(" Please enter a number:");
				num = -1;
			}

		}
		playerIndex = num - 1;
		return playerIndex;
	}

	/*
	 * Reads the horses from a file assume the file exists and is in the format
	 * specified in the assignment.
	 */
	public static String[] getHorses() {
		String[] horses = null;
		try {
			Scanner scanner = new Scanner(new File("input/horses.dat"));
			int numHorses = Integer.parseInt(scanner.nextLine());
			horses = new String[numHorses];

			for (int i = 0; i < numHorses; i++) {
				horses[i] = scanner.nextLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return horses;
	}

	// Check if a horse is already in the race - uses a modified search method
	public static boolean alreadyInRace(int horse, int[] horsesInRace) {
		for (int i = 0; i < horsesInRace.length; i++) {
			if (horsesInRace[i] == horse) {
				return true;
			}
		}
		return false;
	}

	// Gets the players names if chosen
	private static String[] getPlayersNames(String[] data) {
		String[] names = null;
		try {
			Scanner scanner = new Scanner(new File("input/player.dat"));
			int numPlayers = Integer.parseInt(scanner.nextLine());
			names = new String[numPlayers];

			for (int i = 0; i < numPlayers; i++) {
				names[i] = scanner.nextLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return names;
	}

	private static void gameEnd(String[] playerData, String[] playerNames, double[] playerWallets) {
		System.out.println("Thank you for playing Horse Racing.");
		playerQuit(playerData, playerNames, playerWallets);
	}

	private static void playerQuit(String[] playerData, String[] playerNames, double[] playerWallets) {
		System.out.println("Thank you for playing Horse Racing. /nGoodbye!");
		playerQuit(playerData, playerNames, playerWallets);
	}
}
