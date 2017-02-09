package Strings;

//https://leetcode.com/problems/word-break/
import java.util.*;

public class wordBreak139 {
	public static void main(String args[]) {
		List<String> list = new ArrayList<String>();
		list.add(new String("leet"));
		list.add(new String("code"));
		list.add(new String("1"));
		System.out.println(new wordBreak139().wordBreak(new String("leetleetcode1code"),
				list));
	}

	public boolean wordBreak(String str, List<String> wordDict) {
		HashSet<String> set = new HashSet<String>();
		for (String word : wordDict) {
			set.add(word);
		}
		boolean sol[] = new boolean[str.length()];
		for (int i = str.length() - 1; i >= 0; i--) {
			boolean ans=false;
			String temp=str.substring(i,str.length());
			if(set.contains(temp)){ans=true;}
			for(int j=1;j<temp.length();j++)
			{
				String str1=temp.substring(0, j);
				if(set.contains(str1)&&sol[i+j]){ans=true;break;}
			}
			sol[i]=ans;
		}
		return sol[0];
	}
	/*
	 * //Method 1 - Naive - time limit exceeds HashSet<String> set; public
	 * boolean wordBreak(String s, List<String> wordDict) { set = new
	 * HashSet<String>(); for (String word : wordDict) { set.add(word); } return
	 * sub(s, 0,s.length()); } public boolean sub(String str, int startIndex,int
	 * endIndex) { if (startIndex >= str.length()) { return true; } for(int
	 * i=startIndex;i<endIndex;i++) { String
	 * first=str.substring(startIndex,i+1); if(set.contains(first)) {
	 * if(sub(str,i+1,str.length())) { return true; } } } return false; }
	 */
}
