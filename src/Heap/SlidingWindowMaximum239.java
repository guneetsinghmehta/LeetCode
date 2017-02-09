package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

//https://leetcode.com/problems/sliding-window-maximum/
public class SlidingWindowMaximum239 {
	public static void main(String args[]) {
		int x[]={1,3,-1,-3,5,3,6,7};
		int y[]=new SlidingWindowMaximum239().maxSlidingWindow(x, 3);
		for(int i:y)
		{
			System.out.println(i);
		}
		System.out.println(Integer.MAX_VALUE);
	}
	
	public int[] maxSlidingWindow(int[] nums, int k) {
		 if(nums==null||nums.length==0||k==0){int y[]=new int[0];return y;}
	       PriorityQueue<Integer> q=new PriorityQueue<Integer>(Collections.reverseOrder());
			int n=nums.length;
			int x[]=new int[n-k+1];
			int i;
			for( i=0;i<k;i++)
			{
				q.add(nums[i]);
			}
			for(i=0;i<n-k;i++)
			{
				x[i]=q.peek();
				q.remove(nums[i]);
				q.add(nums[i+k]);
			}
			x[i]=q.peek();
			return x;     
		}
	
}
