package Problems;

import Creation_Print_Binary_Trees.Binary_Tree;

public class LCA_Of_BST {

	public Binary_Tree<Integer> lowestCommonAncestor(Binary_Tree<Integer> root, Binary_Tree<Integer> p, Binary_Tree<Integer> q) {
		if(root == null)
			return null;
		if(root.data > p.data && root.data > q.data)
			return lowestCommonAncestor(root.left, p, q);
		else if(root.data < p.data && root.data < q.data)
			return lowestCommonAncestor(root.right, p, q);
		else
			return root;
	}

}

// T.C. - O(H),   H - height of the tree
// S.C. - O(1)
