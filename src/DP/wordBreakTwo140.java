package DP;
//https://leetcode.com/problems/word-break-ii/
import java.util.*;
public class wordBreakTwo140 {
	public static void main(String args[]) {
		String str=new String("catsanddog");
		String words[]=new String("cat cats and sand dog").split(new String(" "));
		List<String> wordDict=new ArrayList<String>();
		for(String x:words)
		{
			wordDict.add(x);
		}
		List<String> list=new wordBreakTwo140().wordBreak(str, wordDict);
		System.out.println(1);
	}
	HashMap<String,List<String>> map=new HashMap<String,List<String>>();
	public List<String> wordBreak(String str, List<String> wordDict) 
	{
		if(map.containsKey(str)){return map.get(str);}
		List<String> list=new ArrayList<String>();
		if(str.length()==0)
		{
			list.add(new String(""));
			return list;
		}
		for(String word:wordDict)
		{
			if(str.startsWith(word))
			{
				List<String> subList=wordBreak(str.substring(word.length()),wordDict);
				for(String subWord:subList)
				{
					String newWord;
					if(subWord.length()!=0)
					{
						newWord=word+" "+subWord;
					}
					else
					{
						newWord=word;
					}
					list.add(newWord);
				}
			}
		}
		map.put(str, list);
		return list;
	}
	/*
	 *Memory exceeds for this
	public List<String> wordBreak(String str, List<String> wordDict) {
		ArrayList<List<String>> x=new ArrayList<List<String>>();
		HashSet<String> set=new HashSet<String>();
		for(String temp:wordDict){set.add(temp);}
		
		for(int i=0;i<str.length();i++){x.add(new ArrayList<String>());}
		String temp;
		for(int i=str.length()-1;i>=0;i--)
		{
			temp=str.substring(i,str.length());
			if(set.contains(temp))
			{
				x.get(i).add(temp);
			}
			for(int j=i+1;j<str.length();j++)
			{
				String strBegin=str.substring(i,j);
				if(set.contains(strBegin))
				{
					for(String kip:x.get(j))
					{
						String addition=strBegin+" "+kip;
						x.get(i).add(addition);
					}
				}
			}
		}
		return x.get(0);
    }
    */
}
