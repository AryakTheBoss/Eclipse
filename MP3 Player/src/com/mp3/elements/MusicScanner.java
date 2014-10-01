/**
 * 
 */
package com.mp3.elements;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * @author UnityBoss
 *
 */
public class MusicScanner {
	
	private File[] soundFiles;
	
	public MusicScanner(String directory){
		
		File dir = new File(directory);
		soundFiles = dir.listFiles(new FilenameFilter() {
		    public boolean accept(File file, String name) {
		        if (name.endsWith(".mp3")) {
		            // filters files whose extension is .mp3
		            return true;
		        } else {
		            return false;
		        }
		    }
		}); //TODO add filter	
		
	    
		
	}
	public File[] getFiles(){
		
		return soundFiles;
		
	}
	
	

}
