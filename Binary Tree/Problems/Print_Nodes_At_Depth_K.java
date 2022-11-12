package Problems;

import Creation_Print_Binary_Trees.Binary_Tree;
import Creation_Print_Binary_Trees.Create_Binary_Trees;

public class Print_Nodes_At_Depth_K {

	public static void main(String[] args) {
		Binary_Tree<Integer> root = Create_Binary_Trees.takesInputFromUserBetter(true, 0, false);
        printNodesDepthK(root,2);
	}

	private static void printNodesDepthK(Binary_Tree<Integer> root, int k) {
		if(root == null)
			return;
		if(k == 0) {
			System.out.println(root.data);
			return;
		}
		printNodesDepthK(root.left, k - 1);
		printNodesDepthK(root.right, k - 1);
	}
}

//      1
//    2   3
//   4 5 6 7