//https://leetcode.com/problems/decode-string/
package Stack;
import java.util.*;
public class DecodeString {
	public static void main(String args[]) {
		String str=new String("2[abc]3[cd]ef");
		System.out.println(new DecodeString().decodeString(str,0,str.length()-1));
	}
	
    public String decodeString(String s,int startGlobal,int endGlobal) {
		StringBuilder sb=new StringBuilder();
		char c;
		for(int i=startGlobal;i<=endGlobal;i++)
		{
			c=s.charAt(i);
			if(Character.isLetter(c))
			{
				sb.append(c);
			}
			else if(c=='[')
			{
				int start=i;
				int sum=1;
				while(sum!=0)
				{
					i++;
					c=s.charAt(i);
					if(c=='['){sum++;}
					if(c==']'){sum--;}
				}
				int end=i;
				String temp=decodeString(s,start+1,end-1);
				int numIndexEnd=start-1;
				int numIndexStart=numIndexEnd;
				while(numIndexStart>=0&&Character.isDigit(s.charAt(numIndexStart)))
				{
					numIndexStart--;
				}
				int num=Integer.parseInt(s.substring(numIndexStart+1,numIndexEnd+1));
				while(num-->0)
				{
					sb.append(temp);
				}
			}
		}
		return sb.toString();
    }

}
