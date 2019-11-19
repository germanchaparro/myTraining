package geeks4geeks.linkedlist_exercises;

// from https://practice.geeksforgeeks.org/problems/intersection-point-in-y-shapped-linked-lists/1#ExpectOP
//for some reason, geeksforgeeks is failing using a stack. The test that I did worked well.

public class IntersectionPointinYShappedLinkedLists {
	int intersectPoint(Node headA, Node headB)
	{
		Node runner = headA;
		while(runner != null)
		{
			runner.value = -runner.value;
			runner = runner.next;
		}
		
		runner = headB;
		while(runner != null)
		{
			if(runner.value < 0)
			{
				return -runner.value;
			}
			runner = runner.next;
		}
		return -1;
	}
}
