package geeks4geeks.string_exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

// from: https://practice.geeksforgeeks.org/problems/longest-distinct-characters-in-string/0
public class LongestDistinctCharactersInString {
	public static boolean HasDuplicates(String s)
	{
		boolean hasDuplicates = false;
		Set<Character> setString = new HashSet<Character>();
		
		int currentChar = 0;
		while(!hasDuplicates && currentChar < s.length())
		{
			hasDuplicates = !setString.add(s.charAt(currentChar));
			currentChar++;
		}
		
		return hasDuplicates;
	}
	
	public static int LongestDistinctCharacters(String s)
	{
		for(int pos=0; pos < s.length()-1; pos++)
		{
			int pointer1 = 0;
			int currlength = s.length() - pos;
			while(pointer1 + currlength <= s.length())
			{
				String currentString = s.substring(pointer1, pointer1 + currlength);
				if(!HasDuplicates(currentString))
				{
					return currentString.length();
				}
				pointer1++;
			}
		}
		return 1;
	}

	public static void main(String[] args) {

		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			int T = Integer.parseInt(reader.readLine());
			
			for(int t = 0; t < T; t++)
			{
				String S = reader.readLine();
				int output = LongestDistinctCharacters(S);
				System.out.println(output);
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
2
abababcdefababcdab
geeksforgeeks

Output:
6
7
*/