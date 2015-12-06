package commercial;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ModLoader {
	
	private static ArrayList<File> mods;
	private static String gtaDirectory;
	
	
	public ModLoader() throws FileNotFoundException{
		
		File f = new File("C:\\Paste Mods Here");
		File f2 = new File("C:\\Paste Mods Here\\gtaDirectory.txt");
		if(f2.exists()){
			
			Scanner fr = new Scanner(f2);
			gtaDirectory = fr.nextLine();
			initialize();
			fr.close();
			
		}else{
			f.mkdir();
			Scanner s = new Scanner(System.in);
			System.out.println("Enter GTA Directory: ");
			String ss = s.nextLine();			
			try {
				f2.createNewFile();
				FileWriter fs = new FileWriter(f2);
				fs.write(ss);
				fs.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Scanner sss = new Scanner(f2);
			gtaDirectory =	sss.nextLine();
			initialize();
			sss.close();
			
			
		}
			
		
	}
	
	private void initialize(){
		
		mods = loadFiles();
		
		
		
		
		
		
	}
	
	private ArrayList<File> loadFiles(){
		
		ArrayList<File> files = new ArrayList<File>();
		
	}
	

}
