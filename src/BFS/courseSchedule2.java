package BFS;
import java.util.*;
//https://leetcode.com/problems/course-schedule-ii/
public class courseSchedule2 {
	public static void main(String args[])
	{
		int pre[][]={{0,1},{2,0},{1,2}};
		int a[]=new courseSchedule2().findOrder(3, pre);
		System.out.println(1);
	}
	
	private class node
	{
		int label;
		ArrayList<Integer> neighbors;
		boolean visited;
		public node(int label)
		{
			this.label=label;
			this.visited=false;
			this.neighbors=new ArrayList<Integer>();
		}
	}
	int inDegree[];
	public int[] findOrder(int numCourses, int[][] prereqs) {
        node nodes[]=new node[numCourses];
        inDegree=new int[numCourses];
        for(int i=0;i<numCourses;i++){nodes[i]=new node(i);}
        for(int i=0;i<prereqs.length;i++)
        {
        	int x=prereqs[i][0];
        	int y=prereqs[i][1];
        	nodes[y].neighbors.add(x);
        }
        Queue<node> q=new LinkedList<node>();
        Queue<node> out=new LinkedList<node>();
        for(int i=0;i<numCourses;i++)
        {
        	node nodeTemp=nodes[i];
        	for(int m:nodeTemp.neighbors)
        	{
        		inDegree[m]++;
        	}
        }
        for(int i=0;i<numCourses;i++)
        {
        	if(inDegree[i]==0){q.add(nodes[i]);}
        }
        while(!q.isEmpty())
        {
        	node x=q.remove();
        	out.add(x);
        	x.visited=true;
        	for(int n:x.neighbors)
        	{
        		inDegree[n]--;
        		if(inDegree[n]==0){q.add(nodes[n]);}
        	}
        }
        boolean allCovered=true;
        for(int i=0;i<numCourses;i++)
        {
        	if(!nodes[i].visited){allCovered=false;break;}
        }
        if(!allCovered){return new int[0];}
        else
        {
        	int ans[]=new int[numCourses];
        	for(int i=0;i<numCourses;i++)
        	{
        		ans[i]=out.remove().label;
        	}
        	return ans;
        }
    }
}
