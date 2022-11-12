package Striver_Series;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import Creation_Print_Binary_Trees.Binary_Tree;

//class Pair{
//    public int horizontalDistance;
//    public Binary_Tree<Integer> node;
//    Pair(int horizontalDistance, Binary_Tree<Integer> node){
//        this.horizontalDistance = horizontalDistance;
//        this.node = node;
//    }
//}

public class Top_View_of_Binary_Tree {

	static ArrayList<Integer> topView(Binary_Tree<Integer> root)
	{
		// add your code
		ArrayList<Integer> result = new ArrayList<>();
		if(root == null){
			return result;
		}
		Map<Integer, Integer> map = new TreeMap<>();
		Queue<Pair> q = new LinkedList<>();

		q.add(new Pair(0, root));

		while(!q.isEmpty()){
			Pair current = q.poll();
			if(map.containsKey(current.horizontalDistance) == false){
				map.put(current.horizontalDistance, current.node.data);
			}

			if(current.node.left != null){
				q.add(new Pair(current.horizontalDistance - 1, current.node.left));
			}
			if(current.node.right != null){
				q.add(new Pair(current.horizontalDistance + 1, current.node.right));
			}
		}
		for(Map.Entry<Integer, Integer> entry : map.entrySet()){
			result.add(entry.getValue());
		}
		return result;
	}

}
