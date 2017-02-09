package Strings;

import java.util.ArrayList;
import java.util.Stack;

//https://leetcode.com/problems/basic-calculator-ii/
public class basicCalculatorTwo227 {
	public static void main(String args[]) {
		String str=new String("42");
		System.out.println(new basicCalculatorTwo227().calculate(str));
	}
	public int calculate (String str)
	{
		if(str==null||str.length()==0){return 0;}
        str=str.trim();
        Stack<Integer> stack=new Stack<Integer>();
		int num=0;
		char sign='+';
		for(int i=0;i<str.length();i++)
		{
			char c=str.charAt(i);
			if(Character.isDigit(c))
			{
				num=num*10+c-'0';
			}
			if((!Character.isDigit(c)&&c!=' ')||i==str.length()-1)
			{
				if(sign=='+')
				{
					stack.push(num);
				}
				else if(sign=='-')
				{
					stack.push(-num);
				}
				else if(sign=='*')
				{
					stack.push(stack.pop()*num);
				}
				else if(sign=='/')
				{
					stack.push(stack.pop()/num);
				}
				sign=c;
				num=0;
			}
		}
		int result=0;
		while(!stack.isEmpty())
		{
			result+=stack.pop();
		}
		return result;
	}
	
	//O(n2) time
	public int calculate2(String string) {
        string=string.replace(" ","");
        String strs[]=string.split(new String("[/*\\-+]"));
        if(strs==null){return 0;}
        if(strs.length==1){return Integer.parseInt(strs[0]);}
        ArrayList<Integer> operands=new ArrayList<Integer>();
        for(String str:strs)
        {
        	operands.add(Integer.parseInt(str));
        }
        ArrayList<Character> operators=new ArrayList<Character>();
        for(int i=0;i<string.length();i++)
        {
        	char c=string.charAt(i);
        	if(c=='+'||c=='-'||c=='/'||c=='*')
        	{
        		operators.add(c);
        	}
        }
        int x,y,ans;
        for(int i=0;i<operators.size();i++)
        {
        	if(operators.get(i)=='*')
        	{
        		x=operands.remove(i);
        		y=operands.remove(i);
        		ans=x*y;
        		operands.add(i, ans);
        		operators.remove(i);
        		i=i-1;
        	}
        	else if(operators.get(i)=='/')
        	{
        		x=operands.remove(i);
        		y=operands.remove(i);
        		ans=x/y;
        		operands.add(i, ans);
        		operators.remove(i);
        		i=i-1;
        	}
        }
        for(int i=0;i<operators.size();i++)
        {
        	if(operators.get(i)=='+')
        	{
        		x=operands.remove(i);
        		y=operands.remove(i);
        		ans=x+y;
        		operands.add(i, ans);
        		operators.remove(i);
        		i=i-1;
        	}
        	else if(operators.get(i)=='-')
        	{
        		x=operands.remove(i);
        		y=operands.remove(i);
        		ans=x-y;
        		operands.add(i, ans);
        		operators.remove(i);
        		i=i-1;
        	}
        }
        return operands.get(0);
    }
}
