package HashTable;
//https://leetcode.com/problems/repeated-dna-sequences/
import java.util.*;
public class repeatedDNASequence187 {
	public static void main(String args[]) {
		new repeatedDNASequence187().findRepeatedDnaSequences(new String("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
	}
	
	public List<String> findRepeatedDnaSequences(String str) {
        List<String> list=new ArrayList<String>();
        HashMap<String,Integer> map=new HashMap<String,Integer>();
        if(str.length()<10){return list;}
        for(int i=10;i<=str.length();i++)
        {
        	String temp=str.substring(i-10,i);
        	if(!map.containsKey(temp))
        	{
        		map.put(temp, 1);
        	}
        	else
        	{
        		map.put(temp, map.get(temp)+1);
        	}
        }
        for(String x:map.keySet())
        {
        	if(map.get(x)>=2){list.add(x);}
        }
        return list;
    }
}
