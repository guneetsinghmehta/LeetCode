package Greedy;
import java.util.Arrays;
//https://leetcode.com/problems/heaters/
public class heaters475 {
	public static void main(String args[]) {
		int houses[]={282475249,622650073,984943658,144108930,470211272,101027544,457850878,458777923};
		int heaters[]={823564440,115438165,784484492,74243042,114807987,137522503,441282327,16531729,823378840,143542612};
		System.out.println(new heaters475().findRadius(houses, heaters));
	}
	
	public int findRadius(int[] houses, int[] heaters) {
		Arrays.sort(houses);
		Arrays.sort(heaters);
		int ans=Integer.MIN_VALUE;
		int a=-1,b=0;
		int dist;
		for(int i=0;i<houses.length;i++)
		{
			int housePosition=houses[i];
			if(b==0&&housePosition<=heaters[0])
			{
				ans=Math.max(ans, heaters[0]-housePosition);
			}
			else if(a==heaters.length-1)
			{
				dist=Math.abs(housePosition-heaters[a]);
				ans=Math.max(ans, dist);
			}
			else  
			{
				if(a>=0&&b<heaters.length&&housePosition>=heaters[a]&&housePosition<=heaters[b])
				{
					dist=Math.min(housePosition-heaters[a], heaters[b]-housePosition);
					ans=Math.max(ans, dist);
				}
				else
				{
					a++;
					b++;
					i--;
				}
			}
		}
		return ans;
    }
}
