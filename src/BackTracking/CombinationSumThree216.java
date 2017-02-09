package BackTracking;
import java.util.*;
//https://leetcode.com/problems/combination-sum-iii/
public class CombinationSumThree216 {
	public static void main(String args[])
	{
		new CombinationSumThree216().combinationSum3(3, 15);
	}
	
	List<List<Integer>> ans;
	List<Integer> list;
	public List<List<Integer>> combinationSum3(int k, int n) {
		ans=new ArrayList<List<Integer>>();
		list=new ArrayList<Integer>();
		sub(k,n,1);
		return ans;
	}
	
	public void sub(int k,int n,int index)
	{
		if(n<0||k<0){return;}
		if(k==0&&n==0)
		{
			List<Integer> newList=new ArrayList<Integer>();
			newList.addAll(list);
			ans.add(newList);
			return;
		}
		for(int i=index;i<=9;i++)
		{
			list.add(i);
			sub(k-1,n-i,i+1);
			list.remove(list.size()-1);
		}
	}
}
