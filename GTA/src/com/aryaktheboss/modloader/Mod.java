/**
 * 
 */
package com.aryaktheboss.modloader;
import java.io.File;
/**
 * @author Makarand
 *
 */
public class Mod {
	
	private String type;
	private File mod;
	
	public Mod(File mod, String type){
		
		this.type = type;
		this.mod = mod;
		
	}

}
