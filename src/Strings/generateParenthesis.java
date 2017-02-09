package Strings;
import java.util.*;
//https://leetcode.com/problems/generate-parentheses/
//Wrong*******************************
public class generateParenthesis {
	public static void main(String args[])
	{
		List<String> x=new generateParenthesis().generateParenthesis(4);
		System.out.println();
	}
	
	HashSet<String> set;
	public List<String> generateParenthesis(int n) {

        List<String> ans=new LinkedList<String>();
        if(n==0){return ans;}
		HashSet<String> finalSet=new HashSet<String>();
        for(int m=n;m>0;m--)
        {
        	set=new HashSet<String>();
            int x[]=new int[m];
            Arrays.fill(x, 1);
            sub(x);
            Iterator it=set.iterator();
            while(it.hasNext())
            {
            	String str=(String) it.next();
            	StringBuilder sb=new StringBuilder();
            	for(int i=0;i<n-m;i++)
            	{
            		sb.append(new String("("));
            	}
            	sb.append(str);
            	for(int i=0;i<n-m;i++)
            	{
            		sb.append(new String(")"));
            	}
            	finalSet.add(sb.toString());
            }
        }
        Iterator tempIt=finalSet.iterator();
        while(tempIt.hasNext())
        {
        	String temp=(String)tempIt.next();
        	ans.add(temp);
        }
        return ans;
    }
	
	public void sub(int x[])
	{
		set.add(getString(x));
		for(int i=0;i<x.length-1;i++)
		{
			int y[]=new int[x.length-1];
			for(int j=0;j<y.length;j++)
			{
				if(j<i){y[j]=x[j];}
				else if(j==i){y[j]=x[j]+x[j+1];}
				else
				{
					y[j]=x[j+1];
				}
			}
			sub(y);
		}
	}
	
	public String getString(int x[])
	{
		StringBuilder sb=new StringBuilder();
		for(int a:x)
		{
			for(int i=0;i<a;i++)
			{
				sb.append('(');
			}
			for(int i=0;i<a;i++)
			{
				sb.append(')');
			}
		}
		return sb.toString();
	}
}
