package Array;
//https://leetcode.com/problems/triangle/
import java.util.*;
public class triangle120 {
	public static void main(String args[])
	{
		List<List<Integer>> triangle=new ArrayList<List<Integer>>();
		List<Integer> list=new ArrayList<Integer>();
		list.add(2);
		triangle.add(list);
		
		list=new ArrayList<Integer>();
		list.add(3);
		list.add(4);
		triangle.add(list);
		
		list=new ArrayList<Integer>();
		list.add(6);
		list.add(5);
		list.add(7);
		triangle.add(list);
		
		list=new ArrayList<Integer>();
		list.add(4);
		list.add(1);
		list.add(8);
		list.add(3);
		triangle.add(list);
		
		System.out.println(new triangle120().minimumTotal(triangle));
	}
	
	public int minimumTotal(List<List<Integer>> triangle) {
		//return sub(triangle,0,0);
		return sub2(triangle);
	}
	
	public int sub2(List<List<Integer>> triangle)
	{
		if(triangle==null||triangle.size()==0||triangle.get(0).size()==0){return 0;}
		if(triangle.size()==1){return triangle.get(0).get(0);}
		else
		{
			List<Integer> list=triangle.get(triangle.size()-1);
			List<Integer> newList=new ArrayList<Integer>();
			//finding path stop at end of triangle
			for(int i=0;i<list.size()-1;i++)
			{
				newList.add(Math.min(list.get(i),list.get(i+1)));
			}
			triangle.remove(triangle.size()-1);
			list=triangle.get(triangle.size()-1);
			for(int i=0;i<newList.size();i++)
			{
				list.set(i, list.get(i)+newList.get(i));
			}
			return sub2(triangle);
		}
		
	}
	
	public int sub(List<List<Integer>> triangle,int rowN,int index)
	{
		if(triangle==null||triangle.size()==0||triangle.get(0).size()==0){return 0;}
		if(rowN>=triangle.size()||index>=triangle.get(rowN).size())
		{
			return 0;
		}
		int ans=triangle.get(rowN).get(index);
		ans=ans+Math.min(sub(triangle,rowN+1,index),sub(triangle,rowN+1,index+1));
		return ans;
	}
}
