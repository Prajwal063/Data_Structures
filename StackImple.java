package codeWithMosh;

public class StackImple {
	public int[] items = new int[5];
	public int count;
	
	
	private boolean isEmpty() {					//if stack empty
		return (count==0);
	}
	
	public void push(int item) {				//push method to push an element in a stack
		
		if(count == items.length)				//if stack full, throw exception 
			throw new StackOverflowError();
		
		items[count++]=item;					//else add item on top ; here count++ <==>top++	
	}
	
	public int pop() {							//Method to pop top most element from the stack
		
		if(count==0)
			throw new IllegalStateException();	//if Array is empty; throw new exception
		
		return items[--count];					//else return the top item value; and decreament count
	}
	
	public int peek() {							//Method to peek in the stack
		
		return items[count-1];					//just return the item value without removing it; cause count-->index; and count -1 value of that index
	}
}
