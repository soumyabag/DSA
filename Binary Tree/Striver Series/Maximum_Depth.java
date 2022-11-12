package Striver_Series;

import Creation_Print_Binary_Trees.Binary_Tree;

class Height{
	public int height;
	Height(int height){
		this.height = height;
	}
}

public class Maximum_Depth {

	public int maxDepth(Binary_Tree<Integer> root) {
		Height ans = maximumDepth(root);
		return ans.height;
	}

	public Height maximumDepth(Binary_Tree<Integer> root){
		if(root == null){
			Height ans = new Height(0);
			return ans;
		}

		Height leftOutput = maximumDepth(root.left);
		Height rightOutput = maximumDepth(root.right);

		int height = 1 + Math.max(leftOutput.height, rightOutput.height);

		Height ans = new Height(height);
		return ans;
	}

}
