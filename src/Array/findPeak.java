//https://leetcode.com/problems/find-peak-element/
package Arrays;
import java.util.*;
public class findPeak {
	public static void main(String args[]) {
		int x[]={3,2,3,4};
		System.out.println(new findPeak().findPeakElement(x));
	}
	
	public int findPeakElement(int[] nums) {
		if(nums.length<=1){return 0;}
        for(int i=0;i<nums.length;i++)
        {
        	if(i==0&&nums[0]>nums[1]){return 0;}
        	else if(i==nums.length-1&&nums[nums.length-1]>nums[nums.length-2]){return nums.length-1;}
        	else if(i>0&&i<nums.length-1&&nums[i]>nums[i-1]&&nums[i]>nums[i+1]){return i;}
        }
        return 0;
    }
}
