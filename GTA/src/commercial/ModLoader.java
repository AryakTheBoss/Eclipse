package commercial;

import java.util.List;
import org.apache.commons.io.FileUtils;
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
import java.util.Stack;

public class ModLoader {
	
	
	private static ArrayList<File> availableMods;
	private static ArrayList<File> installedMods;
	private File f = new File("C:\\Paste Mods Here");
	private File dir = new File("C:\\Paste Mods Here\\gtaDirectory.txt");
	private File installed = new File("C:\\Paste Mods Here\\installedMods.txt");
	private static String gtaDirectory;
	private static final String[] supportedFileTypes = {".dll",".asi",".lua",".cs",".vb"};
	
	
	public ModLoader() throws FileNotFoundException{
		
		
		if(dir.exists()){
			
			Scanner fr = new Scanner(dir);
			gtaDirectory = fr.nextLine();
			availableMods = loadFiles();
			installedMods = loadInstalledMods();
			fr.close();
			
		}else{
			f.mkdir();
			Scanner s = new Scanner(System.in);
			System.out.println("Enter GTA Directory: ");
			String ss = s.nextLine();			
			try {
				dir.createNewFile();
				FileWriter fs = new FileWriter(dir);
				fs.write(ss);
				fs.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			gtaDirectory = ss;
			
			availableMods = loadFiles();
			
			System.out.println("LOCATION SAVED!");
			
		}
			
		
	}
	public ArrayList<File> loadInstalledMods() throws FileNotFoundException{
		
		ArrayList<File> lol = new ArrayList<File>();
		Scanner s = new Scanner(installed);
		while(s.hasNext()){
			lol.add(new File(s.nextLine()));
		}
		return null;
		
	}
	
	public void printFiles(){
		
		int count = 1;
		for(File f : availableMods){
			
			System.out.println(count +") "+ f.getName());
			count++;
		}
		
	}
	public int mods(){
		return availableMods.size();
	}
	//copy from mods folder to game folder
	public boolean installMod(File mod){
		System.out.println("Trying to install "+mod.getName()+"...");
		String temp = mod.getPath();
	try {
		if(!mod.getName().endsWith(".dll"))
			FileUtils.copyFileToDirectory(mod, new File(gtaDirectory+"\\scripts"));
		else
			FileUtils.copyFileToDirectory(mod, new File(gtaDirectory));
	
	} catch (IOException e) {
		// TODO Auto-generated catch block
		System.err.println(mod.getName() + " Was NOT Installed Successfully :(");
		return false;
	}
	
		try {
			if(!installed.exists())
				installed.createNewFile();
			
			FileWriter fw = new FileWriter(installed,true);
			fw.write(mod.getPath()+"\n");
			fw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println(mod.getName() + " Was NOT Installed Successfully :(");
			return false;
		}
		new File(temp).delete(); //delete original file
		System.out.println(mod.getName() + " Installed Successfully!");
		
		return true;
	}
	public void installMods(Stack<File> mods){
		
		while(!mods.isEmpty()){
			installMod(mods.pop());
		}
		
		
	}
	//rename extention to .OFFZ+(originalExtention)
	public boolean disableMod(File mod){
		
		if(mod.getName().indexOf(".OFFZ") >= 0){
			return false;
		}
		String originalExtention = mod.getName().substring(mod.getName().indexOf(".")+1);
		
		System.out.println(mod.getName() + " Has Been Disabled.");
		return true;
	}
	public boolean disableMods(Stack<File> mods){		
		
		return true;
		
	}
	public boolean enableMod(File mod){
		System.out.println(mod.getName() + " Has Been Enabled!");
		return true;
	}
	public boolean enableMods(Stack<File> mods){
		
		return false;
		
	}
	
	public boolean uninstallMod(File mod){
		
		return false;
		
	}
	public boolean uninstallMods(Stack<File> mods){
		
		return false;
		
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
