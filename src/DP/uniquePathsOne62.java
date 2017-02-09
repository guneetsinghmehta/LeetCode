package DP;

//https://leetcode.com/problems/unique-paths/
public class uniquePathsOne62 {
	public static void main(String args[])
	{
		System.out.println(new uniquePathsOne62().uniquePaths(3,4));
	}
	
	public int uniquePaths(int m, int n) {
		int x[][]=new int[m][n];
		x[m-1][n-1]=1;
		for(int i=m-1;i>=0;i--)
		{
			for(int j=n-1;j>=0;j--)
			{
				if(i==m-1&&j==n-1){continue;}
				int ans=0;
				if(i<m-1){ans=ans+x[i+1][j];}
				if(j<n-1){ans=ans+x[i][j+1];}
				x[i][j]=ans;
			}
		}
		return x[0][0];
	}
}
