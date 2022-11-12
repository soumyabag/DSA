package Problems;

import Creation_Print_Binary_Trees.Binary_Tree;
import Creation_Print_Binary_Trees.Create_Binary_Trees;

public class InOrder_Binary_Tree {

	public static void main(String[] args) {
		Binary_Tree<Integer> root = Create_Binary_Trees.takesInputFromUserBetter(true, 0, false);
		inOrder(root);
	}

	public static void inOrder(Binary_Tree<Integer> root) {
		if(root == null)
			return;
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}
}

//       1
//    2     3
//  4  5  6   7
//left,root,right
//Output = 4 2 5 1 6 3 7

