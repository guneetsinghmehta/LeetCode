package Strings;
//https://leetcode.com/problems/license-key-formatting/
public class licenseKeyFormatting482 {
	public static void main(String args[]) {
		String str=new String("A2-4A0r7-4k");
		int K=3;
		System.out.println(new licenseKeyFormatting482().licenseKeyFormatting(str, K));
	}
	
	public String licenseKeyFormatting(String str, int k) {
		str=str.replace("-", "");
		str=str.toUpperCase();
		StringBuilder sb=new StringBuilder();
		int left=str.length()-(str.length()/k)*k;
		if(left!=0)
		{
			for(int i=0;i<k-left;i++){sb.append('0');}
			sb.append(str);
			str=sb.toString();
			sb=new StringBuilder();
		}
		for(int i=0;i<str.length()/k;i++)
		{
			int start=i*k;
			int end=start+k;
			sb.append(str.substring(start, end));
			if(i!=str.length()/k-1)
			{
				sb.append('-');
			}
		}
		str=sb.toString();
		if(left!=0)
		{
			int index=k-left;
			str=str.substring(index);
		}
		return str;
    }
}
