package DP;

import java.util.Arrays;

public class predictTheWinner486 {
	public static void main(String args[]) {
		int a[]={0};
		System.out.println(new predictTheWinner486().PredictTheWinner(a));
	}
	
	public boolean PredictTheWinner(int[] nums) {
		int n=nums.length;
		int value[][]=new int[n][n];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				value[i][j]=Integer.MIN_VALUE;
			}
		}
		for(int i=0;i<n;i++)
		{
			for(int j=i;j<n;j++)
			{
				sub(nums,value,i,j);
			}
		}
		int s=0,e=n-1;
		if(s+1<n&&e-1>0&&value[s][e]<value[s+1][e]&&value[s][e]<value[s][e-1])
		{
			return false;
		}
		return true;
    }
	
	public int sub(int nums[],int value[][],int s,int e)
	{
		if(s>e){return 0;}
		if(value[s][e]!=Integer.MIN_VALUE)
		{
			return value[s][e];
		}
		else
		{
			int a=nums[s]+Math.min(sub(nums,value,s+1,e-1), sub(nums,value,s+2,e));
			int b=nums[e]+Math.min(sub(nums,value,s,e-2), sub(nums,value,s+1,e-1));
			value[s][e]=Math.max(a,b);
			return value[s][e];
		}
	}
	
}
