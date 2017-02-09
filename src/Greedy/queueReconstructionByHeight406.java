package Greedy;
//https://leetcode.com/problems/queue-reconstruction-by-height/
import java.util.*;
public class queueReconstructionByHeight406 {
	public static void main(String args[]) {
		int x[][]={{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
		new queueReconstructionByHeight406().reconstructQueue(x);
	}
	class point
	{
		int h;
		int k;
		point(int h,int k)
		{
			this.h=h;
			this.k=k;
		}
	}
	public int[][] reconstructQueue(int[][] people) {
		Comparator<point> comp=new Comparator<point>(){
			public int compare(point a,point b)
			{
				if(a.k>b.k){return 1;}
				else if(a.k<b.k){return -1;}
				else
				{
					if(a.h>b.h){return 1;}
					else if(a.h<b.h){return -1;}
					else{return 0;}
				}
			}
		};
		PriorityQueue<point> pq=new PriorityQueue<point>(comp);
		for(int i=0;i<people.length;i++)
		{
			pq.add(new point(people[i][0],people[i][1]));
		}
		List<point> list=new ArrayList<point>();
		int i;
		while(!pq.isEmpty())
		{
			point x=pq.remove();
			if(x.k==0)
			{
				list.add(x);
			}
			else
			{
				int count=0;
				i=0;
				while(i<list.size())
				{
					if(list.get(i).h>=x.h){count++;}
					i++;
					if(count==x.k){
						while(i<list.size()&&list.get(i).h<x.h){i++;}
						list.add(i,x);
						break;
					}
				}
			}
		}
		int ans[][]=new int[list.size()][2];
		for(i=0;i<ans.length;i++)
		{
			ans[i][0]=list.get(i).h;
			ans[i][1]=list.get(i).k;
		}
		return ans;
	}
}
