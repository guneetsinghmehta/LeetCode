package Array;
import java.util.*;
//15
//https://leetcode.com/problems/3sum/
public class sum3 {
	
	public static void main(String args[])
	{
		int nums[]={-1,0,1,2,-1,-4};
		List<List<Integer>> x=new sum3().threeSum(nums);
		System.out.println();
	}
	
	public List<List<Integer>> threeSum(int[] nums) {
		 List<List<Integer>> ans=new LinkedList<List<Integer>>();
			if(nums.length<=2){return ans;}
			//sort the array
			Arrays.sort(nums);
			//loop over elements
			int start,end,target;
			for(int index=0;index<nums.length;index++)
			{
				target=-(nums[index]);
				if(index>0&&nums[index]==nums[index-1]){continue;}
				start=index+1;
				end=nums.length-1;
				while(start<end)
				{
					if(nums[start]+nums[end]>target){end--;}
					else if(nums[start]+nums[end]<target){start++;}
					else
					{
						List<Integer> list=new LinkedList<Integer>();
						list.add(nums[index]);
						list.add(nums[start]);
						list.add(nums[end]);
						ans.add(list);
						while(start<end&&nums[start]==nums[start+1]){start++;}
						while(start<end&&nums[end]==nums[end-1]){end--;}
						start++;
						end--;
					}
				}
			}
			return ans;
    }
}
