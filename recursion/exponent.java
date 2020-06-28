package recursion;

import java.util.Scanner;

public class exponent {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number: ");
		
		int x = sc.nextInt();
		
		System.out.println("Enter power: ");
		
		int N = sc.nextInt();

		System.out.println("The "+N+" power of "+x+": "+exp(x,N));
		
		sc.close();
	}
	
	static long exp(int x,int n) {
		if(n<=0) {
			return 1;
		}
		
		return x*exp(x,n-1);
	}
}


