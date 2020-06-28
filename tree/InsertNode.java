package tree;

import java.util.LinkedList;
import java.util.Queue;


public class InsertNode {

static class Node{
		
		int data;
		Node left;
		Node right;
		
		Node(int data){
			this.data = data;
			left = right = null;
		}
		
	}
	
	static Node root;
	
static void insert(int data,Node temp) {
		
		if(temp == null) {
			root = new Node(data);
		}
		else {
		Queue<Node> q = new LinkedList<>();
		q.add(temp);
		
		while(!q.isEmpty()) {
			temp = q.remove();
			
			if(temp.left == null) {
				temp.left = new Node(data);
				break;
			}
			else 
				q.add(temp.left);
			
			
			if(temp.right == null) {
				temp.right = new Node(data);
				break;
			}
			else 
				q.add(temp.right);
			
			}
		}
	}
	
}
