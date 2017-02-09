package BackTracking;

//https://leetcode.com/problems/combination-sum/
import java.util.*;

public class combinationSumOne39 {
	public static void main(String args[]) {
		int nums[] = { 2, 3, 6, 7 }, x = 7;
		new combinationSumOne39().combinationSum(nums, x);
	}

	List<List<Integer>> ans;
	List<Integer> list;

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
			sub(nums, x - nums[i], startIndex);
			list.remove(list.size() - 1);
		}
	}
}
