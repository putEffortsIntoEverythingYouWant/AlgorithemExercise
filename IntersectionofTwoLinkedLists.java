/*
Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
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
 calculate length
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        int ALength = calculateLength(headA);
        int BLength = calculateLength(headB);
        
        ListNode longer = null;
        ListNode shorter = null;
        int forward = Math.abs(ALength - BLength);
        if(ALength>BLength){
            longer = headA;
            shorter = headB;
        }else{
            shorter = headA;
            longer = headB;
        }
        while(forward>0){
            longer = longer.next;
            forward--;
        }
        while(shorter!=null){
            if(shorter==longer){
                return shorter;
            }
            shorter = shorter.next;
            longer = longer.next;
        }
        return null;
        
    }
    
    public int calculateLength(ListNode head){
        int count = 0;
        ListNode current = head;
        while(current!=null){
            count++;
            current = current.next;
        }
        return count;
    }
}