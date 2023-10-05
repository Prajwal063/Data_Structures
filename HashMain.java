package codeWithMosh;

public class HashMain {

	public static void main(String[] args) {
		 CharFinder finder= new CharFinder();
	        var ch=finder.findFirstNonRepeatingChar("a green apple");
	        System.out.println(ch);
	        var s=finder.findFirstRepeatedChar("green apple");
	        System.out.println(s);
	}
}
