package DP;
//https://leetcode.com/problems/maximal-square/
public class maximalSquare221 {
	public static void main(String args[]) {
		String str=new String("10100101111111110010");
		char x[][]=new char[4][5];
		int count=0;
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<5;j++)
			{
				x[i][j]=str.charAt(count++);
			}
		}
		System.out.println(new maximalSquare221().maximalSquare(x));
	}
	
	public int maximalSquare(char[][] matrix) {
		int max=0;
		if(matrix==null||matrix.length==0||matrix[0].length==0){return 0;}
		int n=matrix.length,m=matrix[0].length;
		int dp[][]=new int[n+1][m+1];
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=m;j++)
			{
				if(matrix[i-1][j-1]=='1')
				{
					dp[i][j]=Math.min(dp[i-1][j-1], Math.min(dp[i-1][j],dp[i][j-1]))+1;
					max=Math.max(max, dp[i][j]);
				}
			}
		}
		return max*max;
	}
	/*
	public int maximalSquare(char[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0){return 0;}
        int x[]=new int[matrix[0].length];
        for(int i=0;i<x.length;i++)
        {
        	if(matrix[0][i]=='1')
        	{
        		x[i]=1;
        	}
        }
        int ans=0;
        int temp;
        for(int i=0;i<matrix.length;i++)
        {
        	for(int j=0;j<matrix[0].length;j++)
        	{
        		temp=getSquare(x,0,x.length-1);
        		ans=ans<temp?temp:ans;
        	}
        	if(i<matrix.length-1)
        	{
        		for(int j=0;j<matrix[0].length;j++)
        		{
        			if(matrix[i+1][j]=='1')
        			{
        				x[j]++;
        			}
        			else
        			{
        				x[j]=0;
        			}
        		}
        	}
        }
        return ans;
    }
	
	public int getSquare(int x[],int start,int end)
	{
		if(start<0||end>=x.length||start>end){return 0;}
		int minIndex=start;
		for(int i=start;i<=end;i++)
		{
			if(x[i]<x[minIndex]){minIndex=i;}
		}
		int ans1=getSquare(x,start,minIndex-1);
		int ans2=getSquare(x,minIndex+1,end);
		//int y=Math.min(x[minIndex], end-start+1);
		int y=x[minIndex]>end-start+1?end-start+1:x[minIndex];
		//int ans=Math.max(ans1, ans2);
		int ans=ans1>ans2?ans1:ans2;
		//ans=Math.max(ans, y*y);
		ans=ans<y*y?y*y:ans;
		return ans;
	}
	*/
}
