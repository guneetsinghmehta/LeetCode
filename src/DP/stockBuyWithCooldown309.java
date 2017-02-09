package DP;

import java.util.Arrays;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
public class stockBuyWithCooldown309 {
	public static void main(String args[]) {
		int x[]={1,2,3,0,2};
		System.out.println(new stockBuyWithCooldown309().maxProfit(x));
	}
	
	public int maxProfit(int[] prices) {
		int b0,b1,s1,s2,s0=0;
		s1=0;s2=0;b1=-prices[0];
		for(int i=0;i<prices.length;i++)
		{
			b0=Math.max(b1,s2-prices[i]);
			s0=Math.max(s1, b1+prices[i]);
			b1=b0;
			s2=s1;
			s1=s0;
		}
		return s0;
	}
	
	/*
	 //Fails last test case 
	int ansArray[];
	int n;
	int nums[];
	public int maxProfit(int[] prices) {
		if(prices==null||prices.length<=1){return 0;}
		n=prices.length;
		ansArray=new int[n];
		nums=prices;
		Arrays.fill(ansArray, Integer.MIN_VALUE);
		return sub(0);
    }
	
	public int sub(int start)
	{
		if(start>=n){return 0;}
		if(ansArray[start]!=Integer.MIN_VALUE){return ansArray[start];}
		else
		{
			int x=0;
			for(int i=start;i<n;i++)
			{
				for(int j=i+1;j<n;j++)
				{
					if(nums[i]<nums[j])
					{
						int temp=nums[j]-nums[i]+sub(j+2);
						if(x<temp){x=temp;}
					}
				}
			}
			ansArray[start]=x;
			return x;
		}
	}
	*/
}
