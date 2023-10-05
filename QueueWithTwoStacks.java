package codeWithMosh;

import java.util.Stack;

public class QueueWithTwoStacks {
	Stack <Integer> stack1=new Stack<>();	//used for enqueue method, to add items, here items are stored as it is 
	Stack <Integer> stack2=new Stack<>();	//used for dequeue method, to remove items from top, where elements here are stored in reverse order, so that first element removed here in stack (Stack-LIFO), is the last element removed in queue(Queue-FIFO)
	
	public void enqueue(int item) {				//Method to add elements to the queue
		stack1.push(item);						//o(1) --> time complexity
	}
	
	
	public int dequeue() {						//Method to remove elements to the queue
		if(isEmpty())							//if both stacks empty, throw exception (Exception Handling)
			throw new IllegalStateException();
		
		moveStack1ToStack2();		//refactor method ; at last; refactored cause same lines used in dequeue() method too
		return stack2.pop();
	}
	
	
	public int peek() {				//Method to peek the element at the front
		if(isEmpty())
			throw new IllegalStateException();
		
		moveStack1ToStack2();		//refactor method ; at last; refactored cause same lines used in dequeue() method too
		
		return stack2.peek();			
	}
		
	
	public boolean isEmpty() {						//if both stacks are empty
		return stack1.isEmpty() && stack2.isEmpty();
	}
	
	//Refactored -> Extracted method
	
	private void moveStack1ToStack2() { 	//steps to refactor, select the lines of code-> right click-> refactor-> Extract method
		if(stack2.isEmpty())				// if only stack2 empty
			while(!stack1.isEmpty())		//then copy all elements from stack1 to stack2
				stack2.push(stack1.pop());	//i.e push() all elements from stack 1 to stack 2
	}
}
