package Problems_II;

import Creation_Print_Binary_Trees.Binary_Tree;
import Creation_Print_Binary_Trees.Create_Binary_Trees;

public class Mirror_Binary_Tree {

	public static void main(String[] args) {
		Binary_Tree<Integer> root = Create_Binary_Trees.takesInputFromUserBetter(true, 0, false);
		mirrorBinaryTree(root);
		Create_Binary_Trees.printTreeSecondMethod(root);
	}

	private static void mirrorBinaryTree(Binary_Tree<Integer> root) {
		if(root == null)
			return;
		Binary_Tree<Integer> temp = root.left;
		root.left = root.right;
		root.right = temp;
		mirrorBinaryTree(root.left);
		mirrorBinaryTree(root.right);
	}
}

//      1   
//   2     3
// 4   5 6   7