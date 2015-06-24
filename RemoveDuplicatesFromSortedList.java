/*
Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
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
    public ListNode deleteDuplicates(ListNode head) {
       ListNode current = head;
       while(current!=null){
           if(current.next==null){
               break;
           }
           if(current.val==current.next.val){
               //find the next uniqueone
               ListNode nextNode = remove(current);
               current.next = nextNode;
               current = nextNode;
           }else{
               current = current.next;
           }
       }
       return head;
    }
    public ListNode remove(ListNode current){
        ListNode copy = current;
        while(copy!=null){
            if(copy.val != current.val){
                return copy;
            }
            copy = copy.next;
        }
        return copy;
    }
}