package Array;
//https://leetcode.com/problems/search-insert-position/
public class searchInsertPosition35 {
	public static void main(String args[])
	{
		int nums[]={1,2,3,4,5,10};
		int x=2;
		System.out.println(new searchInsertPosition35().searchInsert(nums, x));
	}
	
	public int searchInsert(int[] nums, int x) {
		if(nums==null){return 0;}
		if(x<nums[0]){return 0;}
		if(x>nums[nums.length-1]){return nums.length;}
		if(x==nums[0]){return 0;}
		if(x==nums[nums.length-1]){return nums.length-1;}
		int a=0,b=nums.length-1;
		int mid;
		while(a<b)
		{
			mid=(a+b)/2;
			if(nums[mid]==x){return mid;}
			if(nums[mid]<x)
			{
				a=mid+1;
			}
			else
			{
				b=mid-1;
			}
		}
		if(nums[a]==x){return a;}
		if(nums[a]<x&&nums[a+1]>x){return a+1;}
		if(nums[a-1]<x&&nums[a]>x){return a;}
		return 0;
    }
}
