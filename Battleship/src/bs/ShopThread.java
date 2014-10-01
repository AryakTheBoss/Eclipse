/**
 * 
 */
package bs;



/**
 * @author UnityBoss
 *
 */
public class ShopThread implements Runnable{

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
			if(Battleship.shopB.getModel().isPressed() == true){
				
				try {
					Battleship.openShop();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
				
			}
			
			
			
			
		}
		
		
		
		
	}
	
	public static void start(){new Thread(new ShopThread()).start();}
	
	

}
