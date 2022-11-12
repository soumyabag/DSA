package BST_Class;

public class BST {
    private Binary_Tree<Integer> root;
    private int size;

    public BST(){

    }

    public void insert(int ele){
        root = insertHelper(root, ele);
        size++;
    }

    public void delete(int ele){
        deleteHepler(root, ele);
    }

    public int size(){
        return size;
    }

    public boolean isPresent(int ele){       
        return helper(root, ele);
    }

    public void printTree(){
        printTreeHepler(root);
    }
    
    private static int minEle = 0;
    private static Binary_Tree<Integer> deleteHepler(Binary_Tree<Integer> root, int ele){
        if(root == null)
            return null;
        if(root.data > ele)
            root.left = deleteHepler(root.left, ele);
        else if(root.data < ele)
            root.right = deleteHepler(root.right, ele);
        else{
            if(root.left == null && root.right == null)
                return null;
            else if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;
            else{
                root.data = findRightMinData(root);
                root.right = deleteHepler(root.right, minEle);
            }
        }
        return root;
    }

    private static int findRightMinData(Binary_Tree<Integer> root) {
        Binary_Tree<Integer> temp = root.right;
        while(temp != null){
            minEle = temp.data;
            temp = temp.left;
        }
        return minEle;
    }

    private static Binary_Tree<Integer> insertHelper(Binary_Tree<Integer> root, int ele){
        if(root == null){
            Binary_Tree<Integer> newRoot = new Binary_Tree<Integer>(ele);
            return newRoot;
        }
        if(root.data > ele){
            root.left = insertHelper(root.left, ele);
        }
        else{
            root.right = insertHelper(root.right, ele);
        }
        return root;
    }

    private static void printTreeHepler(Binary_Tree<Integer> root){
        if(root == null)
			return;
		System.out.print(root.data + " : "); 
		if(root.left != null)
			System.out.print("L" + root.left.data + ",");
		if(root.right != null)
			System.out.print("R" + root.right.data);
		System.out.println();
		printTreeHepler(root.left);
		printTreeHepler(root.right);
    }

    private static boolean helper(Binary_Tree<Integer> root, int ele){
        if(root == null){
            return false;
        }
        if(root.data == ele){
            return true;
        }
        boolean left = false;
        boolean right = false;
        if(root.data > ele){
            left = helper(root.left, ele);
        }
        else if(root.data < ele){
            right = helper(root.right, ele);
        }      
        return left || right;
    }

    
}
