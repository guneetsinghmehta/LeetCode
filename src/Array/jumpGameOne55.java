package Array;
//https://leetcode.com/problems/jump-game/
public class jumpGameOne55 {
	public static void main(String args[])
	{
		//int x[]={2,3,1,1,4};
		int x[]={3,2,1,0,4};
		System.out.println(new jumpGameOne55().canJump(x));
	}
	
	public boolean canJump(int[] nums) {
		  boolean ans=false;
			int r=0;
			if(nums.length==1){ans=true;}//case where start==end
			for(int i=0;i<nums.length-1;i++)
			{
			    if(i>r){break;}//if the current index cannot be reached
				int x=nums[i];
				r=r>i+x?r:i+x;//update the max index reached
				if(r>=nums.length-1){ans=true;break;}
			}
			return ans;
    }
}
