//https://leetcode.com/problems/summary-ranges/
package Arrays;
import java.util.*;
public class summaryRanges {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int x[]={0,1,2,4,5,7};
		System.out.println(new summaryRanges().summaryRanges(x));
	}
	
	public List<String> summaryRanges(int[] nums) 
	{
		List<String> list=new LinkedList<String>();
		int i=0,j;
		while(i<nums.length)
		{
			j=i;
			while(j<nums.length-1&&nums[j+1]==nums[j]+1)
			{
				j++;
			}
			if(i==j)
			{
				list.add(new String(Integer.toString(nums[i])));
			}
			else
			{
				String temp=Integer.toString(nums[i]);
				temp=temp.concat(new String("->"));
				temp=temp.concat(Integer.toString(nums[j]));
				list.add(temp);
			}
			if(i==j){i++;}
			else{i=j+1;}
		}
		return list;
	}
}
