package shit;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class SpanRunner
{
	/*
	 * yo quiero una ordenador virus
todas de los muchachos tienen interno memoria
mi pelo es cafe
tu quieres tinta con su papel
rearrancar el ordenador a vacio el pantalla
	 */
	public static void main( String args[] ) throws IOException
	{
		
		SpanishToEnglish ss = new SpanishToEnglish();
		
		out.println(ss+"\n");
		out.println(ss.translate("yo quiero una ordenador virus"));
		out.println(ss.translate("todas de los muchachos tienen interno memoria"));
		out.println(ss.translate("mi pelo es cafe"));
		out.println(ss.translate("tu quieres tinta con su papel"));
		out.println(ss.translate("rearrancar el ordenador a vacio el pantalla"));
		
		
	}
}