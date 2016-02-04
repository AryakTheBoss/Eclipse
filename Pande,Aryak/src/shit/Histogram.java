package shit;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;



public class Histogram
{
	private Map<String,Integer> histogram = new TreeMap<String,Integer>();

	public Histogram()
	{
		
	}

	public Histogram(String sent)
	{
		setSentence(sent);
	}
	
	public void setSentence(String sent)
	{
		histogram.clear();
		String[] list = sent.split(" ");
		for(String s : list){
			
			if(histogram.containsKey(s)){
				histogram.put(s, histogram.get(s)+1); 
			}else{
				histogram.put(s, 1);
			}		
			
		}
		
		
		
	}

	public String toString()
	{
		String output="char";
		
		
		Iterator<String> i = histogram.keySet().iterator();
		String key = null;
		while(i.hasNext()){
			key = i.next();
			output += "\n"+key.toString()+"\t"+getStars(histogram.get(key));			
			
		}
	
		
		
		
		
		
		
		
		
		
		
		return output+"\n\n";
	}
	public String getStars(int num){
		String output = "";
		for(int i=1;i<=num;i++){
			output += "*";
		}
		return output;
	}
}