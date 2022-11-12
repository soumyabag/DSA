package Striver_Series;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import Creation_Print_Binary_Trees.Binary_Tree;

public class InOrder_Iteratively {

	public List<Integer> inorderTraversal(Binary_Tree<Integer> root) {
		List<Integer> ans = new ArrayList<>();
		inorder(root, ans);
		return ans;
	}

	public void inorder(Binary_Tree<Integer> root, List<Integer> ans){
		if(root == null)
			return;
		Stack<Binary_Tree<Integer>> stack = new Stack<>();
		Binary_Tree<Integer> temp = root;

		while(true){
			if(temp != null){
				stack.push(temp);
				temp = temp.left;
			}
			else{
				if(stack.isEmpty() == true)
					break;
				temp = stack.pop();
				ans.add(temp.data);
				temp = temp.right;
			}
		}
	}

}
