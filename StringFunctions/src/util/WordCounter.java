/**
 * 
 */
package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;



/**
 * @author UnityBoss
 *  Counts words in either a file or in console input
 */
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.util.Scanner;

public class WordCounter {
	
	 private Scanner sc = new Scanner(System.in);
	private JFileChooser fc = new JFileChooser();
	
	
	public WordCounter(){ 
		
		System.out.println("Word Counter Opened");
		fc.setFileFilter(new FileNameExtensionFilter("Text and word files","txt","rtf","doc","docx"));
		
	}
	
	public int CountWords() throws FileNotFoundException{
		
		int words = 0;
		
		System.out.println("Enter 1 for console 2 for file");
		
		int s = sc.nextInt();
		
		if(s==1){
			
			System.out.println("Enter a phrase");
			sc.nextLine();
			String ak = sc.nextLine();
			Scanner read = new Scanner(ak);
			while(read.hasNext()){
				
			read.next();
			words++;
			
			}
			read.close();
		}else{
			int Final = 0;
			System.out.println("Opening File Chooser....");
			File f = OpenFile();
			Scanner reader = new Scanner(f);
			while(reader.hasNext()){
				
				String hh = reader.nextLine();
				Scanner sdf = new Scanner(hh);
				while(sdf.hasNext()){
					sdf.next();
					
					Final++;
				}
				words += Final;
				
				sdf.close();
				
			}
			reader.close();
			
		}
		
		return words;
		
	}
	private File OpenFile(){
		
		JFrame fr = new JFrame("Bong");
		
		fr.setVisible(true);
		fr.setAlwaysOnTop(true);
		fc.showOpenDialog(fr);
		return fc.getSelectedFile();
		
	}
	public static void main(String[] args) throws FileNotFoundException{
		
		WordCounter wc = new WordCounter();
		
		System.out.println(wc.CountWords());
		System.exit(0);
	}

}
