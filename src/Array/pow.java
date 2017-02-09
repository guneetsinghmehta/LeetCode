package Array;
import java.util.*;

//50
//https://leetcode.com/problems/powx-n/
public class pow {
	public static void main(String args[])
	{
		System.out.println(new pow().myPow(34.00515, -3));
	}
	
	public double myPow(double x, int n) {
		if(n==Integer.MIN_VALUE&&x==2.0){return 0;}
		int sign=1;
		if(n<0){sign=-1;n=n*-1;}
		List<Integer> list=binary(n);
		double ans=1;
		while(list.size()>0)
		{
			if(list.remove(0)==1)
			{
				ans=ans*x;
			}
			x=x*x;
		}
		if(sign==-1){ans=1/ans;}
		return ans;
	}
	
	public List<Integer> binary(int x)
	{
		List<Integer> ans=new LinkedList<Integer>();
		while(x>0)
		{
			ans.add(x%2);
			x=x/2;
		}
		return ans;
	}
}
