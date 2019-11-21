package geeks4geeks.tree_exercises;

import java.util.HashMap;
import java.util.Stack;

class Node
{
    int data;
    int hd;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}

public class BottomViewOfBinaryTree {

	HashMap<Integer, Stack<Integer>> myHashMap = new HashMap<>();
	
	void InsertInMap(int key, int value)
	{
		if(myHashMap.get(key) == null)
		{
			Stack<Integer>
		}
	}
	
	void SetHorizontalDistance(Node node)
	{
		if(node == null)
		{
			return;
		}
		
		node.hd = 0;

		if(node.left != null)
		{
			SetHorizontalDistance(node.left, node.hd-1);
		}
		if(node.right != null)
		{
			SetHorizontalDistance(node.right, node.hd+1);
		}		
	}
	
	void SetHorizontalDistance(Node node, int horizontalDistance)
	{
		node.hd = horizontalDistance;
		if(node.left != null)
		{
			SetHorizontalDistance(node.left, node.hd-1);
		}
		if(node.right != null)
		{
			SetHorizontalDistance(node.right, node.hd+1);
		}		
	}
	
	int[] array = new int[1000];
	int arraySize = 0;
	
	void inOrder(Node currentNode)
	{
		if(currentNode == null)
		{
			return;
		}
		
		inOrder(currentNode.left);
		
		// will save the data in the array only if it is a leaf node
		if(currentNode.left == null && currentNode.right == null)
		{
			array[arraySize] = currentNode.data;
			arraySize++;
		}
		inOrder(currentNode.right);
	}
	
    void printArray()
    {
    	for (int i = 0; i < arraySize; i++)
    	{
    		System.out.print(array[i] + " ");
    	}
    	System.out.println();
    }
	
    public void bottomView(Node root)
    {
    	if(root == null)
    	{
    		return;
    	}
    	
    	SetHorizontalDistance(root);
    	
    	
    	inOrder(root);
    	printArray();
    }
    
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
