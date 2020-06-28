package recursion.Backtracking;

import java.util.Scanner;

//Problem in this code- Not able to print moves of solution path Eg. DRDRRRLDRR

public class RatInMaze {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the size of maze: ");
		
		int N = sc.nextInt();
		
		int maze[][] = new int [N][N];
		
		System.out.print("Enter maze blocks only (0 or 1): ");
		
		for(int x=0;x<N;x++) {
			for(int y=0;y<N;y++) {
				maze[x][y] = sc.nextInt();
			}
		}
		
		int path[][] = new int[N][N];
		
		solvepuzzle(maze,0,0,N,path);
		
		sc.close();
	}
	
	static void solvepuzzle(int maze[][],int x,int y,int n,int path[][]) {
		if(x<0 || x>=n || y>=n || y<0 || maze[x][y] == 0 || path[x][y] == 1) {
			return;
		}
		
		if(x==n-1 && y==n-1) {
			path[n-1][n-1] = 1;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					System.out.print(path[i][j]+" ");
				}
				System.out.println();
			}
			System.out.println();
		}
		
	
		path[x][y] = 1;
		
		//Right
		solvepuzzle(maze,x,y+1,n,path);
			
		//Left
		solvepuzzle(maze,x,y-1,n,path);
			
		//Down
		solvepuzzle(maze,x+1,y,n,path);
			
		//Up
		solvepuzzle(maze,x-1,y,n,path);
			
		path[x][y] = 0;

	}

}
