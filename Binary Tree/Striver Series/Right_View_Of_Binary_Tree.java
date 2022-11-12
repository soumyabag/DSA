package Striver_Series;

import java.util.ArrayList;

import Creation_Print_Binary_Trees.Binary_Tree;

public class Right_View_Of_Binary_Tree {

	ArrayList<Integer> rightView(Binary_Tree<Integer> node) {
		//add code here.
		ArrayList<Integer> result = new ArrayList<>();
		if(node == null){
			return result;
		}
		rightViewLevelWise(node,0,result);
		return result;
	}

	void rightViewLevelWise(Binary_Tree<Integer> root, int level, ArrayList<Integer> result){
		if(root == null){
			return;
		}
		if(level == result.size()){
			result.add(root.data);
		}
		rightViewLevelWise(root.right, level + 1, result);            
		rightViewLevelWise(root.left, level + 1, result);            
	}

}
