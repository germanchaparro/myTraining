package geeks4geeks.array_exercises;

import java.util.Scanner;

// from https://practice.geeksforgeeks.org/problems/subarray-with-given-sum/0
public class SubArrayWithGivenSum {

	public static void subArrayGivenSum(long arrayIntegers[], int N, long S)
	{
		long sum = 0;
		int initialPosition = 0;
		int finalPosition = 0;
		boolean foundSum = false;
		while(sum < S && initialPosition < N)
		{
			sum += arrayIntegers[finalPosition];
			finalPosition++;
			
			if(sum == S)
			{
				foundSum = true;
				break;
			}
			else if(sum < S && finalPosition >= N)
			{
				foundSum = false;
				break;
			}
			else if(sum > S)
			{
				initialPosition++;
				finalPosition = initialPosition;
				sum = 0;
			}
		}
		if(foundSum)
		{
			System.out.println(initialPosition+1 + " " + finalPosition);
		}
		else
		{
			System.out.println(-1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
				
		for (int i = 0; i < T; i++)
		{
			int N = sc.nextInt();
			long arrayIntegers[] = new long[N];
			long S = sc.nextLong();
			for (int j = 0; j < N; j++)
			{
				arrayIntegers[j] = sc.nextLong();
			}
			subArrayGivenSum(arrayIntegers, N, S);
			
		}
		sc.close();
	}
}
