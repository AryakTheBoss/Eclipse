package shit;
public class Part implements Comparable<Part>
{
	private String make, mode, rest;
	private int year;

	public Part(String line) 
	{
		String[] list = line.split(" ");

		make = list[3];
		mode = list[4];
		year = Integer.parseInt(list[5]);
		if(list[0].equals("Radiator"))
		rest = list[0]+" "+list[1];
		else
			rest = list[0]+" "+list[1]+" "+list[2];
	}

	//have to have compareTo if implements Comparable
	public int compareTo( Part rhs )
	{

		if(make.compareTo(rhs.getMake()) == 1)			
			return 1;
		else if(make.compareTo(rhs.getMake()) == -1)
			return -1;
		else if(make.compareTo(rhs.getMake()) == 0){
			
			if(mode.compareTo(rhs.getMode()) == 1)
				return 1;
			else if(mode.compareTo(rhs.getMode()) == -1)
				return -1;
			else if(mode.compareTo(rhs.getMode()) == 0){
				
				if(year < rhs.getYear())
					return -1;
				else if(year > rhs.getYear())
					return 1;
				else
					return 0;
				
			}
			
		}
			
			
	
		throw new IllegalStateException("You Suck");


		
	}

	public String getMake() {
		return make;
	}

	public String getMode() {
		return mode;
	}

	public String getRest() {
		return rest;
	}

	public int getYear() {
		return year;
	}

	public String toString()
	{
		return make+" "+mode+" "+year+" "+rest;
	}
}