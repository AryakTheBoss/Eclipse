package commercial;

import java.util.List;
import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ModLoader {
	
	private static ArrayList<File> mods;
	private static String gtaDirectory;
	private static final String[] supportedFileTypes = {".dll",".asi",".lua",".cs",".vb"};
	
	
	public ModLoader() throws FileNotFoundException{
		
		File f = new File("C:\\Paste Mods Here");
		File f2 = new File("C:\\Paste Mods Here\\gtaDirectory.txt");
		if(f2.exists()){
			
			Scanner fr = new Scanner(f2);
			gtaDirectory = fr.nextLine();
			mods = loadFiles();
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
			gtaDirectory = ss;
			
			mods = loadFiles();
			
			System.out.println("LOCATION SAVED!");
			
		}
			
		
	}
	
	
	public void printFiles(){
		
		int count = 1;
		for(File f : mods){
			
			System.out.println(count +") "+ f.getName());
			count++;
		}
		
	}
	public int mods(){
		return mods.size();
	}
	//copy from mods folder to game folder
	public boolean installMod(File mod){
		
	/*	File file = new File("<file to be copied>");
		// get the java.nio.file.path from this
		Path filePath = file.toPath();
		//create a temporary file to copy contents to.
		//In actual application this is the target file for copy
		Path tempFilePath = Files.createTempFile(tempDir, "temp", "a",new FileAttribute<?>[0]);
		
		// copy contents
		Files.copy(filePath, out);*/
		
		System.out.println(mod.getName() + " Installed Successfully!");
		return true;
	}
	//rename extention to .OFFZ+(originalExtention)
	public boolean disableMod(File mod){
		
		if(mod.getName().indexOf(".OFFZ") >= 0){
			return false;
		}
		String originalExtention = mod.getName().substring(mod.getName().indexOf(".")+1);
		//mod.renameTo(new File(mod.getPath()));
		
		System.out.println(mod.getName() + " Has Been Disabled.");
		return true;
	}
	public boolean enableMod(File mod){
		System.out.println(mod.getName() + " Has Been Enabled!");
		return true;
	}
	
	
	private ArrayList<File> loadFiles(){
		
		ArrayList<File> fileList = new ArrayList<File>();
		File dir = new File("C:\\Paste Mods Here");	
		
		FilenameFilter filter = new FilenameFilter() {
	        public boolean accept(File directory, String fileName) {
	        	
	           for(String s : supportedFileTypes)
	        	   if(fileName.endsWith(s))
	        		   return true;
	           
	           return false;
	           
	        }
	        };
		
		for(File f : dir.listFiles(filter))
			fileList.add(f);
		
		
		
		
		
		return fileList;
		
	}
	

}
