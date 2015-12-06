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
	public static Stack<File> toInstall = new Stack<File>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		createBat(false); //Change to True if using Jar File
		
		ModLoader loader = new ModLoader();
		System.out.println("Mods were Successfully Loaded!");
		System.out.println("1) Install Mods");
		System.out.println("2) Configure Installed Mods");
		System.out.println("\nWhat would you like to do?");
		String choi = s.nextLine();
		
		if(Integer.parseInt(choi) == 1){
		
		
		System.out.println("AVAILABLE MODS (Not Installed): ");
		loader.printFiles();
		System.out.println("\nWhich Mods would you like to install? (Enter number and Seperate by commas)");
		String choice = s.nextLine();
		//parse input
		
		
		
		
		}


	}
	public static void createBat(boolean flag) throws IOException{
		
		if(flag)
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
