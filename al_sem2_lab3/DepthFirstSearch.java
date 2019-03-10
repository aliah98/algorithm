package al_sem2_lab3;

public class DepthFirstSearch {

	public char top;

	public DepthFirstSearch() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void doDFS(GraphList gl) {
		if(gl.isEmpty()) {

			System.out.println("You are working with an empty list!");
			return;
		}
		//Create a stack
		Stack s = new Stack();

		//Create a linked list to keep a record of which vertices have been visited
		LinkedList v = new LinkedList();

		//which linked list we are currently in
		LinkedList currentLinkList = new LinkedList();

		currentLinkList = gl.head;

		//insert(push) the first vertex onto the stack
		s.push(currentLinkList.getInteger());

		s.display();

		//mark the node which has been pushed as visited
		v.insertFirstNode(currentLinkList.getInteger());

		//While the stack s is not empty
		while(!s.isEmpty()) {

			//look at the top of the stack
			int topu = s.peek();
			
			//find the linked list with int value same as top of stack 
			currentLinkList = gl.find(topu);

			//set the value of currentNode to that of the first node in that linked list
			Node currentNode = currentLinkList.head;

			//traverse the linked list up till currentNode not null
			while(currentNode != null) {

				//see if the current node exists in the visited list v
				//boolean isPresentInVisited

				//the current node has not been visited
				//not found in the visited list
				if(v.find(currentNode.getInt()) == null) {

					//add the value of the current node to the list of visited vertex
					v.insertOrderedNode(currentNode.getInt());

					System.out.print("\nAdd the unvisited neighbour to the list");
					v.displayLinkedList();

					//push the vertex current node onto the stack
					s.push(currentNode.getInt());

					System.out.print("\nThere is an unvisited neighbour! Add to stack");
					s.display();

					//break this loop
					break;
				}


				//the next node after this one is null in the current linked list
				//did not have an unvisited neighbour
				if (currentNode.getNext() == null) {

					//pop the stack
					s.pop();

					System.out.print("\nNo unvisited neighbours, pop stack");
					s.display();
				}

				//set currentNode to the next node to continue the loop
				currentNode = currentNode.getNext();

			}

		}

	}

}
