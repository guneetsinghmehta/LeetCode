package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSumTwo40 {
	public static void main(String args[]) {
		int nums[] = { 10, 1, 2, 7, 6, 1, 5 }, x = 8;
		new combinationSumTwo40().combinationSum2(nums, x);
	}

	List<List<Integer>> ans;
	List<Integer> list;

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		ans = new ArrayList<List<Integer>>();
		list = new ArrayList<Integer>();
		Arrays.sort(candidates);
		sub(candidates, target, 0);
		return ans;
	}

	public void sub(int nums[], int x, int startIndex) {
		if (x == 0) {
			List<Integer> newList = new ArrayList<Integer>();
			newList.addAll(list);
			ans.add(newList);
		}
		if (nums == null || x < nums[0]) {
			return;
		}
		for (int i = startIndex; i < nums.length; i++) {
			if (list.size() > 0 && nums[i] < list.get(list.size() - 1)) {
				continue;
			}
			list.add(nums[i]);
			sub(nums, x - nums[i], i + 1);
			list.remove(list.size() - 1);
			while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
				i++;
			}
		}
	}
}
