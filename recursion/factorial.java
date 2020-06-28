package recursion;

import java.util.Scanner;

public class factorial {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number: ");
		
		int N = sc.nextInt();

		System.out.println("The factorial of "+N+": "+fact(N));
		
		sc.close();
	}
	
	static int fact(int n) {
		if(n<=1) {
			return 1;
		}
		
		return n*fact(n-1);
	}

}
