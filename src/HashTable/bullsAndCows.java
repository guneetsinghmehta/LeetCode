package HashTable;

import java.util.HashMap;

//https://leetcode.com/problems/bulls-and-cows
public class bullsAndCows {
	public static void main(String args[]) {
		System.out.println(new bullsAndCows().getHint(new String("1807"),
				new String("7810")));
	}

	public String getHint(String secret, String guess) {
		int bulls = 0;
		HashMap<Character, Integer> sH = new HashMap<Character, Integer>();
		HashMap<Character, Integer> gH = new HashMap<Character, Integer>();
		char a, b;
		for (int i = 0; i < secret.length(); i++) {
			if (secret.charAt(i) == guess.charAt(i)) {
				bulls++;
			}
			a = secret.charAt(i);
			if (sH.containsKey(a)) {
				sH.put(a, sH.get(a) + 1);
			} else {
				sH.put(a, 1);
			}

			b = guess.charAt(i);
			if (gH.containsKey(b)) {
				gH.put(b, gH.get(b) + 1);
			} else {
				gH.put(b, 1);
			}
		}
		int cows = 0;
		for (char c : gH.keySet()) {
			int x = sH.containsKey(c) ? sH.get(c) : 0;
			cows += Math.min(gH.get(c), x);
		}
		cows = cows - bulls;
		String ans = new String();
		ans = ans.concat(Integer.toString(bulls));
		ans = ans.concat(new String("A"));
		ans = ans.concat(Integer.toString(cows));
		ans = ans.concat(new String("B"));
		return ans;
	}
}
