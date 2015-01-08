package com.aryaktheboss.algorithims;


/**
 * This is the main interface that is used by algorithm classes.
 * simply implement this interface to make your own algorithm
 * 
 * @author 310843
 *
 */
public interface Encryptor {

	    /**
	     * Encrypts the plain text with the algorithm that
	     * implements it.
	     * 
	     * @param text
	     * @return
	     */
		String encrypt(String text);
		/**
	     * Decrypts the plain text with the algorithm that
	     * implements it.
	     * 
	     * @param data
	     * @return
	     */
		String decrypt(String data);
	    
}
