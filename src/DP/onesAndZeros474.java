package DP;

//https://leetcode.com/problems/ones-and-zeroes/
public class onesAndZeros474 {
	public static void main(String args[]) {
		String strs[]={"10","1","0"};
		int m=1,n=1;
		System.out.println(new onesAndZeros474().findMaxForm(strs, m, n));
	}

	public int findMaxForm(String[] strs, int m, int n) {
		int dp[][]=new int[m+1][n+1];
		for(String str:strs)
		{
			int count[]=getCount(str);
			for(int i=m;i>=count[0];i--)
			{
				for(int j=n;j>=count[1];j--)
				{
					dp[i][j]=Math.max(1+dp[i-count[0]][j-count[1]], dp[i][j]);
				}
			}
		}
		return dp[m][n];
	}
	
	public int[] getCount(String str)
	{
		int ans[]=new int[2];
		for(int i=0;i<str.length();i++)
		{
			ans[str.charAt(i)-'0']++;
		}
		return ans;
	}
}
