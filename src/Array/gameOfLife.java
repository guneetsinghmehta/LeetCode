package Arrays;
import java.util.*;
public class gameOfLife {
	public static void main(String args[]) {
		int board[][]={{0,1,1},{0,1,0},{0,0,1}};
		print(board);
		new gameOfLife().gameOfLife(board);
		print(board);
	}
	
	public static void print(int[][] board)
	{
		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<board[0].length;j++)
			{
				System.out.printf("%d ",board[i][j]);
			}
			System.out.println();
		}
	}
	
	public void gameOfLife(int[][] board) 
	{
		int neighbors;
		//3 - for dead->alive
		//2 - for alive ->dead
	    for(int i=0;i<board.length;i++)
	    {
	    	for(int j=0;j<board[0].length;j++)
	    	{
	    		neighbors=checkNeighbors(i,j,board);
	    		if(board[i][j]==1)
	    		{
	    			if(neighbors<2){board[i][j]=2;}
	    			else if(neighbors>3){board[i][j]=2;}
	    		}
	    		else if(board[i][j]==0)
	    		{
	    			if(neighbors==3){board[i][j]=3;}
	    		}
	    	}
	    }
	    
	    for(int i=0;i<board.length;i++)
	    {
	    	for(int j=0;j<board[0].length;j++)
	    	{
	    		if(board[i][j]==2){board[i][j]=0;}
	    		else if(board[i][j]==3){board[i][j]=1;}
	    	}
	    }
	}
	
	public int checkNeighbors(int x,int y,int[][] board)
	{
		int ans=0;
		int n=board.length,m=board[0].length;
		for(int i=-1;i<=1;i++)
		{
			for(int j=-1;j<=1;j++)
			{
				if(i==0&&j==0){continue;}
				if(isValid(x+i,y+j,n,m)&&(board[x+i][y+j]==1||board[x+i][y+j]==2))
				{
					ans++;
				}
			}
		}
		return ans;
	}
	
	public boolean isValid(int x,int y,int n,int m)
	{
		boolean ans=true;
		if(x<0||x>=n||y<0||y>=m){ans=false;}
		return ans;
	}
}
