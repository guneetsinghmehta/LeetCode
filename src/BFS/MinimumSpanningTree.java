package BFS;
//https://leetcode.com/problems/minimum-height-trees/
import java.util.*;

public class MinimumSpanningTree {
	public static void main(String args[])
	{
		int edges[][]={{1,0},{1,2},{1,3}};
		List<Integer> ans=new MinimumSpanningTree().findMinHeightTrees(4, edges);
		System.out.println(ans);
	}
	
	 public List<Integer> findMinHeightTrees(int n, int[][] edgeList) {
		 //edge case of 0 or 1
		 List<Integer> ans=new ArrayList<Integer>();
		 if(n==1){ans.add(0);}
		 if(n<=1){return ans;}
		 //make adjacency list
		 List<ArrayList<Integer>> edges=new ArrayList<ArrayList<Integer>>();
		 for(int i=0;i<n;i++){edges.add(new ArrayList<Integer>());}
		 for(int i=0;i<edgeList.length;i++)
		 {
			 int x=edgeList[i][0],y=edgeList[i][1];
			 edges.get(x).add(y);
			 edges.get(y).add(x);
		 }
		 //put all leaves in the queue
		 List<Integer> leaves=new ArrayList<Integer>();
		 for(int i=0;i<n;i++)
		 {
			 if(edges.get(i).size()==1){leaves.add(i);}
		 }
		 //run while more than 2 are present
		 int count=n;
		 while(count>2)
		 {
			 count=count-leaves.size();
			 List<Integer> newLeaves=new ArrayList<Integer>();
			 for(int leaf:leaves)
			 {
				 for(int neighbor:edges.get(leaf))
				 {
					 edges.get(neighbor).remove(Integer.valueOf(leaf));
					 if(edges.get(neighbor).size()==1)
					 {
						 newLeaves.add(neighbor);
					 }
				 }
			 }
			 leaves=newLeaves;
		 }
		 //return the ansList
		 return leaves;
	 }
	 
	 //find longest path in a graph
}
