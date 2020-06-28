package graph;

import java.util.Scanner;

class BellmanFordAlgo {
	
	class Edge{
		
		int src,dest,weight;
		Edge(){
			src = dest = weight = 0;
		}
	}
	
	int V,E;
	Edge edge[];
	
	BellmanFordAlgo(int v, int e) 
    { 
        V = v; 
        E = e; 
        edge = new Edge[e]; 
        for (int i = 0; i < e; ++i) 
            edge[i] = new Edge(); 
    } 
	
	void BellmanFord(BellmanFordAlgo graph,int src) {
		
		int V = graph.V, E = graph.E; 
        int dist[] = new int[V]; 
        
        for (int i = 0; i < V; ++i) 
            dist[i] = Integer.MAX_VALUE; 
        
            dist[src] = 0;
            
             // Relax all edges |V| - 1 times. A simple 
            // shortest path from src to any other vertex can 
            // have at-most |V| - 1 edges 
            for(int i=1;i<V;i++) {
            	for(int j=0;j<E;j++) {
            		int u = graph.edge[j].src; 
                    int v = graph.edge[j].dest; 
                    int weight = graph.edge[j].weight;
                    if(weight!= Integer.MAX_VALUE && dist[u] + weight < dist[v])
                    		dist[v] = dist[u] + weight;
            	}
            }
            
             // Check for negative-weight cycles. The above 
            // step guarantees shortest distances if graph doesn't 
            // contain negative weight cycle. If we get a shorter 
            // path, then there is a cycle. 
            for(int j=0;j<E;j++) {
        		int u = graph.edge[j].src; 
                int v = graph.edge[j].dest; 
                int weight = graph.edge[j].weight;
                if(weight!= Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                		System.out.println("Graph contains negative weight cycle");
                		return;
                }
        	}
            	// Print distances from source
            	System.out.println("Vertex\t Distance from Source"); 
                for (int i = 1; i < V; ++i) 
                    System.out.println(i + "\t\t" + dist[i]); 
            }
            
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter no. of vertex in Graph: ");
		int V = sc.nextInt();  
		System.out.print("Enter no. of edge in Graph: ");
        int E = sc.nextInt(); 
  
        BellmanFordAlgo g = new BellmanFordAlgo(V, E); 
  
         for(int i=0;i<E;i++) {
        System.out.print("Enter source,destination,weight of Edge: ");
        g.edge[i].src = sc.nextInt(); 
        g.edge[i].dest = sc.nextInt(); 
        g.edge[i].weight = sc.nextInt(); 
         }
         
         System.out.print("Enter starting Element: ");
         int x = sc.nextInt();
         
        g.BellmanFord(g, x); 

        sc.close();
	}

}
