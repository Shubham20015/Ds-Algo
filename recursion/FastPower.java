package recursion;

import java.util.Scanner;

public class FastPower {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter power: ");
		int b = sc.nextInt();
		System.out.print("Enter no. you want raised to "+b+": ");
		int a = sc.nextInt();
		System.out.print(a+" raised to "+b+" = "+expo(a,b));
		
		sc.close();
	}
	
	static int expo(int a,int b) {
		
		if(b == 0) {
			return 1;
		}
		
		if(b%2 == 0) {
			
			return expo(a*a,b/2);
		}
		
			return a*expo(a,b-1);
	}
	
}
