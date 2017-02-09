package Array;

import java.util.Arrays;

//https://leetcode.com/problems/next-permutation/
public class nextPermutation {
	public static void main(String args[])
	{
		int x[]={1,2,3,4};
		for(int i=0;i<=24;i++)
		{
			
			for(int a:x)
			{
				System.out.format("%d ",a);
			}
			System.out.println();
			new nextPermutation().nextPermutation(x);
		}
		
	}
	
	public void nextPermutation(int[] nums) {
		if(nums==null||nums.length==0){return;}
		int i=nums.length-1;
		while(i>0&&nums[i]<=nums[i-1])
		{
			i--;
		}
		if(i==0)
		{
			//4 3 2 1
			Arrays.sort(nums);
		}
		else
		{
			int x=nums[i-1];
			int minIndex=-1;
			for(int j=i;j<nums.length;j++)
			{
				if(minIndex==-1&&nums[j]>x)
				{
					minIndex=j;
				}
				else if(minIndex!=-1&&nums[j]>x&&nums[j]<nums[minIndex])
				{
					minIndex=j;
				}
			}
			int temp=nums[minIndex];
			nums[minIndex]=nums[i-1];
			nums[i-1]=temp;
			Arrays.sort(nums,i,nums.length);
		}
    }
}
