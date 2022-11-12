package Striver_Series;

import java.util.ArrayList;
import java.util.List;

import Creation_Print_Binary_Trees.Binary_Tree;
import Creation_Print_Binary_Trees.Create_Binary_Trees;

public class Morris_InOrder_Traversal {

	public static void main(String[] args) {
		Binary_Tree<Integer> root = Create_Binary_Trees.takesInputFromUserBetter(true, 0, false);
        List<Integer> result = morrisInorder(root);
        System.out.println(result);
	}

	public static List<Integer> morrisInorder(Binary_Tree<Integer> root){
		List<Integer> ans = new ArrayList<>();
        Binary_Tree<Integer> current = root;

		while(current != null){
			if(current.left == null){
				ans.add(current.data);
				current = current.right;
			}
			else{
				Binary_Tree<Integer> temp = current.left;
				while(temp.right != null && temp.right != current){
					temp = temp.right;
				}
				if(temp.right == null){
					temp.right = current;
					current = current.left;
				}
				else{
					temp.right = null;
					ans.add(current.data);
					current = current.right;
				}
			}
		}
		return ans;
	}

}
