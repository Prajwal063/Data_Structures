package codeWithMosh;

public class Heap {
	private int[] items = new int[10];
	
	private int size;

	
//INSERT METHOD
	
	public void insert(int item) {				//method to insert an item in heap
		if(isFull())
			throw new IllegalStateException();
		
		items[size++] = item;					//add the new item in the array
		
		bubbleUp();								//method to satisfy the heap property
		
	}
	
	public void bubbleUp() {
		var index = size - 1;					//as size increased (in line 12) index is 1 less than it

		while(index > 0 && items[index] > items[parent(index)]) {	//until index of greater than zero and item added is greater than it's parent, keep iterating 
			swap(index, parent(index));			//swap the new item and it's parent, (if new item > it's parent)
			index = parent(index);				//as swapping is done, new item should be parent
		}
	}
	
	private int parent(int index) {				//method to find index of parent
		return (index - 1) / 2;					//Formula => Parent = (new item index -1) / 2
												//			 Left child = (parent * 2) + 1
												//			 Right child = (parent * 2) + 2
															
	}
	
	private void swap(int first, int second) {	//method to swap (Done earlier)
		var temp = items[first];				//HINT:value of first stored in temp (not value of temp in first)
		items[first] = items[second];
		items[second] = temp;
	}
	
	public boolean isFull() {
		return size == items.length;
	}
	
	
//REMOVE METHOD
	
	public int remove() {
		if(isEmpty())
			throw new IllegalStateException();
		
		var root = items[0];					//first element is named as 'root'
		items[0] = items[--size];				//items at 0th index is replaced with last element added -> size is decreamented to obtain index (basics)
		
		bubbleDown();
		
		return root;
	}
	
	private void bubbleDown() {
		var index = 0;
		while(index <= size && !isValidParent(index)) {
			var largerChildIndex = largerChildIndex(index);	//largerChildIndex method's  object is created
			swap(index, largerChildIndex);
			index = largerChildIndex;						
		}
	}
	
	private boolean isValidParent(int index) {
		if(!hasLeftChild(index))
			return true;
		
		var isValid = items[index] >= leftChild(index); //if node (root node) is greater or equal to it's child nodes [left child considered here]
		
		if(!hasRightChild(index))	//if it doesn't have a right child still it's valid (heap stored from left child to right child)
			isValid &= items[index] >= rightChild(index); //[right child considered here]
			
		
		return isValid;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	private int leftChildIndex(int index) {
		return index * 2 + 1;
	}
	
	private int leftChild(int index) {
		return items[leftChildIndex(index)];
	}
	
	private int rightChildIndex(int index) {
		return index * 2 + 2;
	}
	
	private int rightChild(int index) {
		return items[rightChildIndex(index)];
	}
	
	private int largerChildIndex(int index) {
		if(!hasLeftChild(index))
			return index;
		
		if(!hasRightChild(index))
			return leftChildIndex(index);
		
		return (leftChild(index) > rightChild(index)) ? 
			    leftChildIndex(index) : rightChildIndex(index);
	}
	
	public boolean hasLeftChild(int index) {
		return leftChildIndex(index) <= size;
	}
	
	public boolean hasRightChild(int index) {
		return rightChildIndex(index) <= size;
	}
	
	public int max() {						//for heapify algorithm
		if(isEmpty())
			throw new IllegalStateException();
		
		return items[0];
	}
}