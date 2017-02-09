package BackTracking;

//46
//https://leetcode.com/problems/permutations/
import java.util.*;

public class permutations46 {
	public static void main(String args[])
	{
		int x[]={1,2,3,4};
		new permutations46().permute(x);
	}
	
	List<List<Integer>> ans=new ArrayList<List<Integer>>();
	int count;
	boolean visited[];
	int x[];
	public List<List<Integer>> permute(int[] nums) {
		visited=new boolean[nums.length];
		count=0;
		x=nums;
		ArrayList<Integer> list=new ArrayList<Integer>();
		sub(list);
		return ans;
	}
	
	public void sub(ArrayList<Integer> list)
	{
		if(count==visited.length)
		{
			ArrayList<Integer> temp=new ArrayList<Integer>();
			temp.addAll(list);
			ans.add(temp);
			return;
		}
		for(int i=0;i<visited.length;i++)
		{
			if(!visited[i])
			{
				list.add(x[i]);
				visited[i]=true;
				count++;
				sub(list);
				count--;
				visited[i]=false;
				list.remove(list.size()-1);
			}
		}
	}
	
}
