package Tree;
//https://leetcode.com/problems/unique-binary-search-trees-ii/
import java.util.*;
public class uniqueBSTTwo95 {
	public static void main(String args[]) {
		List<TreeNode> list=new uniqueBSTTwo95().generateTrees(3);
		System.out.println(list.size());
	}
	
	public List<TreeNode> generateTrees(int n) {
		if(n==0){return new ArrayList<TreeNode>();}
        return sub(1,n);
    }
	
	public List<TreeNode> sub(int start, int end)
	{
		List<TreeNode> list=new ArrayList<TreeNode>();
		if(start>end){list.add(null);return list;}
		for(int i=start;i<=end;i++)
		{
			List<TreeNode> leftList=sub(start,i-1);
			List<TreeNode> rightList=sub(i+1,end);
			for(TreeNode left:leftList)
			{
				for(TreeNode right:rightList)
				{
					TreeNode root=new TreeNode(i);
					root.left=left;
					root.right=right;
					list.add(root);
				}
			}
		}
		return list;
	}
}
