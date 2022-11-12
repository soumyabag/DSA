package Problems;

import Creation_Print_Binary_Trees.Binary_Tree;
import Creation_Print_Binary_Trees.Create_Binary_Trees;

public class Number_Of_Leaf_Nodes {

	public static void main(String[] args) {
		Binary_Tree<Integer> root = Create_Binary_Trees.takesInputFromUserBetter(true, 0, false);
		int result = noOfLeafNodes(root);
        System.out.println(result);
	}

	public static int noOfLeafNodes(Binary_Tree<Integer> root) {
		if(root == null)
			return 0;
//		if(root.left == null && root.right == null)
//			return 1;
		int leftNoOfLeafNodes = noOfLeafNodes(root.left);
		int rightNoOfLeafNodes = noOfLeafNodes(root.right);
		if(root.left == null && root.right == null)
			return 1;
		return leftNoOfLeafNodes + rightNoOfLeafNodes;
	}
}

//     1
//    2   3
//  4   5   6