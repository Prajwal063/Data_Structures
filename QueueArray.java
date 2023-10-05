package codeWithMosh;

public class QueueArray {
	private int[] items;
	private int rear, front;
	private int count;
	
	public QueueArray(int capacity) {
		items= new int[capacity];
	}
	
	public void enqueue(int item) {		//Method to add item at rear end of queue
		if(count==items.length)
			throw new IllegalStateException();
		
		items[rear]=item;
		rear=(rear+1)%items.length;		//Implementation of Circular queue; refer video
		count++;
	}
	
	public int dequeue() {				//Method to remove item at front end of queue
		
		var item=items[front];			//storing the address of first loacation
		items[front]=0;					//nulling the element present at first address, (garbage collection)
		front=(front+1)%items.length;	//Implementation of Circular queue; refer video (instead of increamenting rear; we use circular queue)	
		
		return item;
	}
}
