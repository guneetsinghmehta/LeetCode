package Strings;
//
import java.util.*;
public class generateParenthesis22 {
	public static void main(String args[]) {
		new generateParenthesis22().generateParenthesis(3);
	}
	List<String> list;
	public List<String> generateParenthesis(int n) {
		list=new ArrayList<String>();
		backTrack(new String(""),0,0,n);
		return list;
	}
	
	public void backTrack(String str,int open,int close,int max)
	{
		if(open==max&&close==max)
		{
			list.add(str);
		}
		if(open<max)
		{
			backTrack(str+"(",open+1,close,max);
		}
		if(close<max&&open>close)
		{
			backTrack(str+")",open,close+1,max);
		}
	}
}