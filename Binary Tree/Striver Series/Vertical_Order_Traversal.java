package Striver_Series;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import Creation_Print_Binary_Trees.Binary_Tree;
import Creation_Print_Binary_Trees.Create_Binary_Trees;

class Pair{
	public int horizontalDistance;
	public Binary_Tree<Integer> node;
	public Pair(int horizontalDistance, Binary_Tree<Integer> node) {
		this.horizontalDistance = horizontalDistance;
		this.node = node;
	}
}

public class Vertical_Order_Traversal {

	public static void main(String[] args) {
		Binary_Tree<Integer> root = Create_Binary_Trees.takesInputFromUserBetter(true, 0, false);
		ArrayList <Integer> result = verticalOrder(root);
        System.out.println(result);
	}

	private static ArrayList<Integer> verticalOrder(Binary_Tree<Integer> root) {
		ArrayList<Integer> ans = new ArrayList<>();
		if(root == null)
			return ans;
		Map<Integer,ArrayList<Integer>> map = new TreeMap<>();
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(0,root));
		
		while(!queue.isEmpty()) {
			Pair current = queue.poll();
			if(map.containsKey(current.horizontalDistance)) {
				map.get(current.horizontalDistance).add(current.node.data);
			}else {
				ArrayList<Integer> tempList = new ArrayList<>();
				tempList.add(current.node.data);
				map.put(current.horizontalDistance, tempList);
			}
			
			if(current.node.left != null)
				queue.add(new Pair(current.horizontalDistance - 1, current.node.left));
			if(current.node.right != null)
				queue.add(new Pair(current.horizontalDistance + 1, current.node.right));
		}
		
		for(Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
			ans.addAll(entry.getValue());
		}
		return ans;
	}

}
