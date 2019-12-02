package geeks4geeks.recursion_exercises;

import java.util.Scanner;

public class NumberOfPaths {
	static int npaths = 0;

	public static void DiscoverPaths(int nrows, int ncols, int x, int y)
	{
		if(x == nrows-1 && y == ncols-1)
		{
			npaths++;
			return;
		}
		
		if(x == nrows-1)
		{
			DiscoverPaths(nrows, ncols, x, y+1);
			return;
		}

		if(y == ncols-1)
		{
			DiscoverPaths(nrows, ncols, x+1, y);
			return;
		}
		
		
		DiscoverPaths(nrows, ncols, x+1, y);
		DiscoverPaths(nrows, ncols, x, y+1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 0; t < T; t++)
		{
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			DiscoverPaths(N, M, 0, 0);
			
			System.out.println(npaths);
			npaths = 0;

		}
		sc.close();
	}

}

/*
For Input:
2
3 3
2 8
Your Output is:
6
8
*/