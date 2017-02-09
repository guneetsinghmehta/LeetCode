package BFS;

import java.util.Comparator;
import java.util.PriorityQueue;

//https://leetcode.com/problems/trapping-rain-water-ii/
public class trappingRain2 {
	public static void main(String args[])
	{
		int x[][]={{9,9,9,9,9},{9,2,1,2,9},{9,2,8,2,9},{9,2,3,2,9},{9,9,9,9,9}};
		System.out.println(new trappingRain2().trapRainWater(x));
	}
	
	private class cell
	{
		int x;
		int y;
		int height;
		boolean visited;
		public cell(int x,int y,int height)
		{
			this.x=x;
			this.y=y;
			this.height=height;
			this.visited=false;
		}
	}
	public int trapRainWater(int[][] heightMap) {
		if(heightMap==null||heightMap.length==0||heightMap[0].length==0){return 0;}
		PriorityQueue<cell> pq=new PriorityQueue<cell>(heightMap.length*heightMap[0].length,new Comparator<cell>()
			{
				public int compare(cell v1,cell v2)
				{
					return v1.height-v2.height;
				}
			}
		);
		int n=heightMap.length;
		int m=heightMap[0].length;
		cell array[][]=new cell[n][m];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				array[i][j]=new cell(i,j,heightMap[i][j]);
			}
		}
		for(int i=0;i<n;i++)
		{
			pq.add(array[i][0]);
			pq.add(array[i][m-1]);
		}
		for(int i=1;i<m-1;i++)
		{
			pq.add(array[0][i]);
			pq.add(array[n-1][i]);
		}
		int sum=0;
		int maxH=0;
		cell p;
		int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
		while(!pq.isEmpty())
		{
			p=pq.remove();
			if(p.visited){continue;}
			sum+=(int)Math.max(0, maxH-p.height);
			maxH=(int)Math.max(maxH, p.height);
			array[p.x][p.y].visited=true;
			for(int dir[]:dirs)
			{
				int i=p.x+dir[0];
				int j=p.y+dir[1];
				if(i>=0&&i<n&&j>=0&&j<m&&!array[i][j].visited)
				{
					pq.add(array[i][j]);
				}
			}
		}
		return sum;
    }
}
