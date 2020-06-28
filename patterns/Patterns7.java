package patterns;

import java.util.Scanner;

public class Patterns7 {

	public static void main(String[] args) {
		
		 Scanner sc = new Scanner(System.in);
			
			System.out.print("Enter no. of rows you want: ");
		 	
			int n = sc.nextInt();
			
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n-i; j++) {
					System.out.print("  ");
				}
				for(int j=1; j<=2*i-1; j++) {
					if(j>1 && j<2*i-1)
					System.out.print("0 ");
					else 
				    System.out.print(i +" ");		
				}
				System.out.println();
			}
				sc.close();
	}

}
