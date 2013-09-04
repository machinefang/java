import java.util.*;
public class TreeNode {
	public int data;
	public TreeNode left, right;
	TreeNode(int _data) {
		data = _data;
		left = null;
		right = null;
	}
	
	public static void inOrder(TreeNode root){
		if (root == null) return;
		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
	}
}
	