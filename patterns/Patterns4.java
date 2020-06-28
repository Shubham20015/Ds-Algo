package patterns;

import java.util.Scanner;

public class Patterns4 {

	public static void main(String[] args) {
		
Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter no. of rows you want: ");
	 	
		int n = sc.nextInt();
		
		int rows = 2*n-1;
		
		for(int i=1; i<=rows; i++) {
			if(i<n) {
			for(int y=1; y<=n-i; y++) {
				System.out.print(" ");	
			}
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			}
			else {
				for(int y=1; y<=i-n; y++) {
					System.out.print(" ");	
				}
				for(int x=1; x<=rows-i+1; x++) {
					System.out.print("*");	
				}
			}	
			
			System.out.println();
		}
		sc.close();
	}

}
