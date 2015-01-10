/**
 * 
 */
package com.aryaktheboss.algorithims;

/**
 * @author UnityBoss
 *
 */
public enum KeySize {
	
	/**
	 * Smallest and Least secure key length of 
	 * 1024 bits <br>
	 * <b>Operations on this key size are fairly quick</b>
	 */
	SMALL,
	/**
	 * Medium secure key length of 
	 * 2048 bits <br>
	 * <b>Operations on this key size are a little slow</b>
	 */
	MEDIUM,
	/**
	 * Large key size of 4096 bits <br>
	 * <b>Operations on this key size are slow</b>
	 */
	LARGE,
	/**
	 * Highest Security key with length of
	 * 8192 bits <br>
	 * <b>Operations on this key size are VERY slow</b>
	 */
	XTRALARGE
	
	
	
}
