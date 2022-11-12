package Problems;

import BST_Class.Binary_Tree;

class Pair{
    public int min;
    public int max;
    public int size;
    public Pair(int min, int max, int size){
        this.min = min;
        this.max = max;
        this.size = size;
    }
}

public class Largest_BST_In_BT {

    public static Pair helper(Binary_Tree<Integer> root){
        if(root == null){
            return new Pair(Integer.MAX_VALUE,Integer.MIN_VALUE,0);
        }
        Pair left = helper(root.left);
        Pair right = helper(root.right);

        if(root.data > left.max && root.data < right.min)
            return new Pair(Math.min(root.data, left.min), Math.max(root.data, right.max), left.size + right.size + 1);

        return new Pair(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.size, right.size));
    }

    public static int largestBST(Binary_Tree<Integer> root) {

        Pair ans = helper(root);
        return ans.size;
    }

}
