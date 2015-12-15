package commercial;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
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
				installed.createNewFile();
				FileWriter fs = new FileWriter(dir);
				fs.write(ss);
				fs.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			gtaDirectory = ss;
			
			availableMods = loadFiles();
			installedMods = loadInstalledMods();
			
			System.out.println("LOCATION SAVED!");
			
		}
			
		
	}
	public ArrayList<File> loadInstalledMods() throws FileNotFoundException{
		
		ArrayList<File> lol = new ArrayList<File>();
		Scanner s = new Scanner(installed);
		while(s.hasNext()){
			lol.add(new File(s.nextLine()));
		}
		s.close();
		System.out.println(lol);
		return lol;
		
	}
	public File getInstalledModAtIndex(int i){
		try{
		return installedMods.get(i);
		}catch (IndexOutOfBoundsException e){
			throw new IllegalArgumentException();
		}
	}
	public File getAvailableModAtIndex(int i){
		try{
			return availableMods.get(i);
			}catch (IndexOutOfBoundsException e){
				throw new IllegalArgumentException();
			}
	}
	public void printAvailableMods(){
		
		int count = 1;
		System.out.println("Name\tType");
		for(File f : availableMods){
			
			System.out.println(count +") "+ f.getName());
			count++;
		}
		
	}
	public void printInstalledMods(){
		int count = 1;
		for(File f : installedMods){
			
			System.out.println(count +") "+ f.getName());
			count++;
		}
	}
	public void printInstalledModsWithStatus(){
		int count = 1;
		System.out.println("Name\tType\tStatus");
		
		for(File f : installedMods){
			//System.out.println(Arrays.toString(f.getName().split(".")));
			//System.out.println(f.getName());
			System.out.println(count +") "+ f.getName().split(".")[0]+"\t"+f.getName().split(".")[1]+(f.getName().endsWith(".OFFZ") ? "DISABLED":"ENABLED"));
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
			fw.write(gtaDirectory+"\\"+mod.getName()+"\n");
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
	
	public boolean isDisabled(File mod){
		return mod.getName().indexOf(".offz") >= 0;
	}
	//rename mod extention to .OFFZ and Script extention to .OFFS
	public boolean disableMod(File mod){
		
		if(isDisabled(mod) || !mod.getName().endsWith(".dll")){
			System.out.println("Disabling and enabling of Scripts is not supported yet");
			return false;
		}
		
		renameFileExtention(mod.getPath(),".offz");
		
		
		System.out.println(mod.getName() + " Has Been Disabled.");
		
		return true;
	}
	public boolean renameFileExtention(String source, String newExtension)  
	{  
		String target;  
		String currentExtension = getFileExtension(source);  
  
		if (currentExtension.equals("")){  
     target = source + "." + newExtension;  
	}  
		else {  
     target = source.replaceAll("." + currentExtension, newExtension);  
		}  
		return new File(source).renameTo(new File(target));  
	}  
  
private static String getFileExtension(String f) {  
  String ext = "";  
  int i = f.lastIndexOf('.');  
  if (i > 0 &&  i < f.length() - 1) {  
     ext = f.substring(i + 1).toLowerCase();  
  }  
  return ext;  
}  
	public boolean disableMods(Stack<File> mods){		
		
		while(!mods.isEmpty()){
			disableMod(mods.pop());
		}
		return true;
		
	}
	public boolean enableMod(File mod){
		
		if(!isDisabled(mod) || !(mod.getName().endsWith(".dll") || mod.getName().endsWith(".offz"))){
			System.out.println("Disabling and enabling of Scripts is not supported yet");
			return false;
		}
		
		
		renameFileExtention(mod.getPath(),".dll");
		
		
		System.out.println(mod.getName() + " Has Been Enabled.");
		
		return true;
	}
	public boolean enableMods(Stack<File> mods){
		
		while(!mods.isEmpty()){
			enableMod(mods.pop());
		}
		return true;
		
	}
	
	public boolean uninstallMod(File mod, boolean moveBack){ //if moveback is true, it will move the mod back to "Paste Mods Here" folder else it will delete it
		
		if(!moveBack){
		String s = mod.getPath();
			mod.delete();
			for(int i=0;i<installedMods.size();i++){
				if(installedMods.get(i).getPath().equals(s)){
					installedMods.remove(i);
				}
			}
			try {
				FileWriter fw = new FileWriter(installed,false);
				for(int i=0;i<installedMods.size();i++)
					fw.write(installedMods.get(i).getPath());
				
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(mod.getName()+" Has been Uninstalled Successfully!");
			
		}else{
			String s = mod.getPath();
			try {
				FileUtils.copyFileToDirectory(mod, f);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			new File(s).delete();
			System.out.println(mod.getName()+" Has been Uninstalled Successfully!");
		}
		
		return true;
	}
	public boolean uninstallMods(Stack<File> mods, boolean moveBack){
		
		while(!mods.isEmpty()){
			uninstallMod(mods.pop(),moveBack);
		}
		return false;
		
	}
	private ArrayList<File> loadFiles(){
		
		ArrayList<File> fileList = new ArrayList<File>();
		File dir = new File("C:\\Paste Mods Here");	
		
		FilenameFilter filter = new FilenameFilter() {
	        @Override
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
