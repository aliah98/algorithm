package al_sem2_lab3;

public class LinkedList {
	public Node head;
	public Node tail;
	public int size;
	public int integer;
	public LinkedList next;

	public LinkedList(int integer, LinkedList dd) {
		super();
		this.head = null;
		this.tail = null;
		this.integer = integer;
		
		this.size = 0;
	}

	public LinkedList() {
		// TODO Auto-generated constructor stub
		head = null;
		tail = null;
		size = 0;
	}

	public int getInteger() {
		return integer;
	}

	public void setInteger(int integer) {
		this.integer = integer;
	}

	public LinkedList getNext() {
		return next;
	}

	public void setNext(LinkedList next) {
		this.next = next;
	}

	public boolean isEmpty() {
		System.out.println("\nCheck emptiness");
		if(head == null){
			System.out.println("\nIs Empty");
		}
		else {
			System.out.println("\nIs Not empty");
		}
		
		return (head == null);
	}

	public int getSize() {
		return size;
	}

	public void insertFirstNode(int integer) {
		Node newNode = new Node(integer);
		size++;
		if (head == null) {
			head = newNode;
			tail = head;
		}
		else {

			newNode.setNext(head);
			head=newNode;
		}
	}
	
	public int deleteFirst() {
		Node temp = head;
		head = head.getNext();
		size--;
		int tempVal = temp.getInt();
		return tempVal;
	}

	public void insertLastNode(int key) {
		
		Node newNode = new Node(key);
		if (head == null) {
			head = newNode;
			tail = head;
			return;
		}
		
		tail.setNext(newNode);
		tail=newNode;
		
	}

	public void insertOrderedNode(int key)
	{
		Node newNode = new Node(key);
		size++;
		Node current = head;
		Node previous = head;
		if (head == null) {
			head = newNode;
			tail = head;
			return;
		}
		
		if(head.getInt()>key){
			insertFirstNode(key);
			return;
		}
		
		while((current != null) && (current.getInt()<key)) {
			previous = current;
			current = current.getNext();
		}
		newNode.setNext(current);
		previous.setNext(newNode);
		
	}

	public void displayLinkedList(){
		System.out.println("\n" + getInteger()+ "----------------");
		
		if (head == null) {
			System.out.print("linklist empty\n");
			return;
		}
		if (head.getNext() == null) 
		{
			head.displayNode();
			return;
		}
		Node current = head;
		while(current != null) {
			current.displayNode();
			current = current.getNext();
		}
	}

	
	public Node find(int k) // find Node with given key
	{ // (assumes non-empty list)
		Node current = head; // start at ‘first node’
		while(current.getInt() != k) // while no match,
		{
			if(current.getNext() == null) // if end of list,
				return null; // didn’t find it
			else // not end of list,
				current = current.getNext(); // go to next node
		}
		return current; // found it
	}
	
	public boolean findExist(int k) // find Node with given key
	{ // (assumes non-empty list)
		Node current = head; // start at ‘first node’
		while(current.getInt() != k) // while no match,
		{
			if(current.getNext() == null) // if end of list,
				return false; // didn’t find it
			else // not end of list,
				current = current.getNext(); // go to next node
		}
		return true; // found it
	}
}
