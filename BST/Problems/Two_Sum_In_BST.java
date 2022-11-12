package Problems;

import java.util.HashSet;

import BST_Class.Binary_Tree;

public class Two_Sum_In_BST {

    // Approach - 2 
    
    HashSet<Integer> set = new HashSet<>();
    public boolean findTarget(Binary_Tree<Integer> root, int k) {
        if(root == null)
            return false;
        if(set.contains(k - root.data))
            return true;
        else
            set.add(root.data);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }
    
    // Approach - 1
    
    //  public boolean findTarget(TreeNode root, int k){
    //  ArrayList<Integer> list = new ArrayList<>();
    //  inorder(root, list);
    //  // 0 1 2 3 4 5
    //  // 2 3 4 5 6 7
    //  int i = 0, j = list.size() - 1;
    //  // i=0, j= 5
    //  while(i<j){
    //      int sum = list.get(i) + list.get(j); // sum = 9
    //      if(sum == k)
    //          return true;
    //      else if(sum > k)
    //          j--;
    //      else
    //          i++;
    //  }
    //  return false;
    //}

    //public void inorder(TreeNode root, ArrayList<Integer> list){
    //  if(root == null)
    //      return;
    //  inorder(root.left, list);
    //  list.add(root.val);
    //  inorder(root.right, list);
    //}

}
