package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/surrounded-regions/
public class SurroundedRegions {
	public static void main(String args[])
	{
		char[][] board={{'X','O'},{'O','X'}};
		new SurroundedRegions().solve(board);
		System.out.println(board);
	}
	
	public void solve(char[][] board) {
		Queue<int[]> q=new LinkedList<int[]>();
		int rows=board.length;
		int columns=board[0].length;
		int[] kip;
		for(int i=0;i<rows;i++)
		{
			if(board[i][0]=='O')
			{
				kip=new int[2];
				kip[0]=i;
				kip[1]=0; 
				q.add(kip);
			}
			if(board[i][columns-1]=='O')
			{
				kip=new int[2];
				kip[0]=i;
				kip[1]=columns-1; 
				q.add(kip);
			}
		}
		for(int i=1;i<columns-1;i++)
		{
			if(board[0][i]=='O')
			{
				kip=new int[2];
				kip[0]=0;
				kip[1]=i; 
				q.add(kip);
			}
			if(board[rows-1][i]=='O')
			{
				kip=new int[2];
				kip[0]=rows-1;
				kip[1]=i; 
				q.add(kip);
			}
		}
		
		while(!q.isEmpty())
		{
			int p[]=q.remove();
			board[p[0]][p[1]]='M';
			int x,y;
			x=p[0];
			y=p[1]-1;
			if(x>=0&&x<rows&&y>=0&&y<columns)
			{
				kip=new int[2];
				kip[0]=x;
				kip[1]=y;
				if(board[x][y]=='O')
				{
					q.add(kip);	
				}
			}
			x=p[0];
			y=p[1]+1;
			if(x>=0&&x<rows&&y>=0&&y<columns)
			{
				kip=new int[2];
				kip[0]=x;
				kip[1]=y;
				if(board[x][y]=='O')
				{
					q.add(kip);	
				}
			}
			x=p[0]-1;
			y=p[1];
			if(x>=0&&x<rows&&y>=0&&y<columns)
			{
				kip=new int[2];
				kip[0]=x;
				kip[1]=y;
				if(board[x][y]=='O')
				{
					q.add(kip);	
				}
			}
			x=p[0]+1;
			y=p[1];
			if(x>=0&&x<rows&&y>=0&&y<columns)
			{
				kip=new int[2];
				kip[0]=x;
				kip[1]=y;
				if(board[x][y]=='O')
				{
					q.add(kip);	
				}
			}
		}
		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<board[0].length;j++)
			{
				if(board[i][j]=='O'){board[i][j]='X';}
				if(board[i][j]=='M'){board[i][j]='O';}
			}
		}
		
    }
}
