package Strings;
//https://leetcode.com/problems/repeated-substring-pattern/
import java.util.*;
public class repeatedSubstring459 {
	public static void main(String args[]) {
		System.out.println(new repeatedSubstring459().repeatedSubstringPattern("abac"));
	}
	
	public boolean repeatedSubstringPattern(String str) {
		boolean ans=false;
		List<Integer> list=new ArrayList<Integer>();
		for(int i=1;i<str.length();i++)
		{	
			if(str.length()%i==0){list.add(i);}
		}
		for(int x:list)
		{
			String substr=str.substring(0,x);
			boolean subAns=true;
			for(int i=0;i+x<=str.length();i=i+x)
			{
				if(!str.substring(i,i+x).equals(substr)){subAns=false;break;}
			}
			if(subAns==true){ans=true;break;}
		}
		return ans;
    }
}
