package HashTable;
import java.util.*;
//https://leetcode.com/problems/max-points-on-a-line/
class Point {
	int x;
	int y;
	Point() {
		x = 0;
		y = 0;
	}
	Point(int a, int b) {
		x = a;
		y = b;
	}
}

public class maxPointsOnLine149 {
	
	public static void main(String args[]) {
		Point point[]=new Point[3];
		point[0]=new Point(2,3);
		point[1]=new Point(3,3);
		point[2]=new Point(-5,3);
		System.out.println(new maxPointsOnLine149().maxPoints(point));
	}

	public int maxPoints(Point[] points) {
		if(points==null){return 0;}
		if(points.length<=2){return points.length;}
		int ans=2;
		for(int i=0;i<points.length;i++)
		{
			HashMap<Double,Integer> map=new HashMap<Double,Integer>();
			int samePoint=0;
			int sameX=1;
			for(int j=0;j<points.length;j++)
			{
				if(i!=j)
				{
					if(points[i].x==points[j].x&&points[i].y==points[j].y){
						samePoint++;
					}
					if(points[i].x==points[j].x){
						sameX++;
					}
				}
			}
			for(int j=i+1;j<points.length;j++)
			{
				if(points[i].x!=points[j].x){
					double m=((double)points[i].y-(double)points[j].y)/((double)points[i].x-(double)points[j].x);
					if(m==0){m=0;}
					if(map.containsKey(m)){
						map.put(m, map.get(m)+1);
					}
					else{
						map.put(m,2);
					}
					ans=Math.max(ans, map.get(m)+samePoint);
				}
			}
			ans=Math.max(ans, sameX);
		}
		return ans;
	}
}
