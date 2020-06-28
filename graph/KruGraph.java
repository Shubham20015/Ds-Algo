package graph;

import java.util.Arrays;
// Implementation of this class is in KrushalAlgo
public class KruGraph {
	
static class Edge implements Comparable<Edge>{
		
		int src,dest,weight;
		
		@Override
		public int compareTo(Edge Compare) {
			return this.weight - Compare.weight;
		}
		
	}
		
		static class subset{
			int parent,rank;
		}
		
		static int V,E;
		Edge edge[];
		
		KruGraph(int v,int e){
			V = v;
			E = e;
			edge = new Edge[E];
			for(int i=0;i<E;i++) 
				edge[i] = new Edge();
		}
		// checking for cyclic or not
		static int find(subset set[],int i) {
			if(set[i].parent != i) {
				set[i].parent = find(set,set[i].parent);
			}
			return set[i].parent;
		}
//		To find union of selected nodes
		static void Union(subset set[],int x,int y) {
			
			int xroot = find(set,x);
			int yroot = find(set,y);
			
			if(set[xroot].rank < set[xroot].rank)
				set[xroot].parent = yroot;
			else if(set[xroot].rank > set[xroot].rank)
				set[yroot].parent = xroot;
			else
				set[yroot].parent = xroot;
				set[xroot].rank++;
		}
		
		void KrushalMST() {
			Edge result[] = new Edge[V];
			int e = 0;
			int i = 0;
			
			// Step 1:  Sort all the edges in non-decreasing order of their 
	        // weight.  If we are not allowed to change the given graph, we 
	        // can create a copy of array of edges 
			Arrays.sort(edge);
			
			// Allocate memory for creating V ssubsets
			subset subsets[] = new subset[V]; 
	        for(i=0; i<V; ++i) 
	            subsets[i]=new subset(); 
	  
	     // Create V subsets with single elements
	        for (int v = 0; v < V; ++v) 
	        { 
	            subsets[v].parent = v; 
	            subsets[v].rank = 0; 
	        } 
	  
	        i = 0; 
			
			while(e < V-1) {
				
				// Step 2: Pick the smallest edge. And increment  
	            // the index for next iteration 
				Edge next_edge = new Edge(); 
	            next_edge = edge[i++];
				
	            // check whether it cause cycling or not
				int x = find(subsets,next_edge.src);
				int y =	find(subsets,next_edge.dest);	
				
				// If including this edge does't cause cycle, 
	            // include it in result and increment the index  
	            // of result for next edge 
				if(x!=y) {
					result[e++] = next_edge; 
	                Union(subsets, x, y); 
				}
			}
				
				System.out.println("Following are the edges in the constructed MST"); 
				for (i = 0; i < e; ++i) 
					System.out.println(result[i].src+" -- " + result[i].dest+" == " + result[i].weight); 
		}
}
