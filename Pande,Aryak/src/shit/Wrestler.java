/**
 * 
 */
package shit;

/**
 * @author 17ap0497
 *
 */
public class Wrestler {
	
	/**

     * Constructor for objects of class Wrestler

     */
	private String name = "";
	private int weight = 0;

    public Wrestler( String theName, int theWeight)

        

    {

        name= theName;

        weight=theWeight;

    }

    

    

    public int getWeight()

    {

        return weight;

    }

    

    public String getName()

    {

       

        return name;

    }

    public String toString()

    {

       

        return name + "  " +weight;

    }

}
