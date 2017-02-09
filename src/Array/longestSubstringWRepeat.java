package Array;
import java.util.*;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class longestSubstringWRepeat {
	public static void main(String args[])
	{
		System.out.println(new longestSubstringWRepeat().lengthOfLongestSubstring(new String("abcabcbb")));
	}
	
	public int lengthOfLongestSubstring(String s) {
		int a,b,max=0;
		if(s==null||s.length()==0){return 0;}
		a=0;
		char c;
		HashSet<Character> set=new HashSet<Character>();
		for(b=0;b<s.length();b++)
		{
			c=s.charAt(b);
			if(set.isEmpty()){set.add(c);}
			else
			{
				while(set.contains(c))
				{
					set.remove(s.charAt(a));
					a++;
				}
				set.add(c);
			}
			max=max<set.size()?set.size():max;
		}
		return max;
    }
}
