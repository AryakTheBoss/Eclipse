/**
 * 
 */
package com.mp3.elements;

import java.io.File;

/**
 * @author UnityBoss
 *
 */
public class Globals {
	
	public static boolean paused = true;
	public static boolean skippedFor = false;
	public static boolean skippedBack = false;
    public static File[] mp3Files = Comps.mp3.getFiles();
	public static File currentSong = null;

}
