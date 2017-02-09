package HashTable;
import java.util.*;
//https://leetcode.com/problems/happy-number/
public class HappyNumber202 {
	public static void main(String args[])
	{
		System.out.println(new HappyNumber202().isHappy(19));
	}
	
	HashSet<Integer> set;
	public boolean isHappy(int n) {
		if(n==1){return true;}
		if(set==null){set=new HashSet<Integer>();}
		if(set.contains(n)){return false;}
		else
		{
			set.add(n);
			String str=Integer.toString(n);
			int x=0;
			for(int i=0;i<str.length();i++)
			{
				int y=str.charAt(i)-48;
				x+=y*y;
			}
			return isHappy(x);
		}
	}
}
