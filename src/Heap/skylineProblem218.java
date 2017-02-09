package Heap;
//
import java.util.*;


public class skylineProblem218 {
	class change
	{
		int index;
		int height;
		public change(int index,int height)
		{
			this.index=index;
			this.height=height;
		}
	}
	
	public static void main(String args[]) {
		//int buildings[][]={{0,4,1},{1,3,3},{2,5,2}};
		int buildings[][]={{0,4,1},{0,4,2},{0,4,3}};
		new skylineProblem218().getSkyline(buildings);
	}
	
	public List<int[]> getSkyline(int[][] buildings) {
		List<int[]> ans=new ArrayList<int[]>();
		Comparator<change> comp=new Comparator<change>(){
			public int compare(change a1,change a2)
			{
				if(a1.index>a2.index){return 1;}
				else if(a1.index<a2.index){return -1;}
				else {return 0;}
			}
		};
		PriorityQueue<change> pq=new PriorityQueue<change>(10000,comp);
		for(int i=0;i<buildings.length;i++)
		{
			int left=buildings[i][0];
			int right=buildings[i][1];
			int h=buildings[i][2];
			pq.add(new change(left,h));
			pq.add(new change(right,-h));
		}
		PriorityQueue<Integer> pqh=new PriorityQueue<Integer>(Collections.reverseOrder());
		
		int lastHeight=0;
		while(!pq.isEmpty())
		{
			change c1=pq.remove();
			if(c1.height>0)
			{
				pqh.add(c1.height);
			}
			else
			{
				pqh.remove(-c1.height);
			}
			while(!pq.isEmpty()&&pq.peek().index==c1.index)
			{
				change c2=pq.remove();
				if(c2.height>0)
				{
					pqh.add(c2.height);
				}
				else
				{
					pqh.remove(-c2.height);
				}
			}
			if(!pqh.isEmpty()&&pqh.peek()!=lastHeight)
			{
				int x[]=new int[2];
				x[0]=c1.index;
				x[1]=pqh.peek();
				ans.add(x);
				lastHeight=pqh.peek();
			}
			else if(pqh.isEmpty())
			{
				int x[]=new int[2];
				x[0]=c1.index;
				x[1]=0;
				lastHeight=0;
				ans.add(x);
			}
		}
		return ans;
    }
}
