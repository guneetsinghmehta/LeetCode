//https://leetcode.com/problems/majority-element/
package Arrays;
import java.util.*;
public class majorityElement {
	public static void main(String args[]) {
		int nums[]={1,3,3,2,3,3};
		System.out.println(new majorityElement().majorityElement(nums));
	}
	
	public int majorityElement(int[] nums) {
		int ans=sub(nums,0,nums.length-1);
		return ans;
    }
	
	public int sub(int[] nums,int start,int end)
	{
		if(start>end){return Integer.MIN_VALUE;}
		else if(start==end){return nums[start];}
		
		int mid=(start+end)/2;
		int left=sub(nums,start,mid);
		int right=sub(nums,mid+1,end);
		int n=end-start+1;
		
		//check for left
		int count=0;
		for(int i=start;i<=end;i++)
		{
			if(nums[i]==left){count++;}
		}
		if(count>Math.floor(n/2)){return left;}
		//check for right
		count=0;
		for(int i=start;i<=end;i++)
		{
			if(nums[i]==right){count++;}
		}
		if(count>Math.floor(n/2)){return right;}
		
		return Integer.MIN_VALUE;
	}
}
