package codeWithMosh;

public class Arrays {
	private int[] items;
	private int[] items1;
	private int count;
	private int large;
	
	public Arrays(int length) {					//constructor initialization
		items=new int[length];					//declaring array
		items1=new int[length];
	}
	
	public void insert(int item) {				//Insert Method
		if(items.length==count) {				//if array size reaches it's limit
			int newItems[]=new int[count*2];	//create new array of double size
			
			for(int i=0;i<count;i++) {			//copy all items from old array to new array
				newItems[i]=items[i];
			}
			items=newItems;						//name the new array as default
		}
		
		//else
		items[count++]=item;					//else add new item at the end
	}
	
	public void print() {						//Method to print all elements of an Array
		for(int i=0;i<count;i++) {
			System.out.println(items[i]);
		}
	}
	
	public void removeAt(int index) {			//Method to remove an element at user defined index
		
		if(index<0||index>count)								
			throw new IllegalArgumentException();	//If index doesn't exists, throw exception 
		
		for(int i=index;i<count;i++) 
			items[i]=items[i+1];				
		//shift all elements to left, value at 1st = value at 2nd
			count--;
	}
	
	public int indexof(int item) {				//Method to find index of array item
		
		for(int i=0;i<count;i++)
			if(items[i]==item)					//if items exists	
				return i;						//return the index
		
		return -1;								
	}
	
	public void largestNo() {
		for(int i=0;i<count;i++) 
			if(items[i+1]>items[i])
				large=items[i+1];
		System.out.println(large);
	}

	@Override
	public String toString() {
		return "Arrays [items=" + java.util.Arrays.toString(items) + ", items1=" + java.util.Arrays.toString(items1)
				+ ", count=" + count + ", large=" + large + "]";
	}
	
}
