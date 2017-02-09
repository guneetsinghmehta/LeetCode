package Strings;

//https://leetcode.com/problems/add-binary/
public class addBinary67 {
	
	public static void main(String args[])
	{
		String str1=new String("11");
		String str2=new String("1");
		System.out.println(new addBinary67().addBinary(str1, str2));
	}
	
	public String addBinary(String str1, String str2) {
		if(str1==null||str1.length()==0){return str2;}
		if(str2==null||str2.length()==0){return str1;}
		int a=str1.length()-1;
		int b=str2.length()-1;
		int sum,carry=0,x,y;
		StringBuilder sb=new StringBuilder();
		while(a>=0&&b>=0)
		{
			x=str1.charAt(a)-48;
			y=str2.charAt(b)-48;
			sum=x+y+carry;
			sb.append(sum%2);
			carry=sum>=2?1:0;
			a--;
			b--;
		}
		while(a>=0)
		{
			x=str1.charAt(a)-48;
			sum=x+carry;
			sb.append(sum%2);
			carry=sum>=2?1:0;
			a--;
		}
		while(b>=0)
		{
			x=str2.charAt(b)-48;
			sum=x+carry;
			sb.append(sum%2);
			carry=sum>=2?1:0;
			b--;
		}
		if(carry==1)
		{
			sb.append(1);
		}
		return sb.reverse().toString();
	}
}
