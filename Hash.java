package codeWithMosh;

import java.util.HashMap;
import java.util.Map;

public class Hash {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();		//Map=>Interface, HashMap=> implementation
		map.put(1, "Praj");								//to add 
		map.put(2, "yata");
		map.put(3, "lala");
		map.put(null, null);							//null key and objects can be added
		
		map.remove(null);								//to remove by key value
		
		System.out.println(map);
		
		var ish=map.get(2);								//to get a value through hash function
		System.out.println(ish);
		
		var first=map.containsValue("Praj");			//to check if an object(String value) is present
		System.out.println(first);
		
		for(var item: map.keySet())		//to iterate and print all key values
			System.out.println(item);
		
		for(var item: map.entrySet())	//to iterate and print all object/string values
			System.out.println(item);
	}
}
