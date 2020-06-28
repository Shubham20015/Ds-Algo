package tree;

import java.util.Scanner;

public class SplayTree {

	static class Node{
		int data;
		Node left,right;
		Node(int data){
			this.data = data;
			left = right = null;
		}
	}
		static Node root;
		
		static Node leftRotate(Node x) {
			Node y = x.right;
			x.right = y.left;
			y.left = x;
			return y;
		}
		
		static Node RightRotate(Node x) {
			Node y = x.left;
			x.left = y.right;
			y.right = x;
			return y;
		}
		
		static Node splay(Node temp,int data) {
			
			if(temp == null || temp.data == data)
			return temp;
			
			// Key lies in left subtree
			if(data<temp.data) {
				
				// Key is not in tree, we are done
				if(temp.left == null) {
					return temp;
				}
				// Zig - Zig (Left-Left)
				if(temp.left.data > data) {
					temp.left.left = splay(temp.left.left,data);
					// Do first rotation for root,  
		            // second rotation is done after else
					temp = RightRotate(temp);
				}
				
				else if(temp.left.data < data) { // Zig-Zag (Left-Right)
					
					temp.left.right = splay(temp.left.right,data);
					// Do first rotation for root->left
					if(temp.left.right != null)
					temp.left = leftRotate(temp.left);
				}
				// Do second rotation for root
				return (temp.left == null)?temp:RightRotate(temp);
			}
			else { // Key lies in right subtree
				
				// Key is not in tree, we are done
				if(temp.right == null) {
					return temp;
				}
				// Zag-Zag (Right Right)
				if(temp.right.data < data) {
					// Bring the key as root of  
		            // right-right and do first rotation 
					temp.right.right = splay(temp.right.right,data);
					temp = leftRotate(temp);
				}
				// Zig-Zag (Right Left) 
				else if(temp.right.data > data) {
					temp.right.left = splay(temp.right.left,data);
					
					// Do first rotation for root->right
					if(temp.right.left != null) 
						temp.right = RightRotate(temp.right);
				}
				// Do second rotation for root 
				return (temp.right == null)?temp:leftRotate(temp);
			}
		}
		
		static Node insert(Node temp,int data) {
			
			if(temp == null) 
				return new Node(data);
			
			// Bring the closest leaf node to root
			temp = splay(temp,data);
			
			if(temp.data == data) 
				return temp;
			
			
			Node newNode = new Node(data);
			
			if(data<temp.data) {
				newNode.right = temp;
				newNode.left = temp.left;
				temp.left = null;
			}
			
			else {
				newNode.left = temp;
				newNode.right = temp.right;
				temp.right = null;
			}
			
			return newNode;
		}
		
		static Node delete(Node temp,int data) {
			
			Node x = temp;
			
			if(temp == null)
				return null;
			
			temp = splay(temp,data);
			
			if(temp.data != data)
				return temp;
			
			if(temp.left == null) {
//				x = temp;
				temp = temp.right;
			}else {
//				x = temp;
				temp = splay(temp.left,data);
				temp.right = x.right;
			}
			
			x = null;
			return temp;
		}
		
		static void preOrder(Node node) {
	  		if(node == null)
	  			return;
	  		
	  		System.out.print(node.data+" ");
	  		preOrder(node.left);
	  		preOrder(node.right);
	  	}

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		
		System.out.print("Do you want to add an element to Splay Tree(Y or N): ");
		char ch = sc.next().charAt(0);
		
		while(ch == 'Y') {
			System.out.print("Enter number you want to add: ");
			int data = sc.nextInt();
			root = insert(root,data);
			
			System.out.print("Do you want to add more: ");
			ch = sc.next().charAt(0);
			}
		
		System.out.print("Preorder transeversal of Splay Tree: ");
		preOrder(root);
		
		System.out.println();
		
		System.out.print("Do you want to delete an element from Splay Tree(Y or N): ");
		char del = sc.next().charAt(0);
		
		if(del == 'Y') {
			System.out.print("Enter number you want to delete: ");
			int data = sc.nextInt();
			root = delete(root,data);
			System.out.print("Preorder transeversal of Splay Tree after deletion: ");
			preOrder(root);
		}else {
			System.out.print("Thanks to run this program");
		}
		sc.close();
	}

}

