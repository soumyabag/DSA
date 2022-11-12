package Striver_Series;

import java.util.ArrayList;

import Creation_Print_Binary_Trees.Binary_Tree;

public class Boundery_Traversal {
	
	void traverseLeft(Binary_Tree<Integer> node, ArrayList <Integer> ans){
        if((node == null) || (node.left == null && node.right == null)){
            return;
        }
        ans.add(node.data);
        if(node.left != null){
            traverseLeft(node.left, ans);
        }else{
            traverseLeft(node.right, ans);
        }
    }
    
     void leafPrint(Binary_Tree<Integer> node, ArrayList <Integer> ans){
        if(node == null){
            return;
        }
        if(node.left == null && node.right == null){
            ans.add(node.data);
            return;
        }
        if(node.left != null){
            leafPrint(node.left, ans);
        }
        if(node.right != null){
            leafPrint(node.right, ans);
        }
    }
    
     void traverseRight(Binary_Tree<Integer> root, ArrayList <Integer> ans) {
        //base case
        if( (root == null) || (root.left == null && root.right == null) )
            return ;
        
        if(root.right != null)
            traverseRight(root.right, ans);
        else
            traverseRight(root.left, ans);
            
        //wapas aagye
        ans.add(root.data);
            
    }
    
	ArrayList <Integer> boundary(Binary_Tree<Integer> node)
	{
	    ArrayList <Integer> ans = new ArrayList<>();
	    
	    // Addition Of Root 
	    ans.add(node.data);
	    
	    //Traverse Left nodes excluding Leaf Nodes
	    traverseLeft(node.left, ans);
	    
	    // Traverse Leaf Nodes
	    // Traverse Left Leaf Nodes
	    leafPrint(node.left, ans);
	    // Traverse Right Leaf Nodes
	    leafPrint(node.right, ans);
	    
	    // Traverse Right Nodes excluding Leaf Nodes
	    traverseRight(node.right, ans);
	    
	    return ans;
	}

}
