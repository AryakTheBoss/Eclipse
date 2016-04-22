/**
 * 
 */
package cards;

import java.util.Collections;
import java.util.Stack;

/**
 * @author 17ap0497
 *
 */
public class Deck {

	private Stack<Card> deck;

	public Deck() {
		deck = new Stack<Card>();
		loadDeck();
		//System.out.println(deck);

	}

	public Stack<Card> getDeck() {

		return deck;

	}


	// Load the stack with 52 cards in order

	public void loadDeck() {
		for (int i = 1; i < 5; i++) {
			for (int j = 2; j < 15; j++) {
				deck.push(new Card(i, j));
			}
		}
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		int x = 0;
		for (Card c : deck) {
			//System.out.println(c);
			if (x == 4) {
				x = 0;
				s.append("\n");
			}
			s.append(c.toString()+"\t");
			x++;
		}
		return s.toString();
	}

	// Return and remove the top card

	public Card deal() {
		return deck.pop(); // :^)
	}

	// Take the top half of the deck (26 cards) and alternate card by card with

	// the bottom half

	public void bridgeShuffle() {
		int r = 26;
		Stack<Card> new1 = new Stack<Card>();
		Stack<Card> alpha = new Stack<Card>();
		while (r > 0) {
			
			new1.push(deck.pop());
			r--;
		}
		for(int i=52;i>0;i--){
			if(i % 2 == 0)
				alpha.push(deck.pop());
			else
				alpha.push(new1.pop());
			
		}
		deck = alpha;
		
	}

	// split the deck at a random spot. Put the stack of cards above the random

	// spot below the other cards
	// TODO f
	public void cut() {
		int r = 1 + (int) (Math.random() * 52);
		Stack<Card> new1 = new Stack<Card>();
		Stack<Card> alpha = new Stack<Card>();

		while (r > 0) {
			new1.push(deck.pop());
			r--;
		}

		for (Card c : new1)
			alpha.push(c);
		Collections.reverse(alpha);
		for (Card c : deck)
			alpha.push(c);

		deck = alpha;

	}

	// complete a bridge shuffle and then cut the deck. Repeat 7 times

	public void completeShuffle() {
		// it's the industry standard
		for(int i=0;i<7;i++){
			bridgeShuffle();
			cut();
		}
	}

}
