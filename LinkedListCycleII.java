/*
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Follow up:
Can you solve it without using extra space?
*/
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 /*
 fast runner and slow runner, when they meet, set a pointer at head and 
 move the pointer and slow runner together till they meet, that's the start of the loop
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        while(slow!=null && fast!=null){
            slow = slow.next;
            fast = fast.next;
            if(fast==null){
                return null;
            }
            fast = fast.next;
            if(slow == fast){
                break;
            }
        }
        ListNode catchUp = head;
        while(catchUp!=null && slow!=null){
            if(catchUp==slow){
                break;
            }
            catchUp = catchUp.next;
            slow = slow.next;
        }
        return slow;
        
    }
}