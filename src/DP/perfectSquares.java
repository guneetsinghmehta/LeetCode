package DP;

import java.util.Arrays;

//https://leetcode.com/problems/perfect-squares/
public class perfectSquares {
	
	public static void main(String args[])
	{
		System.out.println(new perfectSquares().numSquares(13));
	}
	public int numSquares(int n) {
		int x[]=new int[n+1];
		Arrays.fill(x, Integer.MAX_VALUE);
		x[0]=0;
		for(int i=0;i<=n;i++)
		{
			for(int j=1;i+j*j<=n;j++)
			{
				x[i+j*j]=(int)Math.min(x[i+j*j], x[i]+1);
			}
		}
		return x[n];
    }
}
