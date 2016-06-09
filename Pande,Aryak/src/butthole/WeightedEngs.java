package butthole;
//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -  
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.Scanner;

import static java.lang.System.*;

public class WeightedEngs
{
	private TreeMap<String, HashSet<Path>> map = new TreeMap<String, HashSet<Path>>();
	
	boolean match = false;
	int shortest = 0;
	Random r = new Random();


	public WeightedEngs(String line)
	{
		map = new TreeMap<String, HashSet<Path>>();
		String[] a = line.split(" ");
		for (int i = 1; i < a.length; i++) {
			int diss = r.nextInt(80)+1;
			if (map.containsKey(a[i].substring(0, 1))) {
				HashSet<Path> t = map.get(a[i].substring(0, 1));
				
				t.add(new Path(r.nextFloat(),diss,diss/45,a[i].substring(1)));
				map.put(a[i].substring(0, 1), t);
			} else {
				HashSet<Path> t = new HashSet<Path>();
				t.add(new Path(r.nextFloat(),diss,diss/45,a[i].substring(1)));
				map.put(a[i].substring(0, 1), t);
			}

			if (map.containsKey(a[i].substring(1))) {
				HashSet<Path> t = map.get(a[i].substring(1));
				t.add(new Path(r.nextFloat(),diss,diss/45,a[i].substring(0,1)));
				map.put(a[i].substring(1), t);
			} else {
				HashSet<Path> t = new HashSet<Path>();
				t.add(new Path(r.nextFloat(),diss,diss/45,a[i].substring(0,1)));
				map.put(a[i].substring(1), t);
			}
		}
	}

	public boolean contains(String letter)
	{
		return map.containsKey(letter);
	}

	public void check(String one, String two, ArrayList<Path> been, int steps)
	{
		if (map.get(one).contains(two)) {
			match = true;
			if (shortest == 0 || steps <= shortest)
				shortest = steps;
		} else {
			HashSet<Path> set = map.get(one);
			for (Path x : set){
				boolean add = false;
				if (!been.contains(x)) {
					add = true;
					been.add(x);
					check(x.getEndPoint(), two, been, steps + 1);
				}
				if(add)
					been.remove(x);
			}
		}
	}

	public String toString()
	{
		return "";
	}
}
