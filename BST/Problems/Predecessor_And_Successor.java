package Problems;

import java.util.ArrayList;

import Creation_Print_Binary_Trees.Binary_Tree;
import Creation_Print_Binary_Trees.Create_Binary_Trees;

public class Predecessor_And_Successor {

    public static void main(String[] args) {
        Binary_Tree<Integer> root = Create_Binary_Trees.takesInputFromUserBetter(true, 0, false);
        ArrayList<Integer> ans = predecessorSuccessor(root, 5);
        System.out.println(ans);
    }

    public static ArrayList<Integer> predecessorSuccessor(Binary_Tree<Integer> root, int key) {

        ArrayList<Integer> ans = new ArrayList<>();
        int succ = -1;
        int pre = -1;
        Binary_Tree<Integer> temp = root;
        while(temp.data != key) {
            if(temp.data > key) {
                succ = temp.data;
                temp = temp.left;
            }else {
                pre = temp.data;
                temp = temp.right;
            }
        }
        
        // Finding Predecessor
        Binary_Tree<Integer> left = temp.left; // 10
        while(left != null){
            pre = left.data; // 12
            left = left.right; // 12
        }
        
        // Findning Successor
        Binary_Tree<Integer> right = temp.right; // 20
        while(right != null){
            succ = right.data; // 16
            right = right.left; // null
        }
        ans.add(pre);
        ans.add(succ);
        return ans;
    }

}
