package Problems;

import Creation_Print_Binary_Trees.Binary_Tree;
import Creation_Print_Binary_Trees.Create_Binary_Trees;

public class Nodes_Without_Sibling {

	public static void main(String[] args) {
		Binary_Tree<Integer> root = Create_Binary_Trees.takesInputFromUserBetter(true, 0, false);
		printNodesWithoutSibling(root);
	}

	private static void printNodesWithoutSibling(Binary_Tree<Integer> root) {
		if(root == null)
			return;
		if(root.left != null || root.right != null) {
			if(root.left != null && root.right == null)
				System.out.print(root.left.data + " ");
			else if(root.left == null && root.right != null)
				System.out.print(root.right.data + " ");
		}
		printNodesWithoutSibling(root.left);
		printNodesWithoutSibling(root.right);		
	}
}

//        2
//     4     5
//   6          7
// 20  30    80   90
