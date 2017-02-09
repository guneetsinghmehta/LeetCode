package BitManipulation;
//https://leetcode.com/problems/gray-code/
import java.util.*;
public class grayCode89 {
	public static void main(String args[]) {
		List<Integer> ans=new grayCode89().grayCode(2);
		for(int x:ans)
		{
			System.out.println(x);
		}
	}
	
	public List<Integer> grayCode(int n) {
        List<Integer> ans=new ArrayList<Integer>();
        for(int i=0;i<1<<n;i++){ans.add(i^(i>>1));}
        return ans;
    }
}
