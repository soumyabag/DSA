package Problems_II;

import Creation_Print_Binary_Trees.Binary_Tree;
import Creation_Print_Binary_Trees.Create_Binary_Trees;

public class Diameter_Of_Binary_Tree {

	public static void main(String[] args) {
		Binary_Tree<Integer> root = Create_Binary_Trees.takesInputFromUserBetter(true, 0, false);
        int diameter = findDiameter(root);
        System.out.println(diameter);
	}

	private static int findDiameter(Binary_Tree<Integer> root) {
		if(root == null)
			return 0;
		
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		
		int leftDiameter = findDiameter(root.left);
		int rightDiameter = findDiameter(root.right);
		
		return Math.max(1 + leftHeight + rightHeight,Math.max(leftDiameter, rightDiameter));
	}

	private static int height(Binary_Tree<Integer> root) {
		if(root == null)
			return 0;
		int left = height(root.left);
		int right = height(root.right);
		return 1 + Math.max(left, right);
	}
}
//      1
//    2   3
//   4 5 6 7