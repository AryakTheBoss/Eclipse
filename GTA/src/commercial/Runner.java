/**
 * 
 */
package commercial;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 * @author Aryak
 *
 */
public class Runner {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/*File f = new File("run.bat");
		if(!f.exists()){
			f.createNewFile();
		
		FileWriter fw = new FileWriter(f);
		fw.write("echo Loading Directories....\njava -jar ModControl.jar");
		fw.close();
		}*/
		File f = new File("C:\\RHDSetup.log");
		String extention = f.getName();
		extention = extention.substring(extention.indexOf(".")+1);
		System.out.println(f.getName());
		System.out.println(extention);


	}

}
