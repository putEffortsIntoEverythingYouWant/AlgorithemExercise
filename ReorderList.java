/*
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
*/
//need to do it iteratively, recusion verson see below, works fine but receive
//stackoverflowerror on large input test
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        int count = 0;
        ListNode current = head;
        while(current!=null){
            count++;
            current = current.next;
        }
        //find mid point
        int mid = (count/2)+1;//start from 1 
        count = 1;
        current = head;
        ListNode newStart = null;
        while(current!=null){
           if(count == mid){
               newStart = current.next;
               current.next = null;
               break;
           }
            current = current.next;
             count++;
        }
        //reverse newStart
        ListNode before = null;
        ListNode currentNode = newStart;
        ListNode next = null;
        while(currentNode!=null){
            next = currentNode.next;
            currentNode.next = before;
            before = currentNode;
            currentNode = next;
        }
        //before is the new head
        //combine before with head
        while(head!=null && before!=null){
            ListNode headNext = head.next;
            head.next = before;
            ListNode beforeNext = before.next;
            before.next = headNext;
            head = headNext;
            before = beforeNext;
        }
        
    }
}
//works perfectly fine, but get stackoverflow on the recursion 
//call when testing large input
//therefore need to do it iteratively
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if(head==null || head.next ==null){
            return;
        }
        int count = 0;
        ListNode pointer = head;
        while(pointer!=null){
            count++;
            pointer = pointer.next;
        }
        
        int mid = count/2 + count%2;
        boolean trueHalf = false;
        if(count%2 ==0){
            trueHalf = true;
        }
        reorder(head,1,mid,trueHalf);
           
    }
    public ListNode reorder (ListNode node, int count, int mid, boolean trueHalf){
        if(count == mid){
            if(trueHalf){
                ListNode next = node.next.next;
                node.next.next = null;
                return next;
            }else{
                ListNode next = node.next;
                node.next=null;
                return next;
            }
        }
        ListNode nextNode = reorder(node.next,count+1,mid,trueHalf);
        ListNode currentNext = node.next;
        node.next = nextNode;
        ListNode nextNodeNext = nextNode.next;
        nextNode.next = currentNext;
        return nextNodeNext;
        
    }
}