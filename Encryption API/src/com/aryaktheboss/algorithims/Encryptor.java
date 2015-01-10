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
	     * @return encrypted text
	     */
		String encrypt(String text) throws Exception;
		/**
	     * Decrypts the plain text with the algorithm that
	     * implements it.
	     * 
	     * @param data
	     * @return decrypted text
	     */
		String decrypt(String data) throws Exception;
	    
}
