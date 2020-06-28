package searchingSorting;

import java.util.Scanner;

public class QuickMergeSort {
	
	static int partion(int A[],int lb,int ub) {
		
		int pivot = A[ub];
		int i = lb-1;
		for(int j =lb;j<ub;j++){
			
			if(A[j] <pivot) {
				
				i++;
				
				int temp = A[i];
				A[i] = A[j];
				A[j] = temp;
			}
			
		}
		int x = A[i+1];
		A[i+1] = A[ub];
		A[ub] = x;
		
		return i+1;
	}
	
	static void quickSort(int A[],int lb,int ub) {
		
		if(lb < ub) {
			int loc = partion(A,lb,ub);
			quickSort(A,lb,loc-1);
			quickSort(A,loc+1,ub);
		}
	}
	
	static void merge(int A[],int lb,int mid,int ub) {
		
		int n1 = mid - lb + 1; 
        int n2 = ub - mid; 
  
        /* Create temp arrays */
        int L[] = new int[n1]; 
        int R[] = new int[n2]; 
  
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i) 
            L[i] = A[lb + i]; 
        for (int j = 0; j < n2; ++j) 
            R[j] = A[mid + 1 + j]; 
        
		int i=0,k=lb,j=0;
		
		while(i < n1 && j < n2) {
			
			if(L[i] <= R[j]) {
				A[k] = L[i];
				i++;
			}
			else {
				A[k] = R[j];
				j++;
			}
			
			k++;
		}
	
			while(j < n2) {
				A[k] = R[j];
				j++;
				k++;
			}
		
			while(i < n1) {
				A[k] = L[i];
				i++;
				k++;
			}
	}
	
	static void mergeSort(int A[],int lb,int ub) {
		
		if(lb < ub) {
			int mid = (lb+ub)/2;
			mergeSort(A,lb,mid);
			mergeSort(A,mid+1,ub);
			merge(A,lb,mid,ub);
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
		
		quickSort(A,0,N-1);
		
		printArr(A,N);
		
		System.out.println();
		
		mergeSort(A,0,N-1);
		
		printArr(A,N);
		
		sc.close();
	}

}
