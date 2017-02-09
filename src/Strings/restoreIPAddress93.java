package Strings;
//https://leetcode.com/problems/restore-ip-addresses/
import java.util.*;
public class restoreIPAddress93 {
	public static void main(String args[])
	{
		String str=new String("010010");
		new restoreIPAddress93().restoreIpAddresses(str);
	}
	
	List<String> ans;
	Stack<String> stack;
	public List<String> restoreIpAddresses(String str) {
        ans=new ArrayList<String>();
        stack=new Stack<String>();
        sub(str,4);
        return ans;
    }	
	
	public void sub(String str,int n)
	{
		if(str.length()==0&&n==0&&stack.size()==4)
		{
			StringBuilder sb=new StringBuilder();
			Stack<String> temp=new Stack<String>();
			String x;
			while(!stack.isEmpty())
			{
				x=stack.pop();
				temp.push(x);
				sb.append(x);
				if(stack.size()!=0)
				{
					sb.append('.');
				}
			}
			boolean invalid=false;
			while(!temp.isEmpty())
			{
				x=temp.pop();
				if(Integer.parseInt(x)!=0&&x.charAt(0)=='0'){invalid=true;}
				if(Integer.parseInt(x)==0&&x.length()>1){invalid=true;}
				stack.push(x);
			}
			if(!invalid)
			{
				ans.add(sb.toString());
			}
		}
		else if(str.length()>3*n||str.length()<n)
		{
			return;
		}
		else
		{
			for(int i=1;i<=3&&i<=str.length();i++)
			{
				String num=str.substring(str.length()-i,str.length());
				if(Integer.parseInt(num)>255){continue;}
				stack.push(num);
				String strNew=str.substring(0,str.length()-i);
				sub(strNew,n-1);
				stack.pop();
			}
		}
		
	}
}
