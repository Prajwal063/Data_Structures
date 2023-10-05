package codeWithMosh;

public class ArrayMain {

	public static void main(String[] args) {
		Arrays numbers=new Arrays(3);
		numbers.insert(10);
		numbers.insert(20);
		numbers.insert(30);
		numbers.insert(40);
		numbers.insert(50);
		System.out.println(numbers.indexof(50));
		//numbers.removeAt(2);
		
		Arrays numbers1=new Arrays(3);
		numbers1.insert(10);
		numbers1.insert(20);
		numbers1.insert(30);
		numbers1.insert(40);
		numbers1.insert(50);
		numbers1.print();
		numbers.largestNo();
		numbers.print();
	}

}
