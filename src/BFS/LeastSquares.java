package BFS;
//https://leetcode.com/problems/perfect-squares/
public class LeastSquares
{
	public int numSquares(int n) {
		int x[]=new int[n+1];
		x[1]=1;
		for(int i=2;i<=n;i++)
		{
			int y=(int)Math.floor(Math.sqrt(i));
			if(y*y==i)
			{
				x[i]=1;
			}
			else 
			{
				int j=i-1;
				while(j!=Math.floor(Math.sqrt(j))*Math.floor(Math.sqrt(j)))
				{
					j--;
				}
				x[i]=x[j]+
			}
		}
	}
}
