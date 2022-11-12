package Problems;

import Creation_Print_Binary_Trees.Binary_Tree;
import Creation_Print_Binary_Trees.Create_Binary_Trees;

public class Sum_Of_Nodes {

	public static void main(String[] args) {
		
		Binary_Tree<Integer> root = Create_Binary_Trees.takesInputFromUserBetter(true, 0, false);
		int sumOfNodes = sumOfNodes(root);
        System.out.println(sumOfNodes);
	}
	
	public static int sumOfNodes(Binary_Tree<Integer> root) {
		if(root == null)
			return 0;
		int leftSum = sumOfNodes(root.left);
		int rightSum = sumOfNodes(root.right);
		return root.data + leftSum + rightSum;
	}

}

//       10
//    20    30
//  40   50