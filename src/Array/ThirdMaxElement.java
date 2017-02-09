//https://leetcode.com/problems/third-maximum-number/
package Arrays;
import java.util.*;
public class ThirdMaxElement {
	public static void main(String args[]) {
		int nums[]={1,1,2};
		System.out.println(new ThirdMaxElement().thirdMax(nums));
	}
	
	public int thirdMax(int[] nums) 
	{
	        PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
	        for(int i=0;i<nums.length;i++)
	        {
	        	if(!pq.contains(nums[i]))
	        	{
	        		pq.add(nums[i]);
	        	}
	        	if(pq.size()>3){pq.remove();}
	        }
	        if(pq.size()==1){return pq.remove();}
	        else if(pq.size()==2){pq.remove(); return pq.remove();}
	        else{return pq.remove();}
    }
}
