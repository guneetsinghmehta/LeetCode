package Tree;

public class recoverBinarySearchTree99 {
	public static void main(String args[]) {
		/*
		TreeNode root=new TreeNode(6);
		root.left=new TreeNode(2);
		root.left.left=new TreeNode(1);
		root.left.right=new TreeNode(3);
		
		root.right=new TreeNode(4);
		root.right.left=new TreeNode(5);
		root.right.right=new TreeNode(7);
		*/
		
		TreeNode root=new TreeNode(2);
		root.right=new TreeNode(1);
		
		inOrder(root);
		System.out.println();
		new recoverBinarySearchTree99().recoverTree(root);
		inOrder(root);
	}
	
	public static void inOrder(TreeNode root)
	{
		if(root==null){return;}
		inOrder(root.left);
		System.out.printf("%d ",root.val);
		inOrder(root.right);
	}
	
	TreeNode node1,node2,prevElement;
	public void recoverTree(TreeNode root) {
		prevElement=new TreeNode(Integer.MIN_VALUE);
		sub(root);
		int temp=node1.val;
		node1.val=node2.val;
		node2.val=temp;
    }
	
	public void sub(TreeNode root)
	{
		if(root==null){return;}
		sub(root.left);
		//start
		if(node1==null&&prevElement.val>=root.val)
		{
			node1=prevElement;
		}
		if(node1!=null&&prevElement.val>=root.val){
			node2=root;
		}
		prevElement=root;
		//end
		sub(root.right);
	}
}
