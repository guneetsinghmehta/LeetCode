package Strings;
//https://leetcode.com/problems/reverse-vowels-of-a-string/
import java.util.*;
public class reverseVowels345 {
	public static void main(String args[]) {
		System.out.println(new reverseVowels345().reverseVowels(new String("leet code")));
	}
	
	public String reverseVowels(String s) {
        HashSet<Character> set=new HashSet<Character>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        StringBuilder sb=new StringBuilder();
        char c;
        for(int i=0;i<s.length();i++)
        {
            c=s.charAt(i);
            if(set.contains(c)){sb.append(c);}
        }
        String vowels=sb.reverse().toString();
        sb=new StringBuilder();
        int count=0;
        for(int i=0;i<s.length();i++)
        {
            c=s.charAt(i);
            if(set.contains(c))
            {
                sb.append(vowels.charAt(count++));
            }
            else
            {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
