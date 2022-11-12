package Problems_II;

import Creation_Print_Binary_Trees.Binary_Tree;
import Creation_Print_Binary_Trees.Create_Binary_Trees;

public class Diameter_Of_Binary_Tree_Improved {

	public static void main(String[] args) {
		Binary_Tree<Integer> root = Create_Binary_Trees.takesInputFromUserBetter(true, 0, false);
        BinaryTreeHeightDiameter result = findDiameter(root);
        System.out.println(result.diameter);
	}

	private static BinaryTreeHeightDiameter findDiameter(Binary_Tree<Integer> root) {
		if(root == null) {
			int height = 0;
			int diameter = 0;
			BinaryTreeHeightDiameter ans = new BinaryTreeHeightDiameter();
			ans.height = height;
			ans.diameter = diameter;
			return ans;
		}
		
		BinaryTreeHeightDiameter leftOutput = findDiameter(root.left);
		BinaryTreeHeightDiameter rightOutput = findDiameter(root.right);
		
		int height = 1 + Math.max(leftOutput.height, rightOutput.height);
		int dist = 1 + leftOutput.height + rightOutput.height;
		int diameter =  Math.max(dist, Math.max(leftOutput.diameter, rightOutput.diameter));
		
		BinaryTreeHeightDiameter ans = new BinaryTreeHeightDiameter();
		ans.height = height;
		ans.diameter = diameter;
		return ans;
	}

}
