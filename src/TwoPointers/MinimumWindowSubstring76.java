package TwoPointers;
//https://leetcode.com/problems/minimum-window-substring/
import java.util.*;
public class MinimumWindowSubstring76 {
	public static void main(String args[]) {
		System.out.println(new MinimumWindowSubstring76().minWindow(new String("adobecodebanc"),new String("abc")));
	}
	int a;
	int b;
	String s;
	String t;
	HashMap<Character,Integer> mapT,mapS;
	public String minWindow(String str, String target) {
		s=str;
		t=target;
        //make a hashtable for t mapT
		mapT=new HashMap<Character,Integer>();
		for(int i=0;i<t.length();i++)
		{
			char c=t.charAt(i);
			if(mapT.containsKey(c)){mapT.put(c, mapT.get(c)+1);}
			else{mapT.put(c, 1);}
		}
		//make a hashtable for s mapS
		mapS=new HashMap<Character,Integer>();
		//initialize a and b;
		a=0;
		b=0;
		//call sub fn to move b to accommodate all chars in T - if it returns false return an empty string
		if(!sub()){return new String("");}
		else
		{
			String ans=null;
			//loop of while(a<b and b<s.length)
			while(a<b&&b<=s.length())
			{
				if(ans==null)
				{
					ans=s.substring(a,b);
				}
				else
				{
					//update the ans string if it is smaller than the current length
					ans=ans.length()>b-a?s.substring(a,b):ans;
				}
				char c=s.charAt(a);
				if(mapS.get(c)==1){mapS.remove(c);}
				else{mapS.put(c, mapS.get(c)-1);}
				if(!sub())
				{
					break;
				}
				a++;
			}
			return ans;
		}
    }
	
	public boolean sub()
	{
		while(b<s.length()&&!allContained())
		{
			char c=s.charAt(b);
			if(mapS.containsKey(c)){mapS.put(c, mapS.get(c)+1);}
			else{mapS.put(c, 1);}
			b++;
		}
		if(b<=s.length()&&allContained()){return true;}
		else{return false;}
	}
	
	public boolean allContained()
	{
		boolean ans=true;
		for(char c:mapT.keySet())
		{
			if(mapS.containsKey(c)&&mapS.get(c)>=mapT.get(c)){continue;}
			else{ans=false;break;}
		}
		return ans;
	}
}
