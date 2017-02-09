//https://leetcode.com/problems/contains-duplicate-ii/
//https://leetcode.com/problems/contains-duplicate/
package Arrays;
import java.util.*;
public class containsDuplicate1and2 {
	private class point
	{
		int index;
		int number;
		public point(int index,int number)
		{
			this.index=index;
			this.number=number;
		}
	}
	
	public static void main(String args[]) {
		int x[]={1,2,1,3};
		boolean ans=new containsDuplicate1and2().containsNearbyDuplicate(x, 2);
		System.out.println(ans);
	}
	
	public boolean containsDuplicate(int[] nums) {
        boolean ans=false;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++)
        {
        	if(nums[i]==nums[i+1]){ans=true;break;}
        }
        return ans;
    }
	
	 public boolean containsNearbyDuplicate(int[] nums, int k)
	 {
		 boolean ans=false;
		 HashSet<Integer> set=new HashSet<Integer>();
		 for(int i=0;i<nums.length;i++)
		 {
			 if(i>k){set.remove(nums[i-k-1]);}
			 if(set.contains(nums[i]))
			 {
				 ans=true;
				 break;
			 }
			 else
			 {
				 set.add(nums[i]);
			 }
		 }
		 return ans;
	 }
	
	 public boolean containsNearbyDuplicate2(int[] nums, int k) 
	 {
		 boolean ans=false;
		 PriorityQueue<point> pq=new PriorityQueue<point>(nums.length,new Comparator<point>()
			 {
				@Override
				public int compare(point o1, point o2) {
					if(o1.number>o2.number){return 1;}
					else if(o1.number<o2.number){return -1;}
					return 0;
				}
			 }
		 );
		 for(int i=0;i<nums.length;i++)
		 {
			 pq.add(new point(i,nums[i]));
		 }
		 point[] collection=new point[nums.length];
		 for(int i=0;i<nums.length;i++)
		 {
			 collection[i]=pq.remove();
		 }
		 int i=0,j=0;
		 while(i<nums.length&&j<nums.length)
		 {
			 while(j<nums.length&&collection[i].number==collection[j].number)
			 {
				 if(i!=j&&Math.abs(collection[i].index-collection[j].index)<=k)
				 {
					 ans=true;break;
				 }
				 j++;
			 }
			 if(ans){break;}
			 i=j;
		 }
		 return ans;
	 }	
}
