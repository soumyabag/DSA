package Striver_Series;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import Creation_Print_Binary_Trees.Binary_Tree;


public class All_Nodes_Distance_K_Binary_Tree {

	public List<Integer> distanceK(Binary_Tree<Integer> root, Binary_Tree<Integer> target, int k) {
		Map<Binary_Tree<Integer>, Binary_Tree<Integer>> nodeWithParentNode = new HashMap<>();
		Binary_Tree<Integer> targetedNode = createMap(root, target, k, nodeWithParentNode);

		List<Integer> ans = new ArrayList<>();
		distanceKHelper(k, targetedNode, nodeWithParentNode, ans);
		return ans;
	}

	public void distanceKHelper(int k,Binary_Tree<Integer> targetedNode,Map<Binary_Tree<Integer>, Binary_Tree<Integer>> nodeWithParentNode,List<Integer> ans){
		Queue<Binary_Tree<Integer>> q = new LinkedList<>();
		HashMap<Binary_Tree<Integer>, Integer> visitedMap = new HashMap<>();
		q.add(targetedNode);
		visitedMap.put(targetedNode, 1);
		int distance = 0;
		if(distance == k) {
			ans.add(targetedNode.data);
			return;
		}

		while(!q.isEmpty()){
			int size = q.size();
			for(int i = 0; i<size; i++){
				Binary_Tree<Integer> temp = q.poll();
				if(temp.left != null && !visitedMap.containsKey(temp.left)){
					q.add(temp.left);
					visitedMap.put(temp.left, 1);
				}
				if(temp.right != null && !visitedMap.containsKey(temp.right)){
					q.add(temp.right);
					visitedMap.put(temp.right, 1);
				}
				Binary_Tree<Integer> parentNode = nodeWithParentNode.get(temp);
				if(parentNode != null && !visitedMap.containsKey(parentNode)){
					q.add(parentNode);
					visitedMap.put(parentNode, 1);
				}
			}
			distance++;
			if(distance == k)
				break;
		}
		while(!q.isEmpty()){
			ans.add(q.poll().data);
		}
	}

	public Binary_Tree<Integer> createMap(Binary_Tree<Integer> root, Binary_Tree<Integer> target, int k,  Map<Binary_Tree<Integer>, Binary_Tree<Integer>> nodeWithParentNode){
		Binary_Tree<Integer> res = null;
		Queue<Binary_Tree<Integer>> q = new LinkedList<>();
		q.add(root);
		nodeWithParentNode.put(root, null);

		while(!q.isEmpty()){
			Binary_Tree<Integer> temp = q.poll();
			if(temp == target)
				res = temp;
			if(temp.left != null){
				q.add(temp.left);
				nodeWithParentNode.put(temp.left, temp);
			}
			if(temp.right != null){
				q.add(temp.right);
				nodeWithParentNode.put(temp.right, temp);
			}    
		}
		return res;
	}

}
