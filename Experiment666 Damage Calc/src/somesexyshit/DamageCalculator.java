/**
 * 
 */
package somesexyshit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.DocumentFilter;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.Format;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
/**
 * @author parya
 *Level 1 Wizard (gains a lot from levelling up)
Level 1 Bandit
HP: 30
ATK: 40
DEF: 25
INV: 50
SP ATK: 20
MVMT: 9
LUCK: 25





 *
 */
public class DamageCalculator {
	
	public static final int[] soldierBS = {60,40,70,35,10,3,8}; //UPDATED
	public static final int[] bruiserBS = {25,60,30,30,20,10,10};
	public static final int[] doctorBS = {35,28,35,38,25,6,12};
	public static final int[] wizardBS = {20,15,15,10,30,5,5}; //UPDATED
	public static final int[] banditBS = {30,40,35,50,20,9,25};//UPDATED
	public static final int HP=0,ATK=1,DEF=2,INV=3,SPATK=4,MVMT=5,LUCK=6;
	public static int rawPlayerHealth=0;
	public static int displayPlayerHealth=0;
	public static int rawEnemyHealth=0;
//	public static int displayEnemyHealth=0;
	public static JProgressBar playerHealth;
	public static JProgressBar enemyHealth;
	public static JComboBox<Integer> level;
	public static JComboBox<String> userClass;
	public static JLabel H = new JLabel();
	public static JLabel EH = new JLabel();
	public static JFormattedTextField enemyHP,enemyATK,enemySPATK,enemyDEF;
	public static int[] currentScaledStat = new int[7];
	public static int[] enemyStats = new int[7];
	
	public static void levelScaleStats(String classType, int level) {
		
		if(classType.equals("Soldier")) {
			
			for(int i=0;i<soldierBS.length;i++) {
				currentScaledStat[i] = (int) (Math.ceil(soldierBS[i]*Math.pow(1.10, level-1)));
			}
			
		}else if(classType.equals("Bruiser")) {
			for(int i=0;i<soldierBS.length;i++) {
				currentScaledStat[i] = (int) (Math.ceil(bruiserBS[i]*Math.pow(1.10, level-1)));
			}
		}else if(classType.equals("Wizard")) {
			for(int i=0;i<soldierBS.length;i++) {
				currentScaledStat[i] = (int) (Math.ceil(wizardBS[i]*Math.pow(1.15, level-1)));
			}
		}else if(classType.equals("Doctor")) {
			for(int i=0;i<soldierBS.length;i++) {
				currentScaledStat[i] = (int) (Math.ceil(doctorBS[i]*Math.pow(1.10, level-1)));
			}
		}else if(classType.equals("Bandit")) {
			for(int i=0;i<soldierBS.length;i++) {
				currentScaledStat[i] = (int) (Math.ceil(banditBS[i]*Math.pow(1.10, level-1)));
			}
		}
		applyPlayerHealth();
		
	}
	public static int calculateAttackDamage(int weaponDamage) {
		
		return rawPlayerHealth;
		
	}
	public static int calculateSpAttackDamage(int[] user, int[] enemy, int attackPower,int level) {
		
		return 0;
		
	}
	public static void updatePlayerHealth() {		
		displayPlayerHealth = rawPlayerHealth/5;		
		playerHealth.setValue(displayPlayerHealth);		
		H.setText("HP: "+displayPlayerHealth+"/"+playerHealth.getMaximum());
	}
	public static void applyPlayerHealth() {
		rawPlayerHealth = currentScaledStat[HP]*25;
		displayPlayerHealth = rawPlayerHealth/5;
	
		playerHealth.setMaximum(displayPlayerHealth);
		playerHealth.setValue(displayPlayerHealth);
		H.setText("HP: "+displayPlayerHealth+"/"+playerHealth.getMaximum());
		
		//System.out.println(playerHealth.getValue());
	}
	public static void updateEnemyHealth() {
		//rawEnemyHealth will be the value typed into the jtextfield marked "HP"
		
		
	
		enemyHealth.setMaximum(rawEnemyHealth);
		enemyHealth.setValue(rawEnemyHealth);
		EH.setText("HP: "+rawEnemyHealth+"/"+enemyHealth.getMaximum());
		
	}
	
	public static void doDamageTo(boolean enemy,int[] user,int[] reciever,int weaponDamage,int level) {
		//TODO
	}
	public static void doSpecialDamageTo(boolean enemy,int[] user,int[] reciever,int weaponDamage,int level) {
		if(enemy) {
			rawEnemyHealth -= calculateSpAttackDamage(user,reciever,weaponDamage,level);
		}else{
			rawPlayerHealth -= calculateSpAttackDamage(user,reciever,weaponDamage,level);
		}
	}
	
	public static void main(String[] args) {
		
		/*String[] options = {"User VS Enemy", "Enemy VS User"};
		int choice = JOptionPane.showOptionDialog(null, "What type of Damage?",
                "Click a button",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
		*/
		
		
		setLookAndFeel();
		level = new JComboBox<Integer>();
		playerHealth = new JProgressBar();
		enemyHealth = new JProgressBar();
		playerHealth.setSize(200, 80);
		JFrame main = new JFrame("Damage Calculator");
		main.setSize(300, 250);
		JPanel leftPanel = new JPanel();
	//	JPanel rightPanel = new JPanel();
		leftPanel.setSize(270, 250);
	//	rightPanel.setSize(270, 250);
		
	
		JTextField weaponAttack = new JTextField("Power");
		
		JButton pAttackButton = new JButton("Attack");
		JButton eAttackButton = new JButton("Attack");
		playerHealth.setMaximum(displayPlayerHealth);
		//enemyHealth.setMaximum(displayEnemyHealth);
		//playerHealth.setValue(displayPlayerHealth);
		//enemyHealth.setValue(displayEnemyHealth);
		NumberFormat integerFieldFormatter = NumberFormat.getIntegerInstance();
		enemyHP = new JFormattedTextField(integerFieldFormatter);
		enemyATK = new JFormattedTextField(integerFieldFormatter);
		enemySPATK = new JFormattedTextField(integerFieldFormatter);
		enemyDEF = new JFormattedTextField(integerFieldFormatter);
		enemyHP.setPreferredSize(new Dimension(50,25));
		
		for(int i=1;i<=25;i++) {
			level.addItem(i);
		}
		userClass = new JComboBox<String>();
		userClass.addItem("Soldier");
		userClass.addItem("Bruiser");
		userClass.addItem("Doctor");
		userClass.addItem("Wizard");
		userClass.addItem("Bandit");
		JCheckBox spatk = new JCheckBox("is a Speical Attack?");
		JLabel j = new JLabel("Level: ");
		JLabel jj = new JLabel("Class: ");
		leftPanel.add(j);
		leftPanel.add(level,JPanel.TOP_ALIGNMENT);
		leftPanel.add(jj);
		leftPanel.add(userClass);
		leftPanel.add(weaponAttack);
		leftPanel.add(playerHealth,JPanel.BOTTOM_ALIGNMENT);
		leftPanel.add(H);
		leftPanel.add(spatk);
		leftPanel.add(pAttackButton);
		leftPanel.add(new JLabel("------------------------ENEMY------------------------"));
		leftPanel.add(new JLabel("HP"));
		leftPanel.add(enemyHP);
		//leftPanel.add(new JLabel(""));
		//rightPanel.add(enemyATK);
		
		main.add(leftPanel);
		//main.add(rightPanel);
		
		levelScaleStats("Soldier", 1);
		
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    applyPlayerHealth();
		main.setVisible(true);
		userClass.addItemListener(new TheHandler());
		level.addItemListener(new TheHandler2());
		
		
		/*JOptionPane.showMessageDialog(null, "Stop Typing Letters Bitch!", "Dumbass", JOptionPane.ERROR_MESSAGE);
				enemyHP.setText("");*/
		pAttackButton.addActionListener(new ActionListener() { 
			 
			

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("FART IN MY FACE");
			} 
			} );
eAttackButton.addActionListener(new ActionListener() { 
			 
			

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("FART IN MY FACE TWICE");
			} 
			} );
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
class TheHandler implements ItemListener{
	@Override
    public void itemStateChanged(ItemEvent event) {

        if(event.getStateChange() == ItemEvent.SELECTED) {
            Object source = event.getSource();
            if (source instanceof JComboBox) {
                JComboBox cb = (JComboBox)source;
                Object selectedItem = cb.getSelectedItem();
               // DamageCalculator.applyPlayerHealthStat((String)selectedItem, (Integer)DamageCalculator.level.getSelectedItem());
               DamageCalculator.levelScaleStats((String)selectedItem, (Integer)DamageCalculator.level.getSelectedItem());
               
            }
        }   
    }

	
}
class TheHandler2 implements ItemListener{
	@Override
    public void itemStateChanged(ItemEvent event) {

        if(event.getStateChange() == ItemEvent.SELECTED) {
            Object source = event.getSource();
            if (source instanceof JComboBox) {
                JComboBox cb = (JComboBox)source;
                Object selectedItem = cb.getSelectedItem();
               // DamageCalculator.applyPlayerHealthStat((String)selectedItem, (Integer)DamageCalculator.level.getSelectedItem());
               DamageCalculator.levelScaleStats((String)DamageCalculator.userClass.getSelectedItem(), (Integer)selectedItem);
               
            }
        }   
    }

	
}
