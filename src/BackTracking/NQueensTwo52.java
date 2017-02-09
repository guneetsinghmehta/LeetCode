package BackTracking;

import java.util.*;

public class NQueensTwo52 {
	public static void main(String args[])
	{
		System.out.println(new NQueensTwo52().totalNQueens(9));
	}
	
	char board[][];
	List<List<String>> ans;
	int count;
	public int totalNQueens(int n) {
		board=new char[n][n];
		count=0;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++){board[i][j]='.';}
		}
		placeQueen(0);
		return count;
	}

	// placeQueen(int col)function
	public void placeQueen(int col)
	{
		if(col>=board.length)
		{
			count++;
		}
		for(int row=0;row<board.length;row++)
		{
			if(checkPosition(row,col))
			{
				board[row][col]='Q';
				placeQueen(col+1);
				board[row][col]='.';
			}
		}
	}
	// check position function
	public boolean checkPosition(int x,int y)
	{
		boolean ans=true;
		//check the row
		for(int i=0;i<y;i++)
		{
			if(board[x][i]=='Q'){return false;}
		}
		//check above left diagonal
		int a=x-1,b=y-1;
		while(a>=0&&b>=0)
		{
			if(board[a][b]=='Q'){return false;}
			a--;
			b--;
		}
		//check below left diagonal
		a=x+1;
		b=y-1;
		while(a<board.length&&b>=0)
		{
			if(board[a][b]=='Q'){return false;}
			a++;
			b--;
		}
		return true;
	}
}
