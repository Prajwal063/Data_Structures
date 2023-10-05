package codeWithMosh;
		
import java.util.ArrayList;
		
public class BinaryTree {
		
	//REPRESENTING BINARY TREES
		
	public class Node {							//creating Node class just like in linked list implementation
				
		private Node leftChild;					//where root>node
		private Node rightChild;				//where root<node
		private int value;						//value of the node
		
		public Node(int value) {				//constructor to assign values to the node
			this.value=value;					//this keyword
		}	
		
		@Override								//overriding string, so that it displays directly in debugger console
		public String toString() {	
			return "Node=" + value;				//will display the value of node of this format in the debugger console
		}
	}	
			
	public Node root;							//initializing the root node
		
		
		
	public void insert(int value) {				//method to insert a node in the tree
		var node=new Node(value);
		
		if(root==null) {						//if tree is empty insert the node and initialize it to root
			root=node;
			return;								//return 'cause we need not to iterate all over
		}	
		
		var current=root;						//initialize the root with current node
		while(true) {							//infinite loop, 'cause we MUST find a parent for the node to be added, to know where we should insert the new node
			
			if(value<current.value) {			//if new node value to be inserted < root node value
				if(current.leftChild==null) {	//if left side of root node is empty;
					current.leftChild=node;		//then insert the new node as the leftChild
					break;						//return 'cause we need not to iterate all over
				}
				
				current=current.leftChild;		//initialize current to left subTree's root node (while condition syntax; like i++ in for loop)
			}
				
			else {
				if(current.rightChild==null) {	//if new node value to be inserted > root node value
					current.rightChild=node;	//then insert the new node as the rightChild	
					return;						//return 'cause we need not to iterate all over
				}
				current=current.rightChild;		//initialize current to right subTree's root node (while condition syntax; like i++ in for loop)
			}			
		}
	}	
		
		
	
	public boolean find(int value) {			//method to find node
		var current = root;						//initialize current to root node to iterate all over the tree
		
		while(current!=null) {					//not infinite loop 'cause; we might not have the node we find in tree; and also if tree is empty(i.e root==null) it won't enter ths loop itself, hence will return false immediately
			
			if(value<current.value)				//if value < current value
				current=current.leftChild;		//set current as left subTree's root node 
			
			else if(value>current.value)		//if value < current value
				current=current.rightChild;		//set current as left subTree's root node 
			
			else
				return true;					//only possiblity is that node is found; hence return true
		}
		return false;							//or come out of the loop and return false
	}	
		
		
	
	public void traversePreOrder() {			//outer method which calls the inner method, this method gets called in main class; so its public; and changing the code here wont affect the actual implementation of this method; the names of the outer and inner methods MUST BE SAME
		traversePreOrder(root);					//recursion as it starts from Root node; cause this isnt possible in the inner method i.e. in Implementation detail method
	}	
	
	private void traversePreOrder(Node root) {	//inner method which does all the work; ; hence its private [Implementation detail]
		if(root==null)							//base condition; necessary for Recursion implementation (syntax of recursion)
			return;
		
		System.out.println(root.value);			//print the node values as they traverse
		traversePreOrder(root.leftChild);		//once the root is traversed to left node(pre order), it continues in the sub tree and not the main tree; and hence goes left again[cause PreOrder => root, leftChild, rightChild ]
		traversePreOrder(root.rightChild);		//once node reach leaf node; hence reach base condition; it becomes null and traverse to the right node [Pre Order]
	}
	
	
	
	
	public void traverseInOrder() {				//This is to kick off recursioj taking place at the private or the implementation method
		traverseInOrder(root);
	}
	
	private void traverseInOrder(Node root) {
		if(root==null)
			return;
		
		traverseInOrder(root.leftChild);		//InOrder => leftChild, root, rightChild
		System.out.println(root.value);
		//System.out.println(root); will print as Node=1, Node = a etc..,.
		traverseInOrder(root.rightChild);
	}
	
	
	
	
	public void traversePostOrder() {			//This is to kick off recursioj taking place at the private or the implementation method
		traversePostOrder(root);
	}
	
	private void traversePostOrder(Node root) {	//PostOrder => leftChild, rightChild, root
		if(root==null)
			return;
		
		traversePostOrder(root.leftChild);
		traversePostOrder(root.rightChild);
		System.out.println(root.value);
	}
	
	
	
	
	private boolean isLeaf(Node node) {
		return node.leftChild == null && node.rightChild == null;
	}
	
	
	
	
	public int height() {						//This is to kick off recursioj taking place at the private or the implementation method				
		return height(root);
	}
	
	private int height(Node root) {				//method to fing height of a tree
		
		if(root == null)						//if tree is empty; (Exception Handling) 
			return -1;
		
		if(isLeaf(root))	//base condition
			return 0;
		
		return 1 + Math.max(height(root.leftChild), height(root.rightChild));	//height= maximum edges of tree from leaf node to the root of the tree; so we should fing maximum no. of edges; so we use if condition; formula to find height = 1 + (height(leftSubTree) or height(rightSubtree))
	}
	
	
	//BINARY SEARCH TREE- should find the left and bottom most node, cause BST definition (refer)
	//Time Complexity => O(log n)-> cause half of the subtrees are being ignored
//	public int min() {
//		
//		if(root == null) 						//EXCEPTION HANDLING
//			throw new IllegalStateException();
//		
//		var current = root;						//initialize root node with the current name
//		var last = current;						//initialize current node as last, to keep track of the last node
//		
//		while (current != null) {
//			last = current;						//as current node keeps changing, we should name it as last node too; so that we can return its value at last after going out of the loop
//			current = current.leftChild;		//go on finding the last left subTree's last leaf node; cause BST 
//		}
//		return last.value;						//return the value of the last left subTree's last leaf node; cause that's the minimum node in BST
//	}
	
	  
	public int min() {							//This is to kick off recursioj taking place at the private or the implementation method
		return min(root);
	}
	
	//BINARY TREE
	//Time Complexity => O(n)->cause we gotta iterate over all nodes to find the minimum of all nodes in the given tree
	private int min(Node root) {				//method to find minimum value in the tree, BINARY TREE
		
		if(isLeaf(root))						//Base Condition		
			return root.value;
		
		var left = min(root.leftChild);			//recursion => finding minimum value in the left subTree and then subTree goes on	
		var right = min(root.rightChild);		//recursion => finding minimum value in the right subTree then subTree goes on	
		
		return Math.min(Math.min(left, right), root.value);	//recursion => comparing left and right subTree and finding minimum, and then comparing that minimum value found to the root node; and returning the minimum obtained 
	}
		
	public boolean equals (BinaryTree other) {				//This is to kick off recursioj taking place at the private or the implementation method	//Intervirew Question => ro chwck if the two trees' node values are same or not
		if(other == null)								//Exception handling
			return false;
		
		
		return equals(root, other.root);				//Recursion
	}
	
	private boolean equals(Node first, Node second) {	//Method to check if 2 trees are equal (node to node)	
		if(first == null && second == null)				//case 1: if both nodes from tree1(first) and tree2(second) are NULL, then return true
			return true;
		
		if(first != null && second != null)				//case 2: if both nodes from tree1(first) and tree2(second) are NOT NULL
			
			return first.value == second.value			// return ONLY if the values of roots are equal
			&& equals (first.leftChild, second.leftChild)	//recursion: then check if value of left nodes of FIRST and SECOND tree are equal
			&& equals (first.rightChild, second.rightChild);//recursion: then check if value of right nodes of FIRST and SECOND tree are equal
				//if all the subTree nodes are equal, ONLY then return true; if ONE OF THE NODES AIN'T TRUE true then return False
		
		return false;									//case 3: if node of tree1 (first) is NULL and node of tree2 (second) is not NULL then return false
	}
	
	
	
	
	public boolean isBinarySearchTree() {				//This is to kick off recursioj taking place at the private or the implementation method
		return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isBinarySearchTree(Node root, int min, int max) {	//method to check if the given Binary Tree is a Binary Search Tree 
		
		if(root == null)									//case1: if root is only null; then empty tree is obviously a BST
			return true;
		
		if(root.value < min || root.value > max)			//case2; if the node values exceeds the limit or if left child is greater than root or rightchild is less than the root; then return false
			return false;
		
		return 												//case3: recursion
			isBinarySearchTree(root.leftChild, min, root.value - 1)	//only when if left child is greater than root value (minus infinity till max - 1) [max - 1 cause if root is 20; we can have left child only till 19 => so root.value - 1] 
			&& isBinarySearchTree(root.rightChild, root.value + 1, max);	////AND when if right child is lesser than root value (max + 1 till plus infinity) [max + 1 cause if root is 20; we can have right child only from 21 => so root.value + 1] 
	}
	
	
	
	
	public void swapRoot() {								//this method is just to make the boolean as false, cause if all the nodes are jumbled then obviously it wont be a binary search tree (here we've taken a binary search tree itself in Main class)
		var temp = root.leftChild;							//store left child's value first	
		root.leftChild = root.rightChild;					//store right child's value in left child's place
		root.rightChild = temp;								//store the previously stored left child's value in right chuld's place
	}
	
	
	
	
	public void printNodesAtDistance(int distance) {		//This is to kick off recursioj taking place at the private or the implementation method
		printNodesAtDistance(root, distance);
	}
	
	private void printNodesAtDistance(Node root, int distance) {	//root's distance = 0; so as we go deep distance increases; so this method is to print nodes values at any distance
		if(root == null)									//if it's an empty tree; then return true
			return;
		
		
		if(distance == 0) {									//if distance = 0; then it's the root of the tree; therefore print the root value
			System.out.println(root.value);
			return;
		}
		
			
		printNodesAtDistance(root.leftChild, distance - 1);	//when distance != 0; then we should go deep down; so we first go to leftChild ; after we go one step down, distance decreases; therefore decreament distance by 1
		printNodesAtDistance(root.rightChild, distance - 1);//when distance != 0; then we should go deep down; so after leftChild we should go to rightChild ; after we go one step down, distance decreases; therefore decreament distance by 1
	}
	
	
	
	
	public ArrayList<Integer> getNodesAtDistance(int distance) {	//This is to kick off recursioj taking place at the private or the implementation method
		var list = new ArrayList<Integer>();						//Initialize ArrayList of integer generics
		getNodesAtDistance(root, distance, list);					//parameters initialized in the private method
		return list;												//then we return the list here, instead pf printing 'em
	}
	
	private void getNodesAtDistance(Node root, int distance, ArrayList<Integer> list) {	//this method does the same job as as printNodeAtDistance() but instead of printing, we store the node values in an ArrayList
								//we add an ArrayList parameter which wasn't there in the printNodesAtDisatnce();
		if(root == null)
			return;
		
		
		if(distance == 0) {
			list.add(root.value);						//so instead of printing like the previous method, we add the node values in the ArrayList initialized previously and return the list
			return;
		}
		
			
		getNodesAtDistance(root.leftChild, distance - 1, list);	//Parameters in private method (root, distance, list)
		getNodesAtDistance(root.rightChild, distance - 1, list);
	}
	
	
	
	//"BREADTH FIRST SEARCH" or "LEVEL ORDER TRAVERSAL"
	
	public void traverseLevelOrder() {					//Until now we've done Depth First Search; this is BREADTH FIRST SEARCH
		for (int i = 0; i <= height(); i++) {			//height() method is implemented previously in this class
			
			for(var value : getNodesAtDistance(i))		//get the node values in a tree until height = 0; cause leaf node height is zero; that is deepest nodes of a tree is zero; so we traverse till height is zero
				System.out.println(value); 
		}
	}
}
