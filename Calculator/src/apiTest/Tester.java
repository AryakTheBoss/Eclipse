/**
 * 
 */
package apiTest;



import java.security.InvalidKeyException;

import com.aryaktheboss.algorithims.AES;
import com.aryaktheboss.algorithims.DES;
import com.aryaktheboss.algorithims.DESede;
import com.aryaktheboss.algorithims.KeySize;
import com.aryaktheboss.algorithims.RSA;


/**
 * @author UnityBoss
 *
 */
public class Tester {

	/**
	 * @param args
	 * @throws InvalidKeyException 
	 */
	public static void main(String[] args) throws Exception, InvalidKeyException {
		// TODO Auto-generated method stub
        System.err.println("RSA Encryption: ");
		RSA rsa = new RSA(KeySize.SMALL);
		String enc = rsa.encrypt("Secret Phrase");
		System.out.println("Encrypted Value: "+enc);
		System.out.println("Decrypted Value: "+rsa.decrypt(enc));
		System.err.println("AES Encryption: ");
		
		
		AES aes = new AES();
		String enc2 = aes.encrypt("Secret Phrase");
		System.out.println("Encrypted Value: "+enc2);
		System.out.println("Decrypted Value: "+aes.decrypt(enc2));		
		System.err.println("DES Encryption: ");
		
		DES des = new DES();
		String enc3 = des.encrypt("Secret Phrase");
		System.out.println("Encrypted Value: "+enc3);
		System.out.println("Decrypted Value: "+des.decrypt(enc3));
		System.err.println("DESede Encryption: ");
		
		DESede tdes = new DESede(true);
		String enc4 = tdes.encrypt("Secret Phrase");
		System.out.println("Encrypted Value: "+enc4);
		System.out.println("Decrypted Value: "+tdes.decrypt(enc4));
		
	}

}
