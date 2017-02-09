//https://leetcode.com/problems/mini-parser/
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
package Stack;
import java.util.*;
public class NestedIntegerQuestion{
    public NestedInteger deserialize(String s) {
        return sub(s,0,s.length()-1);
    }
    
    public NestedInteger sub(String s,int start,int end)
    {
    	NestedInteger ans=new NestedInteger();
    	start=start+1;
    	end=end-1;
    	char c;
    	for(int i=start;i<=end;i++)
    	{
    		c=s.charAt(i);
    		if(Character.isDigit(c))
    		{
    			int numStart=i;
    			while(Character.isDigit(s.charAt(i)))
    			{
    				i++;
    			}
    			int x=Integer.parseInt(s.substring(numStart, i));
    		}
    	}
    }
    
}