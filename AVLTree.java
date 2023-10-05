package codeWithMosh;

import codeWithMosh.BinaryTree.Node;

public class AVLTree {
	private class AVLNode{
		private AVLNode leftChild;
		private AVLNode rightChild;
		private int value;
		private int height;
		
		public AVLNode (int value) {
			this.value = value;
		}
		
		@Override
		public String toString() {
			return "Value=" + this.value;
		}
	}
	
	private AVLNode root;
	
	
	
	public void insert(int value) {				//This is to kick off recursion taking place at the private or the implementation method
		root = insert(root, value);
	}
	
	 
	private AVLNode insert(AVLNode root, int value) {
		if(root == null) {						//if tree is empty, entry a NEW AVLNode with value of node value to be added
			return new AVLNode(value);
		}
		
		if(value < root.value)					//if value to be added is less than root value
			root.leftChild = insert(root.leftChild, value);	//then at left child of root, insert new node of value to be added, using RECURSION
		else
			root.rightChild = insert(root.rightChild, value);	//then at right child of root, insert new node of value to be added, using RECURSION
		
		
		
		setHeight(root);	//this returns the height of tree, (+1 -> 'cayse root node should be added to get height)
		
		
		return balance(root);								//calling balance method after height is found						
	}
	
	
	
	
	private AVLNode balance(AVLNode root) {			//method to balance the tree 
		
		
		if(isLeftHeavy(root)) {						
			if(balanceFactor(root.leftChild) < 0)
				root.leftChild = rotateLeft(root.leftChild);
			rotateRight(root);
		}
			
		else if(isRightHeavy(root)) {
			if(balanceFactor(root.rightChild) > 0)
				root.rightChild = rotateRight(root.rightChild);
			rotateLeft(root);
		}	
		return root;
	}
	
	
	
	private AVLNode rotateLeft (AVLNode root) {
		var newRoot = root.rightChild;
		
		root.rightChild = newRoot.leftChild;
		newRoot.leftChild = root;
		
		setHeight (root);
		setHeight(newRoot);
				
		
		return newRoot;
	}
	
	
	
	private AVLNode rotateRight (AVLNode root) {
		var newRoot = root.leftChild;
		
		root.leftChild = newRoot.rightChild;
		newRoot.rightChild = root;
		
		setHeight(root);
		setHeight(newRoot);
		
		return newRoot;
	}
	
	
	private void setHeight (AVLNode node) {
		node.height = Math.max(height(node.leftChild), height(node.rightChild)) + 1;
	}
	

	
	private int height(AVLNode node) {				
		return (node == null)? -1 : node.height;					
	}
		
	
	private int balanceFactor(AVLNode node) {		//balance factor = height of leftChild - height of rightChild
		return (node == null) ? 0 : height(node.leftChild) - height(node.rightChild);
	}
	
	
	public boolean isLeftHeavy(AVLNode node) {		//if balanceFactor is greater than 1 => then it's left heavy
		return balanceFactor(node) > 1;
	}
	
	
	private boolean isRightHeavy(AVLNode node) {	//if balanceFactor is lesser than -1 => then it's right heavy 
		return balanceFactor(node) < -1;
	}

}
