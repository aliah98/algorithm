package al_sem2_lab3;

public class Node {
	public int integer;
	public Node next;
	public Node previous;
	
	public Node (int in/*, Node n*/) {
		integer = in;
		next = null;
		previous = null;
	}

	public void setNext(Node n) {
		next = n;
	}
	
	public Node getNext() {
		return next;
	}

	public int getInt() {
		return integer;
	}

	public void setInt(int integer) {
		this.integer = integer;
	}

	public void displayNode() {
		System.out.print("->" + integer);
	}
}
