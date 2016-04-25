package shit;

import java.util.HashMap;
import java.util.Map;

public class TeamMap {
	
	private Map<Integer,TeamSet> team = new HashMap<Integer,TeamSet>();
	private int changedWG = 0;
	public TeamMap(){
		
		
		
	}
	
	public void add(Wrestler w){
		
		if(team.get(group(w.getWeight())) != null)
		team.get(group(w.getWeight())).add(w);
		else{
			team.put(group(w.getWeight()), new TeamSet());
			team.get(group(w.getWeight())).add(w);
		}
		
	}

	public int group(int weight){
		
		return weight/10%10;
			
			
		
		
	}
	public void changeWeightGroup(Wrestler w, int group){
		
		int grup = group-1;
		changedWG = grup;
		team.get(group(w.getWeight())).remove(w);
		team.get(grup).add(w);
		
	}
	public String get(Wrestler w){
		
		return changedWG+"";
		
	}
	public String toString(){
		
		return team.toString();
		
	}
	
	
}
