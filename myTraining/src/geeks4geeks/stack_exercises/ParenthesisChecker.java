package geeks4geeks.stack_exercises;

import java.util.Scanner;
import java.util.Stack;

// from https://practice.geeksforgeeks.org/problems/parenthesis-checker/0
public class ParenthesisChecker {
	
	
	public static boolean IsBalanced(String s)
	{
		Stack<Character> myStack = new Stack<>();
		for(char c:s.toCharArray())
		{
			if(c == '{' || c == '(' || c == '[')
			{
				myStack.push(c);
			}
			else
			{
				if(myStack.isEmpty())
				{
					return false;
				}
				
				char close = myStack.pop();
				
				if( ( close == '{' && c != '}' ) || 
					( close == '(' && c != ')' ) || 
					( close == '[' && c != ']' )
								
				  )
				{
					return false;
				}
			}
			
		}
		
		if(myStack.isEmpty())
		{
			return true;
		}
		
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=0; t<T; t++)
		{
			String inputString = sc.next();
			if(IsBalanced(inputString))
			{
				System.out.println("balanced");
			}
			else
			{
				System.out.println("not balanced");
			}
		}
		sc.close();

	}

}

/*
For Input:
3
{([])}
()
()[]
([]
Your Output is:
balanced
balanced
balanced
not balanced
*/

