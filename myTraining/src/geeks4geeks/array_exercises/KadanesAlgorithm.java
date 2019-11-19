package geeks4geeks.array_exercises;

import java.util.Scanner;

//from https://practice.geeksforgeeks.org/problems/kadanes-algorithm/0
public class KadanesAlgorithm {
	
	// my algorithm works but it is to slow
	public static void kadanes(long arrayInt[], int n)
	{
		int maxSum = Integer.MIN_VALUE;
		for(int i = 0; i < n; i++)
		{
			int sum = 0;
			for(int j = i; j < n; j++)
			{
				sum += arrayInt[j];
				if(sum > maxSum)
				{
					maxSum = sum;
				}
			}
		}
		System.out.println(maxSum);
	}

	public static int kadanes_GFG(int arrayInt[], int n)
	{
		int max_global = arrayInt[0];
		int max_temp = arrayInt[0];
		for (int i = 1; i < n; i++)
		{
			max_temp = Math.max(arrayInt[i], max_temp + arrayInt[i]);
			max_global = Math.max(max_global, max_temp);
		}
		return max_global;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
				
		for (int i = 0; i < T; i++)
		{
			int N = sc.nextInt();
			int arrayIntegers[] = new int[N];
			for (int j = 0; j < N; j++)
			{
				arrayIntegers[j] = sc.nextInt();
			}
//			kadanes(arrayIntegers, N);
			System.out.println(kadanes_GFG(arrayIntegers, N));
			
		}
		sc.close();

	}

}
