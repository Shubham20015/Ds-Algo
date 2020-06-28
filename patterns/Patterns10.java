package patterns;

import java.util.Scanner;

public class Patterns10 {

	public static void main(String[] args) {
		
Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter no. of rows you want: ");
	 	
		int n = sc.nextInt();
		
		for(int y=1; y<n; y++) {
			System.out.print("  ");
		}
		System.out.println("* ");
		for(int i=2; i<=n-1; i++) {
			for(int y=1; y<=n-i; y++) {
				System.out.print("  ");
			}
			System.out.print("* ");
		
		for(int j=1; j<=i-2; j++) {
			
			System.out.print("  ");
		}
		System.out.print("* ");
		System.out.println();
		}
		
		for(int i=1; i<=n; i++) {
			
			System.out.print("* ");
			
		}
		sc.close();

	}

}
