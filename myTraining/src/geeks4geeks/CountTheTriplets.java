package geeks4geeks;

import java.util.Arrays;
import java.util.Scanner;

// from https://practice.geeksforgeeks.org/problems/count-the-triplets/0
public class CountTheTriplets {
	
		
	// this was my best solution but it was too slow. the tests didn't pass due to timeout
	public static void countTriplets(long arrayIntegers[], int N)
	{
		long sum = 0;
		int count = 0;
		for(int runner = 0; runner < N; runner++)
		{
			for(int pointer1 = 0; pointer1 < N-1; pointer1++)
			{
				if(arrayIntegers[pointer1] < arrayIntegers[runner])
				{
					for(int pointer2 = pointer1 + 1; pointer2 < N; pointer2++)
					{
						if(arrayIntegers[pointer2] < arrayIntegers[runner])
						{
							sum = arrayIntegers[pointer1] + arrayIntegers[pointer2];
							if(arrayIntegers[runner] == sum)
							{
								count++;
							}
						}
					}
				}
			}
		}

		if(count == 0)
		{
			System.out.println("-1");
		}
		else
		{
			System.out.println(count);
		}
	}
	
	// this is the solution proposed by GFG
	public static void countTriplets_GFG(long arrayIntegers[], int N)
	{
		// sort the array
		Arrays.sort(arrayIntegers);
		

		int count = 0;
		long sum = 0;
		
		
		for(int i = N-1; i >= 0; i--)
		{
			int pointer1 = 0;
			int pointer2 = i-1;
			while(pointer1 < pointer2)
			{
				sum = arrayIntegers[pointer1] + arrayIntegers[pointer2];
				if(arrayIntegers[i] == sum)
				{
					count++;
					pointer1++;
					pointer2--;
				}
				else if(arrayIntegers[i] > sum)
				{
					pointer1++;
				}
				else
				{
					pointer2--;
				}
			}
		}
		
		if(count == 0)
		{
			System.out.println("-1");
		}
		else
		{
			System.out.println(count);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();		
		for (int i = 0; i < T; i++)
		{
			int N = sc.nextInt();
			long arrayIntegers[] = new long[N];
			for (int j = 0; j < N; j++)
			{
				arrayIntegers[j] = sc.nextLong();
			}
//			countTriplets(arrayIntegers, N);
			countTriplets_GFG(arrayIntegers, N);
		}
		sc.close();
	}
}
