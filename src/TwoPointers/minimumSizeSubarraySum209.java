package TwoPointers;
//https://leetcode.com/problems/minimum-size-subarray-sum/
public class minimumSizeSubarraySum209 {
	public static void main(String args[]) {
		int x[]={2,3,1,2,4,3};
		System.out.println(new minimumSizeSubarraySum209 ().minSubArrayLen(7, x));
	}
	
	public int minSubArrayLen(int s, int[] nums) {
        if(nums==null||nums.length==0){return 0;}
        if(nums.length==1&&nums[0]<s){return 0;}
        if(nums.length==1&&nums[0]>=s){return 1;}
        int a=0;
        int b=1;
        int sum=nums[a];
        int ans=Integer.MAX_VALUE;
        while(b<nums.length)
        {
        	while(sum<s&&b<nums.length)
        	{
        		sum+=nums[b++];
        	}
        	while(sum>=s&&a<b)
        	{
        		ans=Math.min(ans, b-a);
        		sum-=nums[a++];
        	}
        }
        if(ans==Integer.MAX_VALUE){return 0;}
        else{return ans;}
    }
}
