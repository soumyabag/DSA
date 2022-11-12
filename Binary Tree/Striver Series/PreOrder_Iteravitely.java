package Striver_Series;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import Creation_Print_Binary_Trees.Binary_Tree;

public class PreOrder_Iteravitely {

	public List<Integer> preorderTraversal(Binary_Tree<Integer> root) {
		List<Integer> ans = new ArrayList<>();
		preorder(root,ans);
		return ans;
	}

	public void preorder(Binary_Tree<Integer> root, List<Integer> ans) {
		if(root == null)
			return;

		Stack<Binary_Tree<Integer>> stack = new Stack<>();
		stack.push(root);

		while(!stack.isEmpty()){
			Binary_Tree<Integer> temp = stack.pop();
			ans.add(temp.data);
			if(temp.right != null)
				stack.push(temp.right);
			if(temp.left != null)
				stack.push(temp.left);
		}
	}

}
