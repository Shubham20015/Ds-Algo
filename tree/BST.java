package tree;

import java.util.*;


public class BST {

	static class Node{
		
		int data;
		Node left,right;
		Node(int data){
			this.data = data;
			left = right = null;
		}
	}
	
	static Node root;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Do you want to add no. in tree: ");
		char ch = sc.next().charAt(0);
		while(ch == 'Y') {
		System.out.print("Enter number you want to add: ");
		int data = sc.nextInt();
		root = insert(data,root);
		System.out.print("Do you want to add more: ");
		ch = sc.next().charAt(0);
		}
		
		System.out.print("Inorder tranversal of Binary search tree: ");
        inorder(root);
        
        System.out.println();
		
		System.out.print("Do you want to delete an element from AVL Tree(Y or N): ");
		char del = sc.next().charAt(0);
		
		if(del == 'Y') {
			System.out.print("Enter number you want to delete: ");
			int data = sc.nextInt();
			root = delete(data,root);
			System.out.print("Inorder transeversal of Avl Tree after deletion: ");
			inorder(root);
		}else {
			System.out.print("Thanks to run this program");
		}
		
//		printpath(root);  -> Not working (Face some problems)
        sc.close();
	}
	
	static Node insert(int data,Node temp) {
		
		if(temp == null) 
			return new Node(data);
		
		if(data<temp.data)
			temp.left = insert(data,temp.left);
		else
			temp.right = insert(data,temp.right);
		
		return temp;
	}
	
	static Node delete(int data,Node temp) {
		if(temp == null) 
			return null;
		
		if(data<temp.data)
			temp.left = delete(data,temp.left);
		else if(data>temp.data)
			temp.right = delete(data,temp.right);
		else {
			
				if(temp.left == null || temp.right == null) {
					
					Node x = null;
					if(temp.left == x) 
						x = temp.right;
					else
						x = temp.left;
					
					if(x == null) {
						x = temp;
						temp = null;
					}else
						temp = x;
				}
				
				else {
					
					Node x = minValue(temp.right);
					
					temp.data = x.data;
					
					temp.right = delete(x.data,temp.right);
				}
		}
		return temp;
	}
	
	static Node minValue(Node node) {
  		Node current = node;
  			
  			while(current.left != null){
  				current = current.left;
  			}
  			
  			return current;
  	}
  	
	static void inorder(Node temp) {
		if(temp == null) {
			return;
		}
		
		inorder(temp.left);
		System.out.print(temp.data+" ");
		inorder(temp.right);
	}
	
	static void printpath(Node temp) {
		int path[] = new int[1000];
		prirecursive(path,temp,0);
	}
	// This is not working 
	static void prirecursive(int path[],Node temp,int len) {
		if(temp == null) {
			return;
		}
		
		path[len] = temp.data;
		len++;
		
		if(temp.left == null && temp.right == null) {
			for(int i=0;i<len;i++) {
				System.out.print(path[i]+" ");
				
				System.out.println();
			}
		}
			else {
			prirecursive(path,temp.left,len);
			prirecursive(path,temp.right,len);
			}
		}
}

