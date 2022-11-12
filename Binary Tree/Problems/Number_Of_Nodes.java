package Problems;

import Creation_Print_Binary_Trees.Binary_Tree;
import Creation_Print_Binary_Trees.Create_Binary_Trees;

public class Number_Of_Nodes {

	public static void main(String[] args) {

		Binary_Tree<Integer> root = Create_Binary_Trees.takesInputFromUserBetter(true, 0, true);
		int nodes = noOfNodes(root);
		System.out.println(nodes);
	}

	public static int noOfNodes(Binary_Tree<Integer> root) {
		if(root == null)
			return 0;
        
		int leftNodes = noOfNodes(root.left);
		int rightNodes = noOfNodes(root.right);
		return leftNodes + rightNodes + 1;
	}

}

//       1
//     2     3  
//   4   5 6   7