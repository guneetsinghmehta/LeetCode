package DivideAndConquer;
//https://leetcode.com/problems/different-ways-to-add-parentheses/
import java.util.*;
public class differentWaysToAdd241 {
	public static void main(String args[]) {
		List<Integer> ans=new differentWaysToAdd241().diffWaysToCompute(new String("2*3-4*5"));
		for(int x:ans)
		{
			System.out.println(x);
		}
	}
	
	public List<Integer> diffWaysToCompute(String str) {
		int numChars=0;
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)=='+'||str.charAt(i)=='-'||str.charAt(i)=='*')
			{
				numChars++;
			}
		}
		List<Integer> ans=new ArrayList<Integer>();
		if(numChars==0)
		{
			ans.add(Integer.parseInt(str));
		}
		else
		{
			for(int i=0;i<str.length();i++)
			{
				if(str.charAt(i)=='+'||str.charAt(i)=='-'||str.charAt(i)=='*')
				{
					String str1=str.substring(0,i);
					String str2=str.substring(i+1);
					List<Integer> A=diffWaysToCompute(str1);
					List<Integer> B=diffWaysToCompute(str2);
					if(str.charAt(i)=='+')
					{
						for(int x:A)
						{
							for(int y:B)
							{
								ans.add(x+y);
							}
						}
					}
					if(str.charAt(i)=='-')
					{
						for(int x:A)
						{
							for(int y:B)
							{
								ans.add(x-y);
							}
						}
					}
					if(str.charAt(i)=='*')
					{
						for(int x:A)
						{
							for(int y:B)
							{
								ans.add(x*y);
							}
						}
					}
				}
			}
		}
		return ans;
    }
}
