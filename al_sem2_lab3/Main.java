package al_sem2_lab3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//LinkedList g = new LinkedList();
		GraphList g = new GraphList();
		//g.isEmpty();
		System.out.println("Adding the nodes");
		g.insertOrdered(1);
		g.insertOrdered(2);
		g.insertOrdered(3);
		g.insertOrdered(4);
		g.insertOrdered(5);
		g.insertOrdered(6);
		g.isEmpty();
		g.displayList();

		System.out.println("\nAdding neighbours to the list");
		g.insertOrderedNode(1,3);
		g.insertOrderedNode(1,5);
		g.insertOrderedNode(3,2);
		g.insertOrderedNode(3,4);
		g.insertOrderedNode(2,6);
		g.insertOrderedNode(3,6);
		g.insertOrderedNode(4,6);
		g.insertOrderedNode(5,6);
		//g.displayLinkedList();
		g.displayList();

		System.out.println("\nChoose d for DFS and b for BFS");
		Scanner sc = new Scanner(System.in);
		String c = sc.next();


		if(c.equals("d")) {

			System.out.println("\nDfs will take place");
			DepthFirstSearch d = new DepthFirstSearch();

			d.doDFS(g);
		}
		else if(c.equals("b")) {

			System.out.println("BFS will take place");
			BreadthFirstSearch b = new BreadthFirstSearch();
			b.doBFS(g);
		}

	}

}
