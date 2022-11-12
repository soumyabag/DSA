package Problems;

import Creation_Print_Binary_Trees.Binary_Tree;

public class Check_Valid_BST {

	public static boolean isBST(Binary_Tree<Integer> root) {
		return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public static boolean isBST(Binary_Tree<Integer> root, int min, int max){
		if(root == null)
			return true;
		if(root.data > min && root.data < max){
			boolean left = isBST(root.left, min, root.data);
			boolean right = isBST(root.right, root.data, max);
			return left && right;
		}
		else
			return false;
	}

}
