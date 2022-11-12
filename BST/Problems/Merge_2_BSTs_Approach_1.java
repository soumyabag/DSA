package Problems;

import java.util.ArrayList;

import BST_Class.Binary_Tree;

public class Merge_2_BSTs_Approach_1 {

    static void inorder(Binary_Tree<Integer> root, ArrayList<Integer> list){
        if(root == null)
            return;
        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);
    }

    static void merge(ArrayList<Integer> list1, ArrayList<Integer> list2, ArrayList<Integer> mergeList){
        int i = 0, j = 0;
        int n1 = list1.size(), n2 = list2.size();
        while(i < n1 && j < n2){
            if(list1.get(i) <= list2.get(j)){
                mergeList.add(list1.get(i));
                i++;
            }else{
                mergeList.add(list2.get(j));
                j++;
            }
        }
        while(j < n2){
            mergeList.add(list2.get(j));
            j++;
        }
        while(i < n1){
            mergeList.add(list1.get(i));
            i++;
        }
    }

    static Binary_Tree < Integer > mergeBST(Binary_Tree < Integer > root1, Binary_Tree < Integer > root2) {

        // Write your code here.
        // Step -1 . To get inorders if trees
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        inorder(root1, list1);
        inorder(root2, list2);

        //Step -2. Merge Two Sorted Arrays
        ArrayList<Integer> mergeList = new ArrayList<>();
        merge(list1, list2, mergeList);

        // Create Tree From Merged Inorder
        return helper(mergeList, 0, mergeList.size()-1);
    }

    static Binary_Tree<Integer> helper(ArrayList<Integer> mergeList, int start, int end){
        if(start > end)
            return null;
        int mid = (start+end)/2;
        Binary_Tree<Integer> root = new Binary_Tree<Integer>(mergeList.get(mid));
        root.left = helper(mergeList, start, mid-1);
        root.right = helper(mergeList, mid+1, end);
        return root;
    }

}
