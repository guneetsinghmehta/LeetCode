package Strings;

import java.util.Stack;

//https://leetcode.com/problems/longest-valid-parentheses/
//when ( - push on stack
//when ) and top is ( - pop
//when ) and top is empty or is ) - push
//return maximum distance between elements
public class longestValidParenthesis {
	
	public static void main(String args[])
	{
		System.out.println(new longestValidParenthesis().longestValidParentheses(new String("((()))())")));
	}
	
	public int longestValidParentheses(String str) {
		int max=0;
		Stack<Integer> stack=new Stack<Integer>();
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)=='('){stack.push(i);}
			else
			{
				//closing brace
				if(!stack.isEmpty()&&str.charAt(stack.peek())=='(')
				{
					int x=stack.pop();
					if(i-x+1>max)
					{
						max=i-x+1;
					}
				}
				else if(stack.isEmpty()||str.charAt(stack.peek())==')'){stack.push(i);}
			}
		}
		if(stack.isEmpty()){max=str.length();}
		int last=str.length();
		while(!stack.isEmpty())
		{
			int current=stack.pop();
			if(max<last-current-1){max=last-current-1;}
			last=current;
		}
		if(max<last){max=last;}
		return max;
    }
}
