package DivideAndConquer;
import java.util.*;
//https://leetcode.com/problems/kth-largest-element-in-an-array/
public class kthLargestElement215 {
	public static void main(String args[])
	{
		int x[]={3,2,1,5,6,4};
		System.out.println(new kthLargestElement215().findKthLargest(x, 2));
	}
	
	public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> pq=new PriorityQueue(k);
		for(int i=0;i<nums.length;i++)
		{
			pq.add(nums[i]);
			if(pq.size()>k){pq.remove();}
		}
		return pq.remove();
	}
}
