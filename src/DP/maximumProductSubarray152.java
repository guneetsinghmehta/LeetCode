package DP;
//https://leetcode.com/problems/maximum-product-subarray/
public class maximumProductSubarray152 {
	public static void main(String args[]) {
		int x[]={-2,3,-4};
		System.out.println(new maximumProductSubarray152().maxProduct(x));
	}
	
	public int maxProduct(int[] nums) {
		if(nums==null||nums.length==0){return 0;}
		int maxV[]=new int[nums.length];
		int minV[]=new int[nums.length];
		maxV[0]=nums[0];
		minV[0]=nums[0];
		for(int i=1;i<nums.length;i++)
		{
			if(nums[i]>=0)
			{
				maxV[i]=Math.max(nums[i], nums[i]*maxV[i-1]);
				minV[i]=Math.min(nums[i], nums[i]*minV[i-1]);
			}
			else
			{
				maxV[i]=Math.max(nums[i], nums[i]*minV[i-1]);
				minV[i]=Math.min(nums[i], nums[i]*maxV[i-1]);
			}
		}
		int ans=maxV[0];
		for(int x:maxV)
		{
			ans=Math.max(ans, x);
		}
		return ans;
    }
}
