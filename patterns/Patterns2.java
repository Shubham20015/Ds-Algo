package patterns;

import java.util.Scanner;

public class Patterns2 {
	
public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter no. of rows you want: ");
	 	
		int n = sc.nextInt();
		
		for(int i=0; i<=n; i++) {
			for(int j=0; j<=2*i;j++) {
				System.out.print("  ");
			}
			for(int j=1; j<=n-i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
			sc.close();
}
}