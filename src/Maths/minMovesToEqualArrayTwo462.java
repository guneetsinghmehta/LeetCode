package Maths;
//https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/
public class minMovesToEqualArrayTwo462 {
	public static void main(String args[]) {
		int x[]={1,2,3};
		System.out.println(new minMovesToEqualArrayTwo462().minMoves2(x));
	}
	
	public int minMoves2(int[] nums) {
		double sum=0;
		int n=nums.length;
		for(int i:nums){sum+=i;}
		int avg=(int) Math.round(sum/n);
		int ans=0;
		for(int i:nums){ans+=Math.abs(i-avg);}
		return ans;
    }
}
