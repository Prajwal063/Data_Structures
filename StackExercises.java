package codeWithMosh;

import java.util.Stack;

public class StackExercises {
	Stack <Character> stack = new Stack<>();
			
	public void reverse(String input) {				//Method to reverse a string and store it in STRING form itself
													//therefore output will be hgfe--> for input "efgh"
		if(input==null)
			throw new IllegalArgumentException();
		
		for (char ch: input.toCharArray())			//it reverses and stores in STRING form itself
			stack.push(ch);							//storing each character from string
		
		StringBuffer reversed = new StringBuffer();	
		while(!stack.empty())						//until stack empty, keep on popping, cause LIFO
			reversed.append(stack.pop());			//last character pushed will be popped first, so reversed
		
		System.out.println(reversed.toString());	//converting characters back to string	
	}
	
	public void reverser(String input) {			//Method to reverse a string; own solution
		
		if(input==null)
			throw new IllegalArgumentException(); 
		
		for(int i=input.length()-1; i>=0; i--) {	//it reverses and stores like a STACK
			stack.push(input.charAt(i));			//therefore output will be [d, c, b, a]-->for inout "abcd"
		}
		System.out.println(stack.toString());
	}
	
	public boolean isBalanced(String input) {		//To check if stack is balanced-->if ( exists; there must be )
		
		for(char ch:input.toCharArray()) {			//iterate over string
			if(ch=='(') 							//if character is '('--> push it to stack
				stack.push(ch);
			
			if(ch==')') {							//if character is ')'-->pop out the element
				if(stack.empty()) return false;		//if stack has no brackets at all; therefore stack will be empty, so return false
				
				stack.pop();						//else pop of top element stored; i.e '(', so stack empty
			}
		}
		return stack.empty();						//therefore, if stack empty-->return true
	
	}
}
