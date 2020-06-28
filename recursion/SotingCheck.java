package recursion;

import java.util.Scanner;

public class SotingCheck {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter size of Array: ");
		
		int N = sc.nextInt();
		
		int A[] = new int [N];
		
		System.out.println("Enter Array elements: ");
		
		for(int i=0;i<N;i++) {
			A[i] = sc.nextInt();
		}
		
		if(sort(A,N)) {
			System.out.println("Array is sorted");
		}else {
			System.out.println("Array is not sorted");
		}
		
		sc.close();
	}

	static boolean sort(int a[],int n) {
		
		if(n==0 || n==1) {
			return true;
		}
		if(a[n-1]<a[n-2]) {
			return false;
		}
		
		return sort(a,n-1);
	}
}

