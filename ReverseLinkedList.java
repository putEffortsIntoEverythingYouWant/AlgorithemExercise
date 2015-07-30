/*
Reverse linked list
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
    public ListNode reverseList(ListNode head) {
        
        ListNode before =null;
        ListNode current = head;
        ListNode next = null;
        while(current!=null){
            next = current.next;
            current.next = before;
            before = current;
            current = next;
        }
        return before;
    }
}