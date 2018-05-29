/**
 * 
 */
package main;

/**
 * @author parya
 *
 */
public class TestSomeShit {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(levelStat(3,60));
	}
	public static double levelStat(int level,int baseStat) {
		
		return Math.ceil(baseStat*Math.pow(1.10, level-1)); 
		
		
	}

}
