package geeks4geeks.array_exercises;

import java.util.*;

public class CheckIfTwoArraysAreEqualOrNot {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long t = sc.nextLong();
		
		while(t-->0)
		{
			int n=sc.nextInt();
			long a[] = new long[n];
			long b[] = new long[n];
			
			for(int i=0; i<n; i++)
			{
				a[i] = sc.nextLong();
			}
			for(int i=0; i<n; i++)
			{
				b[i] = sc.nextLong();
			}
			
			System.out.println(check(a,b,n)==true?"1":"0");
		}
		sc.close();

	}
	
	public static boolean check(long arr[],long brr[],int n)
	{
	    //Your code here

	    Map<Long, Integer> map = new HashMap<Long, Integer>();

	    for(int i=0; i<n; i++)
	    {
	        if(map.get(arr[i]) == null)
	        {
	            map.put(arr[i], 1);
	        }
	        else
	        {
	            map.put(arr[i], map.get(arr[i]) + 1);
	        }

	    }
	    
	    for(int i=0; i<n; i++)
	    {
	        if(map.get(brr[i]) == null)
	        {
	            return false;
	        }
	        
	        map.put(brr[i], map.get(brr[i]) - 1);
	    }
	    
	    for (Integer value : map.values())
	    {
	        if(value != 0)
	        {
	            return false;
	        }
	    }
	    return true;
	}

}
