package chapapap;

import java.util.Random;
import java.util.ArrayList;

public class MyArrayListTest
{
	public static void main(String[] args)
	{
		testRandom(10000, false);
		
		
		
	}

	/**
	 * @param runs
	 *            the number of times to run a random method
	 * @param outputMethodCalls
	 *            true to output all method calls and results, false to output only failed calls
	 */
	private static void testRandom(int runs, boolean outputMethodCalls)
	{
		System.out.println("Start");

		MyArrayList<Integer> a = new MyArrayList<Integer>(25);
		ArrayList<Integer> j = new ArrayList<Integer>(25);

		Random rand = new Random();

		for (int i = 0; i < runs; i++)
		{
			switch (rand.nextInt(9))
			{
				case 0:
					if (outputMethodCalls)
						System.out.println(i + " size()");
					int aSize,
					jSize;
					aSize = a.size();
					jSize = j.size();
					if (aSize != jSize)
						System.err.println("a.size(): " + aSize + " j.size(): " + jSize);
					if (outputMethodCalls)
						System.out.println();
					break;

				case 1: //Broken
					Object aGet, 
					jGet;
					int getIndex = rand.nextInt(25);
					if (outputMethodCalls)
						System.out.println(i + " get(" + getIndex + ")");
					try
					{
						aGet = a.get(getIndex);
					}
					catch (IndexOutOfBoundsException e)
					{
						aGet = -999;
					}
					try
					{
						jGet = j.get(getIndex);
					}
					catch (IndexOutOfBoundsException e)
					{
						jGet = -999;
					}
				
					if (!aGet.equals(jGet))
						System.err.println("a.get(" + getIndex + "): " + aGet + " j.get(" + getIndex + "): " + jGet);
					if (outputMethodCalls)
						System.out.println();
					break;

				case 2:
					int setIndex = rand.nextInt(25),
					setValue = rand.nextInt(100);
					Object aSet,
					jSet;
					if (outputMethodCalls)
						System.out.println(i + " set(" + setIndex + ", " + setValue + ")");
					try
					{
						aSet = a.set(setIndex, setValue);
					}
					catch (IndexOutOfBoundsException e)
					{
						aSet = -999;
					}
					try
					{
						jSet = j.set(setIndex, setValue);
					}
					catch (IndexOutOfBoundsException e)
					{
						jSet = -999;
					}

					if (!aSet.equals(jSet))
						System.err.println("a.set(" + setIndex + ", " + setValue + "): " + aSet + " j.set(" + setIndex + ", " + setValue + "): " + jSet);
					if (outputMethodCalls)
						System.out.println();
					break;

				case 3:
					int containsValue = rand.nextInt(100);
					boolean aContains,
					jContains;
					if (outputMethodCalls)
						System.out.println(i + " contains(" + containsValue + ")");
					aContains = a.contains(containsValue);
					jContains = j.contains(containsValue);
					if (aContains != jContains)
						System.err.println("a.contains(" + containsValue + "): " + aContains + " j.contains(" + containsValue + "): " + jContains);
					if (outputMethodCalls)
						System.out.println();
					break;

				case 4:
					if (outputMethodCalls)
						System.out.println(i + " trimToSize()");
					a.trimToSize();
					j.trimToSize();
					if (outputMethodCalls)
						System.out.println();
					break;

				case 5:
					int addValue = rand.nextInt(100);
					if (outputMethodCalls)
						System.out.println(i + " add(" + addValue + ")");
					a.add(addValue);
					j.add(addValue);
					if (outputMethodCalls)
						System.out.println();
					break;

				case 6:
					int addIndex = rand.nextInt(25);
					int addValue1 = rand.nextInt(100);
					boolean aThrowsException = false;
					boolean jThrowsException = false;
					if (outputMethodCalls)
						System.out.println(i + " add(" + addIndex + ", " + addValue1 + ")");
					try
					{
						a.add(addIndex, addValue1);
					}
					catch (IndexOutOfBoundsException e)
					{
						aThrowsException = true;
					}
					try
					{
						j.add(addIndex, addValue1);
					}
					catch (IndexOutOfBoundsException e)
					{
						jThrowsException = true;
					}
					if (aThrowsException != jThrowsException)
						System.err.println("a.add(" + addIndex + ", " + addValue1 + ") (throws exception): " + aThrowsException + " j.add(" + addIndex + ", "
								+ addValue1 + ") (throws exception): " + jThrowsException);
					if (outputMethodCalls)
						System.out.println();
					break;

				case 7:
					int removeIndex = rand.nextInt(25);
					Object aRemove,
					jRemove;
					if (outputMethodCalls)
						System.out.println(i + " remove(" + removeIndex + ")");
					try
					{
						aRemove = a.remove(removeIndex);
					}
					catch (IndexOutOfBoundsException e)
					{
						aRemove = -999;
					}
					try
					{
						jRemove = j.remove(removeIndex);
					}
					catch (IndexOutOfBoundsException e)
					{
						jRemove = -999;
					}

					if (!aRemove.equals(jRemove))
						System.err.println("a.remove(" + removeIndex + "): " + aRemove + " j.remove(" + removeIndex + "): " + jRemove);
					if (outputMethodCalls)
						System.out.println();
					break;

				case 8:
					int removeObject = rand.nextInt(100);
					boolean aRemoveResult,
					jRemoveResult;
					if (outputMethodCalls)
						System.out.println(i + " remove(new Integer(" + removeObject + "))");
					aRemoveResult = a.remove(new Integer(removeObject));
					jRemoveResult = j.remove(new Integer(removeObject));
					if (aRemoveResult != jRemoveResult)
						System.err.println("a.remove(new Integer(" + removeObject + ")): " + aRemoveResult + " j.remove(new Integer(" + removeObject + ")): "
								+ jRemoveResult);
					if (outputMethodCalls)
						System.out.println();
					break;
			}
		}

		System.out.println("End");
	}
}
