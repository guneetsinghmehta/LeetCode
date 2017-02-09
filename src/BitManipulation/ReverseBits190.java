package BitManipulation;

public class ReverseBits190 {
	public static void main(String args[]) {
		new ReverseBits190().reverseBits(1);
	}
	
	public int reverseBits(int n) {
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<32;i++)
		{
			sb.append(n&1);
			n=n>>1;
		}
		String str=sb.toString();
		int ans=0;
		for(int i=0;i<32;i++)
		{
			//ans+=(int) (((int)(str.charAt(i)-48))*Math.pow(2, 31-i));
			ans+=(int) (((int)(str.charAt(i)-48))*sub(31-i));
		}
		System.out.println(ans);
		return ans;
    }
	
	public int sub(int x)
	{
		int ans=1;
		for(int i=0;i<x;i++)
		{
			ans=ans<<1;
		}
		return ans;
	}
}
