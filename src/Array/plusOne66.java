package Array;
//https://leetcode.com/problems/plus-one/
public class plusOne66 {
	public static void main(String args[])
	{
		int x[]={9,9,9};
		int y[]=new plusOne66().plusOne(x);
		for(int a:y)
		{
			System.out.println(a);
		}
	}
	
	public int[] plusOne(int[] digits) {
        int carry=1;
        for(int i=digits.length-1;i>=0;i--)
        {
        	int sum=digits[i]+carry;
        	carry=sum/10;
        	digits[i]=sum%10;
        }
        if(carry==1)
        {
        	int x[]=new int[digits.length+1];
        	x[0]=1;
        	return x;
        }
        else
        {
        	return digits;
        }
    }
}
