package al_sem2_lab3;


public class GraphList {

	public LinkedList head;
	public LinkedList tail;
	public int size;

	GraphList() { 
		head = null;
		tail = null;
	} 

	public boolean isEmpty() {
		return (head == null);
	}

	public void insertFirst(int integer) {
		LinkedList newLinkedList = new LinkedList(integer, null);

		size++;
		if (head == null) {
			head = newLinkedList;
			tail = head;
		}
		else {

			newLinkedList.setNext(head);
			head=newLinkedList;
		}
	}

	public int deleteFirst() {
		LinkedList temp = head;
		head = head.getNext();
		int tempVal = temp.getInteger();
		size--;
		return tempVal;
	}

	public void displayList(){
		if (head == null) {
			System.out.print("empty\n");
			return;
		}
		if (head.getNext() == null) 
		{
			head.displayLinkedList();
			return;
		}
		LinkedList current = head;
		while(current != null) {
			current.displayLinkedList();
			current = current.getNext();
		}
	}

	/*public void insertOrdered(int k, LinkedList dd)
	{
		//make new LinkedList
		LinkedList newLinkedList = new LinkedList(k, dd);
		if(head==null) {//If list is empty newLinkedList will be the first LinkedList
			head=newLinkedList;
		}
		else if(head.getInteger()>k)
			//first element in list has key value greater than k
			//No need to check other LinkedLists because the newLinkedList
			//will come at the beginning of list
			insertFirst(k);
		else {
			//New LinkedList will go somewhere in the middle of the list
			LinkedList current = head; // start at ‘first LinkedList’
			LinkedList previous=current;
			while((current!=null)&&(current.getInteger()<k)) {
				previous=current;
				current=current.getNext();
			}
			newLinkedList.setNext(current);
			previous.setNext(newLinkedList);
		}
		size++;
	}*/

	public void insertOrdered(int key)
	{
		LinkedList newLinkedList = new LinkedList(key, null);
		size++;
		LinkedList current = head;
		LinkedList previous = head;
		if (head == null) {
			head = newLinkedList;
			tail = head;
			
			System.out.println("Soem nuevo " + newLinkedList.getInteger());
			return;
		}
		if(head.getInteger()>key){
			insertFirst(key);
			System.out.println("Soem nuevo at first " + newLinkedList.getInteger());
			return;
		}


		while((current != null)/* && (current.getInteger()<key)*/) {
			previous = current;
			current = current.getNext();
		}
		//newLinkedList.setNext(current);
		previous.setNext(newLinkedList);
		System.out.println("Soem nuevo ? " + newLinkedList.getInteger());
		
		//Scanner s = new Scanner(System.in);
		//System.out.println("SID: ");
		//int sid = s.nextInt();


	}

	public void insertOrderedNode(int key, int keyL) 
	{

		LinkedList current = head;
		LinkedList previous = head;
		//People previous = peopleFirst;
		if(head == null) {
			System.out.println("No one at all here g76");
			return;
		}
		boolean exists = true;
		while(previous.getInteger() != key) {

			if(previous.getNext() == null) {
				System.out.println("\nNo one like your friend g82");
				exists = false;
				break;
			}
			else {
				previous = previous.getNext();
			}

		}		
		while(current.getInteger() != keyL ) {

			if(current.getNext() == null) {
				System.out.println("\nNo " + keyL);
				exists = false;
				return;
			}
			else {
				current = current.getNext();
			}

		}
		if (exists == true) {
			previous.insertOrderedNode(keyL);
			current.insertOrderedNode(key);
		}		

	}

	public LinkedList find(int k) // find LinkedList with given key
	{ // (assumes non-empty list)
		LinkedList current = head; // start at ‘first LinkedList’
		while(current.getInteger() != k) // while no match,
		{
			if(current.getNext() == null) // if end of list,
				return null; // didn’t find it
			else // not end of list,
				current = current.getNext(); // go to next LinkedList
		}
		return current; // found it
	}
}
