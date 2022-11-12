package Problems_II;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import Creation_Print_Binary_Trees.Binary_Tree;
import Creation_Print_Binary_Trees.Create_Binary_Trees;

public class Takint_Input_Level_Wise {

	public static void main(String[] args) {
		Binary_Tree<Integer> root = takesInputLevelWise();
		Create_Binary_Trees.printTreeSecondMethod(root);
	}

	public static Binary_Tree<Integer> takesInputLevelWise() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Root Data : ");
		int rootData = sc.nextInt();
		Binary_Tree<Integer> root = new Binary_Tree<Integer>(rootData);
		Queue<Binary_Tree<Integer>> queue = new LinkedList<>();
		queue.add(root);
		Binary_Tree<Integer> temp = root;

		while(!queue.isEmpty()) {
			temp = queue.poll();
			System.out.println("Enter Left Child of " + temp.data);
			
			int leftData = sc.nextInt();
			if(leftData != -1) {
				Binary_Tree<Integer> leftRoot = new Binary_Tree<Integer>(leftData);
				temp.left = leftRoot;
				queue.add(leftRoot);
			}
			System.out.println("Enter Right Child of " + temp.data);
			int rightData = sc.nextInt();
			if(rightData != -1) {
				Binary_Tree<Integer> rightRoot = new Binary_Tree<Integer>(rightData);
				temp.right = rightRoot;
				queue.add(rightRoot);
			}
		}
		return root;
	}
}
