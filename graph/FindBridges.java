package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindBridges {

	
	static void addEdge(int u,int v) {
		ll.get(u).add(v);
		ll.get(v).add(u);
	}
	
	// A recursive function that finds and prints bridges 
    // using DFS traversal 
    // u --> The vertex to be visited next 
    // visited[] --> keeps tract of visited vertices 
    // disc[] --> Stores discovery times of visited vertices 
    // parent[] --> Stores parent vertices in DFS tree 
	static void bridgesUtil(int u,boolean visited[],int low[],int dis[],int parent[]) {
		
		visited[u] = true;
		
		// Initialize discovery time and low value
		dis[u] = low[u] = time++;
		
        for(int v: ll.get(u)) 
        { 
            if (!visited[v]) { 
            	
            	parent[v] = u;
            	bridgesUtil(v,visited,low,dis,parent);
            	
            	// Check if the subtree rooted with v has a 
                // connection to one of the ancestors of u
            	low[u]  = Math.min(low[u], low[v]);
            	
            	// If the lowest vertex reachable from subtree 
                // under v is below u in DFS tree, then u-v is 
                // a bridge 
            	if(low[v] > dis[u])
            		System.out.println(u+" "+v);
            				} 
            
         // Update low value of u for parent function calls(IMP for me, don't forget this)
            else if (v != parent[u]) 
                low[u]  = Math.min(low[u], dis[v]);
            
        }

	}

	
	static void bridge() {
		boolean visited[] = new boolean[V];
		int low [] = new int[V];
		int disc [] = new int[V];
		int parent [] = new int[V];
		
		for(int i=0;i<V;i++) {
			parent[i] = -1;
			visited[i] = false;
		}
		for(int i=0;i<V;i++){
			
			if(!visited[i]) 
				bridgesUtil(i,visited,low,disc,parent);
		}
	}
	
	static int V;
	static int time = 0;
	static List<ArrayList<Integer>> ll = new ArrayList<>(V);
	
public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);
	
	System.out.print("Enter no. of vertices in Graph: ");
	V = sc.nextInt();
	
	
	for (int i = 0; i < V; i++)
	      ll.add(new ArrayList<Integer>());
	
	System.out.println("Bridges in graph: "); 
    
    addEdge(1, 0); 
    addEdge(0, 2); 
    addEdge(2, 1); 
    addEdge(0, 3); 
    addEdge(3, 4); 
    
    bridge(); 	
	
	sc.close();
}

}
