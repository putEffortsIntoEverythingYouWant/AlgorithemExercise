/*
Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?
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
    //can't use recursion since space O(1) so just use iterative way to reverse the second part
    public boolean isPalindrome(ListNode head) {
        if(head == null){
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        //put slow = slow.next after fast null check to handle [[1]] case,
        //we want slow to point at 1 in that case
        while(slow != null && fast != null){
            
            fast = fast.next;
            if(fast==null){
                break;
            }
            fast = fast.next;
            slow = slow.next;
        }
        //reverse the nodes after slow
       ListNode start = reverse(slow);
       ListNode oldStart = head;
       while(true){
           if(start.val != oldStart.val){
               return false;
           }
           if(oldStart.next == start || oldStart == start){
               break;
           }
           start = start.next;
           oldStart = oldStart.next;
       }
       return true;
        
    }
    //return new head
    public ListNode reverse(ListNode node){
        ListNode prev = node;
        ListNode current = node.next;
        ListNode next = null;
        while(current!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}