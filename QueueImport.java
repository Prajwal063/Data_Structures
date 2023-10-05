package codeWithMosh;

import java.util.*;									//Import both linked list and queue from java.util

public class QueueImport {

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();	
			queue.add(10);
			queue.add(20);
			queue.add(30);
		
			System.out.println(queue);
			
			reverse(queue);					//Calling the method
			System.out.println(queue);
			
	}
	
	public static void reverse(Queue<Integer> queue) {	//Method to reverse queue using stack
		Stack<Integer> stack=new Stack<>();
		
		while(!queue.isEmpty()) 			//Until queue not empty push all elts to stack i.e (cause FIFO)
			stack.push(queue.remove());		//Q [10, 20, 30]-> S[10, 20, 30]  --->  Q[ , , ] and S[10, 20, 30]
		
		while(!stack.isEmpty())				//until stack not empty remove all items, as LIFO, last elt added was 30, so 30 will be popped then 20 then 10
			queue.add(stack.pop());			//thus these items are stored back to queue in reverse order (cause LIFO)
	}

}
