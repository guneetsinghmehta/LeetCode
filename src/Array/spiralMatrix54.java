package Array;

//54
//https://leetcode.com/problems/spiral-matrix/
import java.util.*;
public class spiralMatrix54 {
	public static void main(String args[])
	{
		//int x[][]={{2,3,4},{5,6,7},{8,9,10},{11,12,13}};
		int x[][]={{1,2,3},{4,5,6},{7,8,9}};
		System.out.println(new spiralMatrix54().spiralOrder(x));
		
	}
	
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> list=new ArrayList<Integer>();
		if(matrix==null||matrix.length==0){return list;}
		int n=matrix.length;
		int m=matrix[0].length;
		if(n==1)
		{
		    for(int i=0;i<m;i++){list.add(matrix[0][i]);}
		}
		else if(m==1)
		{
		    for(int i=0;i<n;i++){list.add(matrix[i][0]);}
		}
		else
		{
		    sub(list,matrix,0,0,n,m);    
		}
		return list;
	}
	
	public void sub(List<Integer> list,int[][]matrix,int x,int y,int n,int m)
	{
		for(int i=y;i<y+m;i++)
		{
			list.add(matrix[x][i]);
		}
		for(int i=x+1;i<x+n-1;i++)
		{
			list.add(matrix[i][y+m-1]);
		}
		for(int i=y+m-1;i>=y&&n>1;i--)
		{
			list.add(matrix[x+n-1][i]);
		}
		for(int i=x+n-2;i>=x+1&&m>1;i--)
		{
			list.add(matrix[i][y]);
		}
		if(n>2&&m>2)
		{
			sub(list,matrix,x+1,y+1,n-2,m-2);
		}
		
	}
}
