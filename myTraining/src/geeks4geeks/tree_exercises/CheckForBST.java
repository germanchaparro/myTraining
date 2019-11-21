package geeks4geeks.tree_exercises;

// from: https://practice.geeksforgeeks.org/problems/check-for-bst/1

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

public class CheckForBST {
	
	int[] array = new int[1000];
	int arraySize = 0;
	
	void inOrder(Node currentNode)
	{
		if(currentNode == null)
		{
			return;
		}
		
		inOrder(currentNode.left);
		array[arraySize] = currentNode.data;
		arraySize++;
		inOrder(currentNode.right);
	}
	
    int checkArrayOrder()
    {
    	if(arraySize == 1)
    	{
    		return 1;
    	}
    	for (int i = 0; i < arraySize-1; i++)
    	{
    		if(array[i] > array[i+1])
    		{
    			return 0;
    		}
    	}
    	return 1;
    }
	
        
    int isBST(Node root)  
    {
    	if(root == null)
    	{
    		return 1;
    	}
    	
    	inOrder(root);
    	return checkArrayOrder();
    }
    

    
    void printArray()
    {
    	for (int i = 0; i < arraySize; i++)
    	{
    		System.out.print(array[i] + " ");
    	}
    	System.out.println();
    }

	public static void main(String[] args) {
/*
		Node myTree = new Node(10);
		myTree.left = new Node(7);
		myTree.left.right = new Node(11);
		myTree.right = new Node(39);
*/		
		Node myTree = new Node(0);

		CheckForBST checkBST = new CheckForBST();
		System.out.println(checkBST.isBST(myTree));
//		checkBST.printArray();
	}

}