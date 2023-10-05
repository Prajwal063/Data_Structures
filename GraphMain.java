package codeWithMosh;

public class GraphMain {

	public static void main(String[] args) {
		GraphImple graph = new GraphImple();
		
		graph.addNode("A");
		graph.addNode("B");
		graph.addNode("C");
		graph.addNode("D");
		graph.addEdge("A", "B");
		graph.addEdge("B", "D");
		graph.addEdge("D", "A");
		graph.addEdge("A", "C");
		graph.traverseDepthFirst("D");
//		graph.print();
		

	}

}
