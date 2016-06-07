package ctf;

import java.io.File;

public class SqT {
/*
 * 	=	[((1+sqrt(2))^(2n)-(1-sqrt(2))^(2n))/(4sqrt(2))]^2	
(10)
	=	1/(32)[(17+12sqrt(2))^n+(17-12sqrt(2))^n-2].
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("C:\\Users\\17ap0497\\Downloads\\keiths_random_nightmare.bin");
		//double lol = (1/32)*(Math.pow((17+(12*Math.sqrt(2))), 1000000)+Math.pow((17-(12*Math.sqrt(2))), 1000000-2));
	//	System.out.println(lol);
		f.renameTo(new File("C:\\Users\\17ap0497\\Downloads\\keiths_random.nightmare.exe"));
	}

}
