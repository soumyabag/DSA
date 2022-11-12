package Striver_Series;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Creation_Print_Binary_Trees.Binary_Tree;

public class ZigZag_Level_Traversal {

	public List<List<Integer>> zigzagLevelOrder(Binary_Tree<Integer> root) {
		List<List<Integer>> result  = new ArrayList<>();
		if(root == null)
			return result;
		Queue<Binary_Tree<Integer>> queue = new LinkedList<>();
		queue.add(root);
		int flag = 0;

		while(!queue.isEmpty()){
			int queueSize = queue.size();
			List<Integer> list = new ArrayList<>();
			for(int i = 0; i < queueSize; i++){
				if(queue.peek().left != null)
					queue.add(queue.peek().left);
				if(queue.peek().right != null)
					queue.add(queue.peek().right);
				list.add(queue.poll().data);
			}
			if(flag == 0){
				result.add(list);
				flag++;
			}else{
				Collections.reverse(list);
				result.add(list);
				flag--;
			}
		}
		return result;
	}

}
