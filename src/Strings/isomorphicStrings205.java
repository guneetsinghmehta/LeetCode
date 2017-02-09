package Strings;

import java.util.*;

public class isomorphicStrings205 {
	public static void main(String args[])
	{
		System.out.println(new isomorphicStrings205().isIsomorphic(new String("ab"), new String("aa")));
	}
	
	public boolean isIsomorphic(String s, String t) {
		if(s==null&&t==null){return true;}
		if(s.length()==t.length())
		{
			HashMap<Character,Character> map=new HashMap<Character,Character>();
			HashSet<Character> set=new HashSet<Character>();
			for(int i=0;i<s.length();i++)
			{
				char c1=s.charAt(i);
				char c2=t.charAt(i);
				if(!map.containsKey(c1)&&!set.contains(c2))
				{
					map.put(c1, c2);
					set.add(c2);
				}
				else if(map.containsKey(c1)&&map.get(c1)!=c2){return false;}
				else if(!map.containsKey(c1)&&set.contains(c2)){return false;}
			}
			return true;
		}
		else
		{
			return false;
		}
	}
}
