package Striver_Series;

import java.util.ArrayList;

import Creation_Print_Binary_Trees.Binary_Tree;
import Creation_Print_Binary_Trees.Create_Binary_Trees;

public class Lowest_Common_Ancestor_Binary_Tree {

	public static void main(String[] args) {
		Binary_Tree<Integer> root = Create_Binary_Trees.takesInputFromUserBetter(true, 0, false);
		Binary_Tree<Integer> ans = lowestCommonAncestor(root, 5, 4);
		System.out.println(ans.data);
	}

	private static Binary_Tree<Integer> lowestCommonAncestor(Binary_Tree<Integer> root, int p, int q) {
		ArrayList<Binary_Tree<Integer>> pPath = getPathToP(root,p);
		ArrayList<Binary_Tree<Integer>> qPath = getPathToQ(root,q);
		int i = 0, j = 0, k = 0;
		//  3 5
		//  3 1
		while(i < pPath.size() && j < qPath.size()) {
			if(pPath.get(i) == qPath.get(j)) {
				k = i;
				i++;
				j++;
			}
			else {
				break;
			}
		}
		return pPath.get(k);
	}
	
	private static ArrayList<Binary_Tree<Integer>> getPathToQ(Binary_Tree<Integer> root, int q) {
		ArrayList<Binary_Tree<Integer>> pathOfQ = new ArrayList<>();
		getPath(root, q, pathOfQ);
		return pathOfQ;
	}

	private static ArrayList<Binary_Tree<Integer>> getPathToP(Binary_Tree<Integer> root, int p){
		ArrayList<Binary_Tree<Integer>> pathOfP = new ArrayList<>();
		getPath(root, p, pathOfP);
		return pathOfP;
	}

	private static boolean getPath(Binary_Tree<Integer> root, int p, ArrayList<Binary_Tree<Integer>> path) {
		
		if(root == null)
			return false;
		
		path.add(root);
		if(root.data == p)
			return true;
		
		if(getPath(root.left, p, path) || getPath(root.right, p, path))
			return true;
		
		path.remove(path.size() - 1);
		return false;
	}

}
