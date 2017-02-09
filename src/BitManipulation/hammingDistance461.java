package BitManipulation;
//https://leetcode.com/problems/hamming-distance/
public class hammingDistance461 {
	public static void main(String args[]) {
		System.out.println(new hammingDistance461().hammingDistance(1, 4));
	}
	
	public int hammingDistance(int x, int y) {
		int ans=0;
		for(int i=0;i<32;i++)
		{
			int a=(x>>i)&1;
			int b=(y>>i)&1;
			if(a!=b){ans++;}
		}
		return ans;
    }
}
