package geeks4geeks.string_exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//from: https://practice.geeksforgeeks.org/problems/implement-strstr/1
public class ImplementStrstr {
	
	public static int strstr(String s, String x)
	{
		for(int pos=0; pos < s.length(); pos++)
		{
			int pointer1 = 0;
			int currlength = s.length() - pos;
			while(pointer1 + currlength <= s.length())
			{
				String currentString = s.substring(pointer1, pointer1 + currlength);
				if(currentString.equals(x))
				{
					return pointer1;
				}
				pointer1++;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			int T = Integer.parseInt(reader.readLine());
			
			for(int t = 0; t < T; t++)
			{
				String S = reader.readLine();
				String stringArray[] = S.split(" ");
				int output = strstr(stringArray[0], stringArray[1]);
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
Input
2
GeeksForGeeks Fr
GeeksForGeeks For
Output
-1
5
*/
