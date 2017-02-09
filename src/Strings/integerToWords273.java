package Strings;

import java.util.HashMap;

//https://leetcode.com/problems/integer-to-english-words/
public class integerToWords273 {
	public static void main(String args[]) {
		System.out.println(Integer.MAX_VALUE);
		System.out.println(new integerToWords273().numberToWords(1000));
	}
	
	public String numberToWords(int num) {
		HashMap<Integer,String> power=new HashMap<Integer,String>();
		HashMap<Integer,String> number=new HashMap<Integer,String>();
		power.put(0, new String(""));
		power.put(1, new String("Thousand"));
		power.put(2, new String("Million"));
		power.put(3, new String("Billion"));
		
		if(num==0){return new String("Zero");}
		String temp=new String("One Two Three Four Five Six Seven Eight Nine Ten Eleven Twelve Thirteen Fourteen Fifteen Sixteen Seventeen Eighteen Nineteen");
		String strs[]=temp.split(" ");
		for(int i=0;i<strs.length;i++)
		{
			number.put(i+1, strs[i]);
		}
		int i=20;
		HashMap<Integer,String> tens=new HashMap<Integer,String>();
		temp=new String("Twenty Thirty Forty Fifty Sixty Seventy Eighty Ninety");
		strs=temp.split(" ");
		int j=0;
		for(i=0;i<strs.length;i++)
		{
			tens.put(20+i*10,strs[i]);
		}
		tens.put(0, "");
		
		HashMap<Integer,String> ones=new HashMap<Integer,String>();
		temp=new String("One Two Three Four Five Six Seven Eight Nine");
		strs=temp.split(" ");
		j=0;
		for(i=0;i<strs.length;i++)
		{
			ones.put(i+1, strs[i]);
		}
		ones.put(0, "");
		
		for(i=20;i<1000;i++)
		{
			String str=new String("");
			int x=i;
			int a=x/100;
			int b=(x%100)/10;
			int c=((x%100)%10);
			if(a!=0)
			{
				str=str+ones.get(a)+" Hundred";
			}
			if(x%100>=20)
			{
			    if(b!=0)
			    {
			        str=str+" "+tens.get(b*10);    
			    }
				if(c!=0)
				{
					str=str+" "+ones.get(c);
				}
			}
			else
			{
				if(x%100!=0)
				{str=str+" "+number.get(x%100);}
			}
			number.put(i, str.trim());
		}
		
		String ans=new String("");
		int place=0;
		while(num>0)
		{
			if(num%1000!=0)
			{
				if(place==0)
				{ans=number.get(num%1000);}
				else
				{
					ans=number.get(num%1000)+" "+power.get(place)+" "+ans;
				}
			}
			num=num/1000;
			place++;
		}
		return ans.trim();
    }
}
