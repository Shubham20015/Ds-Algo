package graph;

import java.util.*;

public class DetectInUndirect {
	
	static int V;
	static List<ArrayList<Integer>> ll = new ArrayList<>(V);
	

	static void addEdge(int u,int v) {
		ll.get(u).add(v);
		ll.get(v).add(u);
	}
	
	static boolean isCyclicUtil(int v,boolean visited[],int parent) {
		
		visited[v] = true;
		
		// Recur for all the vertices adjacent to this vertex
		for(int i : ll.get(v)) {	
			
			// If an adjacent is not visited, then recur for that 
            // adjacent 
			if(!visited[i] && isCyclicUtil(i,visited,v))
					return true;
			
			 // If an adjacent is visited and not parent of current 
            // vertex, then there is a cycle.
			else if(i != parent)
				return true;
		}
		return false;
	}
	
	static boolean isCyclic() {
		boolean visited[] = new boolean[V];
		
		for(int i=0;i<V;i++)
			visited[i] = false;
		
		for(int u=0;u<V;u++) {
			if(!visited[u] && isCyclicUtil(u,visited,-1))
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
		
		addEdge(1, 0); 
        addEdge(0, 2); 
        addEdge(2, 1); 
        addEdge(0, 3); 
        addEdge(3, 4); 
        
        if (isCyclic()) 
            System.out.println("Graph contains cycle"); 
        else
            System.out.println("Graph doesn't contains cycle"); 
        
		sc.close();
		
	}

}
