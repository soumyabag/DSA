package Problems;

import Creation_Print_Binary_Trees.Binary_Tree;
import Creation_Print_Binary_Trees.Create_Binary_Trees;

public class Search_In_BST {

	public static void main(String[] args) {
		Binary_Tree<Integer> root = Create_Binary_Trees.takesInputFromUserBetter(true, 0, false);
		boolean result = searchInBST(root, 8);
		System.out.println(result);
	}

	private static boolean searchInBST(Binary_Tree<Integer> root, int k) {
		if(root == null)
			return false;
		if(root.data == k)
			return true;
		boolean left = false;
		boolean right = false;
		if(k < root.data)
			left = searchInBST(root.left, k);
		else if(k >= root.data)
			right = searchInBST(root.right, k);

		return left || right;
	}

}
