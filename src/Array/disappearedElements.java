//https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
package Arrays;
import java.util.*;
public class disappearedElements {
	public static void main(String args[]) {
		int[] nums={4,3,2,7,8,2,3,1};
		List<Integer> list=new disappearedElements().findDisappearedNumbers(nums);
		System.out.println(list);
	}
	
	public List<Integer> findDisappearedNumbers(int[] nums) {
		 for(int i=0;i<nums.length;i++)
		 {
			 int x=Math.abs(nums[i]);
			 nums[x-1]=-1*Math.abs(nums[x-1]);
		 }
		 List<Integer> list=new LinkedList<Integer>();
		 for(int i=0;i<nums.length;i++)
		 {
			 if(nums[i]>0){list.add(i+1);}
		 }
		 return list;
    }
}
