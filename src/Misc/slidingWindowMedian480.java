package Misc;

import java.util.Collections;
import java.util.PriorityQueue;

public class slidingWindowMedian480 {
	//MedianFinder295.java
	class MedianFinder295 {
		PriorityQueue<Integer> maxHeap=new PriorityQueue<Integer>(Collections.reverseOrder());
		PriorityQueue<Integer> minHeap=new PriorityQueue<Integer>();
		public MedianFinder295() {
			//System.out.println(1);
	    }
	    
	    public void addNum(int num) {
	        maxHeap.add(num);
	        //satisfy the heap property
	        while(!maxHeap.isEmpty()&&!minHeap.isEmpty()&&minHeap.peek()<=maxHeap.peek())
	        {
	        	minHeap.add(maxHeap.remove());
	        }
	        while(!minHeap.isEmpty()&&minHeap.size()>maxHeap.size())
	        {
	        	maxHeap.add(minHeap.remove());
	        }
	        while(!maxHeap.isEmpty()&&maxHeap.size()>minHeap.size()+1)
	        {
	        	minHeap.add(maxHeap.remove());
	        }
	    }
	    
	    public double findMedian() {
	    	if(maxHeap.size()==minHeap.size()+1)
	    	{
	    		return maxHeap.peek();
	    	}
	    	else
	    	{
	    		int a=maxHeap.peek();
	    		int b=minHeap.peek();
	    		double ans=a;
	    		ans=ans+b;
	    		return ans/2;
	    	}
	    }
	}

	public double[] medianSlidingWindow(int[] nums, int k) {
		MedianFinder295 c=new MedianFinder295();
		for(int i=0;i<k;i++)
		{
			c.addNum(nums[i]);
		}
		int n=nums.length;
		double[] ans=new double[n-k+1];
		int i;
		for(i=0;i<n-k;i++)
		{
			ans[i]=c.findMedian();
			boolean temp=c.minHeap.remove(nums[i]);
			if(!temp){
				c.maxHeap.remove(nums[i]);
			}
			c.addNum(nums[i+k]);
		}
		ans[i]=c.findMedian();
		return ans;
    }
	
	
	public static void main(String args[]) {
		int x[]={7,8,8,3,8,1,5,3,5,4};
		double ans[]=new slidingWindowMedian480().medianSlidingWindow(x,3);
		for(double d:ans)
		{
			System.out.println(d);
		}
	}
	
}
