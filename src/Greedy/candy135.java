package Greedy;

import java.util.Arrays;

//https://leetcode.com/problems/candy/
public class candy135 {
	public static void main(String args[])
	{
		int x[]={4,2,3,4,1};
		System.out.println(new candy135().candy(x));
	}
	
	public int candy(int[] ratings) {
		int x[]=new int[ratings.length];
		Arrays.fill(x, 1);
		for(int i=1;i<x.length;i++)
		{
			if(ratings[i]>ratings[i-1]&&x[i]<=x[i-1])
			{
				x[i]=x[i-1]+1;
			}
		}
		for(int i=x.length-2;i>=0;i--)
		{
			if(ratings[i]>ratings[i+1]&&x[i]<=x[i+1])
			{
				x[i]=x[i+1]+1;
			}
		}
		int sum=0;
		for(int a:x)
		{
			sum+=a;
		}
		return sum;
	}
}
