/*
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    //one pass = recuision
    //add dummy to handle when only one node , n =1 return null
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null){
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        removeNode(dummy,n);
        return dummy.next;
    }
    public int removeNode(ListNode node, int n){
        if(node.next==null){
            return 0;
        }
        int index = removeNode(node.next,n);
        if(index+1==n){//this is the parent
            //remove index.next
            node.next = node.next.next;
        }
        return index+1;
    }
}