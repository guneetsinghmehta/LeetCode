package Strings;

import java.util.*;
//https://leetcode.com/problems/sort-characters-by-frequency/
public class sortCharByFreq451 {
	public static void main(String args[]) {
		System.out.println(new sortCharByFreq451().frequencySort("tree"));
	}
	
	class charPair
	{
		char c;int freq;
		charPair(char c,int freq)
		{
			this.c=c;
			this.freq=freq;
		}
	}
	
	public String frequencySort(String s) {
		HashMap<Character,Integer> map=new HashMap<Character,Integer>();
		for(char c:s.toCharArray())
		{
			if(map.containsKey(c))
			{
				map.put(c, map.get(c)+1);
			}
			else
			{
				map.put(c,1);
			}
		}
		Comparator<charPair> comp=new Comparator<charPair>()
		{
			public int compare(charPair a,charPair b)
			{
				if(a.freq>b.freq){return -1;}
				else if(a.freq<b.freq){return +1;}
				else{return 0;}
			}
		};
		PriorityQueue<charPair> q=new PriorityQueue<charPair>(comp);
		for(char c:map.keySet())
		{
			q.add(new charPair(c,map.get(c)));
		}
		StringBuilder sb=new StringBuilder();
		while(!q.isEmpty())
		{
			charPair temp=q.remove();
			for(int i=0;i<temp.freq;i++)
			{
				sb.append(temp.c);
			}
		}
		return sb.toString();
    }	
}
