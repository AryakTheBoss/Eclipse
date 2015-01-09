/**
 * 
 */
package com.aryaktheboss.algorithims;

import java.util.Arrays;
import java.util.Random;

import com.aryaktheboss.exceptions.InvalidKeyException;

/**
 * @author UnityBoss
 *
 */
public class Tester {

	/**
	 * @param args
	 * @throws InvalidKeyException 
	 */
	public static void main(String[] args) throws Exception, InvalidKeyException {
		// TODO Auto-generated method stub
        System.err.println("RSA Encryption: ");
		RSA rsa = new RSA(KeySize.SMALL);
		String enc = rsa.encrypt("Secret Phrase");
		System.out.println("Encrypted Value: "+enc);
		System.out.println("Decrypted Value: "+rsa.decrypt(enc));
		System.err.println("AES Encryption: ");
		String keyChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		byte[] arr = new byte[16];
        for(int i=0;i<arr.length;i++) {
			
			arr[i] = (byte)keyChars.charAt(new Random().nextInt(keyChars.length()));
			
		}
		AES aes = new AES(arr);
		String enc2 = aes.encrypt("Secret Phrase");
		System.out.println("Encrypted Value: "+enc2);
		System.out.println("Decrypted Value: "+aes.decrypt(enc2));
		System.out.println("Key: "+Arrays.toString(arr));
		System.err.println("DES Encryption: ");
		byte[] arr2 = new byte[8];
        for(int i=0;i<arr.length;i++) {
			
			arr[i] = (byte)keyChars.charAt(new Random().nextInt(keyChars.length()));
			
		}
		DES des = new DES(arr2);
		String enc3 = des.encrypt("Secret Phrase");
		System.out.println("Encrypted Value: "+enc3);
		System.out.println("Decrypted Value: "+des.decrypt(enc3));
		System.out.println("Key: "+Arrays.toString(arr2));
	}

}
