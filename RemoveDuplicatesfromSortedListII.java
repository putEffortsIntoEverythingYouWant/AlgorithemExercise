/*
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
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
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        ListNode current = dummy;
        while(current!=null){//compare current.next, current.next.next...till find the next distinct one
            if(current.next==null || current.next.next==null){
                break;
            }
            if(current.next.val == current.next.next.val){
                ListNode nextDist = findNextDist(current.next);
                current.next = nextDist;
            }else{
                current = current.next;
            }
        }
        return dummy.next;
    }
    public ListNode findNextDist(ListNode node){
        ListNode pointer = node;
        while(pointer!=null){
            if(pointer.next==null || pointer.next.val!=pointer.val){
                return pointer.next;
            }
            pointer = pointer.next;
        }
        return pointer;
        
    }
}