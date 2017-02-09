package Strings;

import java.util.*;
//49
//https://leetcode.com/problems/anagrams/

public class GroupAnagrams49 {
	public static void main(String args[]) {
		String strs[] = { "eat", "tea", "tan", "ate", "nat", "bat" };
		List<List<String>> list = new GroupAnagrams49().groupAnagrams(strs);
		System.out.println(list);
	}

	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> ans = new ArrayList<List<String>>();
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		Arrays.sort(strs);
		for (String str : strs) {
			char ca[] = str.toCharArray();
			Arrays.sort(ca);
			String key = String.valueOf(ca);
			if (!map.containsKey(key)) {
				map.put(key, new ArrayList<String>());
			}
			map.get(key).add(str);
		}
		for (String str : map.keySet()) {
			ans.add(map.get(str));
		}
		return ans;
	}
}
m