package geeks4geeks.stack_exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class NextLargerElement {
	
	// this is a brute force solution works but fails due to timeout
	public static StringBuilder NextLarger(int arrayInt[], int n)
	{
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i < n-1; i++)
		{
			int j=i+1;
			
			while(j<n)
			{
				if(arrayInt[i] < arrayInt[j])
				{
					sb.append(arrayInt[j] + " ");
					break;
				}
				j++;
			}
			if(j==n)
			{
				sb.append(-1 + " ");
			}
		}
		sb.append(-1 + " ");
		return sb;
	}

	// this works but it is not my solution :(
	public static StringBuilder NextLarger_Stack(long arrayInt[], int n)
	{
		long result[] = new long[n];

		Stack<Long> stack = new Stack<>();

		for(int i=n-1; i>=0; i-- )
		{
			while( !stack.isEmpty() && arrayInt[i]>stack.peek() )
			{
				stack.pop();
			}
			
			if(stack.isEmpty())
			{
				result[i] = Integer.valueOf(-1);
			}
			else
			{
				result[i] = stack.peek();
			}
			stack.push(arrayInt[i]);

		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i < n; i++)
		{
			sb.append(result[i] + " ");
		}
		return sb;
	}

	public static void main(String[] args) {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			int T = Integer.parseInt(reader.readLine());
			
			for(int t = 0; t < T; t++)
			{
				int N = Integer.parseInt(reader.readLine());
				
				long arrayInt[] = new long[N];
				arrayInt = Arrays.stream(reader.readLine().split("\\s+")).mapToLong(Long::parseLong).toArray();
				System.out.println(NextLarger_Stack(arrayInt, N));
			}
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

/*
3
4
1 3 2 4
4
4 3 2 1
4
7 8 1 4
Output
3 4 4 -1
-1 -1 -1 -1
8 -1 4 -1
 */
