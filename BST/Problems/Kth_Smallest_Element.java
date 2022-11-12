package Problems;

import java.util.ArrayList;

import Creation_Print_Binary_Trees.Binary_Tree;

public class Kth_Smallest_Element {

	// Approach - 2, T.C. - O(N), S.C. - O(1) because of Morris's Traversal
	public int kthSmallest(Binary_Tree<Integer> root, int k) {
        int i = 0;
        Binary_Tree<Integer> current = root; // current = 5
        while(current != null){
            if(current.left == null){
                i++;
                if(i == k)
                   break; 
                current = current.right;
            }
            else{
                Binary_Tree<Integer> temp = current.left;  // temp = 3
                while(temp.right != null && temp.right != current)
                    temp = temp.right;
                if(temp.right == null){
                    temp.right = current;
                    current = current.left;
                }
                else{
                    temp.right = null;
                    i++;
                    if(i == k)
                       break;
                    current = current.right;
                }
            }            
        }
        if(i == k){
            return current.data;    
        }else{
            return -1;
        }
    }
	
	// Approach - 1 (T.C. -O(N), S.C. - O(N)
//	static int i = 0;
//	public int kthSmallest(Binary_Tree<Integer> root, int k) {
//		int ans = 0;
//		ArrayList<Integer> list = new ArrayList<>();
//		helper(root,list);
//		for(int i = 0; i < list.size(); i++){
//			if(i == k - 1){
//				ans = list.get(i);
//				break;
//			}
//		}
//		return ans;
//	}
//	public void helper(Binary_Tree<Integer> root, ArrayList<Integer> list){
//		if(root == null)
//			return;
//		helper(root.left, list);
//		list.add(root.data);
//		helper(root.right, list);
//	}

}
