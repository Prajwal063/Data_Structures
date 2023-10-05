package codeWithMosh;

import java.util.*;

public class GraphImple {
	
	private class Node{
		private String label;
		
		public Node(String label) {
			this.label=label;
		}

		@Override
		public String toString() {
			return label;
		}
		
	}	
	
	private Map<String, Node> nodes = new HashMap<>();
	private Map<Node, List<Node>> adjacencyList = new HashMap<>();
	
	
	
	public void addNode(String label) {				//method to add node in adjaceny matrix
		var node = new Node(label);					//object of node class
		
		nodes.putIfAbsent(label, node);				//method in Hash data structures; add a "new node" with "label" as string
		adjacencyList.putIfAbsent(node, new ArrayList<>());		//when node is added; simultaneously a array list to store all neighbouring nodes of a node must be created; refer previous videos 
	}
		
	
	
	//CREATING A LINK BTW 2 NODES, FROM AND TO		
	public void addEdge(String from, String to) {	//method to add an edge
		
		var fromNode = nodes.get(from);				//this will return the list of nodes this node is connected with and is stored as fromNode
		if(fromNode==null)							
			throw new IllegalArgumentException();	//self understandable
		
		var toNode = nodes.get(to);					//this will return the list of nodes this node is connected with and is stored as toNode
		if(toNode==null)	
			throw new IllegalArgumentException();	//self understandable
			
		
		adjacencyList.get(fromNode).add(toNode);	//get all the nodes that are linked with fromNode of adjacenyList created at line 28 and then add or append the new node(edge) to be added
	}
	
	
	
	
	public void print() {							//method to print all edges and the relation between two egdes
		
		for(var source : adjacencyList.keySet()) {		//iterating through out the arrayList's key values created which lists out all "source" nodes (left column of the table in previous video)
			var targets = adjacencyList.get(source);	//this will return all the "targets" at source; i.e all the edges which is linked to the source	(right column of the table in previous video)
						//it will return all the nodes that are linked with the "source"
			
			if(!targets.isEmpty())
				System.out.println(source + " is connected to " + targets);
		}
	}
	
	
	
	//FIRST REMOVE THE LINKS OF THE "NODE" TO BE REMOVED FROM OTHER NODES
	public void removeNode(String label) {			//method to remove a node from arrayList and removing all the links of that node in other node lists
		
		var node = nodes.get(label);				//check if the node is a valid node
		if(node == null)							//Exception Handling
			return;
		
		
		for(var n : adjacencyList.keySet())			//fetch the node to be removed from the arrayList, this returns all the key values from the adjacenyList
			//HERE ALL THE LINKS ARE REMOVED OF THAT "NODE" IN THE ARRAYLIST
			adjacencyList.get(n).remove(node);		//get(n) will get list of nodes that are connect with "n", remove(node) will remove all the links from "n" which is linked with "node"
		
		//HERE THE "NODE" ITSELF IS REMOVED FROM ARRAYLIST AND FROM NODES
		adjacencyList.remove(node);
		nodes.remove(node);
	}
	
	
	//REMOVING A LINK BTW 2 NODES, BETWEEN FROM AND TO	
	public void removeEdge(String from, String to) {	//method to remove an edge(node) from
		
		var fromNode = nodes.get(from);
		var toNode = nodes.get(to);
		
		if(fromNode == null || toNode == null)
			return;										//similar to addEdge() method; to check if the from and to nodes exist
		
		adjacencyList.get(fromNode).remove(toNode);		//remove the link of "from" and "to" nodes and the edge will be removed automatically
	}
	
	
	//TRAVERSAL - DEPTH FIRST 
	public void traverseDepthFirst(String root) {		//to kick of recursion
		
		var node = nodes.get(root);						//Exception Handling
		if(node == null)
			return;
		
		
		traverseDepthFirst(node, new HashSet<>());
	}
	
	private void traverseDepthFirst(Node root, Set<Node> visited) {
		
		System.out.println(root);						//first printing the first node given
		visited.add(root);
		
		for(var node : adjacencyList.get(root))			//traversing through out the adjacenylist and getting all the nodes linked with the given "root" node
			if(!visited.contains(node))					//if the fetched neighbouring nodes are not visited 
				traverseDepthFirst(node, visited);		//recursion and marking as visited
	}
} 
