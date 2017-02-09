package Strings;
import java.util.*;
//https://leetcode.com/problems/letter-combinations-of-a-phone-number/
public class letterCombinations {
	public static void main(String args[])
	{
		new letterCombinations().letterCombinations(new String("23"));
	}
	List<String> ans;
	HashMap<Character,List<Character>> map;
	public List<String> letterCombinations(String digits) {
			map=new HashMap<Character,List<Character>>();
			HashMap<Character,String> tempMap=new HashMap<Character,String>();
			tempMap.put('2',new String("abc"));
			tempMap.put('3',new String("def"));
			tempMap.put('4',new String("ghi"));
			tempMap.put('5',new String("jkl"));
			tempMap.put('6',new String("mno"));
			tempMap.put('7',new String("pqrs"));
			tempMap.put('8',new String("tuv"));
			tempMap.put('9',new String("wxyz"));
			for(char c:tempMap.keySet())
			{
				List<Character> list=new LinkedList<Character>();
				for(char a:tempMap.get(c).toCharArray())
				{
					list.add(a);
				}
				map.put(c,list);
			}
			ans=new LinkedList<String>();
			if(digits==null||digits.length()==0){return ans;}
	        StringBuilder sb=new StringBuilder();
	        sub(sb,0,digits);
	        return ans;
    }
	
	public void sub(StringBuilder sb,int x,String str)
	{
		if(x==str.length())
		{
			ans.add(sb.toString());
		}
		else
		{
			for(char c:map.get(str.charAt(x)))
			{
				sb.append(c);
				sub(sb,x+1,str);
				sb.deleteCharAt(sb.length()-1);
			}
		}
	}
}
