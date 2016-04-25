/**
 * 
 */
package butthole;

/**
 * @author 17ap0497
 *
 */
public class MorseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MorseTree mt = new MorseTree();
		
		System.out.println(mt.translate("I love to throw mario in everyones face yay theres a guy on your left flank bruh"));
		System.out.println(mt.translate("·· / ·-·· --- ···- · / - --- / - ···· ·-· --- ·-- / -- ·- ·-· ·· --- / ·· -· / · ···- · ·-· -·-- --- -· · ··· / ··-· ·- -·-· · / -·-- ·- -·-- / - ···· · ·-· · ··· / ·- / --· ··- -·-- / --- -· / -·-- --- ··- ·-· / ·-·· · ··-· - / ··-· ·-·· ·- -· -·- / -··· ·-· ··- ···· / "));
		System.out.println(mt.translate("yay"));
		System.out.println(mt.translate("-.-- .- -.--"));
		System.out.println(mt.translate("lol @pandeary12 is my twitter"));
		System.out.println(mt.translate("·-·· --- ·-·· / ·--·-· ·--· ·- -· -·· · ·- ·-· -·-- ·---- ··--- / ·· ··· / -- -·-- / - ·-- ·· - - · ·-· / "));
	}

}
