package HashTable;
import java.util.*;
//https://leetcode.com/problems/number-of-boomerangs/
public class NumberOfBoomerangs447 {
	public static void main(String args[]) {
		int x[][]={{1,0},{0,0},{2,0}};
		System.out.println(new NumberOfBoomerangs447().numberOfBoomerangs(x));
	}

	public int numberOfBoomerangs(int[][] points) {
		if(points==null||points.length<=2){return 0;}
		int ans=0;
		for(int i=0;i<points.length;i++)
		{
			HashMap<Integer,Integer> map=new HashMap();
			for(int j=0;j<points.length;j++)
			{
				if(i==j){continue;}
				int dist=getDist(points[i],points[j]);
				map.put(dist,map.getOrDefault(dist, 0)+1);
			}
			for(int x:map.values()){
				ans+=x*(x-1);
			}
		}
		return ans;
	}
	
	public int getDist(int x[],int y[])
	{
		return ((x[0]-y[0])*(x[0]-y[0])+(x[1]-y[1])*(x[1]-y[1]));
	}
}
