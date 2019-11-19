package geeks4geeks.string_exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// from: https://practice.geeksforgeeks.org/problems/reverse-words-in-a-given-string/0
public class ReverseWordsInAGivenString {
	public static String ReverseWords(String s)
	{
		StringBuilder result = new StringBuilder();
		String splitChar = "\\.";
		
		String strings[] = s.split(splitChar);
		
		for(int i = strings.length-1; i >= 0; i--)
		{
			result.append(strings[i]);
			if(i != 0)
			{
				result.append(".");
			}
		}

		return result.toString();
	}

	public static void main(String[] args) {

		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			int T = Integer.parseInt(reader.readLine());
			
			for(int t = 0; t < T; t++)
			{
				String S = reader.readLine();
				String reverseString = ReverseWords(S);
				System.out.println(reverseString);
			}
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub

	}

}

/*
Input:
2
i.like.this.program.very.much
pqr.mno

Output:
much.very.program.this.like.i
mno.pqr
*/
