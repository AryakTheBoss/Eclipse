/**
 * 
 */
package com.aryaktheboss.algorithims;

import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * This class uses the standard Triple DES alogrithm for added security over 
 * regular DES.
 * 
 * @author UnityBoss
 *
 */
public class DESede implements Encryptor{
	/**
	   * String to hold name of the encryption algorithm.
	   */
	  protected static final String ALGORITHM = "DESede";
	private String digest = "";
	private String keyChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	//http://stackoverflow.com/questions/20227/how-do-i-use-3des-encryption-decryption-in-java
	/**
	 * Main Constructor for DESede takes a boolean if true a random key is generated
	 * else a default key is set.
	 * @param randomKey if false, a default key is set if true it will generate a random key.
	 */
public DESede(boolean randomKey) {
	
	if(randomKey) {
		
		for(int i=0;i<10;i++) {
			
			digest += keyChars.charAt(new Random().nextInt(keyChars.length()));
			
		}
						
	}else {
		this.digest = "HG58YZ3CR9";
	}
	
}
/**
 * This constructor takesa string with a custom key but it must be
 * atleast 10 letters long
 * 
 * @param key
 * @throws InvalidKeyException
 */
public DESede(String key) throws InvalidKeyException{
	
	if(key.length() != 10) {
		throw new InvalidKeyException("Key must be 10 long");
	}
	this.digest = key;
	
}
	public String encrypt(String text) throws Exception{
		// TODO Auto-generated method stub
		final MessageDigest md = MessageDigest.getInstance("md5");
    	final byte[] digestOfPassword = md.digest(this.digest
    			.getBytes("utf-8"));
    	final byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
    	for (int j = 0, k = 16; j < 8;) {
    		keyBytes[k++] = keyBytes[j++];
    	}

    	final SecretKey key = new SecretKeySpec(keyBytes, ALGORITHM);
    	final IvParameterSpec iv = new IvParameterSpec(new byte[8]);
    	final Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
    	cipher.init(Cipher.ENCRYPT_MODE, key, iv);

    	final byte[] plainTextBytes = text.getBytes("utf-8");
    	final byte[] cipherText = cipher.doFinal(plainTextBytes);
    	 final String encodedCipherText = new sun.misc.BASE64Encoder()
    	 .encode(cipherText);

    	return encodedCipherText;
	}

	public String decrypt(String data) throws Exception{
		// TODO Auto-generated method stub
		final MessageDigest md = MessageDigest.getInstance("md5");
    	final byte[] digestOfPassword = md.digest(this.digest
    			.getBytes("utf-8"));
    	final byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
    	for (int j = 0, k = 16; j < 8;) {
    		keyBytes[k++] = keyBytes[j++];
    	}

    	final SecretKey key = new SecretKeySpec(keyBytes, ALGORITHM);
    	final IvParameterSpec iv = new IvParameterSpec(new byte[8]);
    	final Cipher decipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
    	decipher.init(Cipher.DECRYPT_MODE, key, iv);

    	 final byte[] encData = new
    	 sun.misc.BASE64Decoder().decodeBuffer(data);
    	final byte[] plainText = decipher.doFinal(encData);

    	return new String(plainText, "UTF-8");
	}

}
