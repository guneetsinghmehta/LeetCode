package DP;

import java.util.Arrays;

//45
//https://leetcode.com/problems/jump-game-ii/
public class jumpGameTwo45 {
	
	public static void main(String args[])
	{
		int nums[]={1,2};
		System.out.println(new jumpGameTwo45().jump(nums));
	}
	
	public int jump(int[] nums) {
		if(nums==null||nums.length==0){return 0;}
		int jumps[]=new int[nums.length];
		Arrays.fill(jumps, Integer.MAX_VALUE);
		jumps[0]=0;
		for(int i=0;i<nums.length;i++)
		{
			int totalJumps=nums[i];
			for(int j=i;j<=i+totalJumps&&j<nums.length;j++)
			{
				jumps[j]=Math.min(jumps[j], jumps[i]+1);
			}
		}
		return jumps[nums.length-1];
	}
}
