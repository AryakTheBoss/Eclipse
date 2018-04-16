/**
 * 
 */
package rng;

/**
 * @author parya
 *
 */
public class DropCalculator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RNG r = new RNG();
		
		//use r.getCurrentRNG() for the current rng lol
		
		System.out.println(r.getCurrentRNG());
		System.out.println(r.getCurrentRNG());
		System.out.println(r.getCurrentRNG());
		System.out.println(r.getCurrentRNG());
		System.out.println(r.getCurrentRNG());
		System.out.println(r.getCurrentRNG());
		System.out.println(r.getCurrentRNG());
		System.out.println(r.getCurrentRNG());
		System.out.println(r.getCurrentRNG());

		
		System.exit(0); //ALWAYS since the RNG thread is an infinte loop lol

	}

}
