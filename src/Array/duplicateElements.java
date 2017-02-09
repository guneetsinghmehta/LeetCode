package Arrays;
import java.util.*;
public class duplicateElements 
{
	public static void main(String args[]) 
	{
		Scanner scanner = new Scanner(System.in);
		int nums[]={4,3,2,7,8,2,3,1};
		System.out.println(new duplicateElements().findDuplicates(nums));
	}
	
	public List<Integer> findDuplicates(int[] nums) 
	{
		List<Integer> list=new LinkedList<Integer>();
		int x;
		for(int i=0;i<nums.length;i++)
		{
			x=nums[i];
			x=Math.abs(x);
			if(nums[x-1]<0)
			{
				list.add(x);
			}
			else
			{
				nums[x-1]=nums[x-1]*-1;
			}
		}
		return list;
	
	}
}
