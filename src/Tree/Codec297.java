package Tree;

import java.util.*;

//https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
public class Codec297 {
	public static void main(String args[]) {
		TreeNode root = new TreeNode(1);
		root.right=new TreeNode(2);
		root.right.left = new TreeNode(3);
		root.left=new TreeNode(-1);
		
		Codec297 c=new Codec297();
		String str=c.serialize(root);
		System.out.println(str);
		TreeNode newRoot=c.deserialize(str);
		System.out.println();
	}

	StringBuilder sb = new StringBuilder();
	Queue<TreeNode> main = new LinkedList<TreeNode>();
	Queue<TreeNode> aux = new LinkedList<TreeNode>();

	public void subSerialize() {
		TreeNode x;
		while (!main.isEmpty()) {
			aux = new LinkedList<TreeNode>();
			boolean nonzero=false;
			while (!main.isEmpty()) {
				x = main.remove();
				if (x == null) {
					sb.append("null");
				} else {
					sb.append(x.val);
				}
				sb.append(",");
				if(x!=null)
				{
					if(x.left!=null||x.right!=null){nonzero=true;}
					aux.add(x.left);
					aux.add(x.right);
				}
			}
			if(nonzero)
			{main=aux;}
		}
	}

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		main.add(root);
		subSerialize();
		String str = sb.toString();
		return str.substring(0, str.length() - 1);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		String strs[]=data.split(new String(","));
		TreeNode root,x;
		TreeNode nodes[]=new TreeNode[strs.length];
		for(int i=0;i<strs.length;i++)
		{
			nodes[i]=getNode(strs[i]);
		}
		int j=0;
		for(int i=0;i<strs.length;i++)
		{
			if(i==0)
			{
				j=1;
			}
			if(nodes[i]!=null)
			{
				if(j<strs.length)
				{nodes[i].left=nodes[j++];}
				if(j<strs.length)
				{nodes[i].right=nodes[j++];}
			}
		}
		return nodes[0];
	}
	
	public TreeNode getNode(String str)
	{
		if(str.equals(new String("null")))
		{
			return null;
		}
		else
		{
			return new TreeNode(Integer.parseInt(str));
		}
	}

}
