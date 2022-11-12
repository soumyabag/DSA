package Creation_Print_Binary_Trees;

import java.util.Scanner;

public class Create_Binary_Trees {

	public static void main(String[] args) {
		
		//   1
		// 2    3
		//  4  5
		Binary_Tree<Integer> root = takesInputFromUserBetter(true,0,true);
//		printTreeFirstMethod(root);
		printTreeSecondMethod(root);
	}
	
	public static Binary_Tree<Integer> createBinaryTree(){
		Binary_Tree<Integer> root = new Binary_Tree<Integer>(1);
		Binary_Tree<Integer> rootLeft = new Binary_Tree<Integer>(2);
		Binary_Tree<Integer> rootRight = new Binary_Tree<Integer>(3);
        root.left = rootLeft;
        root.right = rootRight;
        Binary_Tree<Integer> twoRight = new Binary_Tree<Integer>(4);
		Binary_Tree<Integer> twoLeft = new Binary_Tree<Integer>(5);
		rootLeft.right = twoRight;
		rootRight.left = twoLeft;
		return root;
	}
	
	public static Binary_Tree<Integer> takesInputFromUserBetter(boolean isRoot, int parentData, boolean isLeft){
		if(isRoot) {
			System.out.println("Enter Root Data");
		}else {
			if(isLeft) {
				System.out.println("Enter Left Child Of " + parentData);
			}else {
				System.out.println("Enter Right Child Of " + parentData);
			}
		}
		Scanner sc = new Scanner(System.in);
		int rootData = sc.nextInt();
		if(rootData == -1)
			return null;
		Binary_Tree<Integer> root = new Binary_Tree<Integer>(rootData);
		root.left = takesInputFromUserBetter(false,rootData,true);
		root.right = takesInputFromUserBetter(false,rootData,false);		
		return root;
	}
	
	public static Binary_Tree<Integer> takesInputFromUser(){		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Root Data");
		int rootData = sc.nextInt();
		if(rootData == -1)
			return null;
		Binary_Tree<Integer> root = new Binary_Tree<Integer>(rootData);
		root.left = takesInputFromUser();
		root.right = takesInputFromUser();		
		return root;
	}
	
	public static void printTreeFirstMethod(Binary_Tree<Integer> root) {
		if(root == null)
			return;
		System.out.println(root.data); // 1
		printTreeFirstMethod(root.left);
		printTreeFirstMethod(root.right);
	}
	
	public static void printTreeSecondMethod(Binary_Tree<Integer> root) {
		if(root == null)
			return;
		System.out.print(root.data + " : "); // 1 : L2,
		if(root.left != null)
			System.out.print("L" + root.left.data + ",");
		if(root.right != null)
			System.out.print("R" + root.right.data);
		System.out.println();
		printTreeSecondMethod(root.left);
		printTreeSecondMethod(root.right);
	}


}
