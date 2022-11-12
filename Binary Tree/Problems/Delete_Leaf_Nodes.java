package Problems_II;

import Creation_Print_Binary_Trees.Binary_Tree;
import Creation_Print_Binary_Trees.Create_Binary_Trees;

public class Delete_Leaf_Nodes {

	public static void main(String[] args) {
		Binary_Tree<Integer> root = Create_Binary_Trees.takesInputFromUserBetter(true, 0, false);
        Binary_Tree<Integer> newRoot = deleteLeafNodes(root);
        Create_Binary_Trees.printTreeSecondMethod(newRoot);
	}

	private static Binary_Tree<Integer> deleteLeafNodes(Binary_Tree<Integer> root) {
		if(root == null)
			return null;
		if(root.left == null && root.right == null)
			return null;
		root.left = deleteLeafNodes(root.left);
		root.right = deleteLeafNodes(root.right);
		return root;
	}
}

//    1
//  2   3
// 4      6
