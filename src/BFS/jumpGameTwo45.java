package BFS;
//45
//https://discuss.leetcode.com/topic/3191/o-n-bfs-solution
import java.util.*;

public class jumpGameTwo45 {

	public static void main(String args[])
	{
		int nums[]={1,2};
		System.out.println(new jumpGameTwo45().jump(nums));
	}
	
	public int jump(int[] nums) {
		 if (nums == null || nums.length < 2) {
		        return 0;
		    }

		    // First set up current region, which is
		    // from 0 to nums[0].
		    int l = 0;
		    int r = nums[0];
		    // Since the length of nums is greater than
		    // 1, we need at least 1 step.
		    int step = 1;

		    // We go through all elements in the region.
		    while (l <= r) {

		        // If the right of current region is greater
		        // than nums.length - 1, that means we are done.
		        if (r >= nums.length - 1) {
		            return step;
		        }

		        // We should know how far can we reach in current
		        // region.
		        int max = Integer.MIN_VALUE;
		        for (; l <= r; l++) {
		            max = Math.max(max, l + nums[l]);
		        }

		        // If we can reach far more in this round, we update
		        // the boundary of current region, and also add a step.
		        if (max > r) {
		            l = r;
		            r = max;
		            step++;
		        }
		/* BFS based
		Queue<Integer> main=new LinkedList<Integer>();
		int jumps[]=new int[nums.length];
		Arrays.fill(jumps, Integer.MAX_VALUE);
		main.add(0);
		int count=0;
		while(!main.isEmpty())
		{
			Queue<Integer> aux=new LinkedList<Integer>();
			while(!main.isEmpty())
			{
				int x=main.remove();
				if(jumps[x]!=Integer.MAX_VALUE){continue;}
				else
				{
					jumps[x]=count;
					for(int i=x+1;i<=x+nums[x]&&i<nums.length;i++)
					{
						aux.add(i);
					}
				}
			}
			count++;
			main=aux;
		}
		return jumps[jumps.length-1];
		/*
		 * 
		 */
		/*
		 * DP solution
		 * if(nums==null||nums.length==0){return 0;}
		int jumps[]=new int[nums.length];
		Arrays.fill(jumps, Integer.MAX_VALUE);
		jumps[0]=0;
		for(int i=0;i<nums.length;i++)
		{
			int totalJumps=nums[i];
			for(int j=i;j<=i+totalJumps&&j<nums.length;j++)
			{
				jumps[j]=Math.min(jumps[j], jumps[i]+1);
			}
		}
		return jumps[nums.length-1];
		 //slow for one testcase
		 */
	}
}
