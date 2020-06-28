package recursion;

import java.util.Scanner;

public class arraySum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter size of Array: ");
		
		int N = sc.nextInt();
		
		int A[] = new int [N];
		
		System.out.println("Enter Array elements: ");
		
		for(int i=0;i<N;i++) {
			A[i] = sc.nextInt();
		}
		
		System.out.println("Sum of an Array: "+sumArr(A,N));
		
		sc.close();
	}

	static int sumArr(int a[],int n) {
		if(n<=0) {
			return 0;
		}
		return sumArr(a,n-1)+a[n-1];
	}
}
