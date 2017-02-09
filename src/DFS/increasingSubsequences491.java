package DFS;
import java.util.*;
//https://leetcode.com/problems/increasing-subsequences/
public class increasingSubsequences491 {
	public static void main(String args[]) {
		int x[]={4,6,7,7};
		new increasingSubsequences491().findSubsequences(x);
	}
	List<List<Integer>> ansCollection=new ArrayList<List<Integer>>();
	HashSet<ArrayList<Integer>> set=new HashSet<ArrayList<Integer>>();
	ArrayList<Integer> list=new ArrayList<Integer>();
	int nums[];
	public List<List<Integer>> findSubsequences(int[] x) {
		nums=x;
		sub(0);
		ansCollection.addAll(set);
		return ansCollection;
	}
	
	public void sub(int index)
	{
		if(list.size()>=2)
		{
			ArrayList<Integer> temp=new ArrayList<Integer>();
			temp.addAll(list);
			set.add(temp);
		}
		for(int i=index;i<nums.length;i++)
		{
			if(list.size()==0||list.get(list.size()-1)<=nums[i])
			{
				list.add(nums[i]);
				sub(i+1);
				list.remove(list.size()-1);
			}
		}
	}
	
}
