/**
 * 
 */
package com.aryaktheboss.algorithims;

import java.io.File;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import com.aryaktheboss.exceptions.InvalidKeyException;

import sun.misc.BASE64Encoder;

/**
 * @author UnityBoss
 *
 */
public class AES implements Encryptor{
	/**
	   * String to hold name of the encryption algorithm.
	   */
	  protected static final String ALGORITHM = "AES";
	
	private final byte[] key;
	
	/**
	 * Constructor which takes the key which is unchangeable afterwards.
	 * key.length must be at least 16
	 * @param key
	 */
	public AES(byte[] key) throws InvalidKeyException {
		
		if(key.length != 16) {
			throw new InvalidKeyException("Key length must be 16");
		}
		this.key = key;
		
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
			
		}
		 return encryptedValue;
	}

	public String decrypt(String data) {
		// TODO Auto-generated method stub
		return null;
	}

	private Key generateKey() throws Exception {
	    Key key = new SecretKeySpec(this.key, ALGORITHM);
	    return key;
	}

}
