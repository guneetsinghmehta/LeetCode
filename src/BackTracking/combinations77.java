package BackTracking;

//https://leetcode.com/problems/combinations/
import java.util.*;

public class combinations77 {

	public static void main(String args[]) {
		List<List<Integer>> kip = new combinations77().combine(4, 2);
		System.out.println(1);
	}

	List<List<Integer>> ans;
	List<Integer> list;

	public List<List<Integer>> combine(int n, int k) {
		ans = new ArrayList<List<Integer>>();
		list = new ArrayList<Integer>();
		sub(n, k, 1);
		return ans;
	}

	public void sub(int n, int k, int index) {
		if (k == 0) {
			List<Integer> newList = new ArrayList<Integer>();
			newList.addAll(list);
			ans.add(newList);
		} else if (k <= n - index + 1) {
			for (int i = index; i <= n; i++) {
				list.add(i);
				sub(n, k - 1, i + 1);
				list.remove(list.size() - 1);
			}
		}
	}
}
