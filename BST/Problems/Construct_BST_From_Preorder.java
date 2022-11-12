package Problems;

import BST_Class.Binary_Tree;

public class Construct_BST_From_Preorder {

    int  i = 0;
    
    public Binary_Tree<Integer> bstFromPreorder(int[] preorder) {
        int max = Integer.MAX_VALUE;
        return helper(preorder, max);
    }

    public Binary_Tree<Integer> helper(int[] preorder, int max){
        if(i == preorder.length || preorder[i] > max)
            return null;
        Binary_Tree<Integer> root = new Binary_Tree<Integer>(preorder[i++]);
        root.left = helper(preorder, root.data);
        root.right = helper(preorder, max);
        return root;
    }

}
