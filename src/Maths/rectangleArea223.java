package Maths;

public class rectangleArea223 {
	public static void main(String args[]) {
		System.out.println(new rectangleArea223().computeArea(-2,-2,2,2,3,3,4,4));
		int n=Integer.MIN_VALUE;
		for(int i=0;i<32;i++)
		{
			System.out.printf("%d ",n&1);
			n=n>>1;
		}
	}
	
	 public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		 int areas=(C-A)*(D-B)+(G-E)*(H-F);
		 int left=Math.max(A, E);
		 int right=Math.min(C,G);
		 int top=Math.min(D, H);
		 int bottom=Math.max(B, F);
		 
		 int overlap=(right-left)*(top-bottom);
		 if(right<left||top<bottom){overlap=0;}
		 return areas-overlap;
	 }
	 
	 public static boolean isPowerOfFour(int num) {
	       if(num==1){return true;}
	       if(num>1&&((num&0xaaaaaaab)==0)){return true;}
	       return false;
	    }
}
