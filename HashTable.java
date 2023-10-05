package codeWithMosh;

import java.util.LinkedList;

public class HashTable {
	
	private class Entry{			//cause both integer and string value is wrapped in map
		private int key;
		private String value;
		
		public Entry(int key, String value) {	//constructor to assign value
			this.key = key;
			this.value = value;
		}
	}
	private LinkedList<Entry>[] entries= new LinkedList[5];	//Array of linked list; cause chaining method is used to handle collisions
	
	public void put(int key, String value) {	//put method 
		
		var index=hash(key);					//finding index where the value should be stored in hashmap; this work is done by "hash" method 					
		if(entries[index]==null)				//if block is empty
			entries[index]=new LinkedList<>();	//add the new value at that index found
		
		
		var bucket=entries[index];				//used many times; i.e value stored at the particular index			
		
		for(var entry : bucket) {				//iterate over all hash map
			if(entry.key==key) {				//if there's an entry with the same key
				entry.value=value;				//update it's value and return it; and we do not want to add anything 
				return;							//we just changing the value at that key to avoid duplicates
			}
		}
		
		
		bucket.addLast(new Entry(key, value));	//if there's already an entry in that index; we've to add the pair of key and value at the end of existing entry in that index; refer chaining video
	}
	
	
	public String get(int key) {				//get method to get a value at desired key value
		
		var index = hash(key);					//finding the index of the given key using hash method
		var bucket = entries[index];			//just like before
		
		for(var entry : bucket)					//iterating through the hash map
			if(entry.key==key) {				//if key is found; i.e key at hash map = key given
				return entry.value;				//return the value at that key 
			}
			return null;						//else return null
	}
	
	
	public void remove(int key) {				//method to remove an entry from the map
		var index = hash(key);					//find the index through hash method
		var bucket = entries[index];			//similar to previous method concepts
		
		if(bucket==null)						
			throw new IllegalStateException();
		
		for(var entry : bucket) {				//iterate over the hashtable
			if(entry.key==key) {				//if the key is found
				bucket.remove(entry);			//remove that entry from the array of linkedlist
			}
		}
		throw new IllegalStateException();		//else, throw an exception
	}
	
	
	private int hash(int key) {					//hash method to find index where value should be stored within the map size
		return key % entries.length;
	}
}
