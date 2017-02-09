package Strings;
//https://leetcode.com/problems/word-ladder/
import java.util.*;
public class wordLadder127 {
	public static void main(String args[]) {
		String beginWord=new String("leet");
		String endWord=new String("code");
		String strAll=new String("lest leet lose code lode robe lost");
		String strs[]=strAll.split(new String("\\s+"));
		List<String> temp=new ArrayList<String>();
		for(String str:strs)
		{
			temp.add(str);
		}
		System.out.println(new wordLadder127().ladderLength(beginWord, endWord, temp));
		System.out.println(findComplement(6));
	}
	
	public static int findComplement(int num) {
        List<Integer> list=new ArrayList<Integer>();
        while(num>0)
        {
            if(num%2==0){list.add(1);}
            else{list.add(0);}
            num=num/2;
        }
        int x=0;
        
        for(int i=0;i<list.size();i++)
        {
            x+=list.get(i)*Math.pow(2,i);
        }
        return x;
    }
	
	HashMap<String,Integer> dp;
	HashMap<String,Boolean> visited;
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		dp=new HashMap<String,Integer>();
		visited=new HashMap<String,Boolean>();
		for(String word:wordList)
		{
			dp.put(word,0);
			visited.put(word, false);
		}
		visited.put(beginWord ,true);
		dp.put(beginWord,1);
		Queue<String> main=new LinkedList<String>();
		main.add(beginWord);
		int count=1;
		while(!main.isEmpty())
		{
			Queue<String> aux=new LinkedList<String>();
			count++;
			while(!main.isEmpty())
			{
				String x=main.remove();
				for(String y:wordList)
				{
					if(!visited.get(y)&&onlyOneDiff(x,y))
					{
						aux.add(y);
						dp.put(y, count);
						visited.put(y, true);
					}
				}
			}
			main=aux;
		}
		if(dp.containsKey(endWord))
		{
			return dp.get(endWord);
		}
		else
		{
			return 0;
		}
		
	}
	
	public boolean onlyOneDiff(String str1,String str2)
	{
		int changes=0;
		for(int i=0;i<str1.length();i++)
		{
			if(str1.charAt(i)!=str2.charAt(i)){changes++;}
		}
		if(changes==1){return true;}
		else{return false;}
	}
}
