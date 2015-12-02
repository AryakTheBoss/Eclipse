/**
 * 
 */
package cards;

/**
 * @author 17ap0497
 *
 */
public class Card implements Comparable<Card>{
	
	private int suit;
	private int value;
	
	public Card(){
		value = 3;
		suit = 1;
	}
	public Card(int suit,int value){
		
		this.suit = suit;
		this.value = value;
		
	}

	public int getRawSuit() {
		return suit;
	}//CDHS
	public String getSuit(){	
		
		if(this.suit == 1)
			return "Clubs";
		else if(this.suit == 2)
			return "Diamonds";
		else if(this.suit == 3)
			return "Hearts";
		else if(this.suit == 4)
			return "Spades";
		else
			throw new IllegalStateException("Unknown Suit");
	}
	public void setSuit(int suit) {
		this.suit = suit;
	}
	public String getValue() {
		
		if(this.value > 1 && this.value < 11){
			return this.value+"";
		}else if(this.value == 11){
			return "J";
		}else if(this.value == 12){
			return "Q";
		}else if(this.value == 13){
			return "K";
		}else if(this.value == 14){
			return "A";
		}else{
			throw new IllegalStateException("Unknown Value");
		}
		
	}
	public int getRawValue(){
		return this.value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	@Override
	public int compareTo(Card arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	public String toString(){
		
		return getValue() + " of " + getSuit();
		
	}

}
