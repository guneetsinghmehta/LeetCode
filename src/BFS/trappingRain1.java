package BFS;
import java.util.*;
//https://leetcode.com/problems/trapping-rain-water/
public class trappingRain1 {
	public static void main(String args[])
	{
		int height[]={0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(new trappingRain1().trap(height));
	}
	
	private class cell
	{
		int x;
		int height;
		boolean visited;
		public cell(int x,int height)
		{
			this.x=x;
			this.height=height;
			this.visited=false;
		}
	}
	
	public int trap(int[] height) {
        //make a priority queue - on height
		PriorityQueue<cell> pq=new PriorityQueue<cell>(height.length,new Comparator<cell>()
			{
				public int compare(cell v1,cell v2)
				{
					return v1.height-v2.height;
				}
			}
		);
		//push first and last
		cell array[]=new cell[height.length];
		for(int i=0;i<height.length;i++)
		{
			array[i]=new cell(i,height[i]);
		}
		pq.add(array[0]);
		pq.add(array[height.length-1]);
		//pop one - check if valid neighbors and if the neighbor is not visited and add difference in height
		int sum=0;
		cell p;
		int maxH=0;
		while(!pq.isEmpty())
		{
			p=pq.remove();
			maxH=(int)Math.max(maxH, p.height);
			array[p.x].visited=true;
			int i=p.x-1;
			if(i>=0&&i<height.length&&!array[i].visited)
			{
				sum+=(int)Math.max(0, maxH-array[i].height);
				pq.add(array[i]);
			}
			i=p.x+1;
			if(i>=0&&i<height.length&&!array[i].visited)
			{
				sum+=(int)Math.max(0, maxH-array[i].height);
				pq.add(array[i]);
			}
		}
		return sum;
    }
}
