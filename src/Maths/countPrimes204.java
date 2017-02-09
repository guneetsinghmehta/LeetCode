package Maths;
//https://leetcode.com/problems/count-primes/
public class countPrimes204 {
	public static void main(String args[]) {
		System.out.println(new countPrimes204().countPrimes(8));
	}
	
	public int countPrimes(int n) {
		if(n<=1){return 0;}
		boolean visited[]=new boolean[n+1];
		visited[0]=true;
		visited[1]=true;
		for(int i=2;i<=n;i++)
		{
			if(!visited[i])
			{
				int jump=i;
				for(int j=i+jump;j<=n;j=j+jump)
				{
					visited[j]=true;
				}
			}
		}
		int count=0;
		for(boolean ans:visited)
		{
			if(!ans){count++;};
		}
		return count;
    }
}
