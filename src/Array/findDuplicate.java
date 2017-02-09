package Arrays;
import java.util.*;
public class findDuplicate {
	public static void main(String args[]) {
		int x[]={2,1,3,3,4};
		System.out.println(new findDuplicate().findDuplicate(x));
	}
	
	public int findDuplicate(int[] nums) {
       int i=nums[0],j=nums[nums[0]];
       while(i!=j)
       {
    	   i=nums[i];
    	   j=nums[nums[j]];
       }
       j=0;
       while(i!=j)
       {
    	   i=nums[i];
    	   j=nums[j];
       }
       return nums[j];
	}
	
	public int advance(int[] nums,int i)
	{
		int x=nums[i-1];
		if(x==i){x=x+1;}
		return x;
	}
}
