package geeks4geeks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// from: https://practice.geeksforgeeks.org/problems/longest-palindrome-in-a-string/0
public class LongestPalindromeInAString {
	
	public static boolean IsPalindrome(String s)
	{
		boolean isPalindrome = false;
		char charArray[] = s.toCharArray();
		int pointer1 = 0;
		int pointer2 = charArray.length-1;
		while(charArray[pointer1] == charArray[pointer2])
		{
			pointer1++;
			pointer2--;
			if(pointer1 > pointer2)
			{
				return true;
			}
		}
		return isPalindrome;
	}
	
	public static String LongestPalindrome(String s)
	{		
		int maxLength = s.length();
		int currentLength = maxLength;
		int init = 0;
		int pointer1 = 0;
		
		for(init = 0; init < maxLength; init++)
		{
			pointer1 = 0;
			while(pointer1 + currentLength <= maxLength)
			{
				String tmpString = s.substring(pointer1, pointer1 + currentLength);
				if ( IsPalindrome(tmpString) )
				{
					return tmpString;
				}
				
				pointer1++;
			}
			currentLength--;
		}
		
		return "";
		
	}

	public static void main(String[] args) {

		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			int T = Integer.parseInt(reader.readLine());
			
			for(int t = 0; t < T; t++)
			{
				String S = reader.readLine();
				String outputString = LongestPalindrome(S);
				System.out.println(outputString);
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
1
aaaabbaa

Output:
aabbaa

*/
