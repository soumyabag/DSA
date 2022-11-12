package Problems;

import Creation_Print_Binary_Trees.Binary_Tree;
import Creation_Print_Binary_Trees.Create_Binary_Trees;

public class Replace_Node_With_Depth {

	public static void main(String[] args) {
		Binary_Tree<Integer> root = Create_Binary_Trees.takesInputFromUserBetter(true, 0, false);
		changeToDepthTree(root);
	}

	private static void changeToDepthTree(Binary_Tree<Integer> root) {
		changeToDepth(root, 0);
		inorder(root);
	}

	private static void inorder(Binary_Tree<Integer> root) {
		if(root == null)
			return;
		inorder(root.left);
		System.out.println(root.data);
		inorder(root.right);
	}

	private static void changeToDepth(Binary_Tree<Integer> root, int depth) {
		if(root == null)
			return;
		root.data = depth;
		depth++;
		changeToDepth(root.left, depth);
		changeToDepth(root.right, depth);
	}
}

//      2
//   35   10
// 2   3 5   2

