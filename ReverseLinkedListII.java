/*
Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
  /*
 create dummy node,
 find the start node
 move the next of the start node to the front of the start node
 till nth node has been moved
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        //find the node before mth
        ListNode startNode = dummy;
        int start = 1;
        while(start<m){
            startNode = startNode.next;
            start++;
        }
        ListNode current = startNode.next.next;
        ListNode before = startNode.next;
        //before and startNode pointers are fixed, next forward
        while(start<n){
            
            ListNode next = current.next;
            before.next = next;
            current.next = startNode.next;
            startNode.next = current;
            current = next;
            start++;
        }
        return dummy.next;
        
    }
}