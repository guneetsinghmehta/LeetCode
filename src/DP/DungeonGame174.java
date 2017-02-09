package DP;
//https://leetcode.com/problems/dungeon-game/
public class DungeonGame174 {
	public static void main(String args[]) {
		int x[][]={{-2,-3,3},{-5,-10,1},{10,30,-5}};
		System.out.println(new DungeonGame174().calculateMinimumHP(x));
	}
	
	public int calculateMinimumHP(int[][] matrix) {
		if(matrix==null||matrix.length==0||matrix[0].length==0){return 0;}
		int n=matrix.length,m=matrix[0].length;
		int x[][]=new int[n][m];
		x[n-1][m-1]=matrix[n-1][m-1];
		for(int i=n-1;i>=0;i--)
		{
			for(int j=m-1;j>=0;j--)
			{
				if(i==n-1&&j==m-1){continue;}
				int value=Integer.MIN_VALUE;
				if(i+1<n)
				{
					value=Math.max(value,x[i+1][j]);
				}
				if(j+1<m)
				{
					value=Math.max(value, x[i][j+1]);
				}
				value=value+matrix[i][j];
				x[i][j]=value;
			}
		}
		//Traverse the optimal path - but there can be multiple optimal paths and the minimum health required in each path can be different
		
		int health=matrix[0][0];
		int i=0,j=0;
		while(i!=n-1||j!=m-1)
		{
			if(i==n-1){j++;}
			else if(j==m-1){i++;}
			else
			{
				int a=x[i+1][j];
				int b=x[i][j+1];
				if(a>b)
				{
					
				}
			}
		}
    }
}
