/**
 * 
 */
package cards;

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
		
	}

	public String toString() {} 

	// Return and remove the top card 

	public Card deal() {} 

	// Take the top half of the deck (26 cards) and alternate card by card with 

	// the bottom half 

	public void bridgeShuffle() {} 

	// split the deck at a random spot. Put the stack of cards above the random 

	// spot below the other cards 

	public void cut() {} 

	// complete a bridge shuffle and then cut the deck. Repeat 7 times 

	public void completeShuffle() {}
}
