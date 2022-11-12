package Problems;

import Creation_Print_Binary_Trees.Binary_Tree;
import Creation_Print_Binary_Trees.Create_Binary_Trees;

public class PreOrder_Binary_Tree {

	public static void main(String[] args) {
		
		Binary_Tree<Integer> root = Create_Binary_Trees.takesInputFromUserBetter(true, 0, false);
        preOrder(root);
	}
	
	public static void preOrder(Binary_Tree<Integer> root) {
		if(root == null)
			return;
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}

}

//     1
//   2     3
// 4  5  6   7
// root,left,right
// Output = 1 2 4 5 3 6 7