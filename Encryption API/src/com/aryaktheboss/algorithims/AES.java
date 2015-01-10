/**
 * 
 */
package com.aryaktheboss.algorithims;


import java.security.InvalidKeyException;
import java.security.Key;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;




import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * This class will encrypt your data using the standard AES-128 encryption algorithim
 * 128 bit is the only current key length
 * @author UnityBoss
 *
 */
public class AES implements Encryptor{
	/**
	   * String to hold name of the encryption algorithm.
	   */
	  protected static final String ALGORITHM = "AES";
	  private static String keyChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	  
	private final byte[] key;
	
	/**
	 * Constructor which takes the key which is unchangeable afterwards.
	 * key length must be at least 16
	 * @param key - the key that should be used with encryption
	 */
	public AES(byte[] key) throws InvalidKeyException {
		
		if(key.length != 16) {
			throw new InvalidKeyException("Key length must be 16");
		}
		this.key = key;
		
	}
	/**
	 * Main Constructor which generates a random key which is
	 * retrievable.
	 * @see getKey()
	 */
	public AES(){
		
		byte[] arr2 = new byte[16];
        for(int i=0;i<arr2.length;i++) {
			
			arr2[i] = (byte)keyChars.charAt(new Random().nextInt(keyChars.length()));
			
		}
	  this.key = arr2;
		
	}

	public byte[] getKey(){
		
		return this.key;
		
	}
	
	public String encrypt(String text) {
		// TODO Auto-generated method stub
		Key key;
		String encryptedValue = null;
		try {
			key = generateKey();
		
        Cipher c = Cipher.getInstance(ALGORITHM);        
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = c.doFinal(text.getBytes());
        encryptedValue = new BASE64Encoder().encode(encVal);
       
		}catch(Exception e) {
			e.printStackTrace();
		}
		 return encryptedValue;
	}

	public String decrypt(String data) {
		// TODO Auto-generated method stub
		String decryptedValue = null;
		try {
		 Key key = generateKey();
		    Cipher c = Cipher.getInstance(ALGORITHM);
		    c.init(Cipher.DECRYPT_MODE, key);
		   
		    byte[] decordedValue = new BASE64Decoder().decodeBuffer(data);
		    byte[] decValue = c.doFinal(decordedValue);
		    decryptedValue = new String(decValue);
		}catch(Exception e) {
			e.printStackTrace();
		}
		    return decryptedValue;
	}

	private Key generateKey() throws Exception {
	    Key key = new SecretKeySpec(this.key, ALGORITHM);
	    return key;
	}

}
