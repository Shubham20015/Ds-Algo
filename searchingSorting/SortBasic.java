package searchingSorting;

import java.util.Scanner;

// This program contains Bubble , Selection & Insertion Sorting methods
public class SortBasic {
	
	static void bubbleSort(int A[],int n) {
		for(int i=0;i<n-1;i++) {
				int flag = 0;
			for(int j=0;j<n-i-1;j++)
			if(A[j]>A[j+1]) {
				int temp = A[j];
				A[j] = A[j+1];
				A[j+1] = temp;
				flag = 1;
			}
			if(flag == 0)
				break;
		}
		
		System.out.print("Bubble ");
		printSol(A);
	}
	
	static void selectionSort(int A[],int n) {
		for(int i=1;i<n;i++) {
				int j = i-1;
			while(j>=0 && A[j]>A[i]) {
				A[j+1] = A[j];
				j--;
			}
			A[j+1] = A[i];
		}
		
		System.out.print("Selection ");
		printSol(A);
	}
	
	static void insertionSort(int A[],int n) {
		for(int i=0;i<n-1;i++) {
				int min = i;
			for(int j=i+1;j<n;j++){
				if(A[j]<A[min])
					min = j;
			}
			
			if(min != i) {
				int temp = A[i];
				A[i] = A[min];
				A[min] = temp;
			}
		}
		
		System.out.print("Insertion ");
		printSol(A);
	}
	
	static void printSol(int A[]) {
		
		System.out.print("Sorted Array: ");
		for(int i: A)
		System.out.print(i+" ");
		
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter size of Array: ");
		int N = sc.nextInt();
		
		int A[] = new int[N];
		
		
		for(int i=0;i<N;i++) {
			System.out.print("Enter data of array: ");
			A[i] = sc.nextInt();
		}
		
		bubbleSort(A,N);
		selectionSort(A,N);
		insertionSort(A,N);
		
		sc.close();
	}

}
