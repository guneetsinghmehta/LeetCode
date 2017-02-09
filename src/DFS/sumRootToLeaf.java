package DFS;

//https://leetcode.com/problems/sum-root-to-leaf-numbers/
public class sumRootToLeaf {
	int sum = 0;

	public int sumNumbers(TreeNode root) {
		sub(root,0);
		return sum;
	}

	public void sub(TreeNode root,int x) {
		if(root==null){return;}
		else if(root.left==null&&root.right==null)
		{
			sum=sum+x*10*root.val;
		}
		else
		{
			x=10*x+root.val;
			if(root.left!=null){sub(root.left,x);}
			if(root.right!=null){sub(root.right,x);}
		}
	}
}
