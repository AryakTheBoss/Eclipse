/**
 * 
 */
package bs;


import java.security.Key;




import javax.crypto.Cipher;

import javax.crypto.spec.SecretKeySpec;
import sun.misc.*;

/**
 * @author UnityBoss
 * f
 *
 */
public class Encryptor {
	
	
	private String passs; //un encrypted
	private static final String ALGO = "AES";
	 private static final byte[] keyValue = 
	 new byte[] { 'E', 'n', 'c', 'r', 'y', 'p', 't', 'i', 'o', 'n', 'I','s', 'Y', 'o', 'l', 'o' };
	 /**
	  * 
	  * @deprecated
	  * @param passw
	  */
	 public Encryptor(String passw){ 
		 
		 passs = passw;
		 
	 }
	 
	 /**
	  * Standard constructor to initalize the object
	  * 
	  */
     public Encryptor(){ 
		 
		 passs = null;
		 
	 }
	   
		/**
		 * Encrypts the stored password
		 * @deprecated
		 * @return
		 * @throws Exception
		 */
		public String encryptSTPSWD() throws Exception{ 
		    
			Key key = generateKey();
	        Cipher c = Cipher.getInstance(ALGO);
	        c.init(Cipher.ENCRYPT_MODE, key);
	        byte[] encVal = c.doFinal(passs.getBytes());
	        String encryptedValue = new BASE64Encoder().encode(encVal);
	        return encryptedValue;


		   }

		   /**
		    * Encrypts the string and returns it
		    * 
		    * @param Data - the string to encrypt
		    * @return - encrypted string
		    * @throws Exception
		    */
		public String encrypt(String Data) throws Exception {
	        Key key = generateKey();
	        Cipher c = Cipher.getInstance(ALGO);
	        c.init(Cipher.ENCRYPT_MODE, key);
	        byte[] encVal = c.doFinal(Data.getBytes());
	        String encryptedValue = new BASE64Encoder().encode(encVal);
	        return encryptedValue;
	    }

		 /**
		  * Sets current Password
		  * @deprecated
		  * @param password
		  */
		public void setPassword(String password){
			
			passs = password;
			
		}
		/**
		 * Decrypts string given and returns it
		 * 
		 * @param pass - encrypted string
		 * @return - decrypted string
		 * @throws Exception - it will throw an exception if the string given is not an encrypted string
		 */
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
