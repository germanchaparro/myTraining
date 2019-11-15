package geeks4geeks;

// from https://practice.geeksforgeeks.org/problems/subarray-with-given-sum/0
public class SubArrayWithGivenSum {
//	class GFG {

	public static void main(String[] args) {
		int argsIndex = 0;
		int T = Integer.valueOf(args[argsIndex++]);
				
		for (int i = 0; i < T; i++)
		{
			int N = Integer.valueOf(args[argsIndex++]);
			long arrayIntegers[] = new long[N];
			int S = Integer.valueOf(args[argsIndex++]);
			for (int j = 0; j < N; j++)
			{
				arrayIntegers[j] = Long.valueOf(args[argsIndex++]);
			}
			
			int sum = 0;
			int initialPosition = 0;
			int finalPosition = 0;
			while(sum < S || initialPosition < N)
			{
				sum += arrayIntegers[finalPosition];
				finalPosition++;
				if(sum == S)
				{
					System.out.println(initialPosition+1 + " " + finalPosition);
					break;
				}
				else if(sum < S && finalPosition == N)
				{
					System.out.println(-1);
					break;
				}
				else if(sum > S)
				{
					initialPosition++;
					finalPosition = initialPosition;
					sum = 0;
				}
			}
		}
	}
}
