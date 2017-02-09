package BitManipulation;
//https://leetcode.com/problems/total-hamming-distance/
import java.util.*;
public class totalHammingDistance477 {
	public static void main(String args[]) {
		int x[]={4,14,2};
		System.out.println(new totalHammingDistance477().totalHammingDistance(x));
	}
	
	public int totalHammingDistance(int[] nums) {
		if(nums==null||nums.length<=1){return 0;}
		int ans=0;
		int temp[]=getBits(nums[0]);
		int oneArray[]=new int[32];
		int zeroArray[]=new int[32];
		for(int i=0;i<32;i++)
		{
			if(temp[i]==1){oneArray[i]=1;}
			else{zeroArray[i]=1;}
		}
		for(int i=1;i<nums.length;i++)
		{
			temp=getBits(nums[i]);
			for(int j=0;j<32;j++)
			{
				if(temp[j]==0)
				{
					ans+=oneArray[j];
				}
				else
				{
					ans+=zeroArray[j];
				}
			}
			//updating counts;
			for(int j=0;j<32;j++)
			{
				if(temp[j]==1){oneArray[j]++;}
				else{zeroArray[j]++;}
			}
		}
		return ans;
    }
	
	public int[] getBits(int n)
	{
		int ans[]=new int[32];
		int i=0;
		while(n>0)
		{
			ans[i++]=n&1;
			n=n>>1;
		}
		return ans;
	}
}
