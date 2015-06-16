/*
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
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
    //edited: seems leetcode updated test cases,
    //for a list with 5 nodes, rotate it 11 times is the same as rotate it 1 times, so we get length of the list first, so rotate time = k%length;
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null){return null;}
        int length = 0;
        ListNode end=head;
        while(end!=null){
            end=end.next;
            length++;
        }
        int num=k%length;
        ListNode slow = head;
        ListNode fast = head;
        int step = 0;
        while(step<num){
            if(fast.next==null){
                fast.next = head;
            }
            fast=fast.next;
            step++;
        }
        while(fast.next!=null && fast.next!=head){
            slow=slow.next;
            fast = fast.next;
        }
        fast.next=head;
        ListNode newHead = slow.next;
        slow.next = null;
        return newHead;
     
        
    }
}