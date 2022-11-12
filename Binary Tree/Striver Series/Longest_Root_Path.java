package Striver_Series;

import java.util.ArrayList;

import Creation_Print_Binary_Trees.Binary_Tree;
import Creation_Print_Binary_Trees.Create_Binary_Trees;

public class Longest_Root_Path {

    public static void main(String[] args) {
        Binary_Tree<Integer> root = Create_Binary_Trees.takesInputFromUserBetter(true, 0, false);
        ArrayList<Integer> list = longestRootPath(root);
        System.out.println(list);
    }

    private static ArrayList<Integer> longestRootPath(Binary_Tree<Integer> root) {
        if(root == null)
            return new ArrayList<>();
        
        ArrayList<Integer> left = longestRootPath(root.left);
        ArrayList<Integer> right = longestRootPath(root.right);

        if(left.size() >= right.size()) {
            left.add(root.data);
            return left;
        }
        else {
            right.add(root.data);
            return right;
        }
    }
}
