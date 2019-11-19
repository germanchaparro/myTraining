package geeks4geeks.array_exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// from https://practice.geeksforgeeks.org/problems/missing-number-in-array/0

public class MissingNumberInArray {

	// work with O(n)
	public static int missingNumber(int arrayInt[], int n)
	{
		// sort the input array
		Arrays.sort(arrayInt);
		
		for(int i = 0; i < n; i++)
		{
			if(arrayInt[i] - (i+1) != 0)
			{
				return i+1;
			}
		}
		return n+1;
			
	}
	
	// another approach with XOR function but still very slow O(n)
	public static int missingNumberv2(int arrayInt[], int n)
	{
		Arrays.sort(arrayInt);
		for(int i = 0; i < n; i++)
		{
			if( (arrayInt[i] ^ (i+1)) != 0 )
			{
				return i+1;
			}
		}
		return n+1;
	}
	
	
	public static void main(String[] args) {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			int T = Integer.parseInt(reader.readLine());

			
/*			Scanner sc = new Scanner(System.in);
			int T = sc.nextInt();
			for(int t = 0; t < T; t++)
			{
				int N = sc.nextInt();
				int arrayInt[] = new int[N-1];
				for(int n = 0; n < N-1; n++)
				{
					arrayInt[n] = sc.nextInt();
				}
*/
			
			for(int t = 0; t < T; t++)
			{
				int N = Integer.parseInt(reader.readLine());
				
				int arrayInt[] = new int[N-1];
				
				arrayInt = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
				System.out.println(missingNumber(arrayInt, N-1));
//				System.out.println(missingNumberv2(arrayInt, N-1));
			}
//			sc.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

/* Test Input	
6
5
1 2 3 5
10
1 2 3 4 5 6 7 8 10
2
1
6
2 3 4 1 6 
5
1 2 3 4
7
2 3 4 5 6 7

Expected Output
4
9
2
5
5
1
*/