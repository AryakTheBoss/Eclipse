package shit;
import static java.lang.System.*;
import java.util.*;

public class DupRunner
{
	public static void main( String args[] )
	{
		/*
		 * "a b c d e f g h a b c d e f g h i j k"

"one two three one two three six seven one two"

"1 2 3 4 5 1 2 3 4 5 1 2 3 4 5 6"
		 */
		System.out.println("Original List: "+"a b c d e f g h a b c d e f g h i j k");
		System.out.println("Uniques: "+UniquesDupes.getUniques("a b c d e f g h a b c d e f g h i j k"));
		System.out.println("Dupes: "+UniquesDupes.getDupes("a b c d e f g h a b c d e f g h i j k"));
		System.out.println("\n");
		System.out.println("Original List: "+"one two three one two three six seven one two");
		System.out.println("Uniques: "+UniquesDupes.getUniques("one two three one two three six seven one two"));
		System.out.println("Dupes: "+UniquesDupes.getDupes("one two three one two three six seven one two"));
		System.out.println("\n");
		System.out.println("Original List: "+"1 2 3 4 5 1 2 3 4 5 1 2 3 4 5 6");
		System.out.println("Uniques: "+UniquesDupes.getUniques("1 2 3 4 5 1 2 3 4 5 1 2 3 4 5 6"));
		System.out.println("Dupes: "+UniquesDupes.getDupes("1 2 3 4 5 1 2 3 4 5 1 2 3 4 5 6"));

	}
}