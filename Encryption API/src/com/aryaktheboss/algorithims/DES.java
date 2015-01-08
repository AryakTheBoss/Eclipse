/**
 * 
 */
package com.aryaktheboss.algorithims;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;

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
	  
	  private byte[] key;
	  
	  public DES(byte[] key) throws InvalidKeyException {
		  
		  if(key.length != 7) {
			  throw new InvalidKeyException("key length is not 7");
		  }
		  this.key = key;
		  
	  }
	  
	 

	public String encrypt(String text) {
		// TODO Auto-generated method stub
		Cipher c;
		byte[] enc = null;
		try {
		  c = Cipher.getInstance("DES");
		    c.init(Cipher.ENCRYPT_MODE, generateKey());
		    
		    // Encode the string into bytes using utf-8
		    byte[] utf8 = text.getBytes("UTF8");

		    // Encrypt
		     enc = c.doFinal(utf8);
		}catch(Exception e) {
			e.printStackTrace();
		}
		    // Encode bytes to base64 to get a string
		    return new sun.misc.BASE64Encoder().encode(enc);
	}

	public String decrypt(String data) {
		// TODO Auto-generated method stub
		byte[] utf8;
		try {
		Cipher c = Cipher.getInstance("DES");
		    c.init(Cipher.ENCRYPT_MODE, generateKey());
		byte[] dec = new sun.misc.BASE64Decoder().decodeBuffer(data);

	    utf8 = c.doFinal(dec);
		}catch(Exception e) {
			e.printStackTrace();
		}
	    // Decode using utf-8
	    return new String(utf8, "UTF8");
	}
	
	private Key generateKey() throws Exception {
	    Key key = new SecretKeySpec(this.key, ALGORITHM);
	    return key;
	}

}
