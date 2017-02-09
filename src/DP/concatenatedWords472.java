package DP;
import java.util.*;
//https://leetcode.com/problems/concatenated-words/
public class concatenatedWords472 {
	public static void main(String args[]) {
		//String strs[]={"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
		String strs[]={"a","aa","aaa"};
		List<String> ans=new concatenatedWords472().findAllConcatenatedWordsInADict(strs);
		System.out.println(1);
	}

	 public List<String> findAllConcatenatedWordsInADict(String[] words) {
			HashSet<String> set=new HashSet<String>();
			for(String word:words)
			{
				set.add(word);
			}
			List<String> ansList=new ArrayList<String>();
			for(String word:words)
			{
				if(word.length()==0){continue;}
				boolean x[]=new boolean[word.length()];
				for(int i=word.length()-1;i>=0;i--)
				{
					boolean ans=false;
					for(int j=i+1;j<=word.length();j++)
					{
						String str1=word.substring(i, j);
						String str2=word.substring(j,word.length());
						if(str2==null||str2.length()==0)
						{
							if(set.contains(str1)&&i!=0)
							{
								ans=true;break;
							}
						}
						else
						{
							if(set.contains(str1)&&x[j])
							{
								set.add(str1);
								set.add(str2);
								ans=true;break;
							}
						}
					}
					x[i]=ans;
				}
				if(x[0])
				{
					ansList.add(word);
					set.add(word);
				}
			}
			return ansList;
		}
}
