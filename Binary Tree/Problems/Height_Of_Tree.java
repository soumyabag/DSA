package Problems;

import Creation_Print_Binary_Trees.Binary_Tree;
import Creation_Print_Binary_Trees.Create_Binary_Trees;

public class Height_Of_Tree {

	public static void main(String[] args) {
		Binary_Tree<Integer> root = Create_Binary_Trees.takesInputFromUserBetter(true, 0, false);
		int height = height(root);
        System.out.println(height);
	}

	public static int height(Binary_Tree<Integer> root) {
		if(root == null)
			return 0;
		
		// 1. Take left height & height height 
		// 2. Take maximum between them and add with 1(for root node) 
		
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);		
		return 1 + Math.max(leftHeight, rightHeight);
	}
}

//        10
//      /    \
//    20      30
//  /    \
// 40    50
