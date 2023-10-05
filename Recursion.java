package codeWithMosh;

public class Recursion {

	public static void main(String[] args) {
		

	}
	
	//using the name of the method or the function itself, inside the method is known as recursion
	//recursion is nothing but looping over something without using any loops
		
	//f(3) 
	//    3 x f(2)
	//         2 x f(1)
	//			    1 x f(0) --> after this it goes to negative; so to handle this base condition is used
	
	//Recurions use STACK to fetch the previous value (or) get back to previous step
	//Example:f(3)=6
	//   	       3 x 2
	//                 2 x 1
	//                     1 x 1
	
	public static int factorial(int n) {
		
		//base condition=>so that it doesn't end up infinitely
		if(n==0)
			return 1;
		
		return n * factorial(n-1);		//recursion
		
//		This is the basic implementation of how to fing factorial of a number n
//		var factorial = 1;
//		for(var i=n;i>1;i--) {
//			factorial*=i;
//		}
//		return factorial;
	
	}

}
