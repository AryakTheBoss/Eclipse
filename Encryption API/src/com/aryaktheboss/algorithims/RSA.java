/**
 * 
 */
package com.aryaktheboss.algorithims;


import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.Cipher;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * @author UnityBoss
 *
 */
public class RSA implements Encryptor{
	
	/**
	   * String to hold name of the encryption algorithm.
	   */
	  protected static final String ALGORITHM = "RSA";

	  /**
	   * Holds the private key
	   */
	  private PrivateKey PRIVATE_KEY = null;

	  /**
	   * Holds public key
	   */
	 private PublicKey PUBLIC_KEY = null;
	 
	 public RSA(int bits) {
		 
		 if(bits != 2048 || bits != 1024) {
			 throw new IllegalArgumentException("Bits are invalid");
		 }
		 generateKey(bits);
		 
	 }
	 
	 protected PublicKey getPublicKey() {
		 
		 return PUBLIC_KEY;
		 
	 }
	

	public String encrypt(String text) {
		// TODO Auto-generated method stub
		byte[] cipherText = null;
		String encryptedValue = null;
	    try {
	      // get an RSA cipher object and print the provider
	      final Cipher cipher = Cipher.getInstance(ALGORITHM);
	      // encrypt the plain text using the public key
	      cipher.init(Cipher.ENCRYPT_MODE, PUBLIC_KEY);
	      cipherText = cipher.doFinal(text.getBytes());
	      encryptedValue = new BASE64Encoder().encode(cipherText);
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    return encryptedValue;
	}

	public String decrypt(String data) {
		// TODO Auto-generated method stub
		byte[] dectyptedText = null;
	    try {
	      // get an RSA cipher object and print the provider
	      final Cipher cipher = Cipher.getInstance(ALGORITHM);
	      byte[] decordedValue = new BASE64Decoder().decodeBuffer(data);
	      // decrypt the text using the private key
	      cipher.init(Cipher.DECRYPT_MODE, PRIVATE_KEY);
	      dectyptedText = cipher.doFinal(decordedValue);

	    } catch (Exception ex) {
	      ex.printStackTrace();
	    }
	   return new String(dectyptedText);
	}
	
	
	
	private void generateKey(int bits) {
	    try {
	      final KeyPairGenerator keyGen = KeyPairGenerator.getInstance(ALGORITHM);
	      keyGen.initialize(bits);
	      final KeyPair key = keyGen.generateKeyPair();

	      PRIVATE_KEY = key.getPrivate();
          PUBLIC_KEY = key.getPublic();
	     
	    } catch (Exception e) {
	      e.printStackTrace();
	    }

	  }

}
