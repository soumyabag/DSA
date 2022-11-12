package Striver_Series;

import Creation_Print_Binary_Trees.Binary_Tree;

public class Symmetric_Tree {

	public boolean isSymmetricHelper(Binary_Tree<Integer> left, Binary_Tree<Integer> right){
		if(left == null || right == null)
			return left==right;
		if(left.data != right.data)
			return false;
		return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
	}

	public boolean isSymmetric(Binary_Tree<Integer> root) {
		if(root == null)
			return true;        
		boolean result = isSymmetricHelper(root.left, root.right);        
		return result;
	}

}
