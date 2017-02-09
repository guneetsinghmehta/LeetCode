package BitManipulation;
//https://leetcode.com/problems/counting-bits/
public class countingBits338 {
	public static void main(String args[]) {
		int x[]=new countingBits338().countBits(5);
		for(int i:x){System.out.println(i);}
	}
	
	public int[] countBits(int num) {
        int ans[]=new int[num+1];
        for(int i=1;i<=num;i++)
        {
        	ans[i]=sub(i);
        }
        return ans;
    }
	
	public int sub(int n)
	{
		int ans=0;
		while(n>0)
		{
			if((n&1)==1){ans++;}
			n=n>>1;
		}
		return ans;
	}
}
