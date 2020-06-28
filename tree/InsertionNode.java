package tree;

import java.util.*;


public class InsertionNode extends InsertNode {
	
	
//	static Node root;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Do you want to add no. in tree: ");
		char ch = sc.next().charAt(0);
		while(ch == 'Y') {
		System.out.print("Enter number you want to add: ");
		int data = sc.nextInt();
		insert(data,root);
		System.out.print("Do you want to add more: ");
		ch = sc.next().charAt(0);
		}
		
		System.out.print("What type transversal of Binary tree you want(Inorder,Preorder,Postorder,Levelorder): ");
		String s = sc.next();
		switch(s) {
		case "Inorder":System.out.print("Inorder Transversal of Binary tree: ");
						inorder(root);
						break;
		case "Preorder":System.out.print("Preorder Transversal of Binary tree: ");
		                 preorder(root);
		                 break;
		case "Postorder":System.out.print("Postorder Transversal of Binary tree: ");
		                 postorder(root);
		                 break;
		case "Levelorder":System.out.print("Reverse Levelorder Transversal of Binary tree: ");
                          levelorder(root);
                          break;
        default:  System.out.println("Wrong Input");
		}
		sc.close();
	}
	
	
	static void inorder(Node temp) {
		if(temp == null) {
			return;
		}
		
		inorder(temp.left);
		System.out.print(temp.data+" ");
		inorder(temp.right);
	}
	
	static void preorder(Node temp) {
		if(temp == null) {
			return;
		}
		
		System.out.print(temp.data+" ");
		preorder(temp.left);
		preorder(temp.right);
	}
	
	static void postorder(Node temp) {
		if(temp == null) {
			return;
		}
		
		postorder(temp.left);
		postorder(temp.right);
		System.out.print(temp.data+" ");
	}
	
   static void levelorder(Node temp) {
		
		Queue<Node> q = new LinkedList<>();
		// stack is not required for Normal Level order
		Stack<Node> st = new Stack<>();
		q.add(temp);
		
		while(!q.isEmpty()) {
			temp = q.remove();
			st.push(temp);
			// Node tempnode = temp;
//			System.out.print(tempnode.data+" ");
			
			if(temp.left != null) 
				q.add(temp.left);
			
			
			if(temp.right != null) 
				q.add(temp.right);
			
		}
		while(!st.empty()) {
			temp = st.peek();
			System.out.print(temp.data+" ");
			st.pop();
		}
	}
	
}
