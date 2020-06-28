package recursion;

import java.util.Scanner;

public class ReverseArray {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter size of Array: ");
		
		int N = sc.nextInt();
		
		int A[] = new int [N];
		
		System.out.println("Enter Array elements: ");
		
		for(int i=0;i<N;i++) {
			A[i] = sc.nextInt();
		}
		
		int [] arr = revArr(A,0,N-1);
		
		System.out.print("Reverse Array: ");
		
		for(int x: arr) {
			System.out.print(x+" ");
		}
		
		sc.close();
	}

	static int[] revArr(int a[],int i,int n) {
		if(i<n) {
			int temp = a[i];
			a[i] = a[n];
			a[n] = temp;
			
			revArr(a,++i,n--);
		}
		return a;
	}
}


