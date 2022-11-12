package Problems;

import java.util.ArrayList;

import BST_Class.Binary_Tree;

public class Flatten_BST_To_Sorted_List {
    
    //      10
    //     /  \
    //   6     12
    //  / \    / \
    // 2   8  11  15
    
    // Output : 
    //  2
    //   \
    //    6
    //     \
    //      8
    //       \
    //        10
    //         \  
    //          11
    //           \
    //            12
    //             \
    //              15
    
    public static void inorder(Binary_Tree<Integer> root, ArrayList<Binary_Tree<Integer>> list)
    {
        if(root == null)
            return;
        inorder(root.left, list);
        list.add(root);
        inorder(root.right, list);
    }
    public static Binary_Tree<Integer> flatten(Binary_Tree<Integer> root)
    {
        // Write your code here
        ArrayList<Binary_Tree<Integer>> list = new ArrayList<>();
        
        // Step - 1, store sorted order in list
        inorder(root, list);
        
        // Creating the Tree  
        Binary_Tree<Integer> newRoot = new Binary_Tree<>(list.get(0).data);
        Binary_Tree<Integer> temp = newRoot;
        for(int i = 1; i < list.size(); i++){
            temp.left = null;
            temp.right = new Binary_Tree<>(list.get(i).data);
            temp = temp.right;
        }
        temp.right = null;
        return newRoot;
    }
}
