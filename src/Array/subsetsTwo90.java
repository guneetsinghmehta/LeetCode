package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subsetsTwo90 {
	public static void main(String args[])
	{
		int x[]={1,2,2};
		new subsetsTwo90().subsetsWithDup(x);
	}
	List<List<Integer>> ans;
	List<Integer> list;

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		ans=new ArrayList<List<Integer>>();
		list=new ArrayList<Integer>();
		Arrays.sort(nums);
		sub(nums,0);
		return ans;
	}
	
	public void sub(int[] nums,int index)
	{
		List<Integer> newList=new ArrayList<Integer>();
		newList.addAll(list);
		ans.add(newList);
		for(int i=index;i<nums.length;i++)
		{
			list.add(nums[i]);
			sub(nums,i+1);
			list.remove(list.size()-1);
			while(i+1<nums.length&&nums[i]==nums[i+1])
			{
				i++;
			}
		}
	}

}
