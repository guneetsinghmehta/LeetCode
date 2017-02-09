package Maths;

public class numberDigitOne233 {
	public static void main(String args[]) {
		System.out.println(new numberDigitOne233().countDigitOne(10));
	}
	
	public int countDigitOne(int n) {
        if(n==0){return 0;}
        if(n>=1&&n<10){return 1;}
        int x=n,y=1;
        while(x>=10)
        {
        	y=y*10;
        	x=x/10;
        }
        if(x==1)
        {
        	return countDigitOne(y-1)+countDigitOne(n%y)+n-y+1;
        }
        else
        {
        	return x*countDigitOne(y-1)+countDigitOne(n%y)+y;
        }
    }
}
