package graph;

import java.util.Scanner;

public class AdjacentcyMatrix {
	
	static class Graph{
		private int V;
		private int adjMatrix [][];
		Graph(int V) {
			this.V = V;
			adjMatrix = new int[V][V];
		}
		
		public void addEdge(int i, int j) {
		    adjMatrix[i][j] = 1;
		    adjMatrix[j][i] = 1;
		  }

		  
		  public void removeEdge(int i, int j) {
		    adjMatrix[i][j] = 0;
		    adjMatrix[j][i] = 0;
		  }
		  
		  public void printGraph() {
			  
			  System.out.println("Adjacency Matrix of Graph: ");
			  
				for(int i=0;i<V;i++) {
					for(int j=0;j<V;j++) {
						System.out.print(adjMatrix[i][j]+" ");
					}
					System.out.println();
				}
		  }
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter no. of vertices in Graph: ");
		int V = sc.nextInt();
		
		Graph g = new Graph(V);
		
		g.addEdge(0,1);
		g.addEdge(0,2);
		g.addEdge(0,3);
		g.addEdge(1,2);
		
		g.printGraph();
		
		sc.close();
	}

}
