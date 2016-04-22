package doublell;

public class LLTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DLinkedList d = new DLinkedList();
		
		d.addFirst("go");
		d.addFirst("on");
		d.addLast("at");
		d.addFirst("34");
		d.addLast("2.1");
		d.addLast("-a-2-1");
		d.addFirst("up");		       		
		d.addFirst("over");
		d.addFirst("a");
		System.out.println(d.size());
		System.out.println(d);

	}

}
