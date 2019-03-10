package al_sem2_labBinaryTree;

/*
 *  Java Program to Implement Binary Tree
 */

import java.util.Scanner;

import com.sun.swing.internal.plaf.basic.resources.basic;

public class BinaryTree {

	Node root;

	public void addNode(int key/*, String name*/) {

		// Create a new Node and initialize it

		Node newNode = new Node(key/*, name*/);

		// If there is no root this becomes root

		if (root == null) {

			root = newNode;

		} else {

			// Set root as the Node we will start
			// with as we traverse the tree

			Node focusNode = root;

			// Future parent for our new Node

			Node parent;

			while (true) {

				// root is the top parent so we start
				// there

				parent = focusNode;

				// Check if the new node should go on
				// the left side of the parent node

				if (key < focusNode.key) {

					// Switch focus to the left child

					focusNode = focusNode.leftChild;

					// If the left child has no children

					if (focusNode == null) {

						// then place the new node on the left of it

						parent.leftChild = newNode;
						return; // All Done

					}

				} else { // If we get here put the node on the right

					focusNode = focusNode.rightChild;

					// If the right child has no children

					if (focusNode == null) {

						// then place the new node on the right of it

						parent.rightChild = newNode;
						return; // All Done

					}

				}

			}
		}

	}

	// All nodes are visited in ascending order
	// Recursion is used to go to one node and
	// then go to its child nodes and so forth

	public void inOrderTraverseTree(Node focusNode) {

		if (focusNode != null) {

			// Traverse the left node

			inOrderTraverseTree(focusNode.leftChild);

			// Visit the currently focused on node

			System.out.print(focusNode);

			// Traverse the right node

			inOrderTraverseTree(focusNode.rightChild);

		}

	}

	public void preorderTraverseTree(Node focusNode) {

		if (focusNode != null) {

			System.out.print(focusNode);

			preorderTraverseTree(focusNode.leftChild);
			preorderTraverseTree(focusNode.rightChild);

		}

	}

	public void postOrderTraverseTree(Node focusNode) {

		if (focusNode != null) {

			postOrderTraverseTree(focusNode.leftChild);
			postOrderTraverseTree(focusNode.rightChild);

			System.out.print(focusNode);

		}

	}

	public Node findNode(int key) {

		// Start at the top of the tree

		Node focusNode = root;

		// While we haven't found the Node
		// keep looking

		while (focusNode.key != key) {

			// If we should search to the left

			if (key < focusNode.key) {

				// Shift the focus Node to the left child

				focusNode = focusNode.leftChild;

			} else {

				// Shift the focus Node to the right child

				focusNode = focusNode.rightChild;

			}

			// The node wasn't found

			if (focusNode == null) {
				return null;
			}

		}

		return focusNode;

	}

	/* function to count the nodes which are leaves*/	
	public int countLeaves(Node focusNode) {

		if (focusNode == null) {
			return 0;
		}

		if(isALeaf(focusNode)) {
			return 1;
		}

		else {
			return countLeaves(focusNode.leftChild) + countLeaves(focusNode.rightChild);
		}

	}

	/* function to check if a node is a leaf */
	public boolean isALeaf(Node focusNode) {

		if (focusNode == null) {
			return false;
		}

		if (focusNode.leftChild == null && focusNode.rightChild == null) {
			return true;
		}

		else {
			return false;
		}

	}

	/* function to count the nodes have only one child*/	
	public int countNodesWithOneChild (Node focusNode) {

		if (focusNode == null) {
			return 0;
		}		

		if(hasOneChild(focusNode)) {
			return 1;
		}
		else {
			return countNodesWithOneChild(focusNode.leftChild) + countNodesWithOneChild(focusNode.rightChild);
		}

	}

	/* function to check if this node has only one child */
	public boolean hasOneChild(Node focusNode) {

		if (focusNode == null) {
			return false;
		}

		if ((focusNode.leftChild == null && focusNode.rightChild != null) 
				|| (focusNode.leftChild != null && focusNode.rightChild == null)) {
			return true;
		}

		else {
			return false;
		}

	}

	/* function to find maximum node */
	public Node maxNode(Node focusNode) {

		if (focusNode == null) {
			return null;
		}

		if (focusNode.rightChild == null) {			
			return focusNode;			
		}

		else {			
			return maxNode(focusNode.rightChild);			
		}

	}

	/* function to find minimum node */
	public Node minNode(Node focusNode) {

		if (focusNode == null) {
			return null;
		}

		if (focusNode.leftChild == null) {			
			return focusNode;			
		}

		else {			
			return minNode(focusNode.leftChild);			
		}

	}

	/* function to delete a node*/
	public boolean remove(int key) {

		// Start at the top of the tree

		Node focusNode = root;
		Node parent = root;

		// When searching for a Node this will
		// tell us whether to search to the
		// right or left

		boolean isItALeftChild = true;

		// While we haven't found the Node
		// keep looking

		while (focusNode.key != key) {

			parent = focusNode;

			// If we should search to the left

			if (key < focusNode.key) {

				isItALeftChild = true;

				// Shift the focus Node to the left child

				focusNode = focusNode.leftChild;

			} else {

				// Greater than focus node so go to the right

				isItALeftChild = false;

				// Shift the focus Node to the right child

				focusNode = focusNode.rightChild;

			}

			// The node wasn't found

			if (focusNode == null)
				return false;

		}

		// If Node doesn't have children delete it

		if (focusNode.leftChild == null && focusNode.rightChild == null) {

			// If root delete it

			if (focusNode == root)
				root = null;

			// If it was marked as a left child
			// of the parent delete it in its parent

			else if (isItALeftChild)
				parent.leftChild = null;

			// Vice versa for the right child

			else
				parent.rightChild = null;

		}

		// If no right child

		else if (focusNode.rightChild == null) {

			if (focusNode == root)
				root = focusNode.leftChild;

			// If focus Node was on the left of parent
			// move the focus Nodes left child up to the
			// parent node

			else if (isItALeftChild)
				parent.leftChild = focusNode.leftChild;

			// Vice versa for the right child

			else
				parent.rightChild = focusNode.leftChild;

		}

		// If no left child

		else if (focusNode.leftChild == null) {

			if (focusNode == root)
				root = focusNode.rightChild;

			// If focus Node was on the left of parent
			// move the focus Nodes right child up to the
			// parent node

			else if (isItALeftChild)
				parent.leftChild = focusNode.rightChild;

			// Vice versa for the left child

			else
				parent.rightChild = focusNode.rightChild;

		}

		// Two children so I need to find the deleted nodes
		// replacement

		else {

			Node replacement = getReplacementNode(focusNode);

			// If the focusNode is root replace root
			// with the replacement

			if (focusNode == root)
				root = replacement;

			// If the deleted node was a left child
			// make the replacement the left child

			else if (isItALeftChild)
				parent.leftChild = replacement;

			// Vice versa if it was a right child

			else
				parent.rightChild = replacement;

			replacement.leftChild = focusNode.leftChild;

		}

		return true;

	}

	public Node getReplacementNode(Node replacedNode) {

		Node replacementParent = replacedNode;
		Node replacement = replacedNode;

		Node focusNode = replacedNode.rightChild;

		// While there are no more left children

		while (focusNode != null) {

			replacementParent = replacement;

			replacement = focusNode;

			focusNode = focusNode.leftChild;

		}

		// If the replacement isn't the right child
		// move the replacement into the parents
		// leftChild slot and move the replaced nodes
		// right child into the replacements rightChild

		if (replacement != replacedNode.rightChild) {

			replacementParent.leftChild = replacement.rightChild;
			replacement.rightChild = replacedNode.rightChild;

		}

		return replacement;

	}


	public static void main(String[] args) {

		BinaryTree theTree = new BinaryTree();

		theTree.addNode(60);
		theTree.addNode(70);
		theTree.addNode(20);
		theTree.addNode(10);
		theTree.addNode(40);
		theTree.addNode(50);
		theTree.addNode(30);
		theTree.addNode(90);

		// Different ways to traverse binary trees
		System.out.println("Root "+theTree.root);

		System.out.println("Inorder Traversal");
		theTree.inOrderTraverseTree(theTree.root);

		System.out.println("\nPreorder Traversal");
		theTree.preorderTraverseTree(theTree.root);

		System.out.println("\nPostorder Traversal");
		theTree.postOrderTraverseTree(theTree.root);

		// Find the node with key 75

		System.out.println("\nNode with the key 10");

		System.out.println(theTree.findNode(10));

		System.out.println("This tree has "
				+theTree.countLeaves(theTree.root)
				+" leaves");

		System.out.println("There are "
				+theTree.countNodesWithOneChild(theTree.root)
				+" node who have only one child");

		System.out.println("The MAX node is " + theTree.maxNode(theTree.root));
		System.out.println("The MIN node is " + theTree.minNode(theTree.root));

		System.out.println("Remove 20 "+ theTree.remove(60));
		System.out.println("Inorder Traversal");
		theTree.inOrderTraverseTree(theTree.root);

	}
}

class Node {

	int key;

	Node leftChild;
	Node rightChild;

	Node(int key/*, String name*/) {

		this.key = key;

	}

	public String toString() {

		return "->" + key;

		/*
		 * return name + " has the key " + key + "\nLeft Child: " + leftChild +
		 * "\nRight Child: " + rightChild + "\n";
		 */

	}

}