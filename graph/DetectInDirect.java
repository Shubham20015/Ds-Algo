package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DetectInDirect {

	static int V;
	static List<ArrayList<Integer>> ll = new ArrayList<>(V);
	

	static void addEdge(int u,int v) {
		ll.get(u).add(v);
	}
	
	static boolean isCyclicUtil(int i,boolean visited[],boolean restack[]) {
		
		if (restack[i]) 
            return true; 
  
        if (visited[i]) 
            return false;
        
		visited[i] = true;
		restack[i] = true;
		
		for(int v : ll.get(i)) {	
			
			if(isCyclicUtil(v,visited,restack))
					return true;
			
			 restack[v] = false;
		}
		return false;
	}
	
	static boolean isCyclic() {
		boolean visited[] = new boolean[V];
		boolean recstack[] = new boolean[V];
				
		for(int u=0;u<V;u++) {
			if(isCyclicUtil(u,visited,recstack))
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter no. of vertex in graph: ");
		V = sc.nextInt();
		
		for (int i = 0; i < V; i++)
		      ll.add(new ArrayList<Integer>());
		
		addEdge(0, 1); 
        addEdge(0, 2); 
        addEdge(1, 2); 
        addEdge(2, 0); 
        addEdge(2, 3); 
        addEdge(3, 3); 
        
        if (isCyclic()) 
            System.out.println("Graph contains cycle"); 
        else
            System.out.println("Graph doesn't contains cycle"); 
        
		sc.close();
		
	}
}
