package recursion;

import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter size of Array: ");
		
		int N = sc.nextInt();
		
		int A[] = new int [N];
		
		System.out.println("Enter Array elements: ");
		
		for(int i=0;i<N;i++) {
			A[i] = sc.nextInt();
		}
		
		System.out.println("Enter element to be searched: ");
		
		int x = sc.nextInt();
		
		int res = search(A,N/2,x);
		
		if(res != -1) {
			System.out.println("Element found at index of array: "+res);
		}
		else
		System.out.println("Element not found in array: ");
		
		sc.close();
	}

	static int search(int a[],int mid,int x) {
		if(mid<=a.length-1) {
			
		if(a[mid] == x) 
			return mid;
		
		else if(x<a[mid]) 
			return search(a,mid-1,x);
		
		else 
			return search(a,mid+1,x);
		}
		else
			return -1;
	}
}
