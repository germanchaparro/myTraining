package geeks4geeks.tree_exercises;

import java.util.Stack;

class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}

// from: https://www.geeksforgeeks.org/must-do-coding-questions-for-companies-like-amazon-microsoft-adobe/
public class LevelOrderTraversalInSpiralForm {
	
	Stack<Node> stackToR = new Stack<>();
	Stack<Node> stackToL = new Stack<>();
	Stack<Node> stackPrint = new Stack<>();
	
	// true -> toTheRight
	// false -> toTheLeft
	boolean direction = false;
	
	public void levelTraversalSpiral(Node node)
	{
		if (node == null)
		{
			return;
		}
		while( !stackToL.isEmpty() || !stackToR.isEmpty())
		{
			if(direction == false)
			{
				while( !stackToL.empty() )
				{
					Node currentNode;
					currentNode = stackToL.pop();
					if(currentNode.left != null)
					{
						stackToR.push(currentNode.left);
					}
					if(currentNode.right != null)
					{
						stackToR.push(currentNode.right);
					}
					stackPrint.push(currentNode);
				}
				direction = true;
			}
			else
			{
				while( !stackToR.empty() )
				{
					Node currentNode;
					currentNode = stackToR.pop();
					if(currentNode.right != null)
					{
						stackToL.push(currentNode.right);
					}
					if(currentNode.left != null)
					{
						stackToL.push(currentNode.left);
					}
					stackPrint.push(currentNode);
				}
				direction = false;
			}
			while(!stackPrint.empty())
			{
				System.out.print(stackPrint.pop().data + " ");
			}

		}
		
		
	}
	
	public void printSpiral(Node root)
	{
		if(root == null)
		{
			return;
		}
		
		stackToL.push(root);
		levelTraversalSpiral(root);
	}

	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		Node n8 = new Node(8);
		Node n9 = new Node(9);
		Node n10 = new Node(10);
		Node n11 = new Node(11);
		Node n12 = new Node(12);
		Node n13 = new Node(13);
		Node n14 = new Node(14);
		Node n15 = new Node(15);
		
		Node root = n1;
		n1.left = n2;
		n1.right = n3;
		n2.left = n7;
		n2.right = n6;
		n3.left = n5;
		n3.right = n4;
		n4.left = n14;
		n4.right = n15;
		n5.left = n12;
		n5.right = n13;
		n6.left = n10;
		n6.right = n11;
		n7.left = n8;
		n7.right = n9;
		
		LevelOrderTraversalInSpiralForm lts = new LevelOrderTraversalInSpiralForm();
		lts.printSpiral(root);
	}

}
