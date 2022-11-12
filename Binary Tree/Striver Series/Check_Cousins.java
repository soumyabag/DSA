package Striver_Series;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import Creation_Print_Binary_Trees.Binary_Tree;
import Creation_Print_Binary_Trees.Create_Binary_Trees;

public class Check_Cousins {

    public static void main(String[] args) {
        Binary_Tree<Integer> root = Create_Binary_Trees.takesInputFromUserBetter(true, 0, false);
        boolean ans = isCousin(root, 2, 3);
        System.out.println(ans);
    }

    private static boolean isCousin(Binary_Tree<Integer> root, int p, int q) {
        if(root == null)
            return false;
        
        // Step 1: Store The Parents In A Map
        Map<Integer, Binary_Tree<Integer>> childParentMap = new HashMap<>();
        mapping(root, childParentMap);
        
        // Step 2: Find Level Of p & q 
        int levelOfP = findLevel(root, p);
        int levelOfQ = findLevel(root, q);
        
        // Step 3: Check for Parent & Level
        if(levelOfP == levelOfQ && childParentMap.get(p) != childParentMap.get(q))
            return true;
        
        return false;
    }

    private static int findLevel(Binary_Tree<Integer> root, int x) {
        Queue<Binary_Tree<Integer>> q = new LinkedList<>();
        q.add(root);
        int level = 1;
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i<size; i++) {
                if(q.peek().data == x) {
                    return level;
                }
                if(q.peek().left != null)
                    q.add(q.peek().left);
                if(q.peek().right != null)
                    q.add(q.peek().right);
                q.poll();
            }
            level++;
        }
        return -1;
    }

    private static void mapping(Binary_Tree<Integer> root, Map<Integer, Binary_Tree<Integer>> childParentMap) {
        Queue<Binary_Tree<Integer>> q = new LinkedList<>();
        q.add(root);
        childParentMap.put(root.data, null);
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i<size; i++) {
                if(q.peek().left != null) {
                    childParentMap.put(q.peek().left.data, q.peek());
                    q.add(q.peek().left);
                }
                if(q.peek().right != null) {
                    childParentMap.put(q.peek().right.data, q.peek());
                    q.add(q.peek().right);
                }
                q.poll();
            }
        }
    }

}
