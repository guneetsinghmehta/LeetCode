//https://leetcode.com/problems/trapping-rain-water/
package Stack;
import java.util.*;
public class trappingWater{
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int height[]={0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(new trappingWater().trap(height));
	}
	
	public int trap(int[] height)
	{
		int ans=0;
		Stack<Integer> stack=new Stack<Integer>();
		int removeArea=0;
		for(int i=0;i<height.length;i++)
		{
			if(stack.isEmpty()||height[stack.peek()]>height[i])
			{
				stack.push(i);
			}
			else
			{
				while(!stack.isEmpty()&&height[i]>height[stack.peek()])
				{
					
				}
			}
		}
		return ans;
	}
}
