//https://leetcode.com/problems/number-of-islands/
package BFS;
import java.util.*;
public class numIslands {
	 public int numIslands(char[][] grid2) {
		 if(grid2.length==0||grid2[0].length==0){return 0;}
		 int grid[][]=new int[grid2.length][grid2[0].length];
		 for(int i=0;i<grid.length;i++)
		 {
			 for(int j=0;j<grid[0].length;j++)
			 {
				 grid[i][j]=(int)grid2[i][j]-48;
			 }
		 }
		 int count=1;
		 int kip[],x,y,p[];
		 int rows=grid.length;
		 int columns=grid[0].length;
		 for(int i=0;i<rows;i++)
		 {
			 for(int j=0;j<columns;j++)
			 {
				 if(grid[i][j]==1)
				 {
					 count++;
					 Queue<int[]> q=new LinkedList<int[]>();
					 kip=new int[2];
					 kip[0]=i;
					 kip[1]=j;
					 q.add(kip);
					 while(!q.isEmpty())
					 {
						 kip=q.remove();
						 x=kip[0];
						 y=kip[1]-1;
						 if(x>=0&&x<rows&&y>=0&&y<columns&&grid[x][y]==1)
						 {
							 grid[x][y]=count;
							 p=new int[2];
							 p[0]=x;
							 p[1]=y;
							 q.add(p);
						 }
						 x=kip[0];
						 y=kip[1]+1;
						 if(x>=0&&x<rows&&y>=0&&y<columns&&grid[x][y]==1)
						 {
							 grid[x][y]=count;
							 p=new int[2];
							 p[0]=x;
							 p[1]=y;
							 q.add(p);
						 }
						 x=kip[0]-1;
						 y=kip[1];
						 if(x>=0&&x<rows&&y>=0&&y<columns&&grid[x][y]==1)
						 {
							 grid[x][y]=count;
							 p=new int[2];
							 p[0]=x;
							 p[1]=y;
							 q.add(p);
						 }
						 x=kip[0]+1;
						 y=kip[1];
						 if(x>=0&&x<rows&&y>=0&&y<columns&&grid[x][y]==1)
						 {
							 grid[x][y]=count;
							 p=new int[2];
							 p[0]=x;
							 p[1]=y;
							 q.add(p);
						 }
					 }
				 }
			 }
		 }
		 return count-1;
	 }
}
