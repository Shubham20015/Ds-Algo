package recursion;

import java.util.Scanner;

public class BubbleSort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter size of Array: ");
		
		int N = sc.nextInt();
		
		int A[] = new int [N];
		
		System.out.println("Enter Array elements: ");
		
		for(int i=0;i<N;i++) {
			A[i] = sc.nextInt();
		}
		
		sorted(A,N);
		
		System.out.println("Sorted Array: ");
		
		for(int x: A) {
			System.out.print(x+" ");
		}
		
		sc.close();
	}

	static void sorted(int a[],int n) {
		if(n== 1)
			return;
		
		for(int i=0;i<n-1;i++)
		if(a[i]>a[i+1]) {
			int temp = a[i];
			a[i] = a[i+1];
			a[i+1] = temp;
		}
		
		sorted(a,n-1);
	}
}
