package Striver_Series;

import Creation_Print_Binary_Trees.Binary_Tree;
import Creation_Print_Binary_Trees.Create_Binary_Trees;

public class Lowest_Common_Ancestor_Binary_Tree_Approach2 {

	public static void main(String[] args) {
		Binary_Tree<Integer> root = Create_Binary_Trees.takesInputFromUserBetter(true, 0, false);
		Binary_Tree<Integer> ans = lowestCommonAncestor(root, 5, 4);
		System.out.println(ans.data);

	}

	private static Binary_Tree<Integer> lowestCommonAncestor(Binary_Tree<Integer> root, int p, int q) {
		if(root == null)
            return null;
        if(root.data == p || root.data == q)
            return root;
        Binary_Tree<Integer> left = lowestCommonAncestor(root.left, p, q);
        Binary_Tree<Integer> right = lowestCommonAncestor(root.right, p, q);
        
        if(left != null && right != null)
            return root;
        else if(left != null && right == null)
            return left;
        else
            return right;
	}

}
