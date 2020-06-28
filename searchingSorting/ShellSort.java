package searchingSorting;

import java.util.Scanner;

public class ShellSort {
	
	static void shellSort(int A[],int n){
		
		for(int gap=n/2;gap>0;gap/=2) {
			for(int j=gap;j<n;j++) {
				for(int x=j-gap;x>=0;x-=gap) {
					
					if(A[j]>A[x])
						break;
					else {
						int temp = A[x];
						A[x] = A[j];
						A[j] = temp;
					}
				}
			}
		}
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
		
		int A[] = new int[N];
		
		
		for(int i=0;i<N;i++) {
			System.out.print("Enter data of array: ");
			A[i] = sc.nextInt();
		}
		
		shellSort(A,N);
		
		printArr(A,N);
		
		sc.close();
	}

}
