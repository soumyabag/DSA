package Problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import BST_Class.Binary_Tree;

public class Level_wise_Linkedlist {

    static class LinkedListNode<T> 
    { 
        T data; 
        LinkedListNode<T> next;
        public LinkedListNode(T data)   
        {
            this.data = data; 
        } 
    }
    
    public static LinkedListNode<Integer> insert(int data, int pos, LinkedListNode<Integer> head){
        if(pos == 0) {
            head = new LinkedListNode<Integer>(data);
            return head;
        }
        else {
            LinkedListNode<Integer> temp = head;
            LinkedListNode<Integer> prev = null;
            while(temp != null) {
                prev = temp;
                temp = temp.next;
            }
            LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(data);
            prev.next = newNode;
        }
        return null;
    }

    public static ArrayList<LinkedListNode<Integer>> constructLinkedListForEachLevel(Binary_Tree<Integer> root){
        ArrayList<LinkedListNode<Integer>> ans = new ArrayList<>();
        Queue<Binary_Tree<Integer>> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            LinkedListNode<Integer> head = null;
            for(int i = 0; i<size; i++) {
                if(i == 0)
                    head = insert(q.peek().data, i, null);
                else
                    insert(q.peek().data, i, head);
                if(q.peek().left != null)
                    q.add(q.peek().left);
                if(q.peek().right != null)
                    q.add(q.peek().right);
                q.poll();
            }
            ans.add(head);
        }
        return ans;
    }

}
