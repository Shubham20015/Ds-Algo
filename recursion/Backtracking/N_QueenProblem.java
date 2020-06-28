package recursion.Backtracking;

import java.util.Scanner;

public class N_QueenProblem {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the size of board: ");
		
		int N = sc.nextInt();
		
		int board[][] = new int [N][N];
		
		solvechess(board,0,N);
		sc.close();
	}
	
	static boolean solvechess(int a[][],int i,int n) {
		
		if(i == n) {
			
			System.out.println("Chess Board which contain Queens that's not attack each other");
			
			for(int x=0;x<n;x++) {
				for(int y=0;y<n;y++) {
					if(a[x][y] == 1)
					System.out.print("Q ");
					else
						System.out.print("_ ");
				}
				System.out.println();
			}
			return true;
		}
		else {
			for(int j=0;j<n;j++) {
			if(safeToPlace(a,i,j,n)) {
				// Place a Queen - Assuming i,j is right position
					a [i][j] = 1;
					
					boolean nextQueenSafeToPlace = solvechess(a,i+1,n);
					
					if(nextQueenSafeToPlace) {
						
						return true;
					}
					// i,j is  not right position-Assumption is wrong
					a[i][j] = 0;
				
				}
			}
			return false;
		}
		
	}
	
	static boolean safeToPlace(int chess[][],int i,int j,int N) {
		//check columns
		for(int row =0;row<i;row++) {
			if(chess[row][j] == 1) {
				return false;
			}
		}
		
		int x = i;
		int y = j;
		// check left diagonal
		while(x>=0 && y>=0) {
			if(chess[x][y] == 1) {
				return false;
			}
			x--;
			y--;
		}
		x = i;
	    y = j;
		//check right diagonal
		while(x>=0 && y<N) {
			if(chess[x][y] == 1) {
				return false;
			}
			x--;
			y++;
		}
		
		return true;
	}

}
