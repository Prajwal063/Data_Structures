package codeWithMosh;

public class BinaryTreeMain {

	public static void main(String[] args) {
		BinaryTree tree=new BinaryTree();
		tree.insert(7);
		tree.insert(4);
		tree.insert(1);
		tree.insert(6);
		tree.insert(9);
		tree.insert(8);
		tree.insert(10);
		System.out.println("Done");
//		tree.traversePreOrder();
//		tree.traverseInOrder();
//		tree.traversePostOrder();
//		System.out.println(tree.height());
//		tree.swapRoot();
//		System.out.println(tree.isBinarySearchTree());
		
		
//		Tree tree2=new Tree();
//		tree2.insert(7);
//		tree2.insert(4);
//		tree2.insert(1);
//		tree2.insert(6);
//		tree2.insert(9);
//		tree2.insert(8);
//		tree2.insert(10);
//		System.out.println(tree.equals(tree2));
		
//		tree.printNodesAtDistance(1);
//		
//		
//		var list = tree.getNodesAtDistance(2);
//		for(int item : list)
//			System.out.println(item);
		
		
		tree.traverseLevelOrder();
		
	}
}
