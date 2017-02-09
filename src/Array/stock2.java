//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
package Arrays;
import java.util.*;
public class stock2 {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int x[]={1,2,3,1,2};
		System.out.println(new stock2().maxProfit(x));
	}
	
	public int maxProfit(int[] prices) {
        int profit=0;
        for(int i=0;i<prices.length-1;i++)
        {
        	if(prices[i+1]>prices[i])
        	{
        		profit=profit+prices[i+1]-prices[i];
        	}
        }
        return profit;
    }
}
