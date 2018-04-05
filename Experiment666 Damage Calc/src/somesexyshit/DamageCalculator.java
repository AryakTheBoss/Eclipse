/**
 * 
 */
package somesexyshit;
import javax.swing.JFrame;
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
	
	public static int calculateAttackDamage(int[] user, int[] receiver, int weaponDamage,int level) {
		
		if(level == 0)
			return (user[ATK]*3*weaponDamage)/receiver[DEF];
		else
			return ((user[ATK]*Math.round((float)Math.pow(1.10, level)))*3*weaponDamage)/receiver[DEF];
		
	}
	public static int calculateSpAttackDamage(int[] user, int[] receiver, int attackPower,int level) {
		
		if(level == 0)
			return (user[SPATK]*3*attackPower)/receiver[DEF];
		else
			return ((user[SPATK]*Math.round((float)Math.pow(1.10, level)))*3*attackPower)/receiver[DEF];
		
		
	}
	
	public static void main(String[] args) {
		
		JFrame main = new JFrame("Damage Calculator");
		JComboBox<Integer> level = new JComboBox<Integer>();
		
	}

}
