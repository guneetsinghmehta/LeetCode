package Array;

//https://leetcode.com/problems/search-for-a-range/
public class searchForRange34 {
	public static void main(String args[]) {
		int nums[] = {5,7,7,8,8,10};
		int x = 8;
		int y[]=new searchForRange34().searchRange(nums, x);
		System.out.println(1);
	}

	public int[] searchRange(int[] nums, int target) {
		int ans[]=new int[2];
		if(nums==null||nums.length==0){ans[0]=-1;ans[1]=-1;return ans;}
		int a=0,b=nums.length-1;
		int mid=0;
		while(a<=b)
		{
			mid=(a+b)/2;
			if(nums[mid]==target)
			{
				break;
			}
			else if(nums[mid]>target)
			{
				b=mid-1;
			}
			else
			{
				a=mid+1;
			}
		}
		if(nums[mid]!=target){ans[0]=-1;ans[1]=-1;}
		else
		{
			int index=mid,start=0,end=nums.length-1;
			//binary search for first target
			a=0;
			b=index;
			while(a<=b)
			{
				mid=(a+b)/2;
				if(nums[mid]!=target)
				{
					a=mid+1;
				}
				else
				{
					if(mid==0||nums[mid-1]!=target){start=mid;break;}
					else if(nums[mid-1]==target){b=mid-1;}
				}
			}
			a=index;
			b=nums.length-1;
			while(a<=b)
			{
				mid=(a+b)/2;
				if(nums[mid]!=target)
				{
					b=mid-1;
				}
				else
				{
					if(mid==nums.length-1||nums[mid+1]!=target){end=mid;break;}
					else if(nums[mid+1]==target){a=mid+1;}
				}
			}
			ans[0]=start;
			ans[1]=end;
		}
		return ans;
	}
}
