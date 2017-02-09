package Strings;

//https://leetcode.com/problems/count-and-say/
public class countAndSay38 {
	public static void main(String args[])
	{
		System.out.println(new countAndSay38().countAndSay(5));
	}
	
	public String countAndSay(int n) {
		String ans = new String("1");
		for (int i = 2; i <= n; i++) {
			//System.out.println(ans);
			ans = sub(ans);
		}
		return ans;
	}

	public String sub(String x) {
		int i = 0;
		int count;
		char c;
		StringBuilder sb = new StringBuilder();
		while (i < x.length()) {
			count = 0;
			c = x.charAt(i);
			while (i < x.length() && c == x.charAt(i)) {
				i++;
				count++;
			}
			sb.append(count);
			sb.append(c);
		}
		return sb.toString();
	}
}
