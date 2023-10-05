package codeWithMosh;

public class HeapSort {

	public static void main(String[] args) {
		int[] numbers = {9, 6, 2, 19, 5, 1 };
		var heap = new Heap();
		
		for(var number : numbers)
			heap.insert(number);
		
		for(var i = 0; i <= numbers.length; i++)		//Descending
			numbers[i] = heap.remove();
		//System.out.println(Arrays.toString(numbers));
        
		for(var i = numbers.length-1; i >= 0; i--)		//Ascending
			numbers[i] = heap.remove();
		//System.out.println(Arrays.toString(numbers));

	}

	@Override
	public String toString() {
		return "toString()=" + super.toString();
				
	}
	
	

}
