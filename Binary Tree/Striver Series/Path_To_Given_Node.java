package Striver_Series;

import java.util.ArrayList;


import Creation_Print_Binary_Trees.Binary_Tree;
import Creation_Print_Binary_Trees.Create_Binary_Trees;

public class Path_To_Given_Node {

	public static void main(String[] args) {
		Binary_Tree<Integer> root = Create_Binary_Trees.takesInputFromUserBetter(true, 0, false);
        ArrayList<Integer> ans = pathToNode(root, 5);
        System.out.println(ans);
	}

	private static ArrayList<Integer> pathToNode(Binary_Tree<Integer> root, int givenNode) {
		ArrayList<Integer> ans = new ArrayList<>();
		if(root == null)
			return ans;
        pathToNodeHelper(root, givenNode, ans);
		return ans;
	}

	private static boolean pathToNodeHelper(Binary_Tree<Integer> root, int givenNode, ArrayList<Integer> ans) {
		if(root == null)
			return false;
		ans.add(root.data);
        if(root.data == givenNode)
        	return true;
        if(pathToNodeHelper(root.left, givenNode, ans) || pathToNodeHelper(root.right, givenNode, ans))
        	return true;
        ans.remove(ans.size() - 1);
		return false;        
	}

}
// [

//      1
//    /   \
//   2     3
//  / \   / \
// 4   5 6   7
// B = 5
// Output = [1,2,5]

//      1
//    /   \
//   2     3
//  / \   / \
// 4   5 6   7
//B = 1
//Output = [1]
