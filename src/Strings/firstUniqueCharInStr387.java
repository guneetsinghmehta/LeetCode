package Strings;

import java.util.HashMap;

//https://leetcode.com/problems/first-unique-character-in-a-string/
public class firstUniqueCharInStr387 {
	public static void main(String args[]) {

	}

	public int firstUniqChar(String s) {
		HashMap<Character,Integer> map=new HashMap<Character,Integer>();
		for(int i=0;i<s.length();i++)
		{
			char c=s.charAt(i);
			map.put(c, map.getOrDefault(c, 0)+1);
		}
		int ans=-1;
		for(int  i=0;i<s.length();i++)
		{
			char c=s.charAt(i);
			if(map.get(c)==1){ans=i;break;}
		}
		for(char c:s.toCharArray())
		return ans;
	}
}
