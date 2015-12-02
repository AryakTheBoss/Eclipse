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

	} 

	public Stack<Card> getDeck() { 

	return deck; 

	} 

	// Load the stack with 52 cards in order 

	public void loadDeck(){
		for(int i=1;i<5;i++){
			for(int j=2;j<15;j++){
				deck.push(new Card(i,j));
			}
		}
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		int x = 0;
		for(Card c : deck){
			if(x == 4){
				x = 0;
				s.append("\n");
			}
			s.append(c);
		}
		return s.toString();
	} 

	// Return and remove the top card 

	public Card deal() {
		return deck.pop(); // :^)
	}
	

	// Take the top half of the deck (26 cards) and alternate card by card with 

	// the bottom half 

	public void bridgeShuffle() {} 

	// split the deck at a random spot. Put the stack of cards above the random 

	// spot below the other cards 
//TODO f
	public void cut() {
		int r = 1 + (int)(Math.random()*52); 
		Stack<Card> rekt = new Stack<Card>();
		while(r>0){
			
		}
	} 

	// complete a bridge shuffle and then cut the deck. Repeat 7 times 

	public void completeShuffle() {}
}
