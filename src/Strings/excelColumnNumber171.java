package Strings;
//https://leetcode.com/problems/excel-sheet-column-number/
public class excelColumnNumber171 {
	public static void main(String args[])
	{
		System.out.println(new excelColumnNumber171().titleToNumber(new String("A")));
	}
	
	public int titleToNumber(String s) {
	        int x=0;
	        for(int i=s.length()-1;i>=0;i--)
	        {
	            int temp=(int) ((s.charAt(i)-64)*Math.pow(26,(s.length()-1)-i));
	            x=x+temp;
	        }
	        return x;
	    }
}
