package Striver_Series;

import Creation_Print_Binary_Trees.Binary_Tree;

public class Same_Tree {
	
	 public boolean isSameTree(Binary_Tree<Integer> p, Binary_Tree<Integer> q) {
	        if(p == null || q == null)
	            return (p==q);        
	        return (p.data == q.data) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	    }

}
