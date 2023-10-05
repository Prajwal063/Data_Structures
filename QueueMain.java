package codeWithMosh;

public class QueueMain {

	public static void main(String[] args) {
//		QueueArray queue=new QueueArray(5);
//		queue.enqueue(10);
//		queue.enqueue(20);
//		queue.enqueue(30);
//		queue.enqueue(40);
//		queue.enqueue(50);
//		var front = queue.dequeue();
//		System.out.println(front);
//		System.out.println(queue);
		
//		QueueWithTwoStacks queue= new QueueWithTwoStacks();
//		queue.enqueue(10);
//		queue.enqueue(20);
//		queue.enqueue(30);
//		var first = queue.dequeue();
//		System.out.println(first);
		
		PriorityQueue queue = new PriorityQueue();
			queue.add(10);
			queue.add(20);
			queue.add(30);
			queue.add(40);
			queue.add(50);
			System.out.println(queue);
	}
}
