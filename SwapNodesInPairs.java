/*
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
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
	//make sure handle null well
	//and point the parent to the right node
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode parent = dummy;
        while(parent.next!=null){
            ListNode second = parent.next.next;
            if(second==null){
                break;
            }
            parent.next.next = second.next;
            second.next = parent.next;
            parent.next = second;
            parent = second.next;
        }
        return dummy.next;
    }
}