package geeks4geeks;

import java.util.Scanner;

// from https://practice.geeksforgeeks.org/problems/count-the-triplets/0
public class CountTheTriplets {
	
	public static void countTriplets(long arrayIntegers[], int N)
	{
		long sum = 0;
		int count = 0;
		for(int pointer1 = 0; pointer1 < N-1; pointer1++)
		{
			for(int pointer2 = pointer1 + 1; pointer2 < N; pointer2++)
			{
				sum = arrayIntegers[pointer1] + arrayIntegers[pointer2];
				for(int runner = 0; runner < N; runner++)
				{
					if(arrayIntegers[runner] == sum)
					{
						count++;
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
			countTriplets(arrayIntegers, N);
		}
		sc.close();
	}
}
