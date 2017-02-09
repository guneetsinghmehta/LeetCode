package BFS;
//https://leetcode.com/problems/pacific-atlantic-water-flow/
import java.util.*;

public class PacificAtlantinc {
	private class point
	{
		int x,y;
		public point(int x,int y)
		{
			this.x=x;this.y=y;
		}
	}
	
	public static void main(String args[])
	{
		//int x[][]={{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
		int x[][]={{1,2},{3,4}};
		List<int[]> ans=new PacificAtlantinc().pacificAtlantic(x);
		System.out.println(ans);
	}
	
	public boolean isValid(point p)
	{
		boolean ans=true;
		if(p.x<0||p.x>=rows||p.y<0||p.y>=columns){ans=false;}
		return ans;
	}
	
	public List<point> getNeighbors(point p)
	{
		List<point> ans=new ArrayList<point>();
		point n=new point(p.x,p.y-1);//left
		if(isValid(n))
		{
			ans.add(n);
		}
		n=new point(p.x,p.y+1);//right
		if(isValid(n))
		{
			ans.add(n);
		}
		n=new point(p.x-1,p.y);//up
		if(isValid(n))
		{
			ans.add(n);
		}
		n=new point(p.x+1,p.y-1);//down
		if(isValid(n))
		{
			ans.add(n);
		}
		return ans;
	}
	int rows,columns;
	
	 public List<int[]> pacificAtlantic(int[][] matrix) {
		 rows=matrix.length;
		 columns=matrix[0].length;
		 List<int[]> ans=new ArrayList<int[]>();
		 //make a matrix of atlantic and pacific
		 int[][] A=new int[rows][columns];
		 int[][] P=new int[rows][columns];
		 //make a queue
		 Queue<point> q=new LinkedList<point>();
		 //popluate queue with pacific , mark pacific as 1
		 for(int i=0;i<rows;i++)
		 {
			 q.add(new point(i,0));
			 A[i][0]=1;
		 }
		 for(int i=0;i<columns;i++)
		 {
			 q.add(new point(0,i));
			 A[0][i]=1;
		 }
		 //keep removing pacific point and check if it can be reached and queue
		 while(!q.isEmpty())
		 {
			 point p=q.remove();
			 List<point> neighbors=getNeighbors(p);
			 for(point n:neighbors)
			 {
				 if(A[n.x][n.y]==0&&matrix[n.x][n.y]>=matrix[p.x][p.y])
				 {
					 q.add(n);
					 A[n.x][n.y]=1;
				 }
			 }
		 }
		 //repeat for pacific
		 for(int i=0;i<rows;i++)
		 {
			 q.add(new point(i,columns-1));
			 P[i][columns-1]=1;
		 }
		 for(int i=0;i<columns;i++)
		 {
			 q.add(new point(rows-1,i));
			 P[rows-1][i]=1;
		 }
		 //keep removing pacific point and check if it can be reached and queue
		 while(!q.isEmpty())
		 {
			 point p=q.remove();
			 List<point> neighbors=getNeighbors(p);
			 for(point n:neighbors)
			 {
				 if(P[n.x][n.y]==0&&matrix[n.x][n.y]>=matrix[p.x][p.y])
				 {
					 q.add(n);
					 P[n.x][n.y]=1;
				 }
			 }
		 }
		 //find all points where both atlantic and pacific are 1 and add those points to the ans list
		 for(int i=0;i<rows;i++)
		 {
			 for(int j=0;j<columns;j++)
			 {
				 if(A[i][j]==1&&P[i][j]==1)
				 {
					 int kip[]=new int[2];
					 kip[0]=i;
					 kip[1]=j;
					 ans.add(kip);
				 }
			 }
		 }
		 return ans;
	 }
}
