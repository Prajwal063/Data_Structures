package codeWithMosh;

import java.util.NoSuchElementException;

public class LinkedlistImple {
	public class Node{					//LinkedList imp Nodes indirectly, so create class inside LL class
		private Node next;				//node for address of next element
		private int value;				//value of LL element
		
		public Node(int value) {		//Node Constructor to add values to the list
			this.value=value;			//this keyword
		}
	}
	
	private Node first;					//Head of LinkedList(first ele is termed as head)
	private Node last;					//Foot of LinkedList(last ele of the list)
	private int size;					//efficient way to calculate size 
	
	private boolean isEmpty() {		
		return first==null;
	}
	
	
	public void addLast(int item) {		//Method to add ele at last of LL
		var node = new Node(item);		//or Node node = new Node();-->obj of Node class
		
		if(isEmpty())
			first=last=node;			//if list is empty, then assign first n last as the new "node" added
		else
			last.next=node;				//else assign last node's address to new node address
			last=node;					//name new "node" added as "last", thus adding at last
			
			size++;						//add-->size increases; returned in size method
	}
	
	public void addFirst(int item) {	//Method to add ele at last of LL
		var node = new Node(item);
		if(isEmpty())
			first=last=node;
		else
			node.next=first;
			first=node;
			
			size++;						//add-->size increases; returned in size method
	}
	
	public int indexOf(int item) {		//Method to find index of an existing element in LL
		int index=0;
		var current = first;
		while(current!=null) {			//traversing through out the LL
			if(current.value==item) return index;	//if ele found return index of it
			
			current=current.next;		//else if move current posistion to next ele
			index++;					//increament index -->while syntax
		}
		return -1;						//else return -1;
	}
	
	public boolean contains(int item) {	//Method to see if an ele exists in LL
		return indexOf(item)!=-1;		//same logic as indexOf method 
	}
	
	public void removeFirst() {			//Method to remove first ele
		if(isEmpty())
			throw new NoSuchElementException();	//if LL is empty throw exception
		
		if(first==last) 				//if only 1 element in LL
			first=last=null;			//point both first n last to null
		else {
			var second=first.next;			//store address of seconf node in variable called second
			first.next=null;				//null the first node
			first=second;					//name second node as first
		}
		size--;						//delete-->size decreases; returned in size method
	}
	
	public void removeLast() {			//Method to remove last node
		
		if(isEmpty()) 						//if LL is empty
			throw new NoSuchElementException();
		
		if(first==last) 					//if only one element
			first=last=null;
		else {
			var previous=getPrevious(last);	//Method getPrevious to get address to last but one node
		last=previous;					//name last but one node as last
		last.next=null;					//free the last node
		}
		
		size--;							//delete-->size decreases; returned in size method
	}
	
	private Node getPrevious(Node node) {	//Method to get previous node
		var current=first;	
		
		while(current!=null) {				//traverse through out the LL 
			if(current.next==node) return node; 
	//if next of current ele is null, current is pointing to last but one element; therefore current->last but one
			current=current.next;			//increament current
		}
		return null;						//if not found return null;
	}

	public int size(){					//size is maintained in all 4 methods, here it return s the final size
 		return size;
		//this is done cause it's efficient -->o(1)
		//other method is traverse through out LL and increament or decreament counter variable which is o(n)
	}

	public int[] toArray() {
		int[] array = new int[size];
		var current = first;
		var index=0;
		while(current!=null) {
			array[index++]=current.value;
			current= current.next;
		}
		return array;
	}

	public void reverse() {				//Method to reverse a string
		var previous = first;			//[10 --> 20  -->  30]
		var current = first.next;		// p	  c       n
		
		while(current!=null) {			//traverse throughout the LL
			var next = current.next;	//storing 3rd element's address, cause when reversed current's link
			
			//[10  -->  20     30] 30 is lost here , so to keep it's address we store it  in next variable
			
			current.next=previous;      //[10 <-- 20    30]		   ==>  	[10 <-- 20    30]
			previous=current;			//		  p     c     n		 			  		  p   c   n
			current=next;			
		}
		last = first;					//first pointing to 10, we want it to point 30 (here)
		last.next = null;				//to *deference* the past link which was pointing from 10 to 20
		first=previous;					//in 129 line, previous is pointing to last element of LL, so name it as first, as now LL is revered			
	}

	public int getKthFromTheEnd(int k) { //Method to get kth node from ONE pass
		
		if(isEmpty())					 //if LL is empty
			throw new IllegalStateException();
		
		var a=first;					 //pointer 1     [10 -> 20 -> 30 -> 40 -> 50]
		var b=first;					 //pointer 2     ab
		
		for(int i=0;i<k-1;i++) {		 // 0	  	    1    	 2     	  3       4  -->index
										 //[10	 ->    20 -> 	30 ->	 40 ->   50]
			b=b.next;					 // a	 	  b=(k-1)	k		
			
			if(b==null)
				throw new IllegalArgumentException();
		}
			
		while(b!=last) {				 // 0	  	 1    	 2     	  3     4  -->index
			a=a.next;					 //[10	 -> 20 -> 	30 ->	 40 -> 	50]
			b=b.next;					 //                          a       b
		}	
		return a.value;					 //a=3rd index; a.value=40
	}
}
