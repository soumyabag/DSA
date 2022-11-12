package Problems;

import java.util.ArrayList;

import Creation_Print_Binary_Trees.Binary_Tree;

public class Find_Path_In_BST {

	public static ArrayList<Integer> getPath(Binary_Tree<Integer> root, int data){

		ArrayList<Integer> path = new ArrayList<>();
		if(root == null)
			return null;
		if(root.data == data){
			path.add(root.data);
		}
		if(root.data > data){
			ArrayList<Integer> leftPath = getPath(root.left, data);
			if(leftPath != null){
				leftPath.add(root.data);
				path.addAll(leftPath);
			}
			else
				return null;
		}
		else if(root.data < data){
			ArrayList<Integer> rightPath = getPath(root.right, data);
			if(rightPath != null){
				rightPath.add(root.data);
				path.addAll(rightPath);
			}
			else
				return null;
		}
		return path;
	}

}
