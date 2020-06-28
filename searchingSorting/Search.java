package searchingSorting;

import java.util.Scanner;

public class Search {

	static int linearSearch(int A[],int n,int element) {
		for(int i=0;i<n;i++) {
			if(A[i] == element)
				return i;
		}
		return -1;
	}
	
	static void binarySearch(int A[],int n,int element) {
		
			int low = 0,end = n-1,flag = 0;
			
			while(low <= end) {
				
				int mid = (low+end)/2;
				
				if(A[mid] == element) {
					flag = 1;
					System.out.println(element + " found at " + (mid+1));
					break;
				}
				else if(A[mid] < element)
					end = mid-1;
				else
					low = mid+1;
			}
			
			if(flag == 0) {
				System.out.println("Not found in Array");
			}
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
		
		System.out.print("Enter element to be searched: ");
		int x = sc.nextInt();
		
		int result = linearSearch(A,N,x);
		
		System.out.println("Linear Search");
		if(result == -1)
			System.out.println("Not found in Array");
		else
			System.out.println(x+" found at "+(result+1));
		
		System.out.println("Binary Search");
		binarySearch(A,N,x);
		
		sc.close();
	}

}
