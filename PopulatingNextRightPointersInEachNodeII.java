/*
Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
*/
/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    /*
    first question i encountered that search left/right subtree does make a difference, 
    right subtree needs to be connected so that when leftnode find the firt next, all next on the right side have already been connected
    */
    public void connect(TreeLinkNode root) {
        if(root==null){return;}
        if(root.right!=null){
            connectNode(root.right,root);
        }
        if(root.left!=null){
            connectNode(root.left,root);
        }

    }
    public void connectNode(TreeLinkNode current, TreeLinkNode parent){
        if(current==parent.left){
            current.next = (parent.right!=null)?parent.right:findFirstNext(parent.next);
        }else{
            current.next = findFirstNext(parent.next);
        }
        if(current.right!=null){
            connectNode(current.right,current);
        }
        if(current.left!=null){
            connectNode(current.left,current);
        }

        
    }
    public TreeLinkNode findFirstNext(TreeLinkNode nextNode){
            while(nextNode!=null){
                if(nextNode.left!=null){
                    return nextNode.left;
                }
                if(nextNode.right!=null){
                    return nextNode.right;
                }
                nextNode = nextNode.next;
            }
            return null;
    }
}