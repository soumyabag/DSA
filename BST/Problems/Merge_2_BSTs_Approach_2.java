package Problems;

import BST_Class.Binary_Tree;

public class Merge_2_BSTs_Approach_2 {

    static void convertBST2DLL(Binary_Tree < Integer > root, Binary_Tree < Integer > head){
        if(head == null)
            return;
        convertBST2DLL(root.right, head);

        root.right = head;
        if(head != null)
            head.left = root;
        head = root;

        convertBST2DLL(root.left, head);
    }

    static Binary_Tree<Integer> mergeDLL(Binary_Tree < Integer > head1, Binary_Tree < Integer > head2){
        Binary_Tree < Integer > head = null;
        Binary_Tree < Integer > tail = null;

        while(head1 != null && head2 != null){
            if(head1.data <= head2.data){
                if(head == null){
                    head = head1;
                    tail = head1;
                    head1 = head1.right;
                }
                else{
                    tail.right = head1;
                    head1.left = tail;
                    tail = head1;
                    head1 = head1.right;
                }
            }
            else{
                if(head == null){
                    head = head2;
                    tail = head2;
                    head2 = head2.right;
                }
                else{
                    tail.right = head2;
                    head2.left = tail;
                    tail = head2;
                    head2 = head2.right;
                }
            }
        }
        while(head1 != null){
            tail.right = head1;
            head1.left = tail;
            tail = head1;
            head1 = head1.right;
        }
        while(head2 != null){
            tail.right = head2;
            head2.left = tail;
            tail = head2;
            head2 = head2.right;
        }
        return head;
    }

    static int findlengthDLL(Binary_Tree<Integer> head){
        Binary_Tree<Integer> temp = head;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.right;
        }
        return count;
    }

    static Binary_Tree<Integer> createTreeFromDLL(Binary_Tree<Integer> head, int n){
        if(head == null)
            return null;
        Binary_Tree<Integer> leftSubTree = createTreeFromDLL(head, n/2);
        Binary_Tree<Integer> root = head;
        root.left = leftSubTree;
        head = head.right;

        root.right = createTreeFromDLL(head, n-(n/2)-1);
        return root;
    }

    static Binary_Tree < Integer > mergeBST(Binary_Tree < Integer > root1, Binary_Tree < Integer > root2) {

        // Write your code here.
        // Step -1 . Converting Tree to Sorted DLL
        Binary_Tree < Integer > head1 = null;
        convertBST2DLL(root1, head1);
        Binary_Tree < Integer > head2 = null;
        convertBST2DLL(root2, head2);

        //Step -2. Merge Two Sorted DLL
        Binary_Tree<Integer> head = mergeDLL(head1, head2);

        // Create Tree From Merged Inorder
        int n = findlengthDLL(head);
        return createTreeFromDLL(head, n);
    }

}
