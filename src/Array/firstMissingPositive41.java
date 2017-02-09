package Array;
//https://leetcode.com/problems/first-missing-positive/
public class firstMissingPositive41 {
	public static void main(String args[]) {
		int x[]={1,1};
		System.out.println(new firstMissingPositive41().firstMissingPositive(x));
	}
	
	public int firstMissingPositive(int[] nums) {
		if(nums==null||nums.length==0){return 1;}
		int newArray[]=new int[nums.length+1];
		for(int i=0;i<nums.length;i++)
		{
			newArray[i]=nums[i];
		}
		newArray[nums.length]=Integer.MIN_VALUE;
		nums=newArray;
		
		int x;
		for(int i=0;i<nums.length;i++)
		{
			x=nums[i];
			if(x<0||x>=nums.length||x==i){continue;}
			else
			{
				int temp=nums[x];
				nums[x]=x;
				nums[i]=temp;
				if(nums[x]!=nums[i])
				{i--;}
			}
		}
		for(int i=1;i<nums.length;i++)
		{
			if(nums[i]!=i){return i;}
		}
		return nums.length;
	}
}
