package Assignments;

import Creation_Print_Binary_Trees.Binary_Tree;

public class Print_nodes_at_distance_k_from_node {

	public static void nodesAtDistanceK(Binary_Tree<Integer> root, int node, int k) {
		//Your code goes here
		nodesAtDistanceKHelper(root, node, k);
	}

	public static int nodesAtDistanceKHelper(Binary_Tree<Integer> root, int node, int k){
		if(root == null)
			return -1;
		if(root.data == node){
			printNodesDepthK(root, k);
			return 0;
		}

		int leftDistance = nodesAtDistanceKHelper(root.left, node, k);
		if(leftDistance != -1){
			if(leftDistance + 1 == k){
				printNodesDepthK(root, 0);
			}
			else{ 
				printNodesDepthK(root.right, k - leftDistance - 2);
			}
			return 1 + leftDistance;
		}

		int rightDistance = nodesAtDistanceKHelper(root.right, node, k);
		if(rightDistance != -1){
			if(rightDistance + 1 == k){
				printNodesDepthK(root, 0);
			}
			else{
				printNodesDepthK(root.left, k - rightDistance - 2);
			}
			return 1 + rightDistance; 
		}

		return -1;
	}

	public static void printNodesDepthK(Binary_Tree<Integer> root, int k){
		if(root == null)
			return;
		if(k == 0)
			System.out.println(root.data);
		printNodesDepthK(root.left, k-1);
		printNodesDepthK(root.right, k-1);
	}

}
