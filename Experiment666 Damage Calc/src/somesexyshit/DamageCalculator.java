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

import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
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
	
	public static final int[] soldierBS = {60,40,70,35,10,3,8}; 
	public static final int[] bruiserBS = {25,48,30,30,20,10,10};
	public static final int[] doctorBS = {35,28,35,38,25,6,12};
	public static final int[] wizardBS = {30,20,15,10,30,5,5};
	public static final int[] banditBS = {30,40,25,50,20,9,25};
	public static final int HP=0,ATK=1,DEF=2,INV=3,SPATK=4,MVMT=5,LUCK=6;
	public static int rawPlayerHealth=0;
	public static int displayPlayerHealth=0;
	public static int rawEnemyHealth=0;
	public static int displayEnemyHealth=0;
	public static JProgressBar playerHealth;
	public static JProgressBar enemyHealth;
	public static JComboBox<Integer> level;
	public static JLabel H = new JLabel();
	
	
	public static int calculateAttackDamage(int[] user, int[] receiver, int weaponDamage,int level) {
		
		if(Arrays.equals(user, soldierBS) && level != 0)
			return ((user[ATK]*Math.round((float)Math.pow(1.10, level-1)))*3*weaponDamage)/receiver[DEF];
		else if(Arrays.equals(user, wizardBS) && level != 0)
			return ((user[ATK]*Math.round((float)Math.pow(1.20, level-1)))*3*weaponDamage)/receiver[DEF];
		else
			return ((user[ATK]*Math.round((float)Math.pow(1.15, level-1)))*3*weaponDamage)/receiver[DEF];
		
	}
	public static int calculateSpAttackDamage(int[] user, int[] receiver, int attackPower,int level) {
		
		if(Arrays.equals(user, soldierBS) && level != 0)
			return ((user[SPATK]*Math.round((float)Math.pow(1.10, level-1)))*3*attackPower)/receiver[DEF];
		else if(Arrays.equals(user, wizardBS) && level != 0)
			return ((user[SPATK]*Math.round((float)Math.pow(1.20, level-1)))*3*attackPower)/receiver[DEF];
		else
			return ((user[SPATK]*Math.round((float)Math.pow(1.15, level-1)))*3*attackPower)/receiver[DEF];
		
	}
	public static void applyPlayerHealthStat(String classType, int level) {
		System.out.println(classType);
		if(classType.equals("Soldier")) {
			rawPlayerHealth = soldierBS[HP]*Math.round((float)Math.pow(1.10, level-1))*25;
			
		}else if(classType.equals("Bruiser")) {
			rawPlayerHealth = bruiserBS[HP]*Math.round((float)Math.pow(1.15, level-1))*25;
		}else if(classType.equals("Wizard")) {
			rawPlayerHealth = wizardBS[HP]*Math.round((float)Math.pow(1.20, level-1))*25;
		}else if(classType.equals("Doctor")) {
			rawPlayerHealth = doctorBS[HP]*Math.round((float)Math.pow(1.15, level-1))*25;
		}else if(classType.equals("Bandit")) {
			rawPlayerHealth = banditBS[HP]*Math.round((float)Math.pow(1.15, level-1))*25;
		}
		displayPlayerHealth = rawPlayerHealth/5;
		System.out.println(displayPlayerHealth);
		playerHealth.setMaximum(displayPlayerHealth);
		playerHealth.setValue(displayPlayerHealth);
		H.setText("HP: "+displayPlayerHealth+"/"+playerHealth.getMaximum());
		
		System.out.println(playerHealth.getValue());
	}
	public static void doDamageTo(boolean enemy,int[] user,int[] reciever,int weaponDamage,int level) {
		if(enemy) {
			rawEnemyHealth -= calculateAttackDamage(user,reciever,weaponDamage,level);
		}else {
			rawPlayerHealth -= calculateAttackDamage(user,reciever,weaponDamage,level);
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
		main.setSize(1000, 500);
		JPanel leftPanel = new JPanel();
		JPanel rightPanel = new JPanel();
		leftPanel.setSize(250, 500);
		rightPanel.setSize(450, 500);
		//JLabel comboLabel = new JLabel("Player Level");
	
		JTextField weaponAttack = new JTextField("Weapon Attack");
		JButton pAttackButton = new JButton("Attack");
		JButton eAttackButton = new JButton("Attack");
		playerHealth.setMaximum(displayPlayerHealth);
		enemyHealth.setMaximum(displayEnemyHealth);
		//playerHealth.setValue(displayPlayerHealth);
		//enemyHealth.setValue(displayEnemyHealth);
		
		
		for(int i=1;i<=25;i++) {
			level.addItem(i);
		}
		JComboBox<String> userClass = new JComboBox<String>();
		userClass.addItem("Soldier");
		userClass.addItem("Bruiser");
		userClass.addItem("Doctor");
		userClass.addItem("Wizard");
		userClass.addItem("Bandit");
		JCheckBox spatk = new JCheckBox("is a Speical Attack?");
		JLabel j = new JLabel("Player");
		leftPanel.add(j);
		leftPanel.add(level,JPanel.TOP_ALIGNMENT);
		leftPanel.add(userClass);
		leftPanel.add(weaponAttack);
		leftPanel.add(playerHealth,JPanel.BOTTOM_ALIGNMENT);
		leftPanel.add(H);
		leftPanel.add(spatk);
		leftPanel.add(pAttackButton);
		//TODO Label This panel as Player HAHAHHAHAHAHAHA
		main.add(leftPanel);
		
		
		
		main.add(rightPanel);
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    applyPlayerHealthStat("Soldier", 1);
		main.setVisible(true);
		userClass.addItemListener(new TheHandler());
		pAttackButton.addActionListener(new ActionListener() { 
			 
			

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("FART IN MY FACE");
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
                DamageCalculator.applyPlayerHealthStat((String)selectedItem, (Integer)DamageCalculator.level.getSelectedItem());
               
            }
        }   
    }

	
}
