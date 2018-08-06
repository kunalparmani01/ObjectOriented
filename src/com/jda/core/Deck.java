package com.jda.core;

import java.util.Random;

public class Deck {
	
	protected String[] suits = { "Clubs", "Diamonds", "Hearts", "Spades" };
	protected String[] num = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };

	public static void main(String[] args) {
		String[][] str = new Deck().generatecards();
		for (int i = 0; i < 4; i++) {
			System.out.print("Player " + i + "-");
			for (int j = 0; j < 9; j++)
				System.out.print("[" + str[i][j] + "] ");
			System.out.println();
		}

	}

	public String[][] generatecards() {
		String[][] cards = new String[4][9];
		int[][] track = new int[4][13];

		Random random = new Random();
		for (int x = 0; x < 4; x++) {
			for (int y = 0; y < 9; y++) {
				while (cards[x][y] == null) {
					int i = random.nextInt(100000) % 4;
					int j = random.nextInt(100000) % 13;
					if (track[i][j] != 500) {
						track[i][j] = 500;
						cards[x][y] = suits[i] + "-" + num[j];
					}
				}
			}
		}
		return cards;
	}

}
