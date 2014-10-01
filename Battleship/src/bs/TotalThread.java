/**
 * 
 */
package bs;

/**
 * @author UnityBoss
 *
 */
public class TotalThread implements Runnable{

	private static int cos=0;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for(;;){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			Battleship.totl.setText("Total Cost: $"+Integer.toString(cos*(Battleship.amt.getSelectedIndex()+1)));
			
			
			
					
				
			}
		
		
	}

	public static void start(){new Thread(new TotalThread()).start();}
	public static void updateItemCost(int cost){cos = cost;}
	public static int getCost(){return cos*(Battleship.amt.getSelectedIndex()+1);}
	
}
