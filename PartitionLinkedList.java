/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 /*
 dummy head
 careful on clean up the linkedlist to prevent circular
 good habit to cut off next pointer when manipulating linked list
 */
 
public class Solution {
    public ListNode partition(ListNode head, int x) {
        
        ListNode less = new ListNode(-1);
        ListNode lessCurrent = less;
        ListNode more = new ListNode(-1);
        ListNode moreCurrent = more;
        ListNode current = head;
        while(current!=null){
            if(current.val>=x){
                moreCurrent.next = current;
                moreCurrent = moreCurrent.next;
            }else{
                lessCurrent.next = current;
                lessCurrent = lessCurrent.next;
            }
            ListNode temp = current.next;
            current.next = null;
            current=temp;
        }
        lessCurrent.next = more.next;
        return less.next;
    }
}