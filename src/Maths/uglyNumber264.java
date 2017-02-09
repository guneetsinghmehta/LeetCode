package Maths;
//https://leetcode.com/problems/ugly-number-ii/
import java.util.*;
public class uglyNumber264 {
	public static void main(String args[]) {
		System.out.println(new uglyNumber264().nthUglyNumber(1600));
		System.out.println(new uglyNumber264().wordPattern(new String("abba"), new String("dog dog dog dog")));
	}
	
	public int nthUglyNumber(int n) {
		int coins,a,b,c;
		HashSet<Integer> set=new HashSet<Integer>();
		for(coins=0;coins<=29;coins++)
		{
			for(a=0;a<=coins;a++)
			{
				for(b=0;b<=coins-a;b++)
				{
					c=coins-a-b;
					if(c>14||b>20){continue;}
					int x=(int) (Math.pow(2, a)*Math.pow(3, b)*Math.pow(5, c));
					set.add(x);
				}
			}
		}
		Iterator it=set.iterator();
		ArrayList<Integer> list=new ArrayList<Integer>();
		while(it.hasNext())
		{
			list.add((Integer) it.next());
		}
		Collections.sort(list);
		return list.get(n-1);
    }
	
	public boolean wordPattern(String pattern, String str) {
        HashMap<Character,String> map=new HashMap<Character,String>();
        HashSet<String> set=new HashSet<String>();
        String strs[]=str.split("\\s+");
        if(strs.length!=pattern.length()){return false;}
        for(int i=0;i<pattern.length();i++)
        {
            char c=pattern.charAt(i);
            String x=strs[i];
            if(!map.containsKey(c))
            {
                if(!set.contains(x)){map.put(c, x);set.add(x);}
                else{return false;}
            }
            else
            {
                if(!map.get(c).equals(x)){return false;}
            }
        }
        return true;
    }
}
