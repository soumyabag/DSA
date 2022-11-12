package Problems_II;

import java.util.LinkedList;
import java.util.Queue;

import Creation_Print_Binary_Trees.Binary_Tree;

public class Print_Level_Wise {

	public static void main(String[] args) {
	      Binary_Tree<Integer> root = Takint_Input_Level_Wise.takesInputLevelWise();
          printLevelWise(root);
	}

	public static void printLevelWise(Binary_Tree<Integer> root) {
		Queue<Binary_Tree<Integer>> queue = new LinkedList<>();
		queue.add(root);
		Binary_Tree<Integer> temp = root;
		
		while(!queue.isEmpty()) {
			temp = queue.poll();
			System.out.print(temp.data + ":");
			
			if(temp.left != null) {
				System.out.print("L:" + temp.left.data + ",");
				queue.add(temp.left);
			}else {
				System.out.print("L:-1,");
			}
			
			if(temp.right != null) {
				System.out.print("R:" + temp.right.data);
				queue.add(temp.right);
			}else {
				System.out.print("R:-1");
			}
			
			System.out.println();
		}
	}

}
