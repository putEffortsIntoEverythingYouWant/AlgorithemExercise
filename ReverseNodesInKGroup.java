/*
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
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
    //reverse by k in group, if less than k, reverse back
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k<=1){
            return head;
        }
        ListNode before = null;
        ListNode current = head;
        ListNode next = null;
        ListNode front = null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode lastGroup = dummy;
        int index = 1;
        ListNode node = head;
        while(node!=null){
            while(current!=null && index<=k){
                //reverse
                if(index==1){
                    front = current;
                }
                next = current.next;
                current.next = before;
                before = current;
                current = next;
                index++;
            
            }
            if(index==k+1){
                lastGroup.next = before;
                front.next = current;
                node = current;
                lastGroup = front;
                before = null;
                index=1;
            }else{//not k yet, reverse back
                ListNode backNode = before;
                ListNode beforeNode = null;
                ListNode nextNode = null;
                while(backNode!=null){
                    nextNode = backNode.next;
                    backNode.next = beforeNode;
                    beforeNode = backNode;
                    backNode = nextNode;
                }
                lastGroup.next = beforeNode;
                break;
            }
        }
        return dummy.next;
    }
    
}