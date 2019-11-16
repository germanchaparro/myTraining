package geeks4geeks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// from https://practice.geeksforgeeks.org/problems/leaders-in-an-array/0
public class LeadersInAnArray {
	
	// O(n) but too slow for GFG
	// it was slow due to the print process should be done all in one 
	// with Stringbuilder instead of printing element by element
	public static void printLeaders(int arrayInt[], int n)
	{
		// create an array to save the leaders
		// potentially all of them are leaders
		int arrayLeaders[] = new int[n];
		int sizeArrayLeaders = 0;
		
		// always the most right element is a leader
		int currentLeader = arrayInt[n-1];
		arrayLeaders[sizeArrayLeaders] = currentLeader;
		sizeArrayLeaders++;
		
		// traverse the input array from right to left to find leaders
		// starting from n-2 position
		for(int i = n-2; i >= 0; i--)
		{
			// if I find a number greater than or equal to the current leader
			if(arrayInt[i] >= currentLeader)
			{
				// then it is a leader
				currentLeader = arrayInt[i];
				arrayLeaders[sizeArrayLeaders] = currentLeader;
				sizeArrayLeaders++;
			}
		}
		
		// print the leaders
		StringBuilder sb = new StringBuilder();
		for(int i = sizeArrayLeaders-1; i >= 0; i--)
		{
			sb.append(arrayLeaders[i] + " ");
		}
		System.out.println(sb.toString());
	}
	
	public static void main(String[] args) {
			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				int T = Integer.parseInt(reader.readLine());
				
				for(int t = 0; t < T; t++)
				{
					int N = Integer.parseInt(reader.readLine());
					
					int arrayInt[] = new int[N];
					arrayInt = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
					
					printLeaders(arrayInt, N);
				}
				
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

	}
}
/*
Input:
3
6
16 17 4 3 5 2
5
1 2 3 4 0
5
7 4 5 7 3
Output:
17 5 2
4 0
7 7 3
 */

