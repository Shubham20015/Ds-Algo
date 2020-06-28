package graph;

import java.util.*;

public class HashMapList {
	
	static Map<Object,List<Object>> map = new HashMap<>();
//	We also add boolean bidirectional(<-->) to check whether it is true or not
	static void addEdge(Object u,Object v) {
		
		if (!map.containsKey(u)) 
            map.put(u,new LinkedList<Object>()); 
  
		if (!map.containsKey(v)) 
            map.put(v,new LinkedList<Object>()); 
		
		map.get(u).add(v);
		map.get(v).add(u);
	}
//	Not able to iterate over Map in alphabetical order
	static void printList() {
		System.out.println("Adjacentacy HashMapList of Graph:");
		for(Object i: map.keySet()) {
			System.out.print(i+" --> ");
			for(Object j: map.get(i)) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		
		addEdge("Amritsar","Delhi");
		addEdge("Amritsar","Jaipur");
		addEdge("Amritsar","Saichen");
		addEdge("Delhi","Banglore");
		addEdge("Delhi","Agra");
		addEdge("Delhi","Saichen");
		
		printList();
	}

}
