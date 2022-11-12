package Striver_Series;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Creation_Print_Binary_Trees.Binary_Tree;

public class Level_Order_Traversal {
	
	public List<List<Integer>> levelOrder(Binary_Tree<Integer> root) {
        List<List<Integer>> result = new ArrayList<>();        
        level(root, result);
        return result;
    }
    
    public void level(Binary_Tree<Integer> root, List<List<Integer>> result){
        if(root == null)
            return;
        List<Integer> ans = new ArrayList<>();
        Queue<Binary_Tree<Integer>> queue = new LinkedList<>();
        queue.add(root);
                
       while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            for(int i=0; i<levelNum; i++) {
                if(queue.peek().left != null) 
                    queue.add(queue.peek().left);
                if(queue.peek().right != null) 
                    queue.add(queue.peek().right);
                subList.add(queue.poll().data);
            }
            result.add(subList);
        }
    }

}
