package BFS;
import java.util.*;
//https://leetcode.com/problems/course-schedule/
public class courseSchedule1 {
	private class node
	{
		int label;
		ArrayList<Integer> neighbors;
		public node(int label)
		{
			this.label=label;
			this.neighbors=new ArrayList<Integer>();
		}
	}
	public static void main(String args[])
	{
		//int pre[][]={{1,4},{1,0},{1,3},{5,1},{2,1}};
		int pre[][]={{0,1},{0,2},{1,2}};
		System.out.println(new courseSchedule1().canFinish(3, pre));
	}
	node nodes[];
	boolean visited[];
	boolean done[];
	
	
	
	public boolean canFinish(int numCourses, int[][] prereqs) 
	{
		nodes=new node[numCourses];
		done=new boolean[numCourses];
		Arrays.fill(done, false);
		for(int i=0;i<numCourses;i++)
		{
			nodes[i]=new node(i);
		}
		for(int i=0;i<prereqs.length;i++)
		{
			int x=prereqs[i][0];
			int y=prereqs[i][1];
			nodes[x].neighbors.add(y);
		}
		
		boolean ans=false;//signifies cycle
		for(int i=0;i<numCourses;i++)
		{
			visited=new boolean[numCourses];
			ans=detectCycle(i);
			if(ans){break;}
		}
		return !ans;
	}
	
	boolean detectCycle(int x)
	{
		if(done[x]){return false;}
		boolean ans=false;
		if(visited[x]){ans=true;}
		else
		{
			visited[x]=true;
			for(int n:nodes[x].neighbors)
			{
				if(detectCycle(n)){ans=true;break;}
				done[x]=true;
			}
			visited[x]=false;
		}
		return ans;
	}
}
