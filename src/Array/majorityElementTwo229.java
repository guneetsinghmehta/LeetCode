package Array;

//https://leetcode.com/problems/majority-element-ii/
import java.util.*;

public class majorityElementTwo229 {
	public static void main(String args[]) {
		int x[]={2,2,9,3,9,3,9,3,9,3,9,3,9,3,9,3,9};
		//Arrays.sort(x);
		System.out.println(new majorityElementTwo229().majorityElement(x));
	}

	public List<Integer> majorityElement(int[] nums) {
		List<Integer> ans = new ArrayList<Integer>();
		if (nums == null || nums.length == 0) {
		} else {
			int num1 = nums[0], num2 = nums[0], count1 = 0, count2 = 0;
			for (int i = 0; i < nums.length; i++) {
				int x = nums[i];
				if (x == num1) {
					count1++;
				} else if (x == num2) {
					count2++;
				} else if (count1 <= 0) {
					num1 = x;
					count1++;
				} else if (count2 <= 0) {
					num2 = x;
					count2++;
				} else {
					count1--;
					count2--;
				}
			}
			count1=0;
			count2=0;
			for(int i=0;i<nums.length;i++)
			{
				if(nums[i]==num1){count1++;}
				else if(nums[i]==num2){count2++;}
			}
			if(count1>nums.length/3){ans.add(num1);}
			if(count2>nums.length/3){ans.add(num2);}
		}
		return ans;
	}
}
