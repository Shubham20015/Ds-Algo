package graph;

import java.util.Scanner;

// G^k(i,j) = min(G^k-1(i,j) , G^k-1(i,k) + G^k-1(k,j))
public class FloydWarshallAlgo {
	
	static void ShortestDistance(int graph[][],int V) {
		
		for(int k=0;k<V;k++) {
			for(int i=0;i<V;i++) {
				for(int j=0;j<V;j++) {
					
					if(graph[i][k] != Integer.MAX_VALUE && graph[k][j] != Integer.MAX_VALUE && graph[i][k] + graph[k][j] < graph[i][j])
						graph[i][j] = graph[i][k] + graph[k][j];
			}
		}
	}
		 
		// Print final Matrix of Solution 
		System.out.println("The following matrix shows the shortest distances between every pair of vertices"); 
		for(int i=0;i<V;i++) {
			for(int j=0;j<V;j++) {
				if(graph[i][j] == Integer.MAX_VALUE)
				System.out.print("INF ");
				else
				System.out.print(graph[i][j]+" ");
			}
			System.out.println();
		}
		
}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter no. of vertex in graph: ");
		int V = sc.nextInt();
		
		int graph[][] = new int[V][V];
		
		for(int i=0;i<V;i++) {
			for(int j=0;j<V;j++) {
				if(i == j)
				graph[i][j] = 0;
				else
				graph[i][j] = Integer.MAX_VALUE;
			}
		}
		
		System.out.print("Enter no. of edges in graph: ");
		int E = sc.nextInt();
		
		for(int i=0;i<E;i++) {
			 System.out.print("Enter source,destination,weight of Edge: ");
		        int src = sc.nextInt(); 
		        int dest = sc.nextInt(); 
		        int weight = sc.nextInt(); 
		        graph[src][dest] = weight;
		}
		
		ShortestDistance(graph,V);
		
		sc.close();
	}

}
