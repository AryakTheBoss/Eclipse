/**
 * 
 */
package authsrc;
import java.io.*;
/**
 * @author Aryak
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// The name of the file to create.
        String fileName = "C:\\jre\\temp1.bin";

        try {
            // Put some bytes in a buffer so we can
            // write them. Usually this would be
            // image data or something. Or it might
            // be unicode text.
            String bytes = "Hello there\n";
            byte[] buffer = bytes.getBytes();

            FileOutputStream outputStream =
                new FileOutputStream(fileName);

            // write() writes as many bytes from the buffer
            // as the length of the buffer. You can also
            // use
            // write(buffer, offset, length)
            // if you want to write a specific number of
            // bytes, or only part of the buffer.
            outputStream.write(buffer);

            // Always close files.
            outputStream.close();		

            System.out.println("Wrote " + buffer.length + 
                " bytes");
        }
        catch(IOException ex) {
            System.out.println(
                "Error writing file '"
                + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
    }

    }


	


