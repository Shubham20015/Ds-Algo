package tree;


import java.util.Scanner;

/*
 AVL Tree Conditions 
 	1. It is same function as Binary search Tree.
 	2. It has a condition that tree always balanced.
*/
public class AVLtree {

  static class Node{
		
		int data,height;
		Node left;
		Node right;
		
		Node(int data){
			this.data = data;
			height = 1;
		}	
	}
  	// Original root of Tree
  	static Node root;
  	
  	//Use to find height of Tree
  	static int height(Node N) {
  		if(N == null) 
  			return 0;
  		
  		return N.height;
  	}
  	
  	//Used to check whether Tree is balanced or not
  	static int getBalance(Node N) {
  		if(N == null)
  			return 0;
  		
  		return height(N.left) - height(N.right);
  	}
  	
  	static Node leftRotate(Node x) {
  		Node y = x.right;
  		Node T = y.left;
  		
  		y.left = x;
  		x.right = T;
  		
  		 x.height = Math.max(height(x.left), height(x.right)) + 1; 
         y.height = Math.max(height(y.left), height(y.right)) + 1; 
         
         
  		return y;
  	}
  	
  	static Node rightRotate(Node y) {
  		Node x = y.left;
  		Node T = x.right;
  		
  		x.right = y;
  		y.left = T;
  		
  		 y.height = Math.max(height(y.left), height(y.right)) + 1; 
         x.height = Math.max(height(x.left), height(x.right)) + 1; 
         
         
  		return x;
  	}
  	
  	//Used to get minimum value of Tree
  	static Node minValue(Node node) {
  		Node current = node;
  			
  			while(current.left != null){
  				current = current.left;
  			}
  			
  			return current;
  	}
  	
  	static Node insert(int data,Node temp) {
  		
  		 // Perform the normal BST insertion
  		if(temp == null) {
  			return (new Node(data));
  		}
  		
  		if(data<temp.data) 
  			temp.left = insert(data,temp.left);
  		
  		else if(data>temp.data)
  			temp.right = insert(data,temp.right);
  		
  		else
  			return temp;
  		
  		temp.height = Math.max(height(temp.left), height(temp.right))+1;
  		
  		/* Get the balance factor of this ancestor 
        node to check whether this node became 
        unbalanced */
  		int balance = getBalance(temp);
  		
  		//If this node becomes unbalanced, then there are 4 cases
  		
  		// 1. LL
  		if(balance>1 && data<temp.left.data) {
  			return rightRotate(temp);
  		}
  		// 2. RR
  		if(balance<-1 && data>temp.right.data) {
  			return leftRotate(temp);
  		}
  		// 3. LR
  		if(balance>1 && data>temp.left.data) {
  			temp.left = leftRotate(temp.left);
  			return rightRotate(temp);
  		}
  		// 4. RL
  		if(balance<-1 && data<temp.right.data) {
  			temp.right = rightRotate(temp.right);
  			return leftRotate(temp);
  		}
  		
  		return temp;
  	}
  	
  	
  	static void preOrder(Node node) {
  		if(node == null)
  			return;
  		
  		System.out.print(node.data+" ");
  		preOrder(node.left);
  		preOrder(node.right);
  	}
  
  	static Node delete(int data,Node temp) {
  		if(temp == null) {
  			return temp;
  		}
  		
  		if(data<temp.data) 
  			temp.left = delete(data,temp.left);
  		
  		else if(data>temp.data)
  			temp.right = delete(data,temp.right);
  		
  		// if key is same as root's key, then this is the node  
        // to be deleted  
  		else
  		{
  			// node with only one child or no child
  			if(temp.left == null || temp.right == null) {
  				
  				Node x = null;
  				
  				if(x == temp.left) 
  					x = temp.right;
  				else
  					x = temp.left;
  				
  				// No child case
  				if(x == null) {
  					x = temp;
  					temp = null;
  				}else { // One child case  
  					temp = x; // Copy the contents of  
                             // the non-empty child 
  				}
  			}else {
  				
  				// node with two children: Get the inorder  
                // successor (smallest in the right subtree)
  				Node x = minValue(temp.right);
  				
  				// Copy the inorder successor's data to this node
  				temp.data = x.data;
  				
  				// Delete inorder successor
  				temp.right = delete(x.data,temp.right);
  			}
  		}
  		
  		if(temp == null) {
  			return temp;
  		}
  		
  		temp.height = Math.max(height(temp.left), height(temp.right))+1;
  		
  		int balance = getBalance(temp);
  		
  		if(balance>1 && getBalance(temp.left)>=0) {
  			return rightRotate(temp);
  		}
  		if(balance<-1 && getBalance(temp.right)<=0) {
  			return leftRotate(temp);
  		}
  		if(balance>1 && getBalance(temp.left)<0) {
  			temp.left = leftRotate(temp.left);
  			return rightRotate(temp);
  		}
  		if(balance<-1 && getBalance(temp.right)>0) {
  			temp.right = rightRotate(temp.right);
  			return leftRotate(temp);
  		}
  		
  		return temp;
  	}
  	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		System.out.print("Do you want to add an element to AVL Tree(Y or N): ");
		char ch = sc.next().charAt(0);
		
		
		while(ch == 'Y') {
			System.out.print("Enter number you want to add: ");
			int data = sc.nextInt();
			root = insert(data,root);
			
			System.out.print("Do you want to add more: ");
			ch = sc.next().charAt(0);
			}
		
		System.out.print("Preorder transeversal of Avl Tree: ");
		preOrder(root);
		
		System.out.println();
		
		System.out.print("Do you want to delete an element from AVL Tree(Y or N): ");
		char del = sc.next().charAt(0);
		
		if(del == 'Y') {
			System.out.print("Enter number you want to delete: ");
			int data = sc.nextInt();
			root = delete(data,root);
			System.out.print("Preorder transeversal of Avl Tree after deletion: ");
			preOrder(root);
		}else {
			System.out.print("Thanks to run this program");
		}
		sc.close();
	}
}
