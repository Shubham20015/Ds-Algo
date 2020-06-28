package graph;

import java.util.*;
// problem in this code that it does not work when edges are more than vertex
public class TopologicalSort {
	static int V;
	static List<ArrayList<Integer>> ll = new ArrayList<>(V);
	

	static void addEdge(int u,int v) {
		ll.get(u).add(v);
	}
	
	static void isTopologicalSort(int i,boolean visited[],Stack<Integer>stack) {
        
		visited[i] = true;
		
		// Recur for all the vertices adjacent  
        // to this vertex  
		for(int v : ll.get(i)) {	
			if(!visited[v])
				isTopologicalSort(v,visited,stack);
		}
		// Push current vertex to stack  
		// which stores result  
		stack.push(i);
	}
	
	static void isSort() {
		Stack<Integer> stack = new Stack<>();
		boolean visited[] = new boolean[V];
				
		for(int i=0;i<V;i++) {
			visited[i] = false;
		}
		
		for(int u=0;u<V;u++) {
			if(!visited[u])
				isTopologicalSort(u,visited,stack);
		}
		
		while (!stack.empty())  
            System.out.print(stack.pop() + " ");
		
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter no. of vertex in graph: ");
		V = sc.nextInt();
		
		for (int i = 0; i < V; i++)
		      ll.add(new ArrayList<Integer>());
		
		addEdge(5,2); 
        addEdge(5,0); 
        addEdge(4,0); 
        addEdge(4,1); 
        addEdge(2,3); 
        addEdge(3,1); 
        
        System.out.println( "Following is a Topological sort of the given graph"); 
        isSort(); // this function only works when graph is directed and not cyclic (This is not a problem which descibed above)
        
		sc.close();
		
	}
}
