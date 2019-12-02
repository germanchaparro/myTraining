package geeks4geeks.recursion_exercises;

import java.util.Scanner;

//from: https://practice.geeksforgeeks.org/problems/flood-fill-algorithm/0
public class FloodFillAlgorithm {
	
	public static void FloodFill(int[][] m, int nrows, int ncols, int x, int y, int newColor, int currentColor)
	{
		if(x < 0 || x >= nrows)
		{
			return;
		}
		if(y < 0 || y >= ncols)
		{
			return;
		}
		
		int thisColor = currentColor;		
		if(thisColor == -1)
		{
			thisColor = m[x][y];
		}
		
		if(thisColor != m[x][y])
		{
			return;
		}
		
		m[x][y] = newColor;
		
		FloodFill(m, nrows, ncols, x-1, y, newColor, thisColor);
		FloodFill(m, nrows, ncols, x+1, y, newColor, thisColor);
		FloodFill(m, nrows, ncols, x, y+1, newColor, thisColor);
		FloodFill(m, nrows, ncols, x, y-1, newColor, thisColor);
		
	}
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 0; t < T; t++)
		{
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] matrix = new int[N][M];
			for(int row = 0; row < N; row++)
			{
				for(int col = 0; col < M; col++)
				{
					matrix[row][col] = sc.nextInt();
				}				
			}
			int x = sc.nextInt();
			int y = sc.nextInt();
			int K = sc.nextInt();
			
			FloodFill(matrix, N, M, x, y, K, -1);
			
			for(int row = 0; row < N; row++)
			{
				for(int col = 0; col < M; col++)
				{
					System.out.print(matrix[row][col] + " ");
				}				
			}
			System.out.println();

		}
		sc.close();
	}

}

/*
Input:
3
3 4
0 1 1 0 1 1 1 1 0 1 2 3
0 1 5
2 2
1 1 1 1
0 1 8
4 4 
1 2 3 4 1 2 3 4 1 2 3 4 1 3 2 4
0 2 9

Output:
0 5 5 0 5 5 5 5 0 5 2 3
8 8 8 8
1 2 9 4 1 2 9 4 1 2 9 4 1 3 2 4

*/