package geeks4geeks;

// from https://practice.geeksforgeeks.org/problems/count-the-triplets/0
public class CountTheTriplets {

	public static void main(String[] args) {
		int argsIndex = 0;
		int T = Integer.valueOf(args[argsIndex++]);
				
		for (int i = 0; i < T; i++)
		{
			int N = Integer.valueOf(args[argsIndex++]);
			long arrayIntegers[] = new long[N];
			for (int j = 0; j < N; j++)
			{
				arrayIntegers[j] = Long.valueOf(args[argsIndex++]);
			}
			
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
	}
}
