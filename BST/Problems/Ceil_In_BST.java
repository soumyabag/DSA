package Problems;

import Creation_Print_Binary_Trees.Binary_Tree;

public class Ceil_In_BST {

	int findCeil(Binary_Tree<Integer> root, int key) {
		if (root == null) return -1;

		int ceil = -1;
		
		while(root != null){
			if(root.data == key){
				ceil = root.data;
				break;
			}
			else if(root.data > key){
				ceil = root.data;
				root = root.left;
			}
			else{
				root = root.right;
			}
		}
		return ceil;
	}

}
