package al_sem2_lab3;

import java.util.Queue;

public class BreadthFirstSearch {



	public void doBFS(GraphList gl) {

		if(gl.isEmpty()) {

			System.out.println("You are working with an empty list!");
			return;
		}

		//create the queue
		//Queue q = new Queue();
		Queue<Integer> q = new java.util.LinkedList<>();

		//Create a linked list to keep a record of which vertices have been visited
		LinkedList v = new LinkedList();

		//which linked list we are currently in
		LinkedList currentLinkList = new LinkedList();

		currentLinkList = gl.head;

		//insert the first vertex onto the queue
		//q.enQueue(currentLinkList.getInteger());
		q.add(currentLinkList.getInteger());

		System.out.println("Adding the first vertex to the queue");
		//q.displayQueue();
		System.out.println(q);

		/*//mark the node which has been enqueued as visited
		v.insertFirstNode(currentLinkList.getInteger());

		 */		System.out.println("\nVisited list with the first vertex");
		 v.displayLinkedList();

		 Node currentNode = currentLinkList.head;


		 System.out.println("Queue with unvisited neighbours");
		 //q.displayQueue();
		 System.out.println(q);

		 //while the queue is not empty
		 while(!q.isEmpty()) {

			 //remove top u of the queue
			 int topu = q.remove();//q.deQueue();

			 System.out.println("\nQueue with the head which has been removed");
			 //q.displayQueue();
			 System.out.println(q);

			 //remove the head from the list and add it to the visited list
			 v.insertOrderedNode(topu);

			 System.out.println("\nVisited list with the head which has been removed");
			 v.displayLinkedList();

			 //Go to the linked list of the head
			 currentLinkList = gl.find(topu);

			 currentNode = currentLinkList.head;

			 //look at the neighbours of this vertex, the top node
			 while(currentNode != null) {
				 System.out.println("NANI");

				 //find unvisited neighbours
				 //if neighbour is unvisited, add them to the queue
				 if(v.find(currentNode.getInt()) == null) {

					 boolean present = false;

					 for(int z = 0; z<q.size(); z++) {
						 if(q.contains(currentNode.getInt())) {
							 present = true;
							 break;
						 }
					 }

					 //SHOULD CHange sth HERE! TO CHECK IF VALUE EXISTS IN THE QUEUE
					 //add the neighbour to the queue
					 // q.enQueue(currentNode.getInt());

					 if(present == false) {
						 q.add(currentNode.getInt());

						 System.out.println("An unvisited node has been added to the queue");
					 }
					 // q.displayQueue();
					 System.out.println(q);


				 }

				 currentNode = currentNode.getNext();

			 }

			 System.out.println("\nQueue with the head removed + neighbours");
			 //q.displayQueue();
			 System.out.println(q);



			 /*currentLinkList = gl.find(topu);*/

		 }				

	}

}
