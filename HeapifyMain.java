package codeWithMosh;

public class HeapifyMain {

	public static void main(String[] args) {
		int[] numbers = { 5, 3, 8, 4, 1, 2 };
		HeapifyMaxHeap.heapify(numbers);
		
		System.out.println(HeapifyMaxHeap.getKthLargest(numbers, 6));  
		System.out.println("done");

	}

}
