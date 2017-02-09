package Maths;

import java.util.HashMap;

//https://leetcode.com/problems/integer-to-roman/
public class integerToRoman12 {
	public static void main(String args[]) {
		System.out.println(new integerToRoman12().intToRoman(345));
		System.out.println(123.00%1==0);
	}
	public String intToRoman(int num) {
		String M[]={"","M","MM","MMM"};
		String H[]={"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
		String T[]={"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
		String I[]={"","I","II","III","IV","V","VI","VII","VIII","IX"};
		return M[num/1000]+H[(num%1000)/100]+T[(num%100)/10]+I[(num%10)];
	}
	
	
}
