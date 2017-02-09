package Strings;
//https://leetcode.com/problems/text-justification/
import java.util.*;
public class textJustification68 {
	public static void main(String args[]) {
		String str=new String("List to many speak to a few");
		String strs[]=str.split(new String("\\s+"));
		new textJustification68().fullJustify(strs, 6);
	}
	
	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> ans=new ArrayList<String>();
		for(int i=0;i<words.length;i++)
		{
			int currentLength=words[i].length();
			List<String> tempList=new ArrayList<String>();
			tempList.add(words[i]);
			while(i+1<words.length&&currentLength+1+words[i+1].length()<=maxWidth)
			{
				tempList.add(words[i+1]);
				currentLength+=1+words[i+1].length();
				i++;
			}
			if(i<words.length-1)
			{
				ans.add(getSentence(tempList,maxWidth,currentLength-tempList.size()+1));
			}
			else
			{
				StringBuilder sb=new StringBuilder();
				for(int j=0;j<tempList.size();j++)
				{
					sb.append(tempList.get(j));
					if(sb.length()<maxWidth)
					{
						sb.append(" ");
					}
				}
				while(sb.length()<maxWidth)
				{
					sb.append(" ");
				}
				ans.add(sb.toString());
			}
		}
		return ans;
    }
	
	public String getSentence(List<String> list,int width,int currentLength)
	{
		if(list.size()==1){return list.get(0)+getSpaces(width-list.get(0).length());}
		int spaces=width-currentLength;
		int eachSpace=spaces/(list.size()-1);
		int extraSpace=spaces-eachSpace*(list.size()-1);
		StringBuilder sb=new StringBuilder();
		sb.append(list.get(0));
		for(int i=0;i<list.size()-1;i++)
		{
			if(i<extraSpace)
			{
				sb.append(getSpaces(eachSpace+1));
			}
			else
			{
				sb.append(getSpaces(eachSpace));
			}
			sb.append(list.get(i+1));
		}
		return sb.toString();
	}
	
	public String getSpaces(int n)
	{
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<n;i++){sb.append(" ");}
		return sb.toString();
	}
}
