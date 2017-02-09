package Array;
//https://leetcode.com/problems/pascals-triangle-ii/
import java.util.*;
public class pascalTriangleTwo119 {
	public static void main(String args[])
	{
		List<Integer> x=new pascalTriangleTwo119().getRow(5);
		System.out.println(1);
	}
	
	 public List<Integer> getRow(int n) {
		 List<Integer> list=new ArrayList<Integer>();
		 if(n==0)
		 {
			 list.add(1);
			 return list;
		 }
		 long x=1;
		 for(int i=0;i<=n;i++)
		 {
			 if(i==0)
			 {
				 list.add((int)x);
			 }
			 else
			 {
				 x=x*(n-(i-1))/i;
				 list.add((int)x);
			 }
		 }
		 return list;  
    }
}
