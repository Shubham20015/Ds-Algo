package graph;

import java.util.Scanner;

public class DijikstraAlgo {

	
	 static int minDist(int dist[], boolean sptSet[]) 
	    { 
	        int min = Integer.MAX_VALUE, min_index = -1; 
	  
	        for (int v = 0; v < dist.length; v++) {
	            if (!sptSet[v] && dist[v] < min) { 
	                min = dist[v]; 
	                min_index = v; 
	            } 
	        }
	        return min_index; 
	    } 
	 
	 static void printSol(int dis[]) {
		 System.out.println("Vertex \t\t Distance from Source");
		 for(int i=0;i<dis.length;i++) {
			 System.out.println(i+ " \t\t "+ dis[i]);
		 }
	 }
	
	static void ShortestPath(int graph[][],int src,int V) {
		
		int dis[] = new int[V];
		boolean spt[] = new boolean[V];
		
		for(int i=0;i<V;i++) {
			dis[i] = Integer.MAX_VALUE;
			spt[i] = false;
		}
		
		dis[0] = 0;
		
		for(int i=0;i<V-1;i++) {
			
			int u = minDist(dis,spt);
			
			spt[u] = true;
			
			for(int v=0;v<V;v++) 
				
				// Update dist[v] only if is not in spt, there is an 
                // edge from u to v, and total weight of path from src to 
                // v through u is smaller than current value of dist[v] 
				if(!spt[v] && graph[u][v] != 0 && dis[u] != Integer.MAX_VALUE && (dis[u] + graph[u][v] < dis[v]))
					dis[v] = dis[u] + graph[u][v];
			
		}
		
		printSol(dis);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter a vertex of Graph: ");
		int V = sc.nextInt();
		
		System.out.print("Enter no. of edges in Graph: ");
		int E = sc.nextInt();
	 
		int graph[][] = new int[V][V];
		
		for(int i=0;i<V;i++) {
			for(int j=0;j<V;j++) {
				graph[i][j] = 0;
			}
		}
		
		/* Example graph
		{ 0, 4, 0, 0, 0, 0, 0, 8, 0 }, 
        { 4, 0, 8, 0, 0, 0, 0, 11, 0 }, 
        { 0, 8, 0, 7, 0, 4, 0, 0, 2 }, 
        { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, 
        { 0, 0, 0, 9, 0, 10, 0, 0, 0 }, 
        { 0, 0, 4, 14, 10, 0, 2, 0, 0 }, 
        { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, 
        { 8, 11, 0, 0, 0, 0, 1, 0, 7 }, 
        { 0, 0, 2, 0, 0, 0, 6, 7, 0 } }; */
		
		for(int i=0;i<E;i++) {
			System.out.print("Enter source,destination elements & data: ");
			int src = sc.nextInt();
			int dest = sc.nextInt();
			int data = sc.nextInt();
			graph[src][dest] = data;
			graph[dest][src] = data;
		}
		
		System.out.print("Enter source element: ");
		int x = sc.nextInt();
		
		ShortestPath(graph,x,V);
		
		sc.close();
	}

}
