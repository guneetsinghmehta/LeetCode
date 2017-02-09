package BitManipulation;
//https://leetcode.com/problems/single-number-iii/
public class SingleNumberThree260 {
	public static void main(String args[]) {
		int x[]={1,1,2,2,3,5};
		int y[]=new SingleNumberThree260().singleNumber(x);
		System.out.println(1);
	}
	
	public int[] singleNumber(int[] nums) {
		int xor=0;
		for(int x:nums)
		{
			xor=xor^x;
		}
		int i;
		for(i=0;i<32;i++)
		{
			if((xor&1)==1){break;}
			else {xor=xor>>1;}
		}
		int g1=0,g2=0;	
		for(int x:nums)
		{
			int a[]=getArray(x);
			if(a[i]==1){g1=g1^x;}
			else {g2=g2^x;}
		}
		int ans[]=new int[2];
		ans[0]=g1;
		ans[1]=g2;
		return ans;
    }
	
	public int[]getArray(int n)
	{
		int ans[]=new int[32];
		for(int i=0;i<32;i++)
		{
			ans[i]=n&1;
			n=n>>1;
		}
		return ans;
	}
}
