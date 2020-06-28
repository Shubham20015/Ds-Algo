package graph;

import java.util.*;

public class ConnectedComponent {

	
	static void addEdge(int u,int v) {
		ll.get(u).add(v);
		ll.get(v).add(u);
	}
	
//	Implement DFS transversal 
	static void dfs(int src,boolean visited[]) {
		
		visited[src] = true;
		System.out.print(src+" ");
		
        for(int i: ll.get(src)) 
        { 
            if (!visited[i]) 
                dfs(i,visited); 
        }
	}

	// check connected components in undirected graph
	static void connect() {
		boolean visited[] = new boolean[V];
		int count = 0;
		
		for(int i=0;i<V;i++){
			if(!visited[i]) {
				dfs(i,visited);
				count++;
			System.out.println();
			}
		}
		System.out.println("No. of components: "+count);
	}
	
	static int V;
	
	static List<ArrayList<Integer>> ll = new ArrayList<>(V);
	
public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);
	
	System.out.print("Enter no. of vertices in Graph: ");
	V = sc.nextInt();
	
	
	for (int i = 0; i < V; i++)
	      ll.add(new ArrayList<Integer>());
	
	addEdge(0,1);
	addEdge(2,3);
	addEdge(3,4);
	addEdge(5,6);
	addEdge(6,7);
	
	System.out.println("Following are connected components");
	connect();
	
	sc.close();
}

}
