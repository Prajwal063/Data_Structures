package codeWithMosh;

public class HeapifyMaxHeap {
	
	public static void heapify(int[] array) {
		/*for(int i = 0; i < array.length; i++)	//here we're iterating through out the heap; which is not necessary, we should see only if the parent nodes are in rigght spot or not 
			heapify(array, i);*/
		
		var lastParentIndex = array.length / 2 - 1;	//formula : (n / 2) - 1;	
		
		for(var i = lastParentIndex ; i >= 0 ; i--)	//optimiazation-> 1. iterating only parent nodes
			heapify(array, i);						//				  2. iterating from leaf nodes, cause most of the nodes will be in right poistions at top; so iterating from leaf nodes will be efficient					
			
	}
	
	private static void heapify(int[] array, int index) {
		var largerIndex = index;
		
		var leftIndex = index * 2 + 1;
		if(leftIndex < array.length && array[leftIndex] > array[largerIndex])
			largerIndex = leftIndex;
		
		var rightIndex = index * 2 + 2;
		if(rightIndex < array.length && array[rightIndex] > array[largerIndex])
			largerIndex = rightIndex;
		
		if(index == largerIndex)
			return;
		swap(array, index, largerIndex);
	}
	
	private static void swap(int[] array, int first, int second) {
		var temp = array[first];
		array[first] = array[second];
		array[second] = temp;
	}
	
	public static int getKthLargest(int[] array, int k) {
		var heap = new Heap();
		
		for(var number : array)		//add all numbers of array into heap
			heap.insert(number);
		
		for(int i = 0; i < k - 1; i++)	//delete the items less than the given 'k' index except kth item (therefore k-1)
			heap.remove();
		
		return heap.max();			//return whatever max element is left in heap; will be the new item after bubbling up after k-1 items are removed
	}
}
