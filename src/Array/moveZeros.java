//https://leetcode.com/problems/move-zeroes/
package Arrays;
import java.util.*;
public class moveZeros {
	public static void main(String args[]) {
		int nums[]={0,1,0,3,12};
		print(nums);
		new moveZeros().moveZeroes(nums);
		print(nums);
	}
	
	public static void print(int[] nums)
	{
		for(int i=0;i<nums.length;i++)
		{
			System.out.printf("%d ",nums[i]);
		}
		System.out.println();
	}
	
	public void moveZeroes(int[] nums) 
	{
	     int i=0,j=0;
	     while(j<nums.length)
	     {
	    	 while(j<nums.length&&nums[j]==0){j++;}
	    	 if(j<nums.length)
	    	 {
	    		 nums[i]=nums[j];
	    		 i++;
	    		 j++;
	    	 }
	     }
	     while(i<nums.length)
	     {
	    	 nums[i]=0;i++;
	     }
    }
}
