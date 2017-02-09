package BitManipulation;
//https://leetcode.com/problems/bitwise-and-of-numbers-range/
import java.util.*;
public class AndNumberRange {
	public static void main(String args[]) {
		System.out.println(new AndNumberRange().rangeBitwiseAnd(4,7));
	}
	
	 public int rangeBitwiseAnd(int m, int n) {
		 int d=n-m;
		 //get the bit representation of m
		 int x[]=new int[32];
		 int y[]=new int[32];
		 int a=m,b=n;
		 for(int i=0;i<32;i++)
		 {
			 x[i]=a&1;
			 a=a>>1;
		 	y[i]=b&1;
		 	b=b>>1;
		 	x[i]=x[i]&y[i];
		 }
		 d=n-m;
		 for(int i=0;i<32;i++)
		 {
			 if(d>=Math.pow(2, i))
			 {
				 x[i]=0;
			 }
		 }
		 int ans=0;
		 for(int i=0;i<32;i++)
		 {
			 if(x[i]!=0)
			 {
				 ans=(int) (ans+Math.pow(2, i));
			 }
		 }
		 return ans;
		 //if d>power(2,i) - nullify that i
    }
}
