package Tree;
//https://leetcode.com/problems/find-mode-in-binary-search-tree/
import java.util.*;
public class findModeInBST501 {
	public static void main(String args[]) {
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(1);
		root.right=new TreeNode(2);
		root.right.right=new TreeNode(2);
		int[] ans=new findModeInBST501().findMode(root);
		for(int x:ans){System.out.println(x);}
	}
	
	int count,tempCount;
	Queue<TreeNode> q=new LinkedList<TreeNode>();
	List<Integer> list=new ArrayList<Integer>();
	public int[] findMode(TreeNode root) {
		count=0;
		if(root!=null){q.add(root);}
		while(!q.isEmpty())
		{
			TreeNode x=q.remove();
			if(x==null){continue;}
			tempCount=0;
			process(x,x.val);
			if(tempCount>count)
			{
				list=new ArrayList<Integer>();
				list.add(x.val);
				count=tempCount;
			}
			else if(tempCount==count)
			{
				list.add(x.val);
			}
			q.add(x.left);
			q.add(x.right);
		}
		int ans[]=new int[list.size()];
		for(int i=0;i<list.size();i++)
		{
			ans[i]=list.get(i);
		}
		return ans;
    }
	
	public void process(TreeNode x,int val)
	{
		if(x.val==val)
		{
			tempCount++;
		}
		if(x.left!=null){process(x.left,val);}
		if(x.right!=null){process(x.right,val);}
	}
}
