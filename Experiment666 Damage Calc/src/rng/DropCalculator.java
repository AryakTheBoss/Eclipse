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
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
	
		
		//use r.getCurrentRNG() for the current rng lol
		
		
		

		
		System.exit(0); //ALWAYS since the RNG thread is an infinte loop lol

	}
	
	public Drops doDropTest() throws InterruptedException {
		
		RNG r = new RNG();
		int val = r.getCurrentRNG(); // MAX 32767
		
		if(val > 0 && val < 800) {
			return Drops.LEGENDARY;
		}
		
		
		
	}

}
