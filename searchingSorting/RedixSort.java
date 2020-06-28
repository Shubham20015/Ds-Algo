package searchingSorting;

import java.util.Scanner;

public class RedixSort {
	
	static int getMax(int arr[], int n) 
    { 
        int max = arr[0]; 
        for (int i = 1; i < n; i++) 
            if (arr[i] > max) 
                max = arr[i]; 
        return max; 
    } 
	
	static void redixSort(int A[],int n) {
		// to find no. with max no. of digits
		int max = getMax(A,n);
		
		// To iterate over digit at unit/tens/hundereds/.. every place
		for(int pos=1;max/pos>0;pos*=10) {
			countSort(A,n,pos);
		}
	}

	// Same as counting Sort with some modifications
	static void countSort(int A[],int n,int pos) {
		int count[] = new int[10];
		int b[] = new int[n];
		
		for(int i=0;i<n;i++)
			++count[(A[i]/pos)%10];// this function in count is used to calclute digit at unit/tens/hundereds/.. place
		for(int i=1;i<=9;i++) 
			count[i] += count[i-1];
		for(int i=n-1;i>=0;i--)
			b[--count[(A[i]/pos)%10]] = A[i];
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
		
		int A[] = new int[N];
		
		
		for(int i=0;i<N;i++) {
			System.out.print("Enter data of array: ");
			A[i] = sc.nextInt();
		}
		
		redixSort(A,N);
		
		printArr(A,N);
		
		sc.close();
	}

}
