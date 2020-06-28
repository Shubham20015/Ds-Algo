package hashing;

import java.util.*;

class HashNode<K,V>{
	K key;
	V value;
	HashNode<K,V>next;
	
//	HashNode(){
//		this.key = key;
//		this.value = value;
//	}
	
}

public class SeperateChaining<K,V> {
	
	// this ArrayList contain Hashnode class
	List<HashNode<K,V>> bucket = new ArrayList<>(); 
	
	// Initial size of HashTable 
	int numbuckets = 10;
	int size;
	
	public SeperateChaining()
	{
		for(int i=0;i<numbuckets;i++)
		{
			bucket.add(null);
		}
	}
	
	public int getSize() {
		return size;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	// To find index of given key
	private int getBucketIndex(K key)
	{
		return key.hashCode() % numbuckets;
	}
	
	// To get value of particular key 
	public V get(K key) {
		
		int index = getBucketIndex(key);
		HashNode<K,V> node = bucket.get(index);
		
		while(node != null) {
			
			if(node.key.equals(key))
				return node.value;
			
			node = node.next;
		}
		
		return null;
	}
	
	// To remove key
	public V remove(K key) {
		
		int index = getBucketIndex(key);
		HashNode<K,V> node = bucket.get(index);
		
		if(node == null)
			return null;
		if(node.key.equals(key)) {
			V val = node.value;
			node = node.next;
			bucket.set(index, node);
			size--;
			return val;
		}
		else {
			HashNode<K,V> prev = null;
			
			while(node != null) {
				
				if(node.key.equals(key)) {
					prev.next = node.next;
					size--;
					return node.value;
				}
				prev = node;
				node = node.next;
			}
			size--;
			return null;
		}
	}
	
	public void add(K key,V value) {
		
		int index = getBucketIndex(key);
		System.out.println(index);
		
		HashNode<K, V> root = bucket.get(index);
		HashNode<K, V> toAdd = new HashNode<>();
		toAdd.key=key;
		toAdd.value=value;
		
		if(root == null) {
			bucket.set(index, toAdd);
			size++;
		}
		else
		{
		while(root!=null)
		{
			if(root.key.equals(key))
			{
				root.value=value;
				size++;
				break;
			}
			root=root.next;
			}
		// I don't know why it is here ????
		if(root == null) {
			toAdd.next = bucket.get(index);
			bucket.set(index, toAdd);
			size++;
		}
	}
	
		//In our implementation whenever we add a key value pair to the Hash Table
		//we check the load factor if it is greater than 0.7 we double the size of our hash table.
		if((1.0*size)/numbuckets > 0.7) {
			
			List<HashNode<K,V>> tmp = bucket;
			bucket=new ArrayList<>();
			
			// Now double the size of bucket 
			numbuckets=2*numbuckets;
			for(int i=0;i<numbuckets;i++)
			{
				bucket.add(null);
			}
			
			// So we add new key-value pair in bucket by searching last empty place
			for(HashNode<K,V> head : tmp) {
				
				while(head != null) {
					
					add(head.key,head.value);
					head = head.next;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		SeperateChaining<String,Integer> map = new SeperateChaining<>();
		
		map.add("this", 1);
		System.out.println(map.remove("this"));
		System.out.println(map.remove("this"));
	}

}
