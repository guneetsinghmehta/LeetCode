//https://leetcode.com/problems/container-with-most-water/
package Arrays;
import java.util.*;
public class maxArea {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int height[]={1,3,2,1,2,1};//ans should be 6
		System.out.println(new maxArea().maxArea(height));
	}
	
	 public int maxArea(int[] height) {
		 int i=0,j=height.length-1;
		 int h,ans=0;
		 while(i<j)
		 {
			 h=height[i]<height[j]?height[i]:height[j];
			 ans=ans<h*(j-i)?h*(j-i):ans;
			 while(i<j&&height[i]<=h){i++;}
			 while(i<j&&height[j]<=h){j--;}
		 }
		 return ans;
		 /*
		  //Slow
		 if(height.length<=1){return 0;}
		 int ans=0;
		 ArrayList<Integer> maxHeight=new ArrayList<Integer>();
		 maxHeight.add(0);
		 int h,w,k;
		 for(int i=1;i<height.length;i++)
		 {
			 for(int j=0;j<maxHeight.size();j++)
			 {
				 k=maxHeight.get(j);
				 h=height[i]<height[k]?height[i]:height[k];
				 w=i-k>0?i-k:k-i;
				 ans=ans<h*w?h*w:ans;
			 }
			 if(height[i]>maxHeight.get(maxHeight.size()-1))
			 {
				 maxHeight.add(i);
			 }
		 }
		 return ans;
		 */
		 /*
		  //Naive
		 int ans=0;
		 int h,w;
		 for(int i=0;i<height.length-1;i++)
		 {
			 for(int j=i+1;j<height.length;j++)
			 {
				 h=height[i]<height[j]?height[i]:height[j];
				 w=j-i;
				 ans=ans<h*w?h*w:ans;
			 }
		 }
		 return ans;
		 */
	 }
}
