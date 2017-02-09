package DP;
///https://leetcode.com/problems/minimum-path-sum/
public class minimumPathSum64 {
	public static void main(String args[])
	{
		int x[][]={{1,2,3},{4,5,6},{7,8,9}};
		System.out.println(new minimumPathSum64().minPathSum(x));
	}
	
	 public int minPathSum(int[][] grid) {
		 if(grid==null||grid.length==0){return 0;}
		 int m=grid.length;
		 int n=grid[0].length;
		 int x[][]=new int[m][n];
		 x[m-1][n-1]=grid[m-1][n-1];
		 for(int i=m-1;i>=0;i--)
		 {
			 for(int j=n-1;j>=0;j--)
			 {
				 if(i==m-1&&j==n-1){continue;}
				 int ans=Integer.MAX_VALUE;
				 if(i<m-1)
				 {
					 ans=ans>grid[i][j]+x[i+1][j]?grid[i][j]+x[i+1][j]:ans;
				 }
				 if(j<n-1)
				 {
					 ans=ans>grid[i][j]+x[i][j+1]?grid[i][j]+x[i][j+1]:ans;
				 }
				 x[i][j]=ans;
			 }
		 }
		 return x[0][0];
    }
}
