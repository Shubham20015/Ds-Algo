package recursion;

import java.util.Scanner;

public class MinJump {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter size of Array: ");
		
		int N = sc.nextInt();
		
		int A[] = new int [N];
		
		System.out.println("Enter Array elements: ");
		
		for(int i=0;i<N;i++) {
			A[i] = sc.nextInt();
		}
		
		System.out.println("Minimum jumps needed to reach end: "+ jump(A,0,N-1));
		
		
		sc.close();
	}

	static int jump(int a[],int x,int n) {
		if(x==n || a[0] == 0)
			return 0;
		
		 int min = Integer.MAX_VALUE; 
		 
	        for (int i = x + 1; i <= n && i <= x + a[x]; i++) { 
	            int jumps = jump(a, i, n); 
	            
	            if (jumps != Integer.MAX_VALUE && jumps + 1 < min) 
	                min = jumps + 1; 
	        }
	        
	        return min;
	}
}

