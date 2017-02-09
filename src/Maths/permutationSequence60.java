package Maths;

//https://leetcode.com/problems/permutation-sequence/
import java.util.*;

public class permutationSequence60 {
	// make a list of n numbers
	// make a map of 1 to 9 total permutation numbers
	// find the value in map just less than k - say x
	// index=k/x - remove indexth entry from the array and put it in the string
	// recursively call with k=k-k/index*index
	public static void main(String args[]) {
		for(int i=1;i<=6;i++)
		{System.out.println(new permutationSequence60().getPermutation(3, i));}
	}

	StringBuilder sb;
	List<Integer> list;
	HashMap<Integer, Integer> map;

	public String getPermutation(int n, int k) {
		sb = new StringBuilder();
		list = new ArrayList<Integer>();
		map=new HashMap<Integer,Integer>();
		for (int i = 1; i <= n; i++) {
			list.add(i);
		}
		int ans = 1;
		for (int i = 1; i < 10; i++) {
			ans = ans * i;
			map.put(i, ans);
		}
		map.put(0, 1);
		sub(n, k);
		return sb.toString();
	}

	public void sub(int n, int k) {
		if (n == 0) {
			return;
		}
		int fact = map.get(n - 1);
		int index = (k - 1) / fact;
		sb.append(list.remove(index));
		k = k - (index) * fact;
		sub(n - 1, k);
	}
}
