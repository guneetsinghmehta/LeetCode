package DP;
//https://leetcode.com/problems/range-sum-query-2d-immutable/
public class rangeSumQuery2DImmutable304 {
	public static void main(String args[]) {
		int x[][]={{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};
		rangeSumQuery2DImmutable304 a=new rangeSumQuery2DImmutable304(x);
	}
	long x[][];
	int n,m;
	public rangeSumQuery2DImmutable304 (int[][] matrix) {
		n=matrix.length;
		m=matrix[0].length;
		x=new long[n][m];
		long arraySum;
		for(int i=0;i<n;i++)
		{
			arraySum=0;
			for(int j=0;j<m;j++)
			{
				arraySum+=matrix[i][j];
				if(i!=0)
				{
					x[i][j]=arraySum+x[i-1][j];
				}
				else
				{
					x[i][j]=arraySum;
				}
			}
		}
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
    	long total=x[row2][col2];
        long A=0,B=0,C=0;
        if(row1>0)
        {
        	A=x[row1-1][col2];
        }
        if(col1>0)
        {
        	B=x[row2][col1-1];
        }
        if(row1>0&&col1>0)
        {
        	C=x[row1-1][col1-1];
        }
        return (int) (total-A-B+C);
    }
}
