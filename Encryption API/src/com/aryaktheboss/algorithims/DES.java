/**
 * 
 */
package com.aryaktheboss.algorithims;


import java.security.InvalidKeyException;
import java.security.Key;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author UnityBoss
 *
 */
public class DES implements Encryptor{
	
	/**
	   * String to hold name of the encryption algorithm.
	   */
	  protected static final String ALGORITHM = "DES";
	  private static String keyChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	  
	  private byte[] key;
	  /**
	   * Constructor for if you want to use a custom key with this 
	   * instance of <code>DES</code>
	   * 
	   * @param key - the key must be 8 bytes
	   * @throws InvalidKeyException
	   */
	  public DES(byte[] key) throws InvalidKeyException {
		  
		  if(key.length != 8) {
			  throw new InvalidKeyException("key length is not 8 bytes");
		  }
		  this.key = key; 
		  
	  }
	  /**
	   * Main Constructor that generates a key which is retriveable.
	   * 
	   */
	  public DES(){
		  
		  byte[] arr2 = new byte[8];
	        for(int i=0;i<arr2.length;i++) {
				
				arr2[i] = (byte)keyChars.charAt(new Random().nextInt(keyChars.length()));
				
			}
		  this.key = arr2;
	  }
	  /**
	   * Gets the key for this instance that was either given or generated.
	   * 
	   * @return the key for this instance
	   */
	  	public byte[] getKey(){
	  		
	  		return this.key;
	  		
	  	}

	public String encrypt(String text) throws Exception{
		// TODO Auto-generated method stub
		Cipher c;
		byte[] enc = null;
		
		  c = Cipher.getInstance("DES");
		    c.init(Cipher.ENCRYPT_MODE, generateKey());
		    
		    // Encode the string into bytes using utf-8
		    byte[] utf8 = text.getBytes("UTF8");

		    // Encrypt
		     enc = c.doFinal(utf8);
		
			
		
		    // Encode bytes to base64 to get a string
		    return new sun.misc.BASE64Encoder().encode(enc);
	}

	public String decrypt(String data) throws Exception{
		// TODO Auto-generated method stub
		byte[] utf8;
		
		Cipher c = Cipher.getInstance("DES");
		    c.init(Cipher.DECRYPT_MODE, generateKey());
		byte[] dec = new sun.misc.BASE64Decoder().decodeBuffer(data);

	    utf8 = c.doFinal(dec);
	    return new String(utf8, "UTF8");
		
		
	    // Decode using utf-8
	    
	}
	
	private Key generateKey() throws Exception {
	    Key key = new SecretKeySpec(this.key, ALGORITHM);
	    return key;
	}

}
