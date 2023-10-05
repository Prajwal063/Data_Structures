package codeWithMosh;

import java.util.*;

public class CharFinder {
	public char findFirstNonRepeatingChar(String str){
        Map<Character, Integer> map = new HashMap<>();

        var chars=str.toCharArray();		//used twice in 2 for loops; to make the code cleaner we declare it
        
        for(var ch:chars){
            
        	var count = map.containsKey(ch)?map.get(ch):0;	//ternary equation --""-- if not; then keep that ch's count as 0; so count=0+1
            map.put(ch, count+1);							//increament counter of that character by 1 in hashtable
            
//            if(map.containsKey(ch)) {		//if map contains ch of string str
//            	var count=map.get(ch);		//get that character ch and store in a variable count
//            	map.put(ch, count);			//update that character in hashtable and its count
//            }else
//            	map.put(ch, 1);				//or else put character count as 1
                   	
        }
        System.out.println(map);
        
        for(var ch:chars) 					//to return first non repeating character in a string
        	if(map.get(ch)==1)				//if count of ch is 1; then return that ch
        		return ch;
        
        return Character.MIN_VALUE;	//not a null value; but it's like a non existing value
    }
	
	public char findFirstRepeatedChar(String str) {
		Set<Character> set = new HashSet<>();
		
		for(var ch : str.toCharArray()) {
			if(set.contains(ch))
				return ch;
		set.add(ch);
		
		}
		return Character.MIN_VALUE;	
	}
	
}
