/*
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.
*/

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
 /*
 insert copy node, connect them, then seperate into new list
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        //make copies of nodes
        RandomListNode current = head;
        while(current!=null){
            RandomListNode next = current.next;
            RandomListNode copy = new RandomListNode(current.label);
            current.next=copy;
            copy.next = next;
            current = next;
        }
        //set up random pointer
        current = head;
        while(current!=null){
            if(current.random!=null){
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }
        //separate up
        current = head;
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode newList = dummy;
        while(current!=null){
            RandomListNode newNode = current.next;
            current.next = newNode.next;
            newList.next = newNode;
            current = newNode.next;
            newList = newNode;
            
        }
        return dummy.next;
    }
}