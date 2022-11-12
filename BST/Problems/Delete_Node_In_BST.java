package Problems;

import Creation_Print_Binary_Trees.Binary_Tree;

public class Delete_Node_In_BST {

    int minEle = 0;
    public Binary_Tree<Integer> deleteNode(Binary_Tree<Integer> root, int key) {
        if(root == null)
            return null;
        if(root.data > key)
            root.left = deleteNode(root.left, key);
        else if(root.data < key)
            root.right = deleteNode(root.right, key);
        else{
            if(root.left == null && root.right == null)
                return null;
            else if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;
            else{
                root.data = findRightMinData(root);
                root.right = deleteNode(root.right, minEle);
            }
        }
        return root;
    }

    public int findRightMinData(Binary_Tree<Integer> root){
        Binary_Tree<Integer> temp = root.right;
        while(temp != null){
            minEle = temp.data;
            temp = temp.left;
        }
        return minEle;
    }

}
