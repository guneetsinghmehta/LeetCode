package Maths;
//https://leetcode.com/problems/sqrtx/
public class sqrt69 {
	public static void main(String args[])
	{
		System.out.println(new sqrt69().mySqrt(4));
	}
	
public int mySqrt(int x) {
		int a=0,b=Integer.MAX_VALUE;
		long mid;
		while(a!=b)
		{
			mid=(a+b)/2;
			if(mid>x/mid)
			{
				b=(int)mid;
			}
			else
			{
				if((mid+1)>x/(mid+1)){return (int) mid;}
				else
				{
					a=(int) mid;
				}
			}
		}
		return 0;
    }
}
