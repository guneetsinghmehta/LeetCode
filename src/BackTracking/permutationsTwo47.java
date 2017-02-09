package BackTracking;

//46
//https://leetcode.com/problems/permutations/
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class permutationsTwo47 {
	public static void main(String args[])
	{
		int x[]={1,1,2};
		new permutationsTwo47().permute(x);
	}
	
	List<List<Integer>> ans;
	ConcurrentHashMap<Integer, Integer> map;
	public List<List<Integer>> permute(int[] nums) {
		ans=new ArrayList<List<Integer>>();
		map=new ConcurrentHashMap<Integer,Integer>();
		for(int x:nums)
		{
			if(map.containsKey(x))
			{
				map.put(x, map.get(x)+1);
			}
			else
			{
				map.put(x,1);
			}
		}
		ArrayList<Integer> list=new ArrayList<Integer>();
		sub(list);
		return ans;
	}
	
	public void sub(ArrayList<Integer> list)
	{
		if(map.size()==0)
		{
			List<Integer> temp=new ArrayList<Integer>();
			temp.addAll(list);
			ans.add(temp);
		}
		else
		{
			
			for(int x:map.keySet())
			{
				if(map.get(x)==1){map.remove(x);}
				else{map.put(x, map.get(x)-1);}
				list.add(x);
				sub(list);
				list.remove(list.size()-1);
				if(map.containsKey(x)){map.put(x, map.get(x)+1);}
				else{map.put(x, 1);}
				
			}
		}
	}
	
}
