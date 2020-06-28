package patterns;

import java.util.Scanner;

public class Patterns8 {

	public static void main(String[] args) {
		

		 Scanner sc = new Scanner(System.in);
			
			System.out.print("Enter no. of rows you want: ");
		 	
			int n = sc.nextInt();
			
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n-i; j++) {
					System.out.print("  ");
				}
				for(int j=1; j<=2*i-1; j++) {
					if(j==i) {
					System.out.print("0 ");
					}
					else if(j>i) {
					System.out.print(n-j+i+" ");
					}
					else 
                    System.out.print(n-i+j +" ");		
				}
				System.out.println();
			}
			sc.close();
	}
}

	


