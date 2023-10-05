package codeWithMosh;

import java.util.Arrays;

public class TrieArray {
	public static int ALPHABET_SIZE = 26;				//26 alphabets, therefore a node can have atmost 26 child nodes
	
	public class Node{				
		
		private char value;									//value
		private Node[] children = new Node[ALPHABET_SIZE];	//children Node array with 26 size
		private boolean isEndOfWord;						//to determine if it's the end of word
		
		public Node(char value) {							//Constructor using source->generate
			this.value = value;
		}

		@Override
		public String toString() {							//using source->generate
			return "value=" + value;
		}
		
	}
	
	
	private Node root = new Node(' ');						//root is null in trie 
	
	//Insert using Arrays -> "inefficient"
	
	public void insert(String word) {						//insert method
		var current = root;									//declaring root as current
		
		for(var ch : word.toCharArray()) {					//converting 'word' into characters and storing it in array
			int index = ch - 'a';							//ASCII value of a=97; therfore if we minus that from the 'ch' from word; we get index where we should append the new character (a=0 index, b= 1 index, c=2 index, d= 3index 'cause=>100 - 97 = 3rd index
			
			if(current.children[index] == null) {			//if there's no character i.e if it's empty 
				current.children[index] = new Node(ch);		//then append the new node with 'ch' character from 'word' to be added
			}				
			current = current.children[index];				//declare the newly added node/ch as current
		}
		
		current.isEndOfWord = true;							//after the word is completely added then the word is complete in trie tree; therefore isEndOfWOrd is turned true
	}
}
