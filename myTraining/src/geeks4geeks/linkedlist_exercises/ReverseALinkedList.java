package geeks4geeks.linkedlist_exercises;

import java.util.Stack;

//from: https://practice.geeksforgeeks.org/problems/reverse-a-linked-list/1
// for some strange reason, geeksforgeeks is failing using a stack. The test that I did worked well.
public class ReverseALinkedList {

	static Node reverseList(Node head)
	{
		if(head == null)
		{
			return null;
		}
		
		Stack<Integer> myStack = new Stack<Integer>();
		Node runner = head;
		
		while(runner != null)
		{
			myStack.push(runner.value);
			runner = runner.next;
		}
		
		Node newList = new Node(myStack.pop());
		runner = newList;
		
		
		while(!myStack.isEmpty())
		{
			runner.next = new Node(myStack.pop());
			runner = runner.next;
		}
		
		return newList;
	}

	public static void main(String[] args) {
		LinkedList1 ll = new LinkedList1();
		ll.addToTheLast(new Node(1));
		ll.addToTheLast(new Node(2));
		ll.addToTheLast(new Node(3));
		ll.addToTheLast(new Node(4));
		ll.addToTheLast(new Node(5));
		ll.addToTheLast(new Node(6));
		ll.addToTheLast(new Node(7));
		
		Node newList = reverseList(ll.head);
		Node runner = newList;
		while(runner != null)
		{
			System.out.print(runner.value + "->");
			runner = runner.next;
		}
		System.out.println("");
				
//		newList.printList();

	}

}

/*
Input:
2
6
1 2 3 4 5 6
5
2 7 8 9 10

Output:
6 5 4 3 2 1
10 9 8 7 2
 */

