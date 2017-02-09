package Stack;
//https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
public class preorderSerialisation331 {
	public static void main(String args[]) {
		System.out.println(new preorderSerialisation331().isValidSerialization(new String("9,3,4,#,#,1,#,#,2,#,6,#,#")));
	}
	public boolean isValidSerialization(String preorder) {
		String strs[]=preorder.split(new String(","));
		int nodes=0;
		int leaves=0;
		for(int i=0;i<strs.length;i++)
		{
			if(strs[i].equals(new String("#")))
			{
				leaves++;
			}
			else
			{
				nodes++;
			}
			if(leaves>nodes&&i!=strs.length-1){return false;}
		}
		return true;
    }
}
