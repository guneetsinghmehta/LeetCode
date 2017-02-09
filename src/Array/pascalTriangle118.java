package Array;
//https://leetcode.com/problems/pascals-triangle/
import java.util.*;
public class pascalTriangle118 {
	public static void main(String args[])
	{
		new pascalTriangle118().generate(5);
	}
	
	List<List<Integer>> ans;
	List<Integer> list;
	public List<List<Integer>> generate(int numRows) {
        ans=new ArrayList<List<Integer>>();
        if(numRows>=1)
        {
        	list=new ArrayList<Integer>();
        	list.add(1);
        	ans.add(list);
        }
        if(numRows>=2)
        {
        	list=new ArrayList<Integer>();
        	list.add(1);
        	list.add(1);
        	ans.add(list);
        }
        for(int i=3;i<=numRows;i++)
        {
        	sub(i);
        }
        return ans;
    }
	public void sub(int n)
	{
		List<Integer> newList=new ArrayList<Integer>();
		newList.add(1);
		for(int i=2;i<=n-1;i++)
		{
			newList.add(list.get(i-2)+list.get(i-1));
		}
		newList.add(1);
		list=newList;
		ans.add(newList);
	}
}
