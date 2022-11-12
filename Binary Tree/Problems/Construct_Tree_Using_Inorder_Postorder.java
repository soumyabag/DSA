package Problems_II;

import java.util.HashMap;

import Creation_Print_Binary_Trees.Binary_Tree;

public class Construct_Tree_Using_Inorder_Postorder {
	
	static HashMap<Integer,Integer> map = new HashMap<>();
	static int postIndex = 0;

	public static void main(String[] args) {
		int postOrder[] = {4, 5, 2, 6, 7, 3, 1};
        int inOrder[] = {4, 2, 5, 1, 6, 3, 7};
        Binary_Tree<Integer> root = buildTree(postOrder, inOrder);
        Print_Level_Wise.printLevelWise(root);
	}

	private static Binary_Tree<Integer> buildTree(int[] postOrder, int[] inOrder) {
		for(int i = 0; i < inOrder.length; i++)
            map.put(inOrder[i], i);
		postIndex = postOrder.length - 1;  // 6
        return buildTree(postOrder, inOrder, 0, inOrder.length - 1);
	}

	public static Binary_Tree<Integer> buildTree(int[] postOrder, int[] inOrder, int strtIndex, int endIndex){
		
		// base case
		if(strtIndex > endIndex)
			return null;
		
        int rootData = postOrder[postIndex--];  // 1
        Binary_Tree<Integer> root = new Binary_Tree<Integer>(rootData);  //   1
        int rootIndex = map.get(rootData);  // 3
        root.right = buildTree(postOrder, inOrder, rootIndex + 1, endIndex);
        root.left = buildTree(postOrder, inOrder, strtIndex, rootIndex - 1);
        return root;
    }
}
