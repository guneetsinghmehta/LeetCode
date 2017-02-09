package Array;

import java.util.Stack;

//https://leetcode.com/problems/zigzag-conversion/
public class zigzag {
	public static void main(String args[])
	{
		System.out.println(new zigzag().convert(new String("PAYPALISHIRING"), 3));
		System.out.println(new zigzag().reverse(-123));
	}
	
	public String convert(String s, int numRows) 
	{
		if(numRows==1){return s;}
		StringBuilder sb[]=new StringBuilder[numRows];
		for(int i=0;i<numRows;i++){sb[i]=new StringBuilder();}
		int row=0;
		boolean downDir=true;
		for(int i=0;i<s.length();i++)
		{
			sb[row].append(s.charAt(i));
			if(row==numRows-1){downDir=false;}
			if(row==0){downDir=true;}
			if(downDir){row++;}
			else{row--;}
		}
		StringBuilder ans=new StringBuilder();
		for(int i=0;i<numRows;i++)
		{
			ans.append(sb[i]);
		}
		return ans.toString();
    }
	
	public int reverse(int x) {
		if(x==0){return 0;}
		Stack<Integer> stack =new Stack<Integer>();
		boolean neg=false;
		if(x<0){neg=true;x=x*-1;}
		while(x>0)
		{
			stack.push(x%10);
			x=x/10;
		}
		long y=0;
		Stack<Integer> aux=new Stack<Integer>();
		while(!stack.isEmpty())
		{
			aux.push(stack.pop());
		}
		stack=aux;
		while(!stack.isEmpty())
		{
			y=y*10+stack.pop();
		}
		if(neg){y=y*-1;}
		if(y>Integer.MAX_VALUE||y<Integer.MIN_VALUE)
		{
			y=0;
		}
		return (int)y;
    }
}
