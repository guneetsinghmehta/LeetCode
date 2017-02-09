package Maths;
//https://leetcode.com/problems/divide-two-integers/
public class divideTwoIntegers29 {
	public static void main(String args[])
	{
		System.out.println(new divideTwoIntegers29().divide(Integer.MAX_VALUE, 1));
	}
	public int divide(int dividend, int divisor) {
		long ans=longDivide(dividend,divisor);
		return ans>Integer.MAX_VALUE?Integer.MAX_VALUE:(int)ans;
    }
	
	public long longDivide(long dividend,long divisor)
	{
		boolean negative=dividend<0!=divisor<0;
		if(dividend<0){dividend*=-1;}
		if(divisor<0){divisor*=-1;}
		if(dividend<divisor){return 0;}
		long divide=1;
		long sum=divisor;
		while(sum+sum<dividend)
		{
			sum+=sum;
			divide+=divide;
		}
		return negative?-(divide+longDivide(dividend-sum,divisor)):(divide+longDivide(dividend-sum,divisor));
	}
}
