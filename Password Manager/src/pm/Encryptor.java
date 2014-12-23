/**
 * 
 */
package pm;


import java.security.Key;




import javax.crypto.Cipher;

import javax.crypto.spec.SecretKeySpec;
import sun.misc.*;

/**
 * @author UnityBoss
 *
 */
public class Encryptor {
	
	
	
	private static final String ALGO = "AES";
	 private static final byte[] keyValue = 
	 new byte[] { 'E', 'n', 'c', 'r', 'y', 'p', 't', 'i', 'o', 'n', 'I','s', 'Y', 'o', 'l', 'o' };
	 
     public Encryptor(){ 
		 
		
		
	 }
	   
		
		

		   
		public String encrypt(String Data) throws Exception {
	        Key key = generateKey();
	        Cipher c = Cipher.getInstance(ALGO);
	        c.init(Cipher.ENCRYPT_MODE, key);
	        byte[] encVal = c.doFinal(Data.getBytes());
	        String encryptedValue = new BASE64Encoder().encode(encVal);
	        return encryptedValue;
	    }

		   
		
		public String decrypt(String pass)throws Exception{
			
			 Key key = generateKey();
			    Cipher c = Cipher.getInstance(ALGO);
			    c.init(Cipher.DECRYPT_MODE, key);
			   
			    byte[] decordedValue = new BASE64Decoder().decodeBuffer(pass);
			    byte[] decValue = c.doFinal(decordedValue);
			    String decryptedValue = new String(decValue);
			    return decryptedValue;
			
		}
		private static Key generateKey() throws Exception {
		    Key key = new SecretKeySpec(keyValue, ALGO);
		    return key;
		}

}
