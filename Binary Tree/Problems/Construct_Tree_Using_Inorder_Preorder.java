package Problems_II;

import java.util.HashMap;

import Creation_Print_Binary_Trees.Binary_Tree;

public class Construct_Tree_Using_Inorder_Preorder {
	
	static int preIndex = 0;
    static HashMap<Integer,Integer> map = new HashMap<>();

	public static void main(String[] args) {
		int preOrder[] = {1, 2, 4, 5, 3, 6, 7};
        int inOrder[] = {4, 2, 5, 1, 6, 3, 7};
        Binary_Tree<Integer> root = buildTree(preOrder, inOrder);
        Print_Level_Wise.printLevelWise(root);
	}

	private static Binary_Tree<Integer> buildTree(int[] preOrder, int[] inOrder) {
		for(int i = 0; i < inOrder.length; i++)
            map.put(inOrder[i], i);
        return buildTree(preOrder, inOrder, 0, inOrder.length - 1);
	}

	private static Binary_Tree<Integer> buildTree(int[] preOrder, int[] inOrder, int strtIndex, int endIndex) {
		
		if(strtIndex > endIndex)
            return null;
		
        int rootData = preOrder[preIndex++]; // 1
        Binary_Tree<Integer> node = new Binary_Tree<>(rootData);
        int rootIndex = map.get(rootData);  // 3
        
        node.left = buildTree(preOrder, inOrder, strtIndex, rootIndex - 1);
        node.right = buildTree(preOrder, inOrder, rootIndex + 1, endIndex);
        
        return node;
	}

}
