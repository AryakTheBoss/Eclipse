/**
 * 
 */
package doublell;

/**
 * @author 17ap0497
 *
 */
public class DListNode

{

    private Object value;

    private DListNode next;

    private DListNode previous;

    public DListNode(Object initValue, DListNode initNext, DListNode initPrev)

    {

        value= initValue;

        next = initNext; 

        previous = initPrev;

}
    public Object getValue(){
    	return value; 
    }
    public DListNode next(){
    	return next;
    }
    public DListNode previous(){
    	return previous;
    }
    public void setValue(Object value){
    	this.value = value;
    }
    public void setNext(DListNode node){
    	this.next = node;
    }
    public void setPrevious(DListNode node){
    	this.previous = node;
    }
}