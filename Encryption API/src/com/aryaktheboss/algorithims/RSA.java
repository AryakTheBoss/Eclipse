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
 * This class uses the standard RSA encryption algorithm with customizable 
 * key sizes including 1024 and 2048
 * 
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
	 
	 /**
	  * Primary Constructor that accepts key size as a parameter
	  * it will then generate a public key and a private key.
	  * 
	  * @param bits - the key size
	  */
	 public RSA(KeySize k) {
		 
		 if(k.equals(KeySize.SMALL)){  
		 generateKey(1024);
		 }else if(k.equals(KeySize.MEDIUM)){
		 generateKey(2048);
		 }else if(k.equals(KeySize.LARGE)){
	     generateKey(4096);
		 }else if(k.equals(KeySize.XTRALARGE)){
		 generateKey(8192);
		 }
		 
	 }
	 /**
	  * This constructor takes a public key and a private key to use
	  * with encryption and decryption.
	  * 
	  * @param publicKey
	  * @param privateKey
	  */
	 public RSA(PublicKey publicKey,PrivateKey privateKey) {
		 this.PUBLIC_KEY = publicKey;
		 this.PRIVATE_KEY = privateKey;
	 }
	 /**
	  * Gets the public key of THIS instance
	  * 
	  * @return the public key
	  */
	 public PublicKey getPublicKey() {
		 
		 return this.PUBLIC_KEY;
		 
	 }
	
	 /**
	  * Gets the private key of THIS instance
	  * 
	  * @return the public key
	  */
	 public PrivateKey getPrivateKey() {
		 
		 return this.PRIVATE_KEY;
		 
	 }
   
	public String encrypt(String text) {
		// TODO Auto-generated method stub
		byte[] cipherText = null;
		String encryptedValue = null;
	    try {
	      // get an RSA cipher object and print the provider
	      final Cipher cipher = Cipher.getInstance(ALGORITHM);
	      // encrypt the plain text using the public key
	      cipher.init(Cipher.ENCRYPT_MODE, this.PUBLIC_KEY);
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
	      cipher.init(Cipher.DECRYPT_MODE, this.PRIVATE_KEY);
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
