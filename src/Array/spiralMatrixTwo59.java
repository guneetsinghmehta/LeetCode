package Array;

//https://leetcode.com/problems/spiral-matrix-ii/
public class spiralMatrixTwo59 {
	public static void main(String args[]) {
		int y[][] = new spiralMatrixTwo59().generateMatrix(3);
	}
	
	int count =1;
	public int[][] generateMatrix(int n) {
		int matrix[][] = new int[n][n];
		sub(matrix,0,0,n);
		return matrix;
	}
	public void sub(int matrix[][],int x,int y,int n)
	{
		for(int i=y;i<y+n;i++)
		{
			matrix[x][i]=count++;
		}
		for(int i=x+1;i<x+n-1;i++)
		{
			matrix[i][y+n-1]=count++;
		}
		for(int i=y+n-1;i>=y&&n>1;i--)
		{
			matrix[x+n-1][i]=count++;
		}
		for(int i=x+n-2;i>=x+1&&n>1;i--)
		{
			matrix[i][y]=count++;
		}
		if(n>2)
		{
			sub(matrix,x+1,y+1,n-2);
		}
	}
}
