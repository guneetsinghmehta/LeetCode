package Design;

import java.util.Collections;
import java.util.PriorityQueue;

//https://leetcode.com/problems/find-median-from-data-stream/
public class MedianFinder295 {
	public static void main(String args[]) {
		MedianFinder295 a=new MedianFinder295();
		a.addNum(1);
		a.addNum(2);
		System.out.println(a.findMedian());
		a.addNum(3);
		System.out.println(a.findMedian());
	}
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
    		return ((double)(a+b))/2;
    	}
    }
}
