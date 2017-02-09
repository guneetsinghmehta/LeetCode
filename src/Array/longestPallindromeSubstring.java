package Array;
//https://leetcode.com/problems/longest-palindromic-substring/
public class longestPallindromeSubstring {
	public static void main(String args[])
	{
		System.out.println(new longestPallindromeSubstring().longestPalindrome(new String("cbbd")));
	}
	int lo;
	int maxlen;
	public String longestPalindrome(String s) {
		String ans=null,temp;
		int i,j;
		lo=0;
		maxlen=0;
		for(i=0;i<s.length();i++)
		{
			sub(s,i,i);
			sub(s,i,i+1);
		}
		return s.substring(lo,lo+maxlen);
    }
	
	public void sub(String s,int i,int k)
	{
		while(i>=0&&k<s.length()&&s.charAt(i)==s.charAt(k))
		{
			i--;
			k++;
		}
		if(maxlen<k-i-1)
		{
			lo=i+1;
			maxlen=k-i-1;
		}
	}
}
