package Problems;

import BST_Class.Binary_Tree;

public class Insert_Node_In_BST {

    public Binary_Tree<Integer>  insertIntoBST(Binary_Tree<Integer> root, int val) {
        if(root == null){
            Binary_Tree<Integer> newRoot = new Binary_Tree<Integer>(val);
            return newRoot;
        }
        if(root.data > val){
            root.left = insertIntoBST(root.left, val);
        }else{
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

}
