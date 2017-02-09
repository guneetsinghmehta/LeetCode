package Maths;

public class arithmeticSlices413 {
	public static void main(String args[]) {
		int x[]={1,2,3,4};
		System.out.println(new arithmeticSlices413().numberOfArithmeticSlices(x));
	}

	public int numberOfArithmeticSlices(int[] A) {
		if(A==null||A.length<=2){return 0;}
		int diff[]=new int[A.length-1];
		for(int i=0;i<diff.length;i++)
		{
			diff[i]=A[i+1]-A[i];
		}
		int i=0,j,ans=0;
		while(i<diff.length)
		{
			j=i+1;
			while(j<diff.length&&diff[j]==diff[i])
			{
				j++;
			}
			int x=j-i;
			ans+=(x*(x-1))/2;
			i=j;
		}
		return ans;
	}
}
