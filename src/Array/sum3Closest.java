package Array;
//https://leetcode.com/problems/3sum-closest/
import java.util.Arrays;

//Sort and use two pointers to find numbers
public class sum3Closest {
	public static void main(String args[]) {
		int nums[]={1,1,1,0};
		System.out.println(new sum3Closest().threeSumClosest(nums, 100));
	}

	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		// closest sum
		int ans = nums[0] + nums[1] + nums[2];
		for (int i = 0; i < nums.length - 2; i++) {
			int lo = i + 1;
			int hi = nums.length - 1;
			while (lo < hi) {
				if (lo<hi&&Math.abs(nums[lo] + nums[hi] +nums[i]- target) < Math.abs(ans
						- target)) {
					ans = nums[lo] + nums[hi]+nums[i];
				}
				if (nums[i]+nums[lo] + nums[hi] > target) {
					hi--;
				} else if (nums[i]+nums[lo] + nums[hi] < target) {
					lo++;
				} else {
					ans = target;
					break;
				}
				
			}
		}
		return ans;
	}
}
