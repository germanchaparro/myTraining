package geeks4geeks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RecursivelyRemoveAllAdjacentDuplicates {
	
	public static boolean HasDups(String s)
	{
		if(s == null || s.length() == 1)
		{
			return false;
		}
		
		for(int i=0; i < s.length()-1; i++)
		{
			if(s.charAt(i) == s.charAt(i+1))
			{
				return true;
			}
		}
		return false;
	}
		
	public static String RemoveAllAdjacentDups(String s, int pos)
	{
		String str = "";
		if(str.length() == 1)
		{
			return str;
		}
		
		if (pos == 0)
		{
			if(s.charAt(pos) == s.charAt(pos + 1))
			{
				str = "";
			}
			else
			{
				str = String.valueOf(s.charAt(pos));
			}
		}
		else if (pos == s.length()-1)
		{
			if(s.charAt(pos) == s.charAt(pos - 1))
			{
				str = "";
			}			
			else
			{
				str = String.valueOf(s.charAt(pos));
			}
			return str;
		}
		else
		{
			if(s.charAt(pos) == s.charAt(pos + 1) || s.charAt(pos) == s.charAt(pos - 1))
			{
				str = "";
			}			
			else
			{
				str = String.valueOf(s.charAt(pos));
			}
		}
		return str + RemoveAllAdjacentDups(s, pos + 1);
	}

	public static void main(String[] args) {
				
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			int T = Integer.parseInt(reader.readLine());
			
			for(int t = 0; t < T; t++)
			{
				String S = reader.readLine();
				while(HasDups(S))
				{
					S=RemoveAllAdjacentDups(S, 0);
				}
				System.out.println(S);
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
4
geeksforgeek
quhxgrhqqaccxeprunllfieilbothbbmpsg
mississipie
acaaabbbacdddd
Your Output is:
gksforgk
quhxgrhaxeprunfieilbothmpsg
mpie
acac
*/

