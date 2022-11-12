package Problems;

import Creation_Print_Binary_Trees.Binary_Tree;

public class Construct_BST {

	public static Binary_Tree<Integer> SortedArrayToBST(int[] arr, int n){
		return sortedArrayToBSTHelper(arr, n, 0, n-1);
	}

	public static Binary_Tree<Integer> sortedArrayToBSTHelper(int[] arr, int n, int start, int end){
		if(start > end)
			return null;
		int mid = (start + end) / 2;
		Binary_Tree<Integer> root = new Binary_Tree<>(arr[mid]);
		root.left = sortedArrayToBSTHelper(arr, n, start, mid - 1);
		root.right = sortedArrayToBSTHelper(arr, n, mid + 1, end);
		return root;
	}

}
