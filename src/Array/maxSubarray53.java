package Array;

//53
//https://leetcode.com/problems/maximum-subarray/
import java.util.*;

public class maxSubarray53 {
	public static void main(String args[]) {
		//int x[] = {-2,1,-3,4,-1,2,1,-5,4};
		int x[] = {1,2};
		System.out.println(new maxSubarray53().maxSubArray(x));
	}

	public int maxSubArray(int[] nums) {
		// if nums is null or a single element return 0 or fist element
		if (nums == null || nums.length < 2) {
			return nums[0];
		}
		for (int i = 1; i < nums.length; i++) {
			nums[i] = nums[i] + nums[i - 1];
		}
		// initiate sum as nums[0]
		int sum = nums[0];
		int min = nums[0];
		for (int i = 1; i < nums.length; i++) {
			sum=sum<nums[i]-min?nums[i]-min:sum;
			sum=sum<nums[i]?nums[i]:sum;
			if(min>nums[i]){min=nums[i];}
		}
		return sum;
	}
}
