package graph;

import java.util.*;

public class AdjacentcyList {

	
		static void addEdge(int u,int v) {
			ll.get(u).add(v);
			ll.get(v).add(u);
		}
		
		static void printList() {
			System.out.println("Adjacentacy List of Graph:");
			for(int i=0;i<ll.size();i++) {
				System.out.print(i+" --> ");
				for(int j: ll.get(i)) {
					System.out.print(j+" ");
				}
				System.out.println();
			}
		}
		
		static void bfs(int src,int dest) {
			Queue<Integer> q = new LinkedList<>();
			boolean visited[] = new boolean[V+1];
			int dist[] = new int[V+1];
			int parent[] = new int[V+1];
			
			for(int i=0;i<ll.size();i++) {
				parent[i] = -1;
			}
			q.add(src);
			visited[src] = true;
//			This function also contain shortest distance of destination node and shortest path of given node
			System.out.print("BFS transversal of Graph: ");
			while(!q.isEmpty()) {
				int x = q.poll();
				System.out.print(x+" ");
				
				for(int i: ll.get(x)) {
					if(!visited[i]) {
						q.add(i);
						visited[i] = true;
						dist[i] = dist[x] + 1;
						parent[i] = x;
					}
				}
			}
			System.out.println();

			System.out.println("Shortest distance is "+dist[dest]+" from given node "+dest);
			System.out.print("Shortest path: ");
			
			while(dest != -1) {
				System.out.print(dest+"<--");
				dest = parent[dest];
			}
			System.out.println();
		}

		static void dfs(int src,boolean visited[]) {
			
			visited[src] = true;
			System.out.print(src+" ");
			
	        for(int i: ll.get(src)) 
	        { 
	            if (!visited[i]) 
	                dfs(i,visited); 
	        }
		}
//		Implement DFS transversal by calling above program dfs()
		static void DFSgraph(int src) {
			boolean visited[] = new boolean[V];
			for(int i=0;i<V;i++){
				visited[i] = false;
			}
			System.out.print("DFS transversal of Graph: ");
			dfs(src,visited);
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
		addEdge(1,2);
		addEdge(0,4);
		addEdge(2,4);
		addEdge(3,2);
		addEdge(2,3);
		addEdge(3,5);
		addEdge(3,4);
		
		printList();
		
		bfs(0,5);
		
		DFSgraph(2);
		
		sc.close();
	}

}
