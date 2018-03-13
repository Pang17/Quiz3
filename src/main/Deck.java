package main;
import java.util.ArrayList;
import java.util.Collections;

import eNum.*;

public class Deck {
	private ArrayList<Card> deck = new ArrayList<Card>();
	
	public Deck(int nDecks) {
		while (nDecks > 0) {
			for (eSuit s : eSuit.values()) {
				for (eRank r : eRank.values()) {
					Card c = new Card(r,s);
					deck.add(c);
				}
			}
			nDecks--;
		}
		Collections.shuffle(deck);
	}
	
	public Card draw() throws Exception {
		if (deck.size() == 0)
			throw new Exception("Empty Deck");
		Card c = deck.get(0);
		deck.remove(0);
		return c;
	}
	
	public ArrayList<Card> getDeck() {
		return deck;
	}
	
	public int getRemaining(Object o) {
		int count = 0;
		if (o instanceof eRank) {
			for (Card c : deck) {
				if ((eRank)o == c.geteRank())
					count++;
			}
		} else {
			for (Card c : deck) {
				if ((eSuit)o == c.geteSuit())
					count++;
			}
		}
		return count;
	}
	
}

