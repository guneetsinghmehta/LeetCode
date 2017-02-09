package BFS;
import java.util.*;
class UndirectedGraphNode {
	      int label;
	      List<UndirectedGraphNode> neighbors;
	      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
	 };

public class cloneGraph {
	public static void main(String args[])
	{
		UndirectedGraphNode x=new UndirectedGraphNode(0);
		UndirectedGraphNode y=new UndirectedGraphNode(1);
		UndirectedGraphNode z=new UndirectedGraphNode(2);
		x.neighbors.add(y);
		x.neighbors.add(z);
		y.neighbors.add(z);
		z.neighbors.add(z);
		UndirectedGraphNode temp=new cloneGraph().cloneGraph2(x);
		System.out.println(1);
	}
	
    public UndirectedGraphNode cloneGraph2(UndirectedGraphNode node) {
    	if(node==null){return null;}
        HashMap<UndirectedGraphNode,UndirectedGraphNode> map=new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
        Queue<UndirectedGraphNode> q=new LinkedList<UndirectedGraphNode>();
        q.add(node);
        while(!q.isEmpty())
        {
            UndirectedGraphNode p=q.remove();
            UndirectedGraphNode newP=new UndirectedGraphNode(p.label);
            map.put(p,newP);
            for(UndirectedGraphNode n:p.neighbors)
            {
                if(!map.containsKey(n))
                {
                	q.add(n);
                }
            }
        }
        q=new LinkedList<UndirectedGraphNode>();
        UndirectedGraphNode y;
        for(UndirectedGraphNode x:map.keySet())
        {
        	y=map.get(x);
        	for(UndirectedGraphNode n:x.neighbors)
        	{
        		y.neighbors.add(map.get(n));
        	}
        }
        return	map.get(node);
    }

}
