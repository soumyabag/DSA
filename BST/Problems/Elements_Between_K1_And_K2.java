package Problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Creation_Print_Binary_Trees.Binary_Tree;
import Creation_Print_Binary_Trees.Create_Binary_Trees;

public class Elements_Between_K1_And_K2 {
	
	public static void main(String[] args) {
		Binary_Tree<Integer> root = Create_Binary_Trees.takesInputFromUserBetter(true, 0, false);
		elementsInRangeK1K2(root, 6, 8);
	}

	public static void elementsInRangeK1K2(Binary_Tree<Integer> root,int k1,int k2){
		List<Integer> list = new ArrayList<>();
		elementsInRangeK1K2helper(root, k1, k2, list);
		for(int x : list)
			System.out.print(x+ " ");
	}

	private static void elementsInRangeK1K2helper(Binary_Tree<Integer> root, int k1, int k2, List<Integer> list) {
		
		if(root==null)
			return ;

		if(root.data < k1)
			elementsInRangeK1K2(root.right, k1, k2);
		else if(root.data > k2)
			elementsInRangeK1K2(root.left, k1, k2);
		else {
			list.add(root.data);
			elementsInRangeK1K2(root.left, k1, k2);
			elementsInRangeK1K2(root.right, k1, k2);
		}
		Collections.sort(list);
	}	
}
