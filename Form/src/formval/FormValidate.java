/**
 * 
 */
package formval;

import javax.swing.JOptionPane;

/**
 * @author Aryak
 *
 */
public class FormValidate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		FormObject oi = new FormObject("Welcome!");
		
		oi.InitializeFields();
		
		int a=JOptionPane.showConfirmDialog(null,oi.main,"Attention!",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);

		
		
	}

}
