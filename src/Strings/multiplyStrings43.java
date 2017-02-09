package Strings;

//https://leetcode.com/problems/multiply-strings/
public class multiplyStrings43 {
	public static void main(String args[]) {
		String str1 = new String("98");
		String str2 = new String("0");
		System.out.println(new multiplyStrings43().multiply(str1, str2));
	}

	public String multiply(String num1, String num2) {
		String ans = new String("0");
		if (num1 == null || num1.length() == 0 || num2 == null
				|| num2.length() == 0) {
			return ans;
		}
		if (num1.equals(new String("0")) || num2.equals(new String("0"))) {
			return ans;
		}
		for (int i = num1.length() - 1; i >= 0; i--) {
			String temp = multSingle(num2, num1.charAt(i));
			temp = shift(temp, num1.length() - 1 - i);
			ans = add(ans, temp);
		}
		return ans;
	}

	public static String shift(String temp, int x) {
		StringBuilder sb = new StringBuilder();
		sb.append(temp);
		while (x-- > 0) {
			sb.append(0);
		}
		return sb.toString();
	}

	public static String multSingle(String str1, char c) {
		String ans = new String("0");
		if (str1 == null || str1.length() == 0) {
			return ans;
		}
		int x = c - 48;
		while (x-- > 0) {
			ans = add(ans, str1);
		}
		return ans;
	}

	public static String add(String str1, String str2) {
		if (str1 == null || str1.length() == 0) {
			return str2;
		}
		if (str2 == null || str2.length() == 0) {
			return str1;
		}
		int a = str1.length() - 1;
		int b = str2.length() - 1;
		int carry = 0, sum, x, y;
		StringBuilder sb = new StringBuilder();
		while (a >= 0 && b >= 0) {
			x = str1.charAt(a) - 48;
			y = str2.charAt(b) - 48;
			sum = x + y + carry;
			sb.append(sum % 10);
			carry = sum / 10;
			a--;
			b--;
		}
		while (a >= 0) {
			x = str1.charAt(a) - 48;
			sum = x + carry;
			sb.append(sum % 10);
			carry = sum / 10;
			a--;
		}
		while (b >= 0) {
			y = str2.charAt(b) - 48;
			sum = y + carry;
			sb.append(sum % 10);
			carry = sum / 10;
			b--;
		}
		if (carry != 0) {
			sb.append(carry);
		}
		return sb.reverse().toString();
	}
}
