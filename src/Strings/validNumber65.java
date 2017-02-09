package Strings;
//https://leetcode.com/problems/valid-number/
public class validNumber65 {
	public static void main(String args[]) {
		String strs[]={"-1."};
		for(String str:strs)
		{
			System.out.println(new validNumber65().isNumber(str));
		}
	}
	
	public boolean isNumber(String str) {
		str=str.trim();
		if(str==null||str.length()==0){return false;}
		String strs[]=str.split(new String("\\s+"));
		if(strs.length>1){return false;}
		str=strs[0];
		int ePosition=-1;
		int dots=0;
		int dotPosition=-1;
		int plus=0;
		int plusPosition=-1;
		int neg=0;
		int negPosition=-1;
		for(int i=0;i<str.length();i++)
		{
			char c=str.charAt(i);
			int x=(int)c-48;
			if(c=='.'){dots++;dotPosition=i;}
			if(c=='+'){plus++;plusPosition=i;}
			if(c=='-'){neg++;negPosition=i;}
			if((x>=0&&x<=9)||c=='e'||c=='.'||c=='+'||c=='-')
			{
				if(c=='e')
				{
					if(ePosition==-1){ePosition=i;}
					else{return false;}
				}
			}
			else
			{
				return false;
			}
		}
		if(dots>1||neg>1||plus>1){return false;}
		if(plus>=1&&neg>=1){return false;}
		if(dotPosition<negPosition&&dotPosition!=-1&&negPosition!=-1){return false;}
		if(dotPosition<plusPosition&&dotPosition!=-1&&plusPosition!=-1){return false;}
		if(ePosition!=-1)
		{
			String str1=str.substring(0,ePosition);
			String str2=str.substring(ePosition+1,str.length());
			return isNumber(str1)&&isNumber(str2);
		}
		if(dotPosition!=-1)
		{
			String str1=str.substring(0,dotPosition);
			String str2=str.substring(dotPosition+1,str.length());
			return isNumber(str1)||isNumber(str2);
		}
		if(negPosition!=-1)
		{
			String str1=str.substring(0,negPosition);
			String str2=str.substring(negPosition+1,str.length());
			return !isNumber(str1)&&isNumber(str2);
		}
		if(plusPosition!=-1)
		{
			String str1=str.substring(0,plusPosition);
			String str2=str.substring(plusPosition+1,str.length());
			return !isNumber(str1)&&isNumber(str2);
		}
		return true;
    }
}
