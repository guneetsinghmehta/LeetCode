package HashTable;

//https://leetcode.com/problems/longest-consecutive-sequence/
import java.util.HashSet;

public class longestConsecutiveSequence128 {
	public static void main(String args[]) {
		int x[] = { 100, 1, 200, 4, 2, 3 };
		System.out.println(new longestConsecutiveSequence128()
				.longestConsecutive(x));
	}

	public int longestConsecutive(int[] nums) {
		if(nums==null||nums.length==0){return 0;}
		HashSet<Integer> set = new HashSet<Integer>();
		for (int x : nums) {
			set.add(x);
		}
		int ans = 1;
		for (int x : nums) {
			if (set.contains(x) && !set.contains(x - 1)) {
				int temp = 0;
				while (set.contains(x)) {
					set.remove(x);
					temp++;
					x++;
				}
				ans = Math.max(ans, temp);
			}
		}
		return ans;
	}
}
