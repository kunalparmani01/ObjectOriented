package com.jda.core;

import com.jda.util.Queue;

public class CardMain {
	public static Deck newDeck = new Deck();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] Dec = newDeck.generatecards();
		for(int i=0; i<4; i++) {
			arrange(Dec[i]);
			System.out.print("Player " + i + " Cards Be ");
			for(int j=0; j<9; j++)
				System.out.print(Dec[i][j] + ",");
			System.out.println();
		}

	}
	public static String[] arrange(String[] deck){
		int[][] fill = new int[4][13];
		for(int i=0; i<deck.length; i++) {
			String[] temp = deck[i].split("-");
			for(int j=0; j<4; j++) {
				if(temp[0].equals(newDeck.suits[j])) {
					for(int k=0; k<13; k++) {
						if(temp[1].equals(newDeck.num[k])) {
							fill[j][k] = 500;
						}
					}
				}
			}
		}
		int count = 0;
		for(int i=0; i<4; i++)
			for(int j=0; j<13; j++) {
				if(fill[i][j] == 500) {
					deck[count] = newDeck.suits[i] + "-" + newDeck.num[j];
					count++;
				}
			}
		return deck;
	}
	public static Queue<String> QueueCards(String[] cards) {
		Queue<String> cardsQ = new Queue<>();
		for(String s : cards) {
			cardsQ.nqueue(s);
		}
		return cardsQ;
	}



}
