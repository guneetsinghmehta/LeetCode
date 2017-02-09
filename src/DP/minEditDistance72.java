package DP;
//https://leetcode.com/problems/edit-distance/
public class minEditDistance72 {
	public static void main(String args[])
	{
		System.out.println(new minEditDistance72().minDistance(new String("abcd"), new String("abef")));
	}
	
	public int minDistance(String word1, String word2) {
		int x[][]=new int[word1.length()+1][word2.length()+1];
		for(int i=1;i<x.length;i++)
		{
			for(int j=1;j<x[0].length;j++)
			{
				int ans=0;
				if(word1.charAt(i-1)==word2.charAt(j-1))
				{
					ans=x[i-1][j-1];
				}
				else
				{
					ans=x[i-1][j-1]+1;
				}
				ans=ans>x[i][j-1]+1?x[i][j-1]+1:ans;
				ans=ans>x[i-1][j]+1?x[i-1][j]+1:ans;
				x[i][j]=ans;
			}
		}
		return x[word1.length()][word2.length()];
	}
}
