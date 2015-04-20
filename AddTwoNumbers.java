/*
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
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
point is to keep considering addOn for the longer one, and check addOn once more outside the loop
create new node if addOn != 0
*/
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode current1 = l1;
        ListNode current2 = l2;
        int addOn = 0;
        ListNode head = new ListNode(-1);//dummy head
        ListNode currentNode = head;
        while(current1 != null && current2 != null){
            int num1 = current1.val;
            int num2 = current2.val;
            int result = num1+num2+addOn;
            int newValue = result%10;
            addOn = result/10;
            ListNode node = new ListNode(newValue);
            currentNode.next = node;
            currentNode = node;
            current1 = current1.next;
            current2 = current2.next;
        }
        while(current1 != null){
            int num1 = current1.val;
            int result = num1+addOn;
            int newValue = result%10;
            addOn = result/10;
            ListNode node = new ListNode(newValue);
            currentNode.next = node;
            currentNode = node;
            current1 = current1.next;
        }
        while(current2 !=null){
            int num2 = current2.val;
            int result = num2+addOn;
            int newValue = result%10;
            addOn = result/10;
            ListNode node = new ListNode(newValue);
            currentNode.next = node;
            currentNode = node;
            current2 = current2.next;
        }
        if(addOn!=0){//don't forget this!!!
            currentNode.next = new ListNode(addOn);
        }
        return head.next;
    }
}