package dingyfart;//PalinListRunner.java

public class PalinListRunner
{
	public static void main ( String[] args )
	{
		PalinList jk = new PalinList();	
		jk.setList("one two three two one");
		System.out.println(jk +" is "+(jk.isPalin() ? "":"not")+" a  palinlist");
		jk.setList("1 2 3 4 5 one two three four five");
		System.out.println(jk +" is "+(jk.isPalin() ? "":"not")+" a  palinlist");
		jk.setList("a b c d e f g x y z g f h");
		System.out.println(jk +" is "+(jk.isPalin() ? "":"not")+" a  palinlist");
		jk.setList("racecar is racecar");
		System.out.println(jk +" is "+(jk.isPalin() ? "":"not")+" a  palinlist");
		jk.setList("1 2 3 a b c c b a 3 2 1");
		System.out.println(jk +" is "+(jk.isPalin() ? "":"not")+" a  palinlist");
		jk.setList("chicken is a chicken");		
		System.out.println(jk +" is "+(jk.isPalin() ? "":"not")+" a  palinlist");
	}
}