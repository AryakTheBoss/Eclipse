/**
 * 
 */
package commercial;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;


/**
 * @author Aryak
 *
 */
public class Runner {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static Scanner s = new Scanner(System.in);
	public static Stack<File> toInstall = new Stack<File>(); //TODO use MOD class
	public static Stack<File> toUninstall = new Stack<File>();
	public static Stack<File> toEnable = new Stack<File>();
	public static Stack<File> toDisable = new Stack<File>();
	public static void main(String[] args) throws IOException {
		
		// TODO Auto-generated method stub
		
		createBat(false); //Change to True if using Jar File
		
		ModLoader loader = new ModLoader();
		//System.out.println(loader.disableMod(new File("H:\\qn.txt")));
		
		
		System.out.println("Mods were Successfully Loaded!");
		System.out.println("1) Install Mods");
		System.out.println("2) Configure Installed Mods");
		System.out.println("\nWhat would you like to do?");
		String choi = s.nextLine();
		
		if(Integer.parseInt(choi) == 1){
		
		
		System.out.println("AVAILABLE MODS (Not Installed): ");
		loader.printAvailableMods();
		System.out.println("\nWhich Mods would you like to install? (Enter numbers and Seperate by commas)");
		String choice = s.nextLine();
		//parse input
		String[] pickedIndecies = choice.split(",");
		
		if(pickedIndecies.length == 1){
			try{
			loader.installMod(loader.getAvailableModAtIndex(Integer.parseInt(pickedIndecies[0])-1));
			}catch (IllegalArgumentException e){
				System.err.println("Illegal Index!");
			}
		}else{
		
		for(int i=0;i<pickedIndecies.length;i++){
			
			try{
			toInstall.push(loader.getAvailableModAtIndex(Integer.parseInt(pickedIndecies[i])-1));
			}catch (IllegalArgumentException e){
				System.err.println("Illegal Index Found! Skipping it...");
			}
			
		}
		loader.installMods(toInstall);  
		
		}
		
		}else if(Integer.parseInt(choi) == 2){
			
			System.out.println("Installed Mods: ");
			loader.printInstalledMods();
			System.out.println("\nWhich Mods would you like to configure? (Enter numbers and Seperate by commas)");
			String choice = s.nextLine();
			String[] pickedIndecies = choice.split(",");
			
			if(pickedIndecies.length == 1){
				System.out.println("1) Enable");
				System.out.println("2) Disable");
				System.out.println("3) Uninstall");				
				System.out.println("\nWhat do you want to do with "+"that mod"+"? (Enter numbers and Seperate by commas)");
				String choice2 = s.nextLine();
				if(Integer.parseInt(choice2) == 1){
					try{
					if(!loader.isDisabled(loader.getInstalledModAtIndex(Integer.parseInt(pickedIndecies[0])-1))){
						System.err.println("Mod is already Enabled!");
					}else					
					loader.enableMod(loader.getInstalledModAtIndex(Integer.parseInt(pickedIndecies[0])-1));
					
					}catch (IllegalArgumentException e){
						System.err.println("Illegal Index!");
					}
				}else if(Integer.parseInt(choice2) == 2){
					
					try{
						if(loader.isDisabled(loader.getInstalledModAtIndex(Integer.parseInt(pickedIndecies[0])-1))){
							System.err.println("Mod is already Disabled!");
						}else						
						loader.disableMod(loader.getInstalledModAtIndex(Integer.parseInt(pickedIndecies[0])-1));
						
						}catch (IllegalArgumentException e){
							System.err.println("Illegal Index!");
						}
					
				}else if(Integer.parseInt(choice2) == 3){
					try{
						
					if(loader.isDisabled(loader.getInstalledModAtIndex(Integer.parseInt(pickedIndecies[0])-1))){
						System.err.println("Mod Must be enabled to uninstall! Mod will be enabled automatically");
						loader.enableMod(loader.getInstalledModAtIndex(Integer.parseInt(pickedIndecies[0])-1));
						System.err.println("Enabled!");
					}
					System.out.println("How would you like to uninstall this mod?");
					System.out.println("1) Delete it");
					System.out.println("2) Move back to Paste folder");
					String uchoice = s.nextLine();
					if(Integer.parseInt(uchoice) == 1)
						loader.uninstallMod(loader.getInstalledModAtIndex(Integer.parseInt(pickedIndecies[0])-1), false);
					else
						loader.uninstallMod(loader.getInstalledModAtIndex(Integer.parseInt(pickedIndecies[0])-1), true);
					}catch (IllegalArgumentException e){
						System.err.println("Illegal Index!");
					}
					
				}
				
			}else{
				System.out.println("1) Enable");
				System.out.println("2) Disable");
				System.out.println("3) Uninstall");				
				System.out.println("\nWith these mods, What do you want to do? (Enter numbers and Seperate by commas)");
				String choice2 = s.nextLine();
				
				if(Integer.parseInt(choice2) == 1){
					
					for(int i=0;i<pickedIndecies.length;i++){
						
						try{
						toEnable.push(loader.getInstalledModAtIndex(Integer.parseInt(pickedIndecies[i])-1));
						}catch (IllegalArgumentException e){
							System.err.println("Illegal Index Found! Skipping it...");
						}
						
					}
					loader.enableMods(toEnable);
					
				}else if(Integer.parseInt(choice2) == 2){
					
					for(int i=0;i<pickedIndecies.length;i++){
						
						try{
						toDisable.push(loader.getInstalledModAtIndex(Integer.parseInt(pickedIndecies[i])-1));
						}catch (IllegalArgumentException e){
							System.err.println("Illegal Index Found! Skipping it...");
						}
						
					}
					loader.disableMods(toDisable);
					
				}else if(Integer.parseInt(choice2) == 3){
					

					System.out.println("How would you like to uninstall these mods?");
					System.out.println("1) Delete it");
					System.out.println("2) Move back to Paste folder");
					String uchoice = s.nextLine();
					boolean flag = false;
					try{
					if(Integer.parseInt(uchoice) == 1)
						flag = false;
					else
						flag = true;
					}catch (IllegalArgumentException e){
						System.err.println("Illegal Index!");
					}
						for(int i=0;i<pickedIndecies.length;i++){
							
							try{
								if(loader.isDisabled(loader.getInstalledModAtIndex(Integer.parseInt(pickedIndecies[i])-1))){
									System.err.println("Mod Must be enabled to uninstall! Mod will be enabled automatically");
									loader.enableMod(loader.getInstalledModAtIndex(Integer.parseInt(pickedIndecies[i])-1));
									System.err.println("Enabled!");
								}
							toUninstall.push(loader.getInstalledModAtIndex(Integer.parseInt(pickedIndecies[i])-1));
							}catch (IllegalArgumentException e){
								System.err.println("Illegal Index Found! Skipping it...");
							}
							
						}
						loader.uninstallMods(toUninstall,flag);
					
					
				}
				
			}
			
		}


	}
	public static void createBat(boolean flag) throws IOException{
		
		if(!flag)
			return;
		
	File f = new File("run.bat");
	
	if(!f.exists()){
		f.createNewFile();
	
	FileWriter fw = new FileWriter(f);
	fw.write("echo Loading Directories....\njava -jar ModControl.jar");
	fw.close();
	}
	
	
	
	}
	

}
