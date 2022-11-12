package Problems_II;

import Creation_Print_Binary_Trees.Binary_Tree;
import Creation_Print_Binary_Trees.Create_Binary_Trees;

public class Check_Tree_Balanced_Or_Not {

	public static void main(String[] args) {
		Binary_Tree<Integer> root = Create_Binary_Trees.takesInputFromUserBetter(true, 0, false);
        boolean result = checkBalanced(root);
        System.out.println(result);
	}

	private static boolean checkBalanced(Binary_Tree<Integer> root) {
		if(root == null)
			return true;
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		int heightDifference = leftHeight - rightHeight;
		if(Math.abs(heightDifference) > 1)
			return false;
		boolean left = checkBalanced(root.left);
		boolean right = checkBalanced(root.right);
		return left && right;
	}

	private static int height(Binary_Tree<Integer> root) {
		if(root == null)
			return 0;
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		return 1 + Math.max(leftHeight, rightHeight);
	}
}
//   T.C. - O(n^2)   for worst case if tree is left sided/ right sided, example below
//          O(nlogn) for case of balanced tree
//   T.C. - O(n*h) , where h is height of the tree

//     1
//   2   
// 4 
//5