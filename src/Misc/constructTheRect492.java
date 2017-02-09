package Misc;
//https://leetcode.com/problems/construct-the-rectangle/
import java.util.*;
public class constructTheRect492 {
	public static void main(String args[]) {
		int y[]=new constructTheRect492().constructRectangle(12);
		System.out.println(y[0]);
		System.out.println(y[1]);
	}
	
	
	public int[] constructRectangle(int area) {
		int a=area,b=1;
		int ans[]=new int[2];
		int x=a,y=b;
		while(x>=y&&x>1)
		{
			x=x-1;
			y=area/x;
			if(x>=y&&x*y==area)
			{
				a=x;
				b=y;
			}
			if(x<y){break;}
		}
		ans[0]=a;
		ans[1]=b;
		return ans;
    }
	
}
