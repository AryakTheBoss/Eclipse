/**
 * 
 */
package butthole;

/**
 * @author 17ap0497
 *
 */
public class Path {
	
	private double tollCost = 0;
	private int distance = 0;
	private int estimatedTime = 0;
	private String endPoint = "";
	
	public Path(double tolls, int dis, int time,String end){
		
		tollCost = tolls;
		distance = dis;
		estimatedTime = time;
		endPoint = end;
		
	}

	public String getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}

	public double getTollCost() {
		return tollCost;
	}

	public void setTollCost(double tollCost) {
		this.tollCost = tollCost;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getEstimatedTime() {
		return estimatedTime;
	}

	public void setEstimatedTime(int estimatedTime) {
		this.estimatedTime = estimatedTime;
	}

}
