/**
 * 
 */
package shit;

/**
 * @author 17ap0497
 *
 */
public class WrestelrTEST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub

		TeamMap a=new TeamMap();

		a.add(new Wrestler("Bob",157));

		a.add(new Wrestler("Fred",129));

		a.add(new Wrestler("Jake",100));

		a.add(new Wrestler("Arnold",199));

		a.add(new Wrestler("Stan",120));

		Wrestler juan = new Wrestler("Juan",180);

		a.add(juan);

		System.out.println(a);

		a.changeWeightGroup(juan,10);

		System.out.println("Juan is in Weight Group " +a.get(juan));

		System.out.println();

		System.out.println(a);

	}

}
