package Problems;

import Creation_Print_Binary_Trees.Binary_Tree;
import Creation_Print_Binary_Trees.Create_Binary_Trees;

public class Is_Node_Present {

	public static void main(String[] args) {
		Binary_Tree<Integer> root = Create_Binary_Trees.takesInputFromUserBetter(true, 0, false);		
        boolean result = isNodePresent(root,7);
        System.out.println(result);
	}

	private static boolean isNodePresent(Binary_Tree<Integer> root, int x) {
		if(root == null)
            return false;
        if(root.data == x)
            return true;
        boolean left = isNodePresent(root.left,x);
        boolean right = isNodePresent(root.right,x);
        return left || right;
	}

}
