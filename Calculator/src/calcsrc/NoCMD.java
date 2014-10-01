/**
 * 
 */
package calcsrc;
import javax.swing.JOptionPane;
/**
 * @author Aryak
 *
 */
public class NoCMD {

	/**
	 * @param args
	 */
	public static String ans;
	public static String vals;
	public static String vals2;
	public static boolean deci;
	public static boolean deci2;
	public static boolean deci3;
	public static int vali,val2i,ansi;
	public static double val,val2;
	public static double Answer;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		intro();
		
		
	}
		public static void Prog(){
		
		
		
		String i,i2,op;
		
		
		
		 JOptionPane pane = new JOptionPane();
		
		 String exit = "stop";
		
		i = JOptionPane.showInputDialog("Please Enter a Number (Decimals work)[You can Get a Chance Next Window that opens in which you can stop this loop]");
		
		op = JOptionPane.showInputDialog("Please Enter an Operator [You Can Also Type in the word stop to terminate this app]");
		
		if(op.contains(exit)){
			   
			   
			   
			   JOptionPane.showMessageDialog(null,"Bye!");
			   
			   System.exit(0);
		   }
		
		i2 = JOptionPane.showInputDialog("Please Enter another value (again Decimals work)");
		
		
		
	   val = Double.parseDouble( i );
	   
	   val2 = Double.parseDouble( i2 );
	   
	   
	   if(op.contains("*")){
		   
		   Answer = (val*val2) ;
		   
		    ans = String.valueOf(Answer);
		    vals = String.valueOf(val);
		    vals2 = String.valueOf(val2);
		   
		   deci = ans.contains(".0");
		    deci2 = vals.contains(".0");
		    deci3 = vals2.contains(".0");
		   
		   if (deci == true){
			   
			   ansi = (int)Answer;
			   
		   }
		   
if (deci2 == true){
			   
			   vali = (int)val;
			   
		   }
		   
if (deci3 == true){
	   
	   val2i = (int)val2;
	   
}
else{
		   notnec();
	   }
	   }
if(op.contains("+")){
		   
		   Answer = val+val2;
		   
		   ans = String.valueOf(Answer);
		    vals = String.valueOf(val);
		    vals2 = String.valueOf(val2);
		   
		   deci = ans.contains(".0");
		    deci2 = vals.contains(".0");
		    deci3 = vals2.contains(".0");
		   
		   if (deci == true){
			   
			   Answer = (int)Answer;
			   
		   }
		   
if (deci2 == true){
			   
			   val = (int)val;
			   
		   }
		   
if (deci3 == true){
	   
	   val2 = (int)val2;
	   
}

		   
		   JOptionPane.showMessageDialog(pane, val + " + " + val2 + " = " + Answer);
		   
		   alt();
	   }
		
if(op.contains("-")){
	   
	   Answer = val-val2;
	   
	   ans = String.valueOf(Answer);
	    vals = String.valueOf(val);
	    vals2 = String.valueOf(val2);
	   
	   deci = ans.contains(".0");
	    deci2 = vals.contains(".0");
	    deci3 = vals2.contains(".0");
	   
	   if (deci == true){
		   
		   Answer = (int)Answer;
		   
	   }
	   
if (deci2 == true){
		   
		   val = (int)val;
		   
	   }
	   
if (deci3 == true){
  
  val2 = (int)val2;
  
}

	   
	   JOptionPane.showMessageDialog(pane, val + " - " + val2 + " = " + Answer);
	   
	   alt();
}
		
if(op.contains("/")){
	   
	   Answer = val/val2;
	   
	   ans = String.valueOf(Answer);
	    vals = String.valueOf(val);
	    vals2 = String.valueOf(val2);
	   
	   deci = ans.contains(".0");
	    deci2 = vals.contains(".0");
	    deci3 = vals2.contains(".0");
	   
	   if (deci == true){
		   
		   Answer = (int)Answer;
		   
	   }
	   
if (deci2 == true){
		   
		   val = (int)val;
		   
	   }
	   
if (deci3 == true){
  
  val2 = (int)val2;
  
}

	   
	   JOptionPane.showMessageDialog(pane, val + " / " + val2 + " = " + Answer);
	   alt();
	   
}

if(op.contains("%")){
	   
	   Answer = val%val2;
	   
	   ans = String.valueOf(Answer);
	    vals = String.valueOf(val);
	    vals2 = String.valueOf(val2);
	   
	   deci = ans.contains(".0");
	    deci2 = vals.contains(".0");
	    deci3 = vals2.contains(".0");
	   
	   if (deci == true){
		   
		   Answer = (int)Answer;
		   
	   }
	   
if (deci2 == true){
		   
		   val = (int)val;
		   
	   }
	   
if (deci3 == true){
  
  val2 = (int)val2;
  
}

	   
	   JOptionPane.showMessageDialog(pane, val + " % " + val2 + " = " + Answer);
	   alt();
	   
}

	}

	public static void intro(){
	
	JOptionPane.showMessageDialog(null, "Welcome! You dont need CMD For this Calculator!");
	Prog();
	}
	
	public static void alt(){
		
		
		Prog();
		}
	public static void notnec(){
		
		JOptionPane.showMessageDialog(null, val + " * " + val2 + " = " + Answer);
		   
		   alt();
	}
	public static void nec(){
		
		JOptionPane.showMessageDialog(null, vali + " * " + val2i + " = " + ansi);
		   
		   alt();
		
	}
}
