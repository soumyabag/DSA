package Striver_Series;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import Creation_Print_Binary_Trees.Binary_Tree;
import Creation_Print_Binary_Trees.Create_Binary_Trees;

public class Burning_Tree {

	public static void main(String[] args) {
		Binary_Tree<Integer> root = Create_Binary_Trees.takesInputFromUserBetter(true, 0, false);
		int time = minTime(root, 8);
		System.out.println(time);
	}

	private static int minTime(Binary_Tree<Integer> root, int target) {
		
		Map<Binary_Tree<Integer>, Binary_Tree<Integer>> nodeWithParentNode = new HashMap<>();
		Binary_Tree<Integer> node = createMap(root, nodeWithParentNode, target);
		
		int time = burnTree(node, nodeWithParentNode);
		return time;
	}

	private static int burnTree(Binary_Tree<Integer> node, Map<Binary_Tree<Integer>, Binary_Tree<Integer>> nodeWithParentNode) {
		int time = 0;
		Map<Binary_Tree<Integer>, Integer> visitedNodes = new HashMap<>();
		Queue<Binary_Tree<Integer>> q = new LinkedList<>();
		
		q.add(node);
		visitedNodes.put(node, 1);
		
		while(!q.isEmpty()) {
			int size = q.size();
			int flag = 0;
			for(int i = 0; i < size; i++){
			    Binary_Tree<Integer> temp = q.poll();
			    if(temp.left != null && !visitedNodes.containsKey(temp.left)) {	
			        flag++;
					q.add(temp.left);
					visitedNodes.put(temp.left, 1);
				}
			    if(temp.right != null && !visitedNodes.containsKey(temp.right)) {
			        flag++;
					q.add(temp.right);
					visitedNodes.put(temp.right, 1);
			    }
			    Binary_Tree<Integer> parentNode = nodeWithParentNode.get(temp);
		    	if(parentNode != null && !visitedNodes.containsKey(parentNode)) {
		    	    flag++;
					q.add(parentNode);
					visitedNodes.put(parentNode, 1);
				}
			    
			}
			if(flag > 0)
			  time++;		
		}		
		return time;
	}

	private static Binary_Tree<Integer> createMap(Binary_Tree<Integer> root, Map<Binary_Tree<Integer>, Binary_Tree<Integer>> nodeWithParentNode, int target) {
		Binary_Tree<Integer> res = null;
		Queue<Binary_Tree<Integer>> q = new LinkedList<>();
		q.add(root);
		nodeWithParentNode.put(root, null);

		while(!q.isEmpty()) {
			Binary_Tree<Integer> temp = q.poll();
			
			if(temp.data == target)
				res = temp;
			if(temp.left != null) {
				q.add(temp.left);
				nodeWithParentNode.put(temp.left, temp);
			}
			if(temp.right != null) {
				q.add(temp.right);
				nodeWithParentNode.put(temp.right, temp);
			}
		}
		return res;
	}

}
