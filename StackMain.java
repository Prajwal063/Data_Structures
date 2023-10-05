package codeWithMosh;

import java.util.Stack;

public class StackMain {

	public static void main(String[] args) {
		

		var stk=new StackExercises();
//		String str="(1+2)";
//		
//		stk.reverse("abcd");
		stk.reverser("abcd");
//		var balanced = stk.isBalanced(str);
//		System.out.println(balanced);		
//	}
	
		Stack stack = new Stack();
		stack.push(10);
		stack.push(20);
		stack.push(30);		
		System.out.println(stack);
		System.out.println(stack.peek());
	}
}
