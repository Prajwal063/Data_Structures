package codeWithMosh;

public class HeapMain {

	public static void main(String[] args) {
		var heap = new Heap();
		heap.insert(10);
		heap.insert(5);
		heap.insert(45);
		heap.insert(2);
		heap.insert(39);
		heap.remove();
		System.out.println("done");
	}

}
