package Array;
import java.util.*;
//https://leetcode.com/problems/subsets/
public class subsets78 {
	public static void main(String args[])
	{
		int x[]={1,2,3};
		new subsets78().subsets(x);
	}
	
	List<List<Integer>> ans;
	List<Integer> list;

	public List<List<Integer>> subsets(int[] nums) {
		ans=new ArrayList<List<Integer>>();
		list=new ArrayList<Integer>();
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
		}
	}
}
