package searchingSorting;

import java.util.Scanner;

public class CountingSort {
	
	static void countSort(int A[],int n,int k) {
		int count[] = new int[k+1];
		int b[] = new int[n];
		
		for(int i=0;i<n;i++)
			++count[A[i]];
		for(int i=1;i<=k;i++) 
			count[i] += count[i-1];
		for(int i=n-1;i>=0;i--)
			b[--count[A[i]]] = A[i];
		for(int i=0;i<n;i++)
			A[i] = b[i];
	}
	
	static void printArr(int A[],int N) {
		
		System.out.print("Sorted Array: ");
		for(int i=0;i<N;i++) 
			System.out.print(A[i]+" ");
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter size of Array: ");
		int N = sc.nextInt();
		
		System.out.print("Enter range of input(Not more than N^2): ");
		int k = sc.nextInt();
		
		int A[] = new int[N];
		
		
		for(int i=0;i<N;i++) {
			System.out.print("Enter data of array: ");
			A[i] = sc.nextInt();
		}
		
		countSort(A,N,k);
		
		printArr(A,N);
		
		sc.close();
	}

}

