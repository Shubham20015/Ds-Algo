package hashing;

import java.util.*;

public class HuffmanCoding {
	
	static class HuffmanNode{
		
		int data;
		char c;
		
		HuffmanNode left;
		HuffmanNode right;
	}
	
	static class MyComparator implements Comparator<HuffmanNode>{
		
		public int compare(HuffmanNode x,HuffmanNode y) {
			return x.data - y.data;
		}
	}

	static void print(HuffmanNode root,String s) {
		
		if(root.left == null && root.right == null && Character.isLetter(root.c)) {
			System.out.println(root.c+": "+s);
			return;
		}
		
		print(root.left,s+"0");
		print(root.right,s+"1");
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); 
		   
		System.out.print("Enter no. of characters: ");
        int n = sc.nextInt();
  
        // creating a priority queue q. 
        // makes a min-priority queue(min-heap). 
        PriorityQueue<HuffmanNode> q 
            = new PriorityQueue<HuffmanNode>(n, new MyComparator());
        
        for(int i=0;i<n;i++) {
        	
        	HuffmanNode node = new HuffmanNode();
        	
        	System.out.print("Enter character and it's frequency: ");
        	node.c = sc.next().charAt(0);
        	node.data = sc.nextInt();
        	
        	node.left = node.right = null;
        	
        	q.add(node);
        }
        
        HuffmanNode root = null;
        
        while(q.size() > 1) {
        	
        	HuffmanNode x = q.poll();
        	
        	HuffmanNode y = q.poll();
        	
        	HuffmanNode r = new HuffmanNode();
        	
        	r.data = x.data + y.data;
        	r.c = '-';
        	
        	r.left = x;
        	r.right = y;
        	
        	root = r;
        	
        	q.add(root);
        }
		
        System.out.println("Hash Code of Characters: ");
        print(root,"");
        
        sc.close();
        
	}

}
