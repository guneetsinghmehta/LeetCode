package DFS;

import java.util.*;

//https://leetcode.com/problems/path-sum-ii/

public class pathSum2 {
	private class TreeNode
	{
		int val;
		TreeNode left,right;
		public TreeNode(int i) {
			this.val=i;
		}
	}
	public static void main(String args[])
	{
		pathSum2 sol=new pathSum2();
		sol.test();
	}
	
	private void test()
	{
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(-2);
		root.right=new TreeNode(-3);
		root.left.left=new TreeNode(1);
		root.left.right=new TreeNode(3);
		root.right.left=new TreeNode(-2);
		root.left.left.left=new TreeNode(-1);
		pathSum(root,-1);
		System.out.println(1);
	}
	List<List<Integer>> ans;

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		// create an ans variable
		ans = new LinkedList<List<Integer>>();
		// create a sub function
		sub(root, new LinkedList<Integer>(), sum);
		return ans;
	}

	public List<Integer> copy(List<Integer> x) {
		List<Integer> temp = new LinkedList<Integer>();
		for (int i : x) {
			temp.add(i);
		}
		return temp;
	}

	public void sub(TreeNode x, List<Integer> list, int sum) {
		if (x == null) {
			return;
		}
		// check if the sum==x.root, if yes then add x to the list and add it to
		// ans
		list.add(x.val);
		sum -= x.val;
		if (sum == 0&&x.left==null&&x.right==null) {
			ans.add(copy(list));
		} else if (sum != 0) {
			sub(x.left, list, sum);
			sub(x.right, list, sum);
		}
		// remove the x node
		list.remove(list.size() - 1);

	}
}
