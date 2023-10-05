package codeWithMosh;

public class PriorityQueue {
	private int[] items=new int[5];
	private int count;
	
	public void add(int item) {			//Method to add an element
		
		if(isFull())			
			throw new IllegalStateException();
		
		var i=shiftItemsToInsert(item);
		items[i]=item;					//add item to to right side of that array element
		count++;						//increament the counter
	}
	
	public int shiftItemsToInsert(int item) {

		int i;							//cause if 'i' initialized inside for; scope will be over once break is executed
		for(i=count-1;i>=0;i--) {		//from backword cause, if iterated from front; pre existeting items at that posistion will be overwritten -> hence the pre existing elements will be lost		
			if(items[i]>item)			//if array element > item to be added 
				items[i+1]=items[i];	//then move array element towards right by one position; so that vacancy can be created and the item to be added can compare w previous array element
			else
				break;					//if array elt < item; get out of the loop
		}
		return i+1;
	}
	
	public int remove() {				//Method to remove an element
		return items[--count];			//forst decreament the counter; cause 5 elements->4 indexes i.e. 0, 1, 2, 3, 4. So to get last elt-> count-1 = 5-1 => 4th index's value will be returned
	}
	
	public boolean isEmpty() {
		return count==0;
	}
	
	public boolean isFull() {			//If queue is full; throw exception; or can create new queue of twice the size-> copy all elements from previous queue and then add the new element
		return count==items.length;
	}
	
//	@Override
//	public String toString() {
//		return Arrays.toString(items);
//	}
}
