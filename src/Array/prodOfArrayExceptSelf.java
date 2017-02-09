//https://leetcode.com/problems/product-of-array-except-self/
package Arrays;
import java.util.*;
class point
{
	int index;
	int number;
	public point(int index,int number)
	{
		this.index=index;
		this.number=number;
	}
}

public class prodOfArrayExceptSelf {
	public static void main(String args[]) {
		int x[]={1,2,3,1};
		print(x);
		boolean ans=new prodOfArrayExceptSelf().containsNearbyDuplicate(x, 2);
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
	
	public static void print(int x[])
	{
		for(int i=0;i<x.length;i++)
		{
			System.out.printf("%d ",x[i]);
		}
		System.out.println();
	}
	 public int[] productExceptSelf(int[] nums) 
	 {
		 int res[]=new int[nums.length];
		 res[0]=1;
		 for(int i=1;i<nums.length;i++)
		 {
			 res[i]=res[i-1]*nums[i-1];
		 }
		 int left=1;
		 for(int i=nums.length-1;i>=0;i--)
		 {
			 res[i]=res[i]*left;
			 left=left*nums[i];
		 }
		 return res;
	 }
}
