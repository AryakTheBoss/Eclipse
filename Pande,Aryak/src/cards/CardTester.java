/**
 * 
 */
package cards;

/**
 * @author 17ap0497
 *
 */
public class CardTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("test");
		Deck d = new Deck();
		System.out.println(d);
		System.out.println("**********CUT**********");
		d.cut();
		System.out.println(d);
		System.out.println("**********BridgeShuffle**********");
		d.bridgeShuffle();
		System.out.println(d);
		System.out.println("**********CompleteShuffle**********");
		d.completeShuffle();
		System.out.println(d);
		System.out.println("Dealing..................");
		System.out.print(d.deal()+" ");
		System.out.print(d.deal()+" ");
		System.out.print(d.deal()+" ");
		System.out.print(d.deal()+" ");
		System.out.print(d.deal());

	}

}
