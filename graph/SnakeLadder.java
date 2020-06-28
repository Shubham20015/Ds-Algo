package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class SnakeLadder {
	
	static void addEdge(int u,int v,boolean birdir) {
		ll.get(u).add(v);
		if(birdir == true)
		ll.get(v).add(u);
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
//		This function also contain shortest distance of destination node and shortest path of given node
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
	
	static int V;
	
	static List<ArrayList<Integer>> ll = new ArrayList<>(V);
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter no. of boxes on board: ");
		V = sc.nextInt();
		
		
		for (int i = 0; i < V; i++)
		      ll.add(new ArrayList<Integer>());
		
		int board[] = new int [50];
		board[2] = 13;
		board[5] = 2;
		board[9] = 18;
		board[18] = 11;
		board[17] = -13;
		board[20] = -14;
		board[24] = -8;
		board[25] = -10;
		board[32] = -2;
		board[34] = -22;
		
		for(int u=0;u<36;u++) {
			for(int dice=1;dice<=6;dice++) {
				int v = u+dice+board[u+dice];
				addEdge(u,v,false);
			}
		}
		
		bfs(0,36);
		
		sc.close();

	}

}
