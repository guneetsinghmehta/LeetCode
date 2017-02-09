package DP;
//https://leetcode.com/problems/target-sum/
import java.util.*;
public class targetSum494 {
	public static void main(String args[]) {
		int x[]={1,1,1,1,1};
		System.out.println(new targetSum494().findTargetSumWays(x, 3));
	}

	public int findTargetSumWays(int[] nums, int S) {
		if(nums==null||nums.length==0){return 0;}
		List<HashMap<Integer,Integer>> x=new ArrayList<HashMap<Integer,Integer>>();
		int n=nums.length;
		for(int i=0;i<n;i++){x.add(new HashMap<Integer,Integer>());}
		if(nums[n-1]!=0)
		{
			x.get(n-1).put(nums[n-1],1);
			x.get(n-1).put(-nums[n-1],1);
		}
		else
		{
			x.get(n-1).put(0,2);
		}
		int newKey,newValue,oldValue;
		for(int i=n-2;i>=0;i--)
		{
			for(int oldKey:x.get(i+1).keySet())
			{
				newKey=oldKey+nums[i];
				if(x.get(i).containsKey(newKey))
				{
					newValue=x.get(i+1).get(oldKey)+x.get(i).get(newKey);
				}
				else
				{
					newValue=x.get(i+1).get(oldKey);
				}
				x.get(i).put(newKey, newValue);
				
				newKey=oldKey-nums[i];
				if(x.get(i).containsKey(newKey))
				{
					newValue=x.get(i+1).get(oldKey)+x.get(i).get(newKey);
				}
				else
				{
					newValue=x.get(i+1).get(oldKey);
				}
				x.get(i).put(newKey, newValue);
			}
		}
		if(x.get(0).containsKey(S))
		{
			return x.get(0).get(S);
		}
		else
		{
			return 0;
		}
	}
}
