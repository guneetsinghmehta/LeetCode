package DFS;
//https://leetcode.com/problems/path-sum/
public class pathSum{

	public boolean hasPathSum(TreeNode root, int sum) {
		boolean ans=false;
		if(root==null){ans=false;}
		else
		{
			if(root.left==null&&root.right==null&&root.val==sum){ans=true;}
			else
			{
				ans=hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);
			}
		}
		return ans;
    }
}
