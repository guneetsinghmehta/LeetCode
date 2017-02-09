package DFS;

import java.util.*;

//https://leetcode.com/problems/house-robber-iii/

public class houseRobber {

	public static void main(String args[])
	{
		int x[]={1,2,3,4};
		System.out.println(new houseRobber().rob2(x));
	}
	//house robber 1 
	//https://leetcode.com/problems/house-robber/
	public int rob(int[] nums) {
		if(nums==null||nums.length==0){return 0;}
		else if(nums.length==1){return nums[0];}
		else
		{
			for(int i=2;i<nums.length;i++)
			{
				if(i==2){nums[i]=nums[i]+nums[i-2];}
				else
				{
					nums[i]=nums[i]+(int)Math.max(nums[i-3], nums[i-2]);
				}
			}
			return (int)Math.max(nums[nums.length-1],nums[nums.length-2]);
		}
		
	}

	//https://leetcode.com/problems/house-robber-ii/
	public int rob2(int[] nums) {
        //case when first is selected
		if(nums==null||nums.length==0){return 0;}
		if(nums.length==1){return nums[0];}
		if(nums.length==2){return Math.max(nums[0], nums[1]);}
		int x[]=Arrays.copyOfRange(nums.clone(),2, nums.length-1);
		int ans=nums[0]+rob(x);
		//case when first is not
		x=Arrays.copyOfRange(nums.clone(),1,nums.length);
		ans=Math.max(ans, rob(x));
		return ans;
    }

	//https://leetcode.com/problems/house-robber-iii/
	public int rob(TreeNode root) 
	{
		return robSub(root);
	}
	
	public int robSub(TreeNode root) 
	{
		if(root==null){return 0;}
		else
		{
			int ans=robSub(root.left)+robSub(root.right);
			int ans2=root.val;
			if(root.left!=null)
			{
				ans2+=robSub(root.left.left)+robSub(root.left.right);
			}
			if(root.right!=null)
			{
				ans2+=robSub(root.right.left)+robSub(root.right.right);
			}
			return Math.max(ans, ans2);
		}
	}
}
