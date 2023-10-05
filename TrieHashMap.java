package codeWithMosh;

import java.util.*;


import codeWithMosh.TrieArray.Node;

public class TrieHashMap {
	public static int ALPHABET_SIZE = 26;				//26 alphabets, therefore a node can have atmost 26 child nodes
	
	public class Node{				
		
		private char value;									//value
		private HashMap<Character, Node> children = new HashMap<>();		//children HashMap with 26 size
		private boolean isEndOfWord;						//to determine if it's the end of word
		
		public Node(char value) {							//Constructor using source->generate
			this.value = value;
		}

		@Override
		public String toString() {							//using source->generate
			return "value=" + value;
		}
		
		public boolean hasChild(char ch) {					//ABSTRACTION -> to check if tree has character ch from 'word'
			return children.containsKey(ch);
		}
		
		public void addChild(char ch) {						//ABSTRACTION ->to add the non exixting character ch from 'word'
			children.put(ch, new Node(ch));
		}
		
		public Node getChild(char ch) {						//ABSTRACTION ->to re-initialise the current to new node added
			return children.get(ch);
		}
		
		public Node[] getChildren() {						//for traverse method; to get children values from the children array
			return children.values().toArray(new Node[0]);	//we want the values in Array of Node format (see return type of this method "Node[]" so .values() will return values as "objects" and .toArray() will append the values as "array of objects" but we want "array of nodes" so "toArray(new Node[0])" will  tell the method to put the values in "Node array"
		}
		
		public boolean hasChildren() {						//for remove method
			return !children.isEmpty();						
		}
		
		public void removeChild(char ch) {					//to remove the child if it has no further children in remove method
			children.remove(ch);
		}
		
	}
	
	
	private Node root = new Node(' ');						//root is null in trie 
	
	//Insert using HashMap
	
	public void insert(String word) {						//insert method
		var current = root;									//declaring root as current
		
		for(var ch : word.toCharArray()) {					//converting 'word' into characters and storing it in array
						
			if(!current.hasChild(ch)) {			
				current.addChild(ch);
			}				
			current = current.getChild(ch);				//declare the newly added node/ch as current
		}
		
		current.isEndOfWord = true;							//after the word is completely added then the word is complete in trie tree; therefore isEndOfWOrd is turned true
	}
	
	public boolean contains(String word) {					//method to lookup a word
		if (word == null)									//if word is null -> Exception handling
			return false;
		
		var current = root;									//same as insert method
		
		for(var ch : word.toCharArray()) {					//iterating and converting the word into character and appending it then into an array
			
			if(!current.hasChild(ch))						//if the character 'ch' doesn't exist in the trie, return false; or keep on iterating
				return false;
			current = current.getChild(ch);					//re assign the current value
		}
		
		return current.isEndOfWord;							//return if it's the end of word
	}
	
	
	
	//PRE-ORDER TRAVERSAL
	public void traversePreOrder() {						//to kick off recursion
		traversePreOrder(root);
	}
	
	private void traversePreOrder(Node root) {				//to print words from trie, pre order traversal is used
		
		System.out.println(root.value);						//first root is traversed
		
		for(var child : root.getChildren())					//iterating through out the node array from Node class created 
			traversePreOrder(child);						//then child is traversed
	}
	
	
	
	//POST-ORDER TRAVERSAL
	public void traversePostOrder() {						//to kick off recursion
		traversePostOrder(root);
	}
	
	private void traversePostOrder(Node root) {				//to delete words from trie, then post order traversal is used
		
		for(var child : root.getChildren())					
			traversePostOrder(child);						//first child is traversed
				
		System.out.println(root.value);						//then root is traversed
	}
	
	
	//REMOVING A WORD
	public void remove(String word) {						//to kick off recursion
		if(word == null)									//Exception handling => if the word to delete is "null: then don't enter the mothod itse;f; directly return from this method
			return;
		
		remove(root, word, 0);
	}
	
	private void remove(Node root, String word, int index) {	
		
		if(index == word.length()) {						//Base condition : Refer Binary trees and Recursion sections
			
			root.isEndOfWord = false;						//if the word reaches the end of the trie, then just remove the isEndOfWord tag from it, instead of deleting (here we dont delete the word if it has further children such as there is "car" in "care" and if we want to delete "car";  WE JUST REMOVE THE isEndOfWord TAG FROM "r" character OF "car" WORD )
			return;											//and we return from the method
		}
				
		
		var ch = word.charAt(index);						//we get the character at the index of "word"
		var child = root.getChild(ch);						//we get child at that particular index
		
		if(child == null)									//if the child we obtained is null; then we just return from the method instead of throwing exceptions
			return;
		
		remove(child, word, index + 1);						//recursion; and we should remove from next index of child so "index + 1"
		
		if(!child.isEndOfWord && !child.hasChildren())		//if the child has no further children and it is not end of any other word; then we can physically remove the word from trie
			root.removeChild(ch);							//method in Node class above
	}
	
	
	public List<String> findWords(String prefix){
		List<String> words = new ArrayList<>();
		var lastNode = findLastNodeOf(prefix);
		findWords(lastNode, prefix, words);
		
		return words;
	}
	
	private void findWords(Node root, String prefix, List words) {
		if(root==null)
			return;
		
		if(root.isEndOfWord)
			words.add(prefix);
		
		for(var child : root.getChildren())
			findWords(child, prefix+child.value, words);
	}
	
	private Node findLastNodeOf(String prefix) {
		if(prefix == null)
			return null;
		
		var current = root;
		for(var ch:prefix.toCharArray()) {
			var child = current.getChild(ch);
			if(child == null)
				return null;
			current = child;
		}
		return current;		
	}
}	

