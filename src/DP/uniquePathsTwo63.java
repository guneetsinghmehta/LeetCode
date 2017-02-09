package DP;

//https://leetcode.com/problems/unique-paths-ii/
public class uniquePathsTwo63 {
	public static void main(String args[]) {
		int x[][]={{0,0,0},{0,1,0},{0,0,0}};
		System.out.println(new uniquePathsTwo63().uniquePathsWithObstacles(x));
	}

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid == null || obstacleGrid.length == 0) {
			return 0;
		}
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int x[][] = new int[m][n];
		if(obstacleGrid[m-1][n-1]==0)//there is a way only if destination has no obstacle
		{
		    x[m - 1][n - 1] = 1;    
		}
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if (i == m - 1 && j == n - 1) {
					continue;
				}
				int ans = 0;
				if (i < m - 1) {
					ans = ans + x[i + 1][j];
				}
				if (j < n - 1) {
					ans = ans + x[i][j + 1];
				}
				if (obstacleGrid[i][j] == 0) {
					x[i][j] = ans;
				}
			}
		}
		return x[0][0];
	}
}
