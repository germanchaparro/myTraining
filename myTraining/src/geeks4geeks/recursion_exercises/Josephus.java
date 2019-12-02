package geeks4geeks.recursion_exercises;

public class Josephus {
	public static int factorial(int n)
	{
		if(n == 0)
		{
			return 1;
		}
		
		return n * factorial(n-1);
	}
	
	public static int josephus(int n, int k)
	{
		if(n == 1)
		{
			return 1;
		}
		
		return ( josephus(n-1, k) + k-1 ) % n + 1;

	}

	public static void main(String[] args) {
		System.out.println(josephus(3,2));
		System.out.println(josephus(5,3));
		System.out.println(josephus(7,3));
		

	}

}
