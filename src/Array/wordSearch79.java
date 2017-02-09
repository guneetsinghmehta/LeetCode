package Array;

//https://leetcode.com/problems/word-search/
public class wordSearch79 {
	public static void main(String args[])
	{
		char board[][]={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		System.out.println(new wordSearch79().exist(board, new String("ABCB")));
	}
	
	char board[][];
	boolean visited[][];
	public boolean exist(char[][] x, String word) {
		board=x;
		if(word==null||board==null||board.length==0||board[0].length==0)
		{
			return false;
		}
		int n=board.length,m=board[0].length;
		if(word.length()>m*n){return false;}
		visited=new boolean[n][m];
		//loop over the board and call sub with the first char
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				boolean ans=sub(i,j,word,0);
				if(ans){return true;}
			}
		}
		return false;
    }
	
	public boolean sub(int x,int y,String word,int index)
	{
		boolean ans=false;
		if(index==word.length()){ans=true;}
		else if(!visited[x][y]&&board[x][y]==word.charAt(index))
		{
			ans=true;
			visited[x][y]=true;
			int dirs[][]={{0,-1},{0,1},{-1,0},{1,0}};
			for(int dir[]:dirs)
			{
				int i=dir[0],j=dir[1];
				if(i==0&&j==0){continue;}
				if(x+i>=0&&x+i<visited.length&&y+j>=0&&y+j<visited[0].length)
				{
					ans=sub(x+i,y+j,word,index+1);
					if(ans){return ans;}
				}
			
			}
			visited[x][y]=false;
		}
		return ans;
	}
}
