package Problems;

import java.util.Scanner;

import Creation_Print_Binary_Trees.Binary_Tree;
import Creation_Print_Binary_Trees.Create_Binary_Trees;

public class Nodes_Greater_Than_X {

	public static void main(String[] args) {
		Binary_Tree<Integer> root = Create_Binary_Trees.takesInputFromUserBetter(true, 0, false);
		int result= countNodesGreaterThanX(root,5);
        System.out.println(result);
	}

	private static int countNodesGreaterThanX(Binary_Tree<Integer> root, int x) {
		if(root == null)
			return 0;
		int leftNumberofNodes = countNodesGreaterThanX(root.left, x);
		int rightNumberOfNodes = countNodesGreaterThanX(root.right, x);
		if(root.data > x)
			return 1 + leftNumberofNodes + rightNumberOfNodes;
		else
		    return leftNumberofNodes + rightNumberOfNodes;
	}

}
