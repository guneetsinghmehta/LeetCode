package Misc;

import java.util.HashMap;

//https://leetcode.com/problems/elimination-game/
public class EliminationGame390 {
	public static void main(String args[]) {
		System.out.println(new EliminationGame390().longestPalindrome("abccccdd"));
	}

	public int lastRemaining(int n) {
		boolean left = true;
		int head = 1;
		int step = 1;
		int remaining = n;
		while (remaining > 1) {
			if (left || remaining % 2 == 1) {
				head += step;
			}
			step *= 2;
			left = !left;
			remaining = remaining / 2;
		}
		return head;
	}

	public int longestPalindrome(String s) {
		HashMap<Character,Integer> map=new HashMap();
		for(char c:s.toCharArray())
		{
			map.put(c, map.getOrDefault(c,0)+1);
		}
		boolean odd=false;
		int ans=0;
		for(int x:map.values())
		{
			ans+=x/2;
			if(x%2==1){odd=true;}
		}
		ans=ans*2;
		if(odd){ans=ans+1;}
		return ans;
	}
}
