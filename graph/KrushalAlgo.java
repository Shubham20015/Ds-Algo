package graph;

import java.util.Scanner;
// Logic of this program is in KruGraph class
public class KrushalAlgo {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter no. of vertex in graph: ");
		int V = sc.nextInt();
		System.out.print("Enter no. of edges in graph: ");
		int E = sc.nextInt();
		
		KruGraph g  = new KruGraph(V,E);
		
		for(int i=0;i<E;i++) {
			System.out.print("Enter source , destination & weight of "+i+" Edge: ");
			g.edge[i].src = sc.nextInt();
			g.edge[i].dest = sc.nextInt();
			g.edge[i].weight = sc.nextInt();
		}
		
		g.KrushalMST();
		
		sc.close();
	}

}
