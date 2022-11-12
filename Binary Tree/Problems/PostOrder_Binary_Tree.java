package Problems;

import Creation_Print_Binary_Trees.Binary_Tree;
import Creation_Print_Binary_Trees.Create_Binary_Trees;

public class PostOrder_Binary_Tree {

	public static void main(String[] args) {
		Binary_Tree<Integer> root = Create_Binary_Trees.takesInputFromUserBetter(true, 0, false);
        postOrder(root);
	}
	
	public static void postOrder(Binary_Tree<Integer> root) {
		if(root == null)
			return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + " ");
	}
}

//       1
//    2     3
//  4  5  6   7
//left,right,root
//Output = 4 5 2 6 7 3 1
