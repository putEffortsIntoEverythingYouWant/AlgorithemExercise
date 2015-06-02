/*
Sort a linked list using insertion sort.
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
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while(dummy.next != null){
            dummy = sortList(dummy,head);
        }
        return head.next;
    }
    public ListNode sortList(ListNode before, ListNode dummyHead){
        ListNode startNode = dummyHead;
        while(startNode.next != null){
            if(startNode.next.val >= before.next.val){
                if(startNode.next == before.next){
                    return before.next;
                    //if the same node, no need to do anything, just return
                    //need to distinguish from value equal case, value equal but different nodes will still need to be sorted
                    //very important, otherwise [1] case will fall into infinate loop
                }
                ListNode current = before.next;
                before.next = current.next;
                current.next = startNode.next;
                startNode.next = current;
                return before;
            }
            startNode = startNode.next;
        }
        return before;//will not get called
    }
}