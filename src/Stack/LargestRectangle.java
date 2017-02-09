//https://leetcode.com/problems/largest-rectangle-in-histogram/
/*
 * Test as :
 * heights={2,1,5,6,2,3}
 * sol.largestRectangleArea(heights)
 * 
 */
package Stack;
import java.util.*;
public class LargestRectangle{
	
	public static void main(String args[]) {
		//int heights[]={2,1,5,6,2,3};
		//int heights[]={2,1,2};
		int heights[]={0,1,0,2,1,0,1,3,2,1,2,1};
		LargestRectangle sol=new LargestRectangle();
		System.out.println(sol.largestRectangleArea(heights));
	}
	
	public int largestRectangleArea(int[] heights) {
    	int ans=sub2(heights);
    	return ans;
    }
    
    public int sub2(int[] heights)
    {
    	int max=0;
    	if(heights!=null&&heights.length!=0)
    	{
    		heights=Arrays.copyOf(heights, heights.length+1);//inserting a zero- last element is smallest so will ensure that the stack is empty at end of function
    		Stack<Integer> stack=new Stack<Integer>();
    		for(int i=0;i<heights.length;i++)
    		{
    			while(!stack.isEmpty()&&heights[i]<heights[stack.peek()])
    			{
    				int h=heights[stack.pop()];
    				int w=stack.isEmpty()?i:i-stack.peek()-1;
    				max=Math.max(max, h*w);
    			}
    			stack.push(i);
    		}
    	}
    	return max;
    }
    
    public int sub(int[] heights,int start,int end)
    {
    	//Divide and Conquer
    	//base case
    	if(start>end){return 0;} 
    	if(start==end){return heights[start];}
    	//Get minIndex
    	int minIndex=start;
    	for(int i=start;i<=end;i++)
    	{
    		if(heights[minIndex]>heights[i])
    		{
    			minIndex=i;
    		}
    	}
    	// get area of left
    	int leftArea=sub(heights,start,minIndex-1);
    	// get right max area
    	int rightArea=sub(heights,minIndex+1,end);
    	// get area with min times size
    	int ans=heights[minIndex]*(end-start+1);
    	// return max of the three values
    	ans=(int)Math.max(ans,leftArea);
    	ans=(int)Math.max(ans,rightArea);
    	return ans;
    }
}