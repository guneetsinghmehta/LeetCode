package HashTable;
//46
//https://leetcode.com/problems/valid-sudoku/
public class validSudoku46 {
    public boolean isValidSudoku(char[][] board) {
    	int x;
    	for(int i=0;i<board.length;i++)
    	{
    		for(int j=0;j<board[0].length;j++)
    		{
    			char c=board[i][j];
    			if(c!='.')
    			{
    				x=0;
    				//row
    				for(int a=0;a<9;a++)
    				{
    					if(c==board[i][a]){x++;}
    				}
    				if(x>1){return false;}
    				
    				//column
    				x=0;
    				for(int a=0;a<9;a++)
    				{
    					if(c==board[a][j]){x++;}
    				}
    				if(x>1){return false;}
    				
    				//block
    				x=0;
    				int row=i/3,col=j/3;
    				for(int a=row*3;a<row*3+3;a++)
    				{
    					for(int b=col*3;b<col*3+3;b++)
    					{
    						if(c==board[a][b])
    						{
    							x++;
    						}
    					}
    				}
    				if(x>1){return false;}
    			}
    		}
    	}
    	return true;
    }
}
