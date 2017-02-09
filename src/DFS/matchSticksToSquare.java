package DFS;

//https://leetcode.com/problems/matchsticks-to-square/
public class matchSticksToSquare {
	public static void main(String args[])
	{
		int x[]={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		System.out.println(new matchSticksToSquare().makesquare(x));
	}
	
	int nums[];
	boolean visited[];
	public boolean makesquare(int[] x) {
		boolean ans=true;
		nums=x;
		visited=new boolean[x.length];
		int perimeter=0;
		for(int a:x)
		{
			perimeter+=a;
		}
		if(perimeter%4!=0){return false;}
		int side=perimeter/4;
		int sum1=0,sum2=0,sum3=0,sum4=0;
		return helper(nums,nums.length-1,sum1,sum2,sum3,sum4,side);
	}
	
	public boolean helper(int[] nums,int i,int sum1,int sum2, int sum3,int sum4,int side)
	{
		if(sum1>side||sum2>side||sum3>side||sum4>side){return false;}
		if(i==-1)
		{
			if(sum1==side&&sum2==side&&sum3==side&&sum4==side){return true;}
			else{return false;}
		}
		else
		{
			return helper(nums,i-1,sum1+nums[i],sum2,sum3,sum4,side)||
					helper(nums,i-1,sum1,sum2+nums[i],sum3,sum4,side)||
					helper(nums,i-1,sum1,sum2,sum3+nums[i],sum4,side)||
					helper(nums,i-1,sum1,sum2,sum3,sum4+nums[i],side);
		}
			
	}
}
