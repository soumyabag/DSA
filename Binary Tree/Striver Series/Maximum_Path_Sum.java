package Striver_Series;

import Creation_Print_Binary_Trees.Binary_Tree;

public class Maximum_Path_Sum {

	public int maxPathSum(Binary_Tree<Integer> root) {
		int max[] = new int[1];
		max[0] = Integer.MIN_VALUE;
		int helper = maxPathSumHelper(root,max);
		return max[0];
	}    

	public int maxPathSumHelper(Binary_Tree<Integer> root, int[] max){
		if(root == null)
			return 0;
		int left = Math.max(0, maxPathSumHelper(root.left, max));
		int right = Math.max(0, maxPathSumHelper(root.right, max));

		max[0] = Math.max(max[0],root.data + left + right);
		return root.data + Math.max(left, right);
	}

}
