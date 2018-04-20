/**
 * 
 */
package rng;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

/**
 * @author parya
 *
 */
public class DropCalculator {

	/**
	 * @param args
	 */
	public static RNG r = new RNG();
	public static int val;
	public static int val2;
	public static Drops[] memes;
	public static int leg=0,epi=0,rar=0,com=0;
	public static boolean useDefault = false;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		setLookAndFeel();
		JPanel pl=new JPanel();  
		 
		   
		 pl.setLayout(new GridLayout(4,1));  
		  
		  
		 JLabel reps=new JLabel("# of Tests");   
		  
		 
		 JLabel legL=new JLabel("LGNDRY Threshold:");  
		 JLabel epiL=new JLabel("Epic Threshold:"); 
		 JLabel rarL=new JLabel("Rare Threshold:"); 
		 
		 JTextField legT=new JTextField();  
		 JTextField epiT=new JTextField();
		 JTextField rarT=new JTextField();
		 JTextField repsT=new JTextField();
		  
		 pl.add(reps);	 
		 pl.add(repsT);		  
		 pl.add(rarL);	
		 pl.add(rarT);
		 pl.add(epiL);		
		 pl.add(epiT); 
		 pl.add(legL); 		
		 pl.add(legT); 
		 for(;;) {
		 int c = JOptionPane.showConfirmDialog(null,pl,"Pick Parameters (CLICK CANCEL TO USE DEFAULT VALUES)",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
		 if(c==JOptionPane.CANCEL_OPTION) {
			 useDefault = true;
			 break;
		 }
		 try {
			 Integer.parseInt(repsT.getText());
			 Integer.parseInt(rarT.getText());
			 Integer.parseInt(epiT.getText());
			 Integer.parseInt(legT.getText());
		 }catch(NumberFormatException e) {
			 JOptionPane.showMessageDialog(null, "That\'s not a Fucking Number", "Dumbass", JOptionPane.ERROR_MESSAGE);
			 continue;
		 }
		 break;
		 }
		//use r.getCurrentRNG() for the current rng lol
		if(!useDefault) {
			memes=new Drops[Integer.parseInt(repsT.getText())];
		for(int i=0;i<Integer.parseInt(repsT.getText());i++) {
			memes[i] = doDropTest(Integer.parseInt(rarT.getText()),Integer.parseInt(legT.getText()),Integer.parseInt(epiT.getText()));			
		}
		}else {
			memes=new Drops[1000];
			for(int i=0;i<1000;i++) {
				memes[i] = doDropTest(0,0,0);			
			}
		}
		for(int i=0;i<memes.length;i++) {
			if(memes[i].equals(Drops.LEGENDARY)) {
				leg++;
			}else if(memes[i].equals(Drops.EPIC)) {
				epi++;
			}else if(memes[i].equals(Drops.RARE)) {
				rar++;
			}else if(memes[i].equals(Drops.COMMON)) {
				com++;
			}
		}
		
		JOptionPane.showMessageDialog(null, "COMMON: "+com+"\nRARE: "+rar+"\nEPIC: "+epi+"\nLEGENDARY: "+leg, "Test Complete...", JOptionPane.INFORMATION_MESSAGE);
		
		

		
		System.exit(0); //ALWAYS since the RNG thread is an infinte loop lol

	}
	
	public static Drops doDropTest(int RT,int LT,int ET) throws InterruptedException {
		
		
		val = r.getCurrentRNG(); // MAX 32767
		val2 = r.getCurrentRNG();
		
		if(useDefault) {
			
		if(Math.abs(val-val2) < 550) {
			return Drops.LEGENDARY;
		}else if(Math.abs(val-val2) < 3500) {
			return Drops.EPIC;
		}else if(Math.abs(val-val2) < 5200) {
			return Drops.RARE;
		}else{
			return Drops.COMMON;
		}
		
		}else {
			
			if(Math.abs(val-val2) < LT) {
				return Drops.LEGENDARY;
			}else if(Math.abs(val-val2) < ET) {
				return Drops.EPIC;
			}else if(Math.abs(val-val2) < RT) {
				return Drops.RARE;
			}else{
				return Drops.COMMON;
			}
			
		}
		
		
		
	}
	public static void setLookAndFeel(){
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, you can set the GUI to another look and feel.
			throw new NullPointerException("Fuck You");
		}

	}

}
