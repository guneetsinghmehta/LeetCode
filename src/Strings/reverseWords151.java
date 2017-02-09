package Strings;

//https://leetcode.com/problems/reverse-words-in-a-string/
public class reverseWords151 {
	public static void main(String args[])
	{
		String str=new String("    a    b");
		System.out.println(new reverseWords151().reverseWords(str));
	}
	
	public String reverseWords(String s) {
		s=s.trim();
		String strs[]=s.split(new String("\\s+"));
		StringBuilder sb=new StringBuilder();
		for(int i=strs.length-1;i>=0;i--)
		{
			sb.append(strs[i]);
			if(i!=0){sb.append(new String(" "));}
		}
		return sb.toString();
	}
}
