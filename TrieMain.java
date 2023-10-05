package codeWithMosh;

public class TrieMain {

	public static void main(String[] args) {
		var trie = new TrieHashMap();
		
//		trie.insert("cat");
//		trie.insert("canada");
		
//		System.out.println(trie.contains(null));
		
//		trie.insert("abcd");
//		trie.insert("abcdef");
//		
//		trie.remove("abcd");
//		trie.remove("");
//		
//		System.out.println(trie.contains("abcd"));
//		System.out.println(trie.contains("abcdef"));
		
		
//		trie.traversePreOrder();
//		
//		System.out.println();
//		
//		trie.traversePostOrder();
		
		trie.insert("car");
		trie.insert("care");
		trie.insert("card");
		trie.insert("careful");
		trie.insert("egg");
		var words = trie.findWords("car");
		System.out.println(words);
	}

}
