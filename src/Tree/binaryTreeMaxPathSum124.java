package Tree;

public class binaryTreeMaxPathSum124 {
	public static void main(String args[]) {

	}
	int max=Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {
		maxToRoot(root);
		return max;
    }
	
	public int maxToRoot(TreeNode root)
	{
		if(root==null){return 0;}
		int leftSum=Math.max(0, maxToRoot(root.left));
		int rightSum=Math.max(0, maxToRoot(root.right));
		
		max=Math.max(max, root.val+leftSum+rightSum);
		return root.val+Math.max(leftSum,rightSum);
	}
}
