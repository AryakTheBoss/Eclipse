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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
	public static JFormattedTextField enemyHP,enemyATK,enemySPATK,enemyDEF,enemyATKPW;
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
		
		if(!enemyDEF.getText().isEmpty())
		return (currentScaledStat[ATK]*3*weaponDamage)/Integer.parseInt(enemyDEF.getText());
		else
			return -1;
		
	}
	public static int calculateEnemyAttackDamage(int weaponDamage) {
		
		if(!enemyDEF.getText().isEmpty() && !enemyATK.getText().isEmpty())
		return (Integer.parseInt(enemyATK.getText())*3*weaponDamage)/currentScaledStat[DEF];
		else
			return -1;
		
	}

	public static int calculateSpAttackDamage(int attackPower) {
		
		if(!enemyDEF.getText().isEmpty())
			return (currentScaledStat[SPATK]*3*attackPower)/Integer.parseInt(enemyDEF.getText());
			else
				return -1;
		
	}
	public static int calculateEnemySpAttackDamage(int attackPower) {
		
		if(!enemyDEF.getText().isEmpty() && !enemySPATK.getText().isEmpty())
			return (Integer.parseInt(enemySPATK.getText())*3*attackPower)/currentScaledStat[DEF];
			else
				return -1;
		
	}
	
	public static void updatePlayerHealth(int before) {
		if(rawPlayerHealth < 0) {
			rawPlayerHealth = 0;
			displayPlayerHealth = 0;		
			playerHealth.setValue(displayPlayerHealth);		
			H.setText("HP: "+displayPlayerHealth+"/"+playerHealth.getMaximum());
			JOptionPane.showMessageDialog(null, "You are Fucking DED", "Great fucking Job", JOptionPane.WARNING_MESSAGE);
		}
		displayPlayerHealth = rawPlayerHealth/5;
		
		
		playerHealth.setValue(displayPlayerHealth);	
		
		
		
		H.setText("HP: "+displayPlayerHealth+"/"+playerHealth.getMaximum());
	}
	public static void updateEnemyHealth() {
		//rawEnemyHealth will be the value typed into the jtextfield marked "HP"
		
		
		if(rawEnemyHealth < 0) {
			rawEnemyHealth = 0;
			enemyHealth.setValue(rawEnemyHealth);
			EH.setText("HP: "+rawEnemyHealth+"/"+enemyHealth.getMaximum());
			JOptionPane.showMessageDialog(null, "Enemy is already DED", "Great fucking Job", JOptionPane.WARNING_MESSAGE);
		}
		enemyHealth.setValue(rawEnemyHealth);//Make go down slowly
		EH.setText("HP: "+rawEnemyHealth+"/"+enemyHealth.getMaximum());
		
	}
	public static void applyPlayerHealth() {
		rawPlayerHealth = currentScaledStat[HP]*25;
		displayPlayerHealth = rawPlayerHealth/5;
	
		playerHealth.setMaximum(displayPlayerHealth);
		playerHealth.setValue(displayPlayerHealth);
		H.setText("HP: "+displayPlayerHealth+"/"+playerHealth.getMaximum());
		
		//System.out.println(playerHealth.getValue());
	}
	public static void applyEnemyHealth() {
		//rawEnemyHealth will be the value typed into the jtextfield marked "HP"
		
		if(!enemyHP.getText().isEmpty()) {
		rawEnemyHealth = Integer.parseInt(enemyHP.getText());
		}
		enemyHealth.setMaximum(rawEnemyHealth);
		enemyHealth.setValue(rawEnemyHealth);
		EH.setText("HP: "+rawEnemyHealth+"/"+enemyHealth.getMaximum());
		
	}
	
	public static void doDamageTo(boolean enemy,int weaponDamage) {
		
		if(enemy) {
			if(calculateAttackDamage(weaponDamage) != -1) {
		rawEnemyHealth -= calculateAttackDamage(weaponDamage);
			}else {
				JOptionPane.showMessageDialog(null, "You Didn\'t set a fucking enemy DEF Value", "Dumbass", JOptionPane.ERROR_MESSAGE);
			}
		updateEnemyHealth();
		}else {
			int before = rawPlayerHealth/5;
			if(calculateEnemyAttackDamage(weaponDamage) != -1) {
				rawPlayerHealth -= calculateEnemyAttackDamage(weaponDamage);
			}else {
				JOptionPane.showMessageDialog(null, "You Didn\'t set either a fucking enemy DEF or ATK Value", "Dumbass", JOptionPane.ERROR_MESSAGE);
			}
			updatePlayerHealth(before);
		}
	}
	public static void doSpecialDamageTo(boolean enemy,int weaponDamage) {
		//TODO
		if(enemy) {
			if(calculateSpAttackDamage(weaponDamage) != -1) {
		rawEnemyHealth -= calculateSpAttackDamage(weaponDamage);
			}else {
				JOptionPane.showMessageDialog(null, "You Didn\'t set a fucking enemy DEF Value", "Dumbass", JOptionPane.ERROR_MESSAGE);
			}
		updateEnemyHealth();
		}else {
			int before = rawPlayerHealth/5;
			if(calculateEnemySpAttackDamage(weaponDamage) != -1) {
				rawPlayerHealth -= calculateEnemySpAttackDamage(weaponDamage);
			}else {
				JOptionPane.showMessageDialog(null, "You Didn\'t set either a fucking enemy DEF or ATK Value", "Dumbass", JOptionPane.ERROR_MESSAGE);
			}
			updatePlayerHealth(before);
		}
	}
	
	public static void main(String[] args) {
		
		
		setLookAndFeel();
		level = new JComboBox<Integer>();
		playerHealth = new JProgressBar();
		enemyHealth = new JProgressBar();
		playerHealth.setSize(200, 80);
		JFrame main = new JFrame("Damage Calculator");
		main.setSize(300, 280);
		JPanel leftPanel = new JPanel();
	//	JPanel rightPanel = new JPanel();
		leftPanel.setSize(270, 250);
	//	rightPanel.setSize(270, 250);
		
	
		JTextField weaponAttack = new JTextField("Power");
		
		JButton pAttackButton = new JButton("Attack");
		JButton eAttackButton = new JButton("Attack");
		playerHealth.setMaximum(displayPlayerHealth);
		enemyHP = new JFormattedTextField();
		enemyATK = new JFormattedTextField();
		enemyATKPW = new JFormattedTextField("Power");
		enemySPATK = new JFormattedTextField();
		enemyDEF = new JFormattedTextField();
		enemyHP.setPreferredSize(new Dimension(50,25));
		enemyATK.setPreferredSize(new Dimension(50,25));
		enemyATKPW.setPreferredSize(new Dimension(50,25));
		enemySPATK.setPreferredSize(new Dimension(50,25));
		enemyDEF.setPreferredSize(new Dimension(50,25));
		
		
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
		JCheckBox spatk2 = new JCheckBox("is a Speical Attack?");
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
		
		leftPanel.add(new JLabel("<-----------------------------ENEMY---------------------------->"));
		leftPanel.add(new JLabel("HP"));
		leftPanel.add(enemyHP);
		leftPanel.add(new JLabel("ATK"));
		leftPanel.add(enemyATK);
		leftPanel.add(spatk2);
		leftPanel.add(enemyATKPW);
		leftPanel.add(eAttackButton);
		
		leftPanel.add(new JLabel("SPC-ATK"));
		leftPanel.add(enemySPATK);
		leftPanel.add(new JLabel("DEF"));
		leftPanel.add(enemyDEF);
		leftPanel.add(enemyHealth);
		leftPanel.add(EH);
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
		applyEnemyHealth();
		//This senses you typing a letter in real time, if a letter is typed it deletes it
		enemyHP.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				if(!Character.isDigit(arg0.getKeyChar())) {
					//JOptionPane.showMessageDialog(null, "Stop Typing Letters Bitch!", "Dumbass", JOptionPane.ERROR_MESSAGE);
					
					arg0.consume();
				}
				
				
			}
			
		});
		enemyATK.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				if(!Character.isDigit(arg0.getKeyChar())) {
					//JOptionPane.showMessageDialog(null, "Stop Typing Letters Bitch!", "Dumbass", JOptionPane.ERROR_MESSAGE);
					
					arg0.consume();
				}
				
					applyEnemyHealth();
				
				
				
			}
			
		});
		enemySPATK.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				if(!Character.isDigit(arg0.getKeyChar())) {
					//JOptionPane.showMessageDialog(null, "Stop Typing Letters Bitch!", "Dumbass", JOptionPane.ERROR_MESSAGE);
					
					arg0.consume();
				}
				
					applyEnemyHealth();
				
				
				
			}
			
		});
		enemyDEF.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				if(!Character.isDigit(arg0.getKeyChar())) {
					//JOptionPane.showMessageDialog(null, "Stop Typing Letters Bitch!", "Dumbass", JOptionPane.ERROR_MESSAGE);
					
					arg0.consume();
				}
				
					applyEnemyHealth();
				
				
				
			}
			
		});
		
		
		pAttackButton.addActionListener(new ActionListener() { 
			 
			

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//System.out.println("FART IN MY FACE");
				if(!spatk.isSelected()) {
					try {
						if(!enemyHP.getText().isEmpty())
					doDamageTo(true, Integer.parseInt(weaponAttack.getText()));
						else
							JOptionPane.showMessageDialog(null, "You Didn\'t set a fucking HP", "Dumbass", JOptionPane.ERROR_MESSAGE);
					}catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, weaponAttack.getText()+" is not a number", "Dumbass", JOptionPane.ERROR_MESSAGE);
					}
				}else {
					try {
						if(!enemyHP.getText().isEmpty())
					doSpecialDamageTo(true, Integer.parseInt(weaponAttack.getText()));
						else
							JOptionPane.showMessageDialog(null, "You Didn\'t set a fucking HP", "Dumbass", JOptionPane.ERROR_MESSAGE);
					}catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, weaponAttack.getText()+" is not a number", "Dumbass", JOptionPane.ERROR_MESSAGE);
					}
				}
			} 
			} );
		eAttackButton.addActionListener(new ActionListener() { 
			 
			

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(!spatk2.isSelected()) {
					try {
						doDamageTo(false, Integer.parseInt(enemyATKPW.getText()));
					}catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, enemyATKPW.getText()+" is not a number", "Dumbass", JOptionPane.ERROR_MESSAGE);
					}
							
				}else {
					try {
						
					doSpecialDamageTo(false, Integer.parseInt(enemyATKPW.getText()));
						
							
					}catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, enemyATKPW.getText()+" is not a number", "Dumbass", JOptionPane.ERROR_MESSAGE);
					}
				}
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
