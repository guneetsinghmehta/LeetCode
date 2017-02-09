package Heap;
import java.util.*;
//https://leetcode.com/problems/top-k-frequent-elements/
public class topKFrequentElements347 {
	public static void main(String args[]) {
		int x[]={1,1,1,2,2,3};
		int k=2;
		List<Integer> ans=new topKFrequentElements347().topKFrequent(x, k);
		for(int a:ans){System.out.println(a);}
	}

	public List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer> ans=new ArrayList<Integer>();
		if(nums==null||nums.length==0||k==0){return ans;}
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		for(int x:nums)
		{
			if(map.containsKey(x))
			{
				map.put(x, map.get(x)+1);
			}
			else{map.put(x, 1);}
		}
		PriorityQueue<Integer> q=new PriorityQueue<Integer>();//minHeap
		for(int x:map.keySet())
		{
			q.add(map.get(x));
			if(q.size()>k){q.remove();}
		}
		int minFreq=q.peek();
		for(int x:map.keySet())
		{
			if(map.get(x)>=minFreq){ans.add(x);}
		}
		return ans;
	}
}
