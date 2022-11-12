package Problems;

import Creation_Print_Binary_Trees.Binary_Tree;

public class Replace_With_Sum_Of_Greater_Nodes {

	static int sum = 0;
	public static void replaceWithLargerNodesSum(Binary_Tree<Integer> root) {
		// Write your code here
		replace(root);
	}

	public static void replace(Binary_Tree<Integer> root){
		if(root == null)
			return;

		replace(root.right);

		root.data = root.data + sum;
		sum = root.data;

		replace(root.left);
	}

}
