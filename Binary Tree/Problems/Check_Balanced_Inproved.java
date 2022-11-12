package Problems_II;
import Creation_Print_Binary_Trees.Binary_Tree;
import Creation_Print_Binary_Trees.Create_Binary_Trees;

public class Check_Balanced_Inproved {

	public static void main(String[] args) {
		Binary_Tree<Integer> root = Create_Binary_Trees.takesInputFromUserBetter(true, 0, false);
        BalancedTree result = checkBalanced(root);
        System.out.println(result.isBalanced);
	}

	private static BalancedTree checkBalanced(Binary_Tree<Integer> root) {
		if(root == null) {
			int height = 0;
			boolean isBalance = true;
			BalancedTree ans = new BalancedTree();
			ans.height = height;
			ans.isBalanced = isBalance;
			return ans;
		}
		
		BalancedTree leftOutput = checkBalanced(root.left);
		BalancedTree rightOutput = checkBalanced(root.right);
		
		boolean isBal = true;
	    int height = 1 + Math.max(leftOutput.height, rightOutput.height);
	    
	    if(Math.abs(height) > 1)
	    	isBal = false;
	    
	    if(!leftOutput.isBalanced || !rightOutput.isBalanced)
	    	isBal = false;
	    
	    BalancedTree ans = new BalancedTree();
	    ans.height = height;
	    ans.isBalanced = isBal;
		return ans;
	}
}

//  T.C. - O(n)
