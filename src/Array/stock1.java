//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
package Arrays;
import java.util.*;
class maxStack
{
	Stack<Integer> main,max;
	public maxStack()
	{
		main=new Stack<Integer>();
		max=new Stack<Integer>();
	}
	public void push(int x)
	{
		if(main.isEmpty())
		{
			main.push(x);
			max.push(x);
		}
		else
		{
			if(max.peek()<=x){max.push(x);}
			main.push(x);
		}
	}
	
	public int pop()
	{
		int x=main.pop();
		if(x==max.peek())
		{
			max.pop();
		}
		return x;
	}
	
	public int getMax()
	{
		return max.peek();
	}
}

public class stock1 {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int x[]={7,1,5,6,3,4};
		System.out.println(new stock1().maxProfit(x));
	}
	
	public int maxProfit(int[] prices) 
	{
		maxStack stack=new maxStack();
		for(int i=prices.length-1;i>=0;i--)
		{
			stack.push(prices[i]);
		}
		int ans=0;
		stack.pop();
		for(int i=0;i<prices.length-1;i++)
		{
			if (stack.getMax()-prices[i]>ans){ans=stack.getMax()-prices[i];}
			stack.pop();
		}
		return ans;
    }
}
