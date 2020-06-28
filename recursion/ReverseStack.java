package recursion;

import java.util.*;

public class ReverseStack {

	static Stack<Integer> st = new Stack<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("No. of elements you want to add: ");
		int N = sc.nextInt();
		
		System.out.print("Enter elements: ");
		
		while(N-->0) {
			int x = sc.nextInt();
			st.push(x);
		}
		reverse();
		
		System.out.print("Reversed Stack: "); 
        
        System.out.println(st); 
		
		sc.close();
	}

	static void reverse() {
		if(st.size()>0) {
			int a = st.pop();
			reverse();
			insertBottom(a);
		}
	}
	
	static void insertBottom(int a) {
		if(st.isEmpty()) {
			st.push(a);
		}else {
			int b = st.pop();
			insertBottom(a);
			st.push(b);
		}
	}
}
