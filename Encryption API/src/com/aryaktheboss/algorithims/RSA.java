/**
 * 
 */
package com.aryaktheboss.algorithims;


import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

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
	   * String to hold the name of the private key file.
	   */
	  private PrivateKey PRIVATE_KEY = null;

	  /**
	   * String to hold name of the public key file.
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
		return null;
	}

	public String decrypt(String data) {
		// TODO Auto-generated method stub
		return null;
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
