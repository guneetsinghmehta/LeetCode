package Maths;
//https://leetcode.com/problems/ugly-number/
public class uglyNumber263 {
	public static void main(String args[]) {

	}
	
	public boolean isUgly(int n) {
		if(n<=0){return false;}
        if(n==1){return true;}
		boolean ans=false;
		if(n%2==0){ans=ans||isUgly(n/2);}
		if(ans){return true;}
		if(n%3==0){ans=ans||isUgly(n/3);}
		if(ans){return true;}
		if(n%5==0){ans=ans||isUgly(n/5);}
		return ans;
    }
}
