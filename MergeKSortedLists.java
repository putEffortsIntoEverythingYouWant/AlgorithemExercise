/*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
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
    public ListNode mergeKLists(ListNode[] lists) {
      if(lists == null || lists.length == 0){
          return null;
      }
      /*
      filter out the null and remove it when one list has been checked to the end..avoid hassel
      */
      List<ListNode> heads = new ArrayList<ListNode> ();
      for(int i=0; i<lists.length; i++){
          if(lists[i] != null){
              heads.add(lists[i]);
          }
      }
      ListNode dummy = new ListNode(0);
      ListNode head = dummy;
      while(heads.size()!=0){
          int index = findMin(heads);
          head.next = heads.get(index);
          heads.set(index,heads.get(index).next);
          if(heads.get(index)==null){//important
              heads.remove(index);
          }
          head = head.next;
      }
      return dummy.next;
    }
    
    public int findMin(List<ListNode> heads){
       int index = 0;//it's guaranteed heads.size >0 and no null
       int minIndex = 0;
       for(ListNode current: heads){
           if(current.val <= heads.get(minIndex).val){
               minIndex = index;
           }
           index++;
       }
       return minIndex;
    }

}