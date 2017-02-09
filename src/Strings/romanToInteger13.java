package Strings;

import java.util.HashMap;

//https://leetcode.com/problems/roman-to-integer/
public class romanToInteger13 {
	public static void main(String args[]) {
		String str=new String("MMM");
		System.out.println(new romanToInteger13().romanToInt(str));
	}
	HashMap<Character,Integer> map;
	public int romanToInt(String s) {
        map=new HashMap<Character,Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        return sub(s,0);
    }
	
	public int sub(String str,int index)
	{
		if(str==null||str.length()==0){return 0;}
		if(index>=str.length()){return 0;}
		char c1=str.charAt(index);
		int v1=map.get(c1);
		char c2;
		int v2;
		int val=v1;
		int nextIndex=index+1;
		if(index+1<str.length())
		{
			c2=str.charAt(index+1);
			v2=map.get(c2);
			if(v2>v1)
			{
				val=v2-v1;
				nextIndex++;
			}
		}
		return val+sub(str,nextIndex);
	}
}
