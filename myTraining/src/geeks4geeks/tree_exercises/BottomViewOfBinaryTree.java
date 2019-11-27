package geeks4geeks.tree_exercises;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

class Node_
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
	TreeMap<Integer, Stack<Integer>> myHashMap = new TreeMap<Integer, Stack<Integer>>();

		
	void InsertInMap(int key, int value)
	{
		if(myHashMap.get(key) == null)
		{
			Stack<Integer> thisList = new Stack<>();
			thisList.push(value);
			myHashMap.put(key, thisList);
		}
		else
		{
			((Stack<Integer>)myHashMap.get(key)).push(value);
		}
	}

	
	void SetHorizontalDistance(Node root)
	{
		if(root == null)
		{
			return;
		}
		
		root.hd = 0;

		if(root.left != null)
		{
			SetHorizontalDistance(root.left, root.hd-1);
		}
		if(root.right != null)
		{
			SetHorizontalDistance(root.right, root.hd+1);
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
	
	
	void traverseTree_InOrder(Node currentNode)
	{
		if(currentNode == null)
		{
			return;
		}
		
		traverseTree_InOrder(currentNode.left);
		System.out.print(currentNode.data + " ");
		traverseTree_InOrder(currentNode.right);
	}

	void traverseTree_PreOrder(Node currentNode)
	{
		if(currentNode == null)
		{
			return;
		}
		
		System.out.print(currentNode.data + " ");
		traverseTree_PreOrder(currentNode.left);
		traverseTree_PreOrder(currentNode.right);
	}

	void traverseTree_PostOrder(Node currentNode)
	{
		if(currentNode == null)
		{
			return;
		}
		
		traverseTree_PostOrder(currentNode.left);
		traverseTree_PostOrder(currentNode.right);
		System.out.print(currentNode.data + " ");
	}
	
	void traverseTree_LevelOrder(Node currentNode)
	{
		if(currentNode == null)
		{
			return;
		}
		Queue<Node> queue = new LinkedList<Node>();

		queue.add(currentNode);
		
		while(!queue.isEmpty())
		{
			Node toPrint = queue.remove();
//			System.out.print(toPrint.data + " ");
			InsertInMap(toPrint.hd, toPrint.data);
			
			if(toPrint.left != null)
			{
				queue.add(toPrint.left);
			}
			if(toPrint.right != null)
			{
				queue.add(toPrint.right);
			}
		}
	}
		
	
	public void bottomView(Node root)
    {
    	if(root == null)
    	{
    		return;
    	}
    	
    	SetHorizontalDistance(root);
    	traverseTree_LevelOrder(root);
    	TraverseMyHashMap();
    }
    
    public void TraverseMyHashMap()
    {
    	Iterator<Entry<Integer, Stack<Integer>>> it = myHashMap.entrySet().iterator();
		
    	while(it.hasNext())
    	{
    		Map.Entry<Integer, Stack<Integer>> mapElement = (Map.Entry<Integer, Stack<Integer>>)it.next();
        	System.out.print(((Stack<Integer>)mapElement.getValue()).peek() + " ");
    	}
    }
    

	public static void main(String[] args) {

		Node n20 = new Node(20);
		Node n8 = new Node(8);
		Node n22 = new Node(22);
		Node n5 = new Node(5);
		Node n3 = new Node(3);
		Node n25 = new Node(25);
		Node n10 = new Node(10);
		Node n14 = new Node(14);
		Node n4 = new Node(4);
		
		Node root = n20;
		n20.left = n8;
		n20.right = n22;
		n8.left = n5;
		n8.right = n3;
		n3.left = n10;
		n3.right = n14;
		n22.right = n25;
		n22.left = n4;
		
		BottomViewOfBinaryTree bvbt = new BottomViewOfBinaryTree();
		bvbt.bottomView(root);

		System.out.println("");
/*		
		System.out.println("Queue");
		BottomViewOfBinaryTree bvbt2 = new BottomViewOfBinaryTree("queue");
		bvbt2.bottomView(root);
*/
/*		
		Node Node10 = new Node(10);
		Node Node20 = new Node(20);
		Node Node30 = new Node(30);
		Node Node40 = new Node(40);
		Node Node60 = new Node(60);
		Node Node70 = new Node(70);
		Node Node80 = new Node(80);
		Node Node100 = new Node(100);

		Node root = Node10;
		Node10.left = Node20;
		Node10.right = Node30;
		Node20.left = Node40;
		Node20.right = Node60;
		Node30.left = Node80;
		Node30.right = Node70;
		Node80.left = Node100;
		
		BottomViewOfBinaryTree bvbt = new BottomViewOfBinaryTree("queue");
		bvbt.traverseTree_InOrder(root);
		System.out.println("");
		bvbt.traverseTree_PreOrder(root);
		System.out.println("");
		bvbt.traverseTree_PostOrder(root);
		System.out.println("");
		bvbt.traverseTree_LevelOrder(root);
*/
	}

}
