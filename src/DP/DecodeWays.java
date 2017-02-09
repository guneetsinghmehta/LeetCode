package DP;

//https://leetcode.com/problems/decode-ways/
public class DecodeWays {
	public static void main(String args[])
	{
		String str=new String("01");
		System.out.println(new DecodeWays().numDecodings(str));
	}
	
	public int numDecodings(String str) {
		if(str==null||str.length()==0){return 0;}
		int x[]=new int[str.length()+1];	
		x[str.length()]=1;
		for(int i=str.length()-1;i>=0;i--)
		{
			int ways=x[i+1];
			if(i+2<=str.length())
			{
				int num=Integer.parseInt(str.substring(i,i+2));
				if(num>0&&num<27)
				{
					ways=ways+x[i+2];
				}
			}
			if(str.charAt(i)=='0'){ways=0;}
			x[i]=ways;
		}
		return x[0];
	}
}
