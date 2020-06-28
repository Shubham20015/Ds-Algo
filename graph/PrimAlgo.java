package graph;

import java.util.Scanner;

public class PrimAlgo {
	
	// This method defines to find minimum weight of edge amongst unvisited Array
	static int find(int weight[],boolean visited[],int V) {
		
		int min = Integer.MAX_VALUE,min_index =-1;
		
		for(int i=0;i<V;i++) {
			if(visited[i] == false && weight[i] < min) {
				min = weight[i];
				min_index = i;
			}
		}
		
		return min_index;
	}
	
	static void printMST(int Graph[][],int parent[],int V) {
		System.out.println("Edge \tWeight"); 
        for (int i = 1; i < V; i++) 
            System.out.println(parent[i] + " - " + i + "\t " + Graph[i][parent[i]]);
	}
	
	static void PrimsAlgo(int Graph[][],int V){
		int parent[] = new int[V]; // source of vertex is stored
		int weight[] = new int[V]; // weight of edge is stored
		boolean visited[] = new boolean[V];
		
		// Initialize all keys as INFINITE 
		for(int i=0;i<V;i++) {
			weight[i] = Integer.MAX_VALUE;
			visited[i] = false;
		}
		
		// Always include first 1st vertex in MST. 
        weight[0] = 0; // Make key 0 so that this vertex is 
        // picked as first vertex 
        parent[0] = -1; // First node is always root of MST
		
		for(int i=0;i<V-1;i++) {
			
			// Pick the minimum key vertex from the set of vertices 
            // not yet included in MST 
			int minIndex = find(weight,visited,V);
			visited[minIndex] = true;
			
			// this is used to check neighbour of given vertex
			for(int j=0;j<V;j++) {
				if (Graph[i][j] != 0 && visited[j] == false && Graph[i][j] < weight[j]) { 
                    parent[j] = i; 
                    weight[j] = Graph[i][j]; 
                } 
			}
		}
		
		// Used to call method which print MST(Minimum Spanning Tree)
		printMST(Graph,parent,V);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the no. of vertex: ");
		int V = sc.nextInt();
		
		System.out.print("Enter the no. of Edges: ");
		int E = sc.nextInt();
		
		int Graph[][] = new int[V][V];
		
		for(int i=0;i<V;i++) {
			for(int j=0;j<V;j++) 
				Graph[i][j] = 0;
		}
		
		 // Here I assign weight of edge b/w given source and given destination of edge
		for(int i=0;i<E;i++) {
			System.out.print("Enter source , destination and weight of edge: ");
			int src = sc.nextInt();
			int dest = sc.nextInt();
			int w = sc.nextInt();
			
			Graph[src][dest] = Graph[dest][src] = w;
		}
		
		PrimsAlgo(Graph,V);
		
		sc.close();
	}

}
