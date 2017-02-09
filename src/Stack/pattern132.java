package Stack;
import java.util.*;

class range
{
	int min;
	int max;
	public range(int min,int max)
	{
		this.min=min;
		this.max=max;
	}
	public String toString()
	{
		String ans=Integer.toString(this.min);
		ans=ans.concat(new String(" "));
		ans=ans.concat(Integer.toString(this.max));
		return ans;
	}
}

public class pattern132{
    public static void main(String args[])
    {
    	int nums[]={3,5,0,3,4};
    	System.out.println(new pattern132().find132pattern(nums));
    }
	
	public boolean find132pattern(int[] nums) {
		boolean ans=false;
		Stack<range> stack =new Stack<range>();
		for(int num:nums)
		{
			if(stack.isEmpty()){stack.push(new range(num,num));}
			else
			{
				range last=stack.pop();
				if(num<last.min)
				{
					stack.push(last);
					stack.push(new range(num,num));
				}
				else if(num>=last.min)
				{
					if(num<last.max){return true;}
					else if(num>=last.max){
						last.max=num;
						if(stack.isEmpty()){stack.push(last);}
						else
						{
							while(!stack.isEmpty()&&stack.peek().min>=last.min&&stack.peek().max<=last.max)
							{
								stack.pop();
							}
							if(stack.isEmpty()){stack.push(last);}
							else
							{
								if(last.min<stack.peek().min&&last.min>stack.peek().max){return true;}
							}
						}
					}
				}
			}
		}
		return ans;
    }
}