/*
Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    TreeNode pre = null;
    TreeNode first = null;
    TreeNode second = null;
    //in order traversal and keep the pre node to compare with current node
    public void recoverTree(TreeNode root) {
        traverse(root);
        if(first != null && second !=null){
            swap(first,second);
        }
    }
    public void traverse(TreeNode node){
        if(node == null){
            return;
        }
        traverse(node.left);
        if(pre == null){
            pre = node;
        }else{
            if(pre.val>node.val){
                if(first ==null){
                    first = pre;
                    second = node;
                }else{
                    second = node;
                }
            }
            
            pre = node;
        }
        traverse(node.right);
        
    }
    public void swap(TreeNode first, TreeNode second){
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}