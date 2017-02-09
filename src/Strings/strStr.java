package Strings;

public class strStr {
	public static void main(String args[])
	{
		System.out.println(new strStr().strStr(new String("aabca"), new String("abc")));
	}
	
	public int strStr(String haystack, String needle) {
		int ans=-1;
		if(haystack.contains(needle))
		{
			ans=haystack.indexOf(needle);
		}
		return ans;
	}
	
}
