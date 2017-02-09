package DFS;
//https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
import java.util.*;
public class rightNode {
	private class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;
		TreeLinkNode(int x) {
			val = x;
		}
	}

	public void connect(TreeLinkNode root) {
		Queue<TreeLinkNode> main=new LinkedList<TreeLinkNode>();
		Queue<TreeLinkNode> aux=new LinkedList<TreeLinkNode>();
		if(root!=null)main.add(root);
		while(!main.isEmpty())
		{
			while(!main.isEmpty())
			{
				TreeLinkNode x=main.remove();
				if(!main.isEmpty())
				{
					x.next=main.peek();
				}
				if(x.left!=null){aux.add(x.left);}
				if(x.right!=null){aux.add(x.right);}
			}
			main=aux;
			aux=new LinkedList<TreeLinkNode>();
		}
	}

}
