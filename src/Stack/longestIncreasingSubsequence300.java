package Stack;

import java.util.Arrays;
import java.util.Stack;

//https://leetcode.com/problems/longest-increasing-subsequence/
public class longestIncreasingSubsequence300 {
	public static void main(String args[]) {
		//int x[]={10,9,2,5,3,7,101,18};
		int x[]={1,3,6,7,9,4,10,5,6};
		System.out.println(new longestIncreasingSubsequence300().lengthOfLIS(x));
	}
	

	public int lengthOfLIS(int[] nums) {
		return dpSolution(nums);
    }
	
	public int stackSolution(int nums[])
	{
		//Takes O(n2) time
		if(nums==null){return 0;}
		if(nums.length<=1){return nums.length;}
		Stack<Integer> stack=new Stack<Integer>();
		stack.push(nums[0]);
		int ans=1;
		for(int i=1;i<nums.length;i++)
		{
			int x=nums[i];
			while(!stack.isEmpty()&&stack.peek()>x)
			{
				stack.pop();
			}
			stack.push(x);
			ans=Math.max(ans, stack.size());
		}
		return ans;
	}
	
	public int dpSolution(int nums[])
	{
		if(nums==null){return 0;}
		if(nums.length<=1){return nums.length;}
		
		int dp[]=new int[nums.length];
		Arrays.fill(dp, 1);
		int ans;
		for(int i=1;i<dp.length;i++)
		{
			ans=1;
			for(int j=0;j<i;j++)
			{
				if(nums[j]<nums[i])
				{
					ans=Math.max(ans, dp[j]+1);
				}
			}
			dp[i]=ans;
		}
		ans=0;
		for(int x:dp)
		{
			ans=Math.max(x, ans);
		}
		return ans;
	}
}
