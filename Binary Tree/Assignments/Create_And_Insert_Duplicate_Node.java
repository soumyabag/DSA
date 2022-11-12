package Assignments;

import Creation_Print_Binary_Trees.Binary_Tree;
import Problems_II.Print_Level_Wise;
import Problems_II.Takint_Input_Level_Wise;

public class Create_And_Insert_Duplicate_Node {

	public static void main(String[] args) {
		Binary_Tree<Integer> root = Takint_Input_Level_Wise.takesInputLevelWise();
		insertDuplicateNode(root);
		Print_Level_Wise.printLevelWise(root);
	}

	private static void insertDuplicateNode(Binary_Tree<Integer> root) {
		
		if(root == null)
			return;
		
		insertDuplicateNode(root.left);
		insertDuplicateNode(root.right);
		
		Binary_Tree<Integer> newNode = new Binary_Tree<Integer>(root.data);
		Binary_Tree<Integer> temp = root.left;
		root.left = newNode;
		newNode.left = temp;
	}

}
