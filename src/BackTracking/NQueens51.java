package BackTracking;

import java.util.*;

public class NQueens51 {
	public static void main(String args[])
	{
		new NQueens51().solveNQueens(9);
	}
	
	char board[][];
	List<List<String>> ans;

	public List<List<String>> solveNQueens(int n) {
		board=new char[n][n];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++){board[i][j]='.';}
		}
		ans = new ArrayList<List<String>>();
		placeQueen(0);
		return null;
	}

	// placeQueen(int col)function
	public void placeQueen(int col)
	{
		if(col>=board.length)
		{
			List<String> list=new ArrayList<String>();
			for(int i=0;i<board.length;i++)
			{
				list.add(new String(board[i]));
			}
			ans.add(list);
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
