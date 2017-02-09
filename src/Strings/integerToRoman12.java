package Strings;
//https://leetcode.com/problems/integer-to-roman/
public class integerToRoman12 {
	public static void main(String args[]) {
		System.out.println(new integerToRoman12().intToRoman(3999));
	}
	
	StringBuilder sb;
	char alpha[];
	int value[];
	public String intToRoman(int num) {
		sb=new StringBuilder();
		char alpha2[]={'I','V','X','L','C','D','M'};
		int value2[]={1,5,10,50,100,500,1000};
		alpha=alpha2;
		value=value2;
		sub(num);
		return sb.toString();
    }
	
	public void sub(int n)
	{
		
	}
}
