package commercial;

import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ModLoader {
	
	private static List<File> mods;
	private static String gtaDirectory;
	private static final String[] supportedFileTypes = {"dll","asi","lua","cs","vb"};
	
	
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
	
	private List<File> loadFiles(){
		
		List<File> fileList = new ArrayList<File>();
		File dir = new File(gtaDirectory);
		File[] files = dir.listFiles();
		fileList = Arrays.asList(files);
		
		for(int i=0;i<fileList.size();i++){
			
			if(fileList.get(i).isDirectory() || isMod(fileList.get(i)))
				fileList.remove(i);
			
		}
		
		
		return fileList;
		
	}
	private boolean isMod(File f){
		
		String extention = f.getName();
		extention = extention.substring(extention.indexOf(".")+1);
		
		for(String s : supportedFileTypes){
			
			if(s.equals(extention)){
				return true;
			}
			
		}
		return false;
		
		
	}
	

}
