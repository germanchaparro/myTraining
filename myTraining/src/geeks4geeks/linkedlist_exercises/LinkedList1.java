package geeks4geeks.linkedlist_exercises;


public class LinkedList1 {
	Node head;
	Node lastNode;

	public void addToTheLast(Node node)
	{
		if(head == null)
		{
			head = node;
			lastNode = node;
		}
		else
		{
			lastNode.next = node;
			lastNode = node;
		}
	}

	public void printList()
	{
		Node runner = head;
		while(runner != null)
		{
			System.out.print(runner.value + "->");
			runner = runner.next;
		}
		System.out.println("");
	}

}
